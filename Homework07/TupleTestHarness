/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * File name  :  TupleTestHarness.java
 * Purpose    :  Test harness for the Tuple class
 * @author    :  Professor Don Murphy
 * @author    :  B.J. Johnson totally ripped off from the original
 * Date       :  2017-04-19
 * Description:  Duh.... see the Purpose above
 * Notes      :  None
 * Warnings   :  None
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Revision History
 * ================
 *   Ver      Date     Modified by:  Reason for change or modification
 *  -----  ----------  ------------  ---------------------------------------------------------------------
 *  1.0.0  2017-04-19  B.J. Johnson  Initial writing and release; stolen blatently from Professor Murphy
 *                                    with his permission; added this comment block and some javadocs
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
public class TupleTestHarness {

   private static int attempts = 0;
   private static int successes = 0;

  /**
   *  the main method which calls all the test methods
   */
   public static void main(String[] args) {
      attempts = 0;
      successes = 0;

      test_toString();
      test_setElement();
      test_add();
      test_equals();
      test_getElement();
      test_length();
      test_total();

      System.out.println( "\n\nResults: " + successes + "/" + attempts + " tests passed.");
   }

  /**
   *  method to display success or failure as a result of a test
   *  @param  value  boolean success/failure
   *  Note that this method keeps track of the count of tests run
   *    as well as the number of successes
   */
   private static void displaySuccessIfTrue(boolean value) {
      attempts++;
      successes += value ? 1 : 0;

      System.out.println(value ? "success" : "failure");
   }

  /**
   *  method to display a failure, probably for things that are
   *   supposed to fail on purpose [that's a guess]
   */
   private static void displayFailure() {
      displaySuccessIfTrue(false);
   }

  /**
   *  method to test the "toString()" method a buncha times
   */
   public static void test_toString() {
      try {
         System.out.println( "Test 01    : testing Tuple.IMPOSSIBLE.toString():" );
         System.out.print  ( "  Expecting: 'Impossible tuple': " );
         displaySuccessIfTrue("Impossible tuple".equals(Tuple.IMPOSSIBLE.toString()));
      } catch (Exception e) {
         e.printStackTrace();
         displayFailure();
      }

      try {
         System.out.println( "Test 02    : testing if Tuple.IMPOSSIBLE returns isImpossible():" );
         System.out.print  ( "  Expecting: 'true': " );
         displaySuccessIfTrue(Tuple.IMPOSSIBLE.isImpossible());
      } catch (Exception e) {
         e.printStackTrace();
         displayFailure();
      }

     // Only one impossible.
      Tuple fakeImpossible = new Tuple(new int[0]);
      try {
         System.out.println( "Test 03    : testing if '<>' [empty Tuple] equals fakeImpossible.toString():" );
         System.out.print  ( "  Expecting: 'true': " );
         displaySuccessIfTrue("<>".equals(fakeImpossible.toString()));
      } catch (Exception e) {
         e.printStackTrace();
         displayFailure();
      }

      try {
         System.out.println( "Test 04    : testing if fakeImpossible equals Tuple.IMPOSSIBLE:" );
         System.out.print  ( "  Expecting: 'true': " );
         displaySuccessIfTrue(fakeImpossible.equals(Tuple.IMPOSSIBLE));
      } catch (Exception e) {
         e.printStackTrace();
         displayFailure();
      }

      try {
         System.out.println( "Test 05    : testing if fakeImpossible returns isImpossible:" );
         System.out.print  ( "  Expecting: 'true': " );
         displaySuccessIfTrue(!fakeImpossible.isImpossible());
      } catch (Exception e) {
         e.printStackTrace();
         displayFailure();
      }

      try {
         Tuple t0 = new Tuple(0);
         System.out.println( "Test 06    : testing constructing '<>' [empty Tuple]:" );
         System.out.print  ( "  Expecting: 'true': " );
         displaySuccessIfTrue("<>".equals(t0.toString()));
      } catch (Exception e) {
         e.printStackTrace();
         displayFailure();
      }

      try {
         Tuple t1 = new Tuple(1);
         System.out.println( "Test 07    : testing constructing '<0>' [one-Tuple]:" );
         System.out.print  ( "  Expecting: 'true': " );
         displaySuccessIfTrue("<0>".equals(t1.toString()));
      } catch (Exception e) {
         e.printStackTrace();
         displayFailure();
      }

      try {
         Tuple t2 = new Tuple(2);
         System.out.println( "Test 08    : testing constructing '<0,0>' [two-Tuple]:" );
         System.out.print  ( "  Expecting: 'true': " );
         displaySuccessIfTrue("<0,0>".equals(t2.toString()));
      } catch (Exception e) {
         e.printStackTrace();
         displayFailure();
      }

      try {
         Tuple t3 = new Tuple(new int[] { 3, 1, 2 });
         System.out.println( "Test 09    : testing constructing '<3,1,2>' [three-Tuple]:" );
         System.out.print  ( "  Expecting: 'true': " );
         displaySuccessIfTrue("<3,1,2>".equals(t3.toString()));
      } catch (Exception e) {
         e.printStackTrace();
         displayFailure();
      }
   }

