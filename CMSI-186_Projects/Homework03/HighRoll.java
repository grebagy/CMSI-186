/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  HighRoll.java
 *  Purpose       :  Demonstrates the use of input from a command line for use with Yahtzee
 *  Author        :  Greg Ebert
 *  Date          :  2017-02-14
 *  Description   :  High Roll dice game
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-14  Greg Ebert    Initial writing and release
 *  @version 1.1.0  2017-02-23  Greg Ebert    Final Release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class HighRoll{

     // run the program with the # of dice and the # of sides, i.e. java HighRoll 10 6


   public static void main( String args[] ) {
      System.out.println( "\n  Welcome to the HighRoll Program!!" );
      int count = 0;
      int sides = 0;
      DiceSet dise = null;
      boolean menu = false;
      int highScore = 0;
      int savedScore = 0;
      if (args.length == 0) {
         System.out.print("try running the program with the # of dice and # of sides values (e.g. java HighRoll 10 6)");
         System.exit(0);
      }
      try {
         count = Integer.parseInt(args[0]);
      }
      catch (NumberFormatException nfe) {
          System.out.println("  Try using numbers.");
          System.exit( 0 );
      }
      try {
          sides = Integer.parseInt(args[1]);
      }
      catch (NumberFormatException nfe) {
          System.out.println("  I need me some numbers, brah.");
          System.exit( 0 );
      }
      if (sides < 4 || count < 1) {
         System.out.println("  Remember, the smallest dice set is a single (1) four sided die (4).");
         System.exit( 0 );
      } else {
         menu = true;
         System.out.println("\n  Dice Set:");
         System.out.print("  ");
         dise = new DiceSet(count, sides);
      }


      BufferedReader input = new BufferedReader( new InputStreamReader( System.in ) );

      while( menu == true ) {
         System.out.println("\n\n    HighRoll Commands:");
         System.out.println("  Enter 'ROLL' to roll all dice");
         System.out.println("  Enter 'ROLL@' to roll a specific single die");
         System.out.println("  Enter 'SCORE' to calculate score for this set");
         System.out.println("  Enter 'SAVE' to save this score as the Saved Score");
         System.out.println("  Enter 'DISPLAY' to display Current Score, Saved Score and High Score");
         System.out.println("  Enter 'HELP' if you're just as confused as I am");
         System.out.println("  Enter 'Q' or 'q' (at any time) to quit the program");
         System.out.print( "\n>>" );
         String inputLine = null;
         try {
            inputLine = input.readLine();
            if( 0 == inputLine.length() ) {
               System.out.println("No Input");
            } else if( 'q' == inputLine.charAt(0) || 'Q' == inputLine.charAt(0) ) {
               System.out.println("  Goodbye!");
               break;
            } else if (inputLine.equals("ROLL")) {
               dise.roll();
               //automatic high schore finder. could be put in score block to only count scores viewed. not everyone views scores though...
                  if (dise.sum() > highScore) {
                     highScore = dise.sum();
                  }
               System.out.println(DiceSet.toString(dise));

            } else if (inputLine.equals("ROLL@"))
               while (true) {
                  System.out.print("  Which die?\n>>");
                     try {
                        inputLine = input.readLine();
                        if( 'q' == inputLine.charAt(0) || 'Q' == inputLine.charAt(0) ) {
                           System.out.println("  Goodbye!");
                            break;
                        }
                        dise.rollIndividual(Integer.parseInt(inputLine)-1);
                        System.out.println("  [" + dise.getIndividual(Integer.parseInt(inputLine)-1) + "]");
                        if (dise.sum() > highScore) {
                           highScore = dise.sum();
                        }
                        break;
                     }
                     catch (NumberFormatException nfe) {
                        System.out.println("using numbers please");
                     }
                     catch (ArrayIndexOutOfBoundsException aioobe) {
                        System.out.println("pick a die number within the set");
                     }
            } else if (inputLine.equals("SCORE")) {
               System.out.println("  Current Score: " + dise.sum());
                  
            } else if (inputLine.equals("SAVE")) {
               savedScore = dise.sum();
               System.out.println("  Score Saved!");
            } else if (inputLine.equals("DISPLAY")) {
               System.out.println("  Current Score: " + dise.sum());
               System.out.println("  Saved Score: " + savedScore);
               System.out.println("  High Score: " + highScore);
            } else if (inputLine.equals("HELP")) {
               System.out.println("  Help?!\n  You want HELP?!?\n  I don't know what's happening. YOU'RE supposed to know that!!\n  well jesus we're all screwed. \n  when in doubt, try restarting the program");
            } else {
            System.out.println("  Not a Valid Input");
            }
         }
         catch( IOException ioe ) {
            System.out.println( "Caught IOException" );
         }
      }
   }
}
