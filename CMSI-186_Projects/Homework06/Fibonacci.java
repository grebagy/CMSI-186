/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * File name  :  Fibonacci.java
 * Purpose    :  Fibonacci java class
 * @author    :  Greg Ebert
 * Date       :  2017-04-06
 * Description:  @see <a href='http://bjohnson.lmu.build/cmsi186web/homework06.html'>Assignment Page</a>
 * Notes      :  None
 * Warnings   :  None
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Revision History
 * ================
 *   Ver      Date     Modified by:  Reason for change or modification
 *  -----  ----------  ------------  ---------------------------------------------------------------------
 *  1.0.0  2017-04-19  Greg Ebert    Initial and final writing and release
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class Fibonacci {

   public Fibonacci() {
      super();
   }

   public static int length = 0;

   public static void main( String[] args ) {
      Fibonacci fib = new Fibonacci();
      try {
         length = Integer.parseInt(args[0]);
      }
      catch (NumberFormatException nfe) {
         System.out.println("  Try using numbers.");
         System.exit( 0 );
      }
      GinormousInt[] gi = new GinormousInt[length+1];
      gi[0] = new GinormousInt("0");
      gi[1] = new GinormousInt("1");
      for (int i=2; i<length+1; i++){
         gi[i] = new GinormousInt(gi[i-1].add(gi[i-2]).toString());
      }
      System.out.println(gi[length].toString());
   }
}
