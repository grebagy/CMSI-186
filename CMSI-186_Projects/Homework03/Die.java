/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Die.java
 *  Purpose       :  Provides a class describing a single die that can be rolled
 *  @author       :  Greg
 *  Date          :  2017-02-14
 *  Description   :  This class provides the data fields and methods to describe a single game die.  A
 *                   die can have "N" sides.  Sides are randomly assigned sequential pip values, from 1
 *                   to N, with no repeating numbers.  A "normal" die would thus has six sides, with the
 *                   pip values [spots] ranging in value from one to six.  Includes the following:
 *                   public Die( int nSides );                  // Constructor for a single die with "N" sides
 *                   public int roll();                         // Roll the die and return the result
 *                   public int getSides()                      // get the number of sides on this die     
 *                   public int getValue()                      // get the value of this die
 *                   public void setSides()                     // change the configuration and return the new number of sides
 *                   public String toString()                   // Instance method that returns a String representation
 *                   public static String toString()            // Class-wide method that returns a String representation
 *                   public static void main( String args[] );  // main for testing porpoises
 *
 *  Notes         :  Restrictions: no such thing as a "two-sided die" which would be a coin, actually.
 *                   Also, no such thing as a "three-sided die" which is a physical impossibility without
 *                   having it be a hollow triangular prism shape, presenting an argument as to whether
 *                   the inner faces are faces which then should be numbered.  Just start at four for
 *                   minimum number of faces.  However, be aware that a four-sided die dosn't have a top
 *                   face to provide a value, since it's a tetrahedron [pyramid] so you'll have to figure
 *                   out a way to get the value, since it won't end up on its point.
 *
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the number of sides or pips is out of range
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-06  Greg Ebert    Initial writing and release
 *  @version 1.1.0  2017-02-23  Greg Ebert    Final Release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
public class Die {

  /**
   * private instance data
   */
   private int sides;
   private int pips = 0;
   private int SIDES_MINIMUM = 4;

   // public constructor:
  /**
   * constructor
   * @param sides int value containing THIS card's rank
   * @throws      IllegalArgumentException
   * Note: parameter must be checked for validity; invalid value must throw "IllegalArgumentException"
   */
   public Die( int nSides ) {
    if ( nSides < SIDES_MINIMUM) {
      throw new IllegalArgumentException();
    } 
      sides = nSides;
   }

  /**
   * Roll the die and return the result
   * @return  integer value of the result of the roll, whatever would be on top, randomly selected
   */
   public int roll() {
      pips = (int )(Math.random() * sides + 1);
      return pips;
   }

  /**
   * @return the side count of THIS die instance
   */
   public int getSides() {
      return sides;
   }

  /**
   * @return the pip count of THIS die instance; whatever is on top when the die stops rolling
   */
   public int getValue() {
      
      return pips;
   }

  /**
   * @param  int  the number of sides to set/reset for this Die instance
   * @return      The new number of sides, in case anyone is looking
   * @throws      IllegalArgumentException
   */
   public int setSides( int newsides ) {
    if (newsides < SIDES_MINIMUM) {
      throw new IllegalArgumentException();
    }
      sides = newsides;
      return sides;
   }

  /**
   * @return Public Instance method that returns a String representation of THIS die instance
   * @throws UnsupportedOperationException
   */
   public String toString() {
      return "[" + Integer.toString(pips) + "]" ;
   }

  /**
   * @return Class-wide method that returns a String representation of THIS die instance
   */
   public static String toString( Die d ) {
      return "[" + d.pips + "]" ;
   }

  /**
   * A little test main to check things out
   */
   public static void main( String[] args ) {
      Die d = new Die( 9 );
      System.out.println( "Die 9 sides: " + d.sides );
      System.out.println( "get sides " + d.getSides() );
      System.out.println( "test roll of d Die: " + d.roll() );
      System.out.println( "test roll of d Die: " + d.roll() );
      System.out.println( "test of print to string: " + d.toString());
      System.out.println( "test of toString: " + Die.toString(d));
      System.out.println( "set sides from 9 to 4" );
      d.setSides(4);
      System.out.println( "get sides " + d.getSides() );
      System.out.println( "test roll of d Die: " + d.roll() );
      System.out.println( "test roll of d Die: " + d.roll() );
      Die e = new Die( 4 );
      System.out.println( "Die 4 sides: " + e.sides );
      System.out.println( "get sides " + e.getSides() );
      System.out.println( "test roll of e Die: " + e.roll() );
      System.out.println( "test roll of e Die: " + e.roll() );
      System.out.println( "test of print to string: " + e.toString());
      System.out.println( "test of toString: " + Die.toString(e));
      Die f = new Die( 6 );
      System.out.println( "Die 6 sides: " + f.sides );
      System.out.println( "get sides " + f.getSides() );
      System.out.println( "test roll of f Die: " + f.roll() );
      System.out.println( "test roll of f Die: " + f.roll() );
      System.out.println( "test of print to string: " + f.toString());
      System.out.println( "test of toString: " + Die.toString(f));
      try {
        Die g = new Die( 3 );
      }
      catch ( IllegalArgumentException iae) {
        System.out.println("illegal die sides");
      }
      try {
        Die h = new Die( 100 );
        System.out.println( "Die 100 sides: " + h.sides );
        System.out.println( "get sides " + h.getSides() );
        System.out.println( "test roll of d Die: " + h.roll() );
        System.out.println( "test roll of d Die: " + h.roll() );
        System.out.println( "test of print to string: " + h.toString());
        System.out.println( "test of toString: " + Die.toString(h));
      }
      catch ( IllegalArgumentException iae) {
        System.out.println("illegal die side");
      }

      System.out.println( "Hello from the Die class main method!" );
   }

}