  /**
   *  method to test the "setElement()" method a couple of times
   *   makes a few Tuples and checks that you got what you paid for
   *   note that the "toString()" method puts angle brackets around
   *   the tuple for easy reading
   */
   public static void test_setElement() {
      Tuple t0 = new Tuple(new int[] { 3, 1, 2 });
      try {
         System.out.println( "Test 10    : testing setting element zero of '<3,1,2>' [three-Tuple] to -1:" );
         System.out.println( "  currently: " + t0.toString() );
         t0.setElement(0, -1);
         System.out.print  ( "  Expecting: '<-1,1,2>': " );
         displaySuccessIfTrue("<-1,1,2>".equals(t0.toString()));
      } catch (Exception e) {
         e.printStackTrace();
         displayFailure();
      }

      try {
         System.out.println( "Test 11    : testing setting element one of '<-1,1,2>' [three-Tuple] to 0:" );
         System.out.println( "  currently: " + t0.toString() );
         t0.setElement(1, 0);
         System.out.print  ( "  Expecting: '<-1,0,2>': " );
         displaySuccessIfTrue("<-1,0,2>".equals(t0.toString()));
      } catch (Exception e) {
         e.printStackTrace();
         displayFailure();
      }

      try {
         System.out.println( "Test 12    : testing setting element two of '<-1,0,2>' [three-Tuple] to 15:" );
         System.out.println( "  currently: " + t0.toString() );
         t0.setElement(2, 15);
         System.out.print  ( "  Expecting: '<-1,0,15>': " );
         displaySuccessIfTrue("<-1,0,15>".equals(t0.toString()));
      } catch (Exception e) {
         e.printStackTrace();
         displayFailure();
      }
   }

  /**
   *  method to test adding two tuples together.  Only one test, but theoreticall
   *   should test a lot of different sizes, not just "three-Tuples"
   */
   public static void test_add() {
      try {
         System.out.println( "Test 13    : testing Tuple addition of '<-1,0,2>' to '<3,1,2>':" );
         Tuple t0 = new Tuple(new int[] { -1, 0, 2 });
         Tuple t1 = new Tuple(new int[] { 3, 1, 2 });
         System.out.println( "  currently: t0 is " + t0.toString() );
         System.out.println( "  currently: t1 is " + t1.toString() );
         Tuple sum = t0.add(t1);
         System.out.print  ( "  Expecting: Tuple sum is '<2,1,4>': " );
         displaySuccessIfTrue("<2,1,4>".equals(sum.toString()) &&
                              "<-1,0,2>".equals(t0.toString()) &&
                              "<3,1,2>".equals(t1.toString()));
      } catch (Exception e) {
         e.printStackTrace();
         displayFailure();
      }
   }

