/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * File name  :  Changemaker.java
 * Purpose    :  make change for a given amount with given amounts
 * @author    :  B.J. Johnson
 * @author    :  Greg Ebert temporarily ripped off from the original
 * Date       :  2017-04-19
 * Description:  This program takes a given number of coin values and an end amount and returns the minimum number of coins with those values
                 to add up to the end amount.
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
 *  1.0.1  2017-04-25  Greg Ebert    Haha what am i doing
 *  1.1.0  2017-04-27  Greg Ebert    things should be working but they arent.
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
public class Changemaker {

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

    public static Tuple makeChangeWithDynamicProgramming(int[] denominations, int amount) {
        Tuple[][] table = new Tuple[denominations.length][amount+1];
        int dl = denominations.length;
        for (int i = 0; i < dl; i++) {
            for (int j = 0; j <= amount; j++) {
                table[i][j] = new Tuple(dl);
                System.out.println("\n  box # " + i + "," + j + " at " + denominations[i] + " to " + amount);
                System.out.println("l: " + table[i][j].toString());
                if (j == 0) {
                } else {

                    if (denominations[i] <= j && table[i][j-denominations[i]] != Tuple.IMPOSSIBLE) {
                        table[i][j].setElement(i, 1);
                        table[i][j] = table[i][j].add(table[i][j-denominations[i]]);
                        if (i>1 && table[i][j].total() > table[i-1][j].total()) {
                          table[i][j] = table[i-1][j];  
                        }
                    } else {
                        table[i][j] = Tuple.IMPOSSIBLE;
                    }
                    if (table[i][j] == Tuple.IMPOSSIBLE && i>0 && table[i-1][j] != Tuple.IMPOSSIBLE) {
                        table[i][j] = table[i-1][j];
                    }
                }
                System.out.print("{");
                for (int k = 0; k < dl; k++)
                System.out.print("," + table[i][j].getElement(k) + ",");
                System.out.print("}");
            }
        }
        Tuple result = new Tuple(dl);
        result = table[dl-1][amount];
        return result;
    }

    private static void printUsage() {
        System.out.println("Usage: java DynamicChangemaker <denominations> <amount>");
        System.out.println("  - <denominations> is a comma-separated list of denominations (no spaces)");
        System.out.println("  - <amount> is the amount for which to make change");
    }

    private static String getSimplePluralSuffix(int count) {
        return count == 1 ? "" : "s";
    }

}
