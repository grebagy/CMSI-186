/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Field.java
 *  Purpose       :  set up the specifications of the ball in BallRoller
 *  Author        :  Greg Ebert
 *  Date          :  2017-03-21
 *  Description   :  basics of the ball in BallKicker
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Historie
 *  -----------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-03-23  Greg Ebert    Initial writing and release
 *  @version 2.0.0  2017-04-03  Greg Ebert    Final writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
import java.lang.Math;


public class Field {
  /**
   *  Class field definintions go here
   * length units are feet. time units are seconds. CONVERT INCHES TO FEET
   */
   static final double[] MIN = { -4000, -4000 };
   static final double[] MAX = { 4000, 4000 };
   public static double polx = 0;
   public static double poly = 0;
  /**
   * pole stuff
   */
   double[] pol = new double[2];

   public void pole() {
      polx = Math.random() * (MAX[0]*2) + (MIN[0]+1);
      poly = Math.random() * (MAX[1]*2) + (MIN[1]+1);
      
   }
  /* 


  /**
   * Tester
   */
   public static void main( String args[] ) {
      Field f1 = new Field();
      System.out.println("test:\n POLE RANDOM TEST");
      f1.pole();
      System.out.println("pol[0]: " + f1.pol[0]);
      System.out.println("pol[1]: " + f1.pol[1]);
   }
}