  /**
   *  method to test the "equals()" method
   */
   public static void test_equals() {
      Tuple t0 = new Tuple(new int[] { -1, 0, 2 });
      Tuple t1 = new Tuple(new int[] { -1, 0, 2 });

      try {
         System.out.println( "Test 14    : testing Tuple equals 'some string object':" );
         System.out.print  ( "  Expecting: 'some string object': " );
         displaySuccessIfTrue(!t0.equals("some string object"));
      } catch (Exception e) {
         e.printStackTrace();
         displayFailure();
      }

      try {
         System.out.println( "Test 15    : testing Tuple equals <-1.0>:" );
         System.out.print  ( "  Expecting: '<-1.0>': " );
         displaySuccessIfTrue(!t0.equals(new Tuple(new int[] { -1, 0 })));
      } catch (Exception e) {
         e.printStackTrace();
         displayFailure();
      }

      try {
         System.out.println( "Test 16    : testing Tuple equals new Tuple(3):" );
         System.out.print  ( "  Expecting: t0 not equal new Tuple(3): " );
         displaySuccessIfTrue(!t0.equals(new Tuple(3)));
      } catch (Exception e) {
         e.printStackTrace();
         displayFailure();
      }

      try {
         System.out.println( "Test 17    : testing Tuples are equal both ways:" );
         System.out.print  ( "  Expecting: t0.equals(t1) and t1.equals(t0) to be true: " );
         displaySuccessIfTrue(t0.equals(t1) & t1.equals(t0));
      } catch (Exception e) {
         e.printStackTrace();
         displayFailure();
      }
   }

  /**
   *  method to test the "getElement()" method
   */
   public static void test_getElement() {
      Tuple t0 = new Tuple(new int[] { -1, 0, 2 });

      try {
         System.out.println( "Test 18    : testing getElement zero of t0:" );
         System.out.print  ( "  Expecting: -1: " );
         displaySuccessIfTrue(-1 == t0.getElement(0));
      } catch (Exception e) {
         e.printStackTrace();
         displayFailure();
      }

      try {
         System.out.println( "Test 19    : testing getElement one of t0:" );
         System.out.print  ( "  Expecting: 0: " );
         displaySuccessIfTrue(0 == t0.getElement(1));
      } catch (Exception e) {
         e.printStackTrace();
         displayFailure();
      }

      try {
         System.out.println( "Test 20    : testing getElement two of t0:" );
         System.out.print  ( "  Expecting: 2: " );
         displaySuccessIfTrue(2 == t0.getElement(2));
      } catch (Exception e) {
         e.printStackTrace();
         displayFailure();
      }
   }

  /**
   *  method to test the "length()" method
   */
   public static void test_length() {
      try {
         System.out.println( "Test 21    : testing length on empty Tuple:" );
         System.out.print  ( "  Expecting: length == 0: " );
         Tuple t0 = new Tuple(0);
         displaySuccessIfTrue(0 == t0.length());
      } catch (Exception e) {
         e.printStackTrace();
         displayFailure();
      }

      try {
         System.out.println( "Test 22    : testing length on three-Tuple <-1,0,2>:" );
         System.out.print  ( "  Expecting: length == 3: " );
         Tuple t1 = new Tuple(new int[] { -1, 0, 2 });
         displaySuccessIfTrue(3 == t1.length());
      } catch (Exception e) {
         e.printStackTrace();
         displayFailure();
      }
   }

  /**
   *  method to test the "total()" method
   */
   public static void test_total() {
      try {
         System.out.println( "Test 23    : testing total on empty Tuple:" );
         System.out.print  ( "  Expecting: total == 0: " );
         Tuple t0 = new Tuple(0);
         displaySuccessIfTrue(0 == t0.total());
      } catch (Exception e) {
         e.printStackTrace();
         displayFailure();
      }

      try {
         System.out.println( "Test 24    : testing total on three-Tuple <-1,0,2>:" );
         System.out.print  ( "  Expecting: total == 1: " );
         Tuple t1 = new Tuple(new int[] { -1, 0, 2 });
         displaySuccessIfTrue(1 == t1.total());
      } catch (Exception e) {
         e.printStackTrace();
         displayFailure();
      }
   }

}
