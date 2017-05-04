/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * File name  :  ChangeMaker.java
 * Purpose    :  Program to make change for a given amount with given denominations.
 * @author    :  B.J. Johnson
 * @author    :  Greg Ebert partially ripped off from the original
 * Date       :  2017-04-19
 * Description:  This program takes a given number of coin values and an end amount and returns the minimum
 *               number of coins with those values to add up to the end amount.
 * Notes      :  None
 * Warnings   :  None
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Revision History
 * ================
 *   Ver      Date     Modified by:  Reason for change or modification
 *  -----  ----------  ------------  ---------------------------------------------------------------------
 *  1.0.0  2017-04-19  B.J. Johnson  Initial release; stolen blatently from Professor Don Murphy with his
 *                                    express permission and blessing; just added this comment block
 *  1.0.1  2017-04-25  Greg Ebert    Haha what am I doing
 *  1.1.0  2017-04-27  Greg Ebert    finished writing the bulk of the code. functionality is still
 *                                   hit-or-miss with mostly misses
 *  1.2.0  2017-04-27  Greg Ebert    Every method is functional. extended functionality is nonexistant.
 *  1.2.1  2017-05-03  Greg Ebert    Added javadocs
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
/**
 * This class will make change for a given amount with given denominations.
 */
public class ChangeMaker {

   /**
    *  Main method which calls all the other methods. it checks to make sure that the input values are positive, non-zero values and that there are no repeats.
    *   calls makeChangeWithDynamicChangeMaker, and grabs what that method returns to output the result
    *
    *  @param args  should be in two parts- currency values and change amount e.g. 1,5,6,10 55
    *
    *  @throws NumberFormatException if the count argument is not a natural number (positive whole number)
    */
    public static void main(String[] args) {
        if (args.length != 2) {
            printUsage();
            return;
        }

        try {

            String[] denominationStrings = args[0].split(",");
            int[] denominations = new int[denominationStrings.length];

            for (int i = 0; i < denominations.length; i++) {
                denominations[i] = Integer.parseInt(denominationStrings[i]);
                if (denominations[i] <= 0) {
                    System.out.println("Denominations must all be greater than zero.\n");
                    printUsage();
                    return;
                }

                for (int j = 0; j < i; j++) {
                    if (denominations[j] == denominations[i]) {
                        System.out.println("Duplicate denominations are not allowed.\n");
                        printUsage();
                        return;
                    }
                }
            }

            int amount = Integer.parseInt(args[1]);
            if (amount < 0) {
                System.out.println("Change cannot be made for negative amounts.\n");
                printUsage();
                return;
            }



            Tuple change = makeChangeWithDynamicProgramming(denominations, amount);
            if (change.isImpossible()) {
                System.out.println("It is impossible to make " + amount + " cents with those denominations.");
            } else {
                int coinTotal = change.total();
                System.out.println(amount + " cents can be made with " + coinTotal + " coin" +
                        getSimplePluralSuffix(coinTotal) + " as follows:");

                for (int i = 0; i < denominations.length; i++) {
                    int coinCount = change.getElement(i);
                    System.out.println("- "  + coinCount + " " + denominations[i] + "-cent coin" +
                            getSimplePluralSuffix(coinCount));
                }
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Denominations and amount must all be integers.\n");
            printUsage();
        }
    }

   /**
    *  makes change with dynamic programming. using the input values gathered in the main method, this method actually does the number crunching
    *
    * @param denominations  the coin values e.g. 1 5 6 10
    *
    * @param amount  the change value trying to be made e.g. 55
    *
    * @return returns a tuple containing the smallest combination of coins.
    * if values given are impossible, it will return an impossible tuple, which cannot be processed the same way other returned Tuples are
    * @see Tuple.IMPOSSIBLE
    */
    public static Tuple makeChangeWithDynamicProgramming(int[] denominations, int amount) {
        Tuple[][] table = new Tuple[denominations.length][amount+1];
        int dl = denominations.length;
        for (int i = 0; i < dl; i++) {
            for (int j = 0; j <= amount; j++) {
                table[i][j] = new Tuple(dl);
                if (j == 0) {
                } else {
                    if (denominations[i] <= j && table[i][j-denominations[i]] != Tuple.IMPOSSIBLE) {
                        table[i][j].setElement(i, 1);
                        table[i][j] = table[i][j].add(table[i][j - denominations[i]]);
                    } else {
                        table[i][j] = Tuple.IMPOSSIBLE;
                    }
                    if (i>0 && table[i][j] != Tuple.IMPOSSIBLE && table[i-1][j] != Tuple.IMPOSSIBLE && table[i][j].total() > table[i - 1][j].total()) {
                        table[i][j] = table[i-1][j];  
                    }
                    if (table[i][j] == Tuple.IMPOSSIBLE && i>0 && table[i-1][j] != Tuple.IMPOSSIBLE) {
                        table[i][j] = table[i-1][j];
                    }
                }
            }
        }
        Tuple result = new Tuple(dl);
        result = table[dl-1][amount];
        return result;
    }

  /**
   *  prints how to use this class in case something goes wrong or there are unacceptable values given
   *
   */
    private static void printUsage() {
        System.out.println("Usage: java Changemaker <denominations> <amount>");
        System.out.println("  - <denominations> is a comma-separated list of denominations (no spaces)");
        System.out.println("  - <amount> is the amount for which to make change");
    }

  /**
   *  adds an "s" to make a string's contents plural
   *
   *  @param count  the number
   *
   *  @return returns an "s" if the count is not 1, 
   */
    private static String getSimplePluralSuffix(int count) {
        return count == 1 ? "" : "s";
    }

}
