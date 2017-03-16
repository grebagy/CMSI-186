/**
 *  File name     :  Clock.java
 *  Purpose       :  solve that clock. oh boy.
 *  Author        :  Greg Ebert
 *  Date          :  2/28/17
 *  Author        :  Greg Ebert
 *  Date          :  2/28/17
 *  Description   :  This file does the clock thing
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ----------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-28  Greg Ebert    first writing. doesnt work
 *  @version 1.0.1  2017-03-14  Greg Ebert    Still going
 */
import java.text.DecimalFormat;

public class Clock {
  /**
   *  Class field definintions go here
   */
   private static final double DEFAULT_TIME_SLICE_IN_SECONDS = 60.0;
   private static final double INVALID_ARGUMENT_VALUE = -1.0;
   private static final double MAXIMUM_DEGREE_VALUE = 360.0;

   int hours = 0;
   int minutes = 0;
   double seconds = 0;
   double hh = 0;
   double mh = 0;
   double ha = 0;
   double angle = 0;
   double slice = DEFAULT_TIME_SLICE_IN_SECONDS;

  /**
   *  Constructor goes here
   */
   public Clock() {
      hours = 0;
      minutes = 0;
      seconds = 0;
   }

  /**
   *  Methods go here
   *
   *  Method to calculate the next tick from the time increment
   *  @return double-precision value of the current clock tick
   */
   public double tick() {
      seconds += slice;
      return seconds;
   }

  /**
   *  Method to validate the angle argument
   *  @param   argValue  String from the main programs args[0] input
   *  @return  double-precision value of the argument
   *  @throws  NumberFormatException
   */
   public double validateAngleArg( String argValue ) throws NumberFormatException {
      try {
         angle = Double.parseDouble(argValue); 
      } catch (NumberFormatException nfe) {
         System.out.println("The first argument must be a number including or between 0.0 and 360.0\n  automatically set to 0");
         //System.exit( 0 );
         angle = 0;
      }
      if (angle>MAXIMUM_DEGREE_VALUE || angle<0) {
         System.out.println("The first argument must be a number including or between 0.0 and 360.0\n  automatically set to 0");
         //System.exit( 0 );
         angle = 0;
      }
      return angle;
   }

  /**
   *  Method to validate the optional time slice argument
   *  @param  argValue  String from the main programs args[1] input
   *  @return double-precision value of the argument or -1.0 if invalid
   *  note: if the main program determines there IS no optional argument supplied,
   *         I have elected to have it substitute the string "60.0" and call this
   *         method anyhow.  That makes the main program code more uniform, but
   *         this is a DESIGN DECISION, not a requirement!
   *  note: remember that the time slice, if it is small will cause the simulation
   *         to take a VERY LONG TIME to complete!
   */
   public double validateTimeSliceArg( String argValue ) {
      try {
         slice = Double.parseDouble(argValue); 
         if (slice>=1800 || slice<=0) {
            System.out.println("The second argument must be a number BETWEEN 0.0 and 1800.0\n  automatically set to " + DEFAULT_TIME_SLICE_IN_SECONDS);
            slice = -1;
         }
      } catch (NumberFormatException nfe) {
         System.out.println("The second argument must be a number between 0.0 and 1800.0\n  automatically set to " + DEFAULT_TIME_SLICE_IN_SECONDS);
         slice = -1;
      }
      if (slice == INVALID_ARGUMENT_VALUE) {
         slice = DEFAULT_TIME_SLICE_IN_SECONDS;
      }
      return slice;
   }

  /**
   *  Method to calculate and return the current position of the hour hand
   *  @return double-precision value of the hour hand location
   */
   public double getHourHand() {
      hh = ((seconds/43200)*360)%360;
      return hh;
   }
   //get hours value
   public int getHours() {
      hours = (int)seconds/3600;
      return hours;
   }
  /**
   *  Method to calculate and return the current position of the minute hand
   *  @return double-precision value of the minute hand location
   */
   public double getMinuteHand() {
      mh = ((seconds/3600)*360)%360;
      return mh;
   }
   //get minutes value
   public int getMinutes() {
      minutes = ((int)seconds%3600)/60;
      return minutes;
   }

   //get seconds value
   public double getSeconds() {
      return seconds%60;
   }

  /**
   *  Method to calculate and return the angle between the hands
   *  @return double-precision value of the angle between the two hands
   */
   public double getHandAngle() {      
      if (mh > hh) {
         ha = mh - hh;
      } else if (hh >= mh) {
         ha = hh - mh;
      }
      if (angle < 180 && ha > 180) {
         ha = 360 - ha;
      } else if (angle > 180 && ha < 180) {
         ha = 180 + ha;
      }
      return ha;
   }
  /**
   *  Method to return a String representation of this clock
   *  @return String value of the current clock
   */
   public String toString() {
      getHours();
      getMinutes();
      DecimalFormat df = new DecimalFormat("#0.00");
      return "[" + hours + ":" + minutes + ":" + df.format(seconds%60) + "]";
   }

  /**
   *  The main program starts here
   *  remember the constraints from the project description
   *  @see  http://bjohnson.lmu.build/cmsi186web/homework04.html
   *  be sure to make LOTS of tests!!
   *  remember you are trying to BREAK your code, not just prove it works!
   */
   public static void main( String args[] ) {

      System.out.println( "\nCLOCK CLASS TESTER PROGRAM\n" +
                          "--------------------------\n" );
      System.out.println( "  Creating a new clock: " );
      Clock clock = new Clock();
      System.out.println( "    New clock created: " + clock.toString() );
      System.out.println( "    Testing validateAngleArg()....");
      System.out.print( "      sending '  0 degrees', expecting double value   0.0" );
      try { System.out.println( (0.0 == clock.validateAngleArg( "0.0" )) ? " - got a   0.0" : " - got " + clock.angle ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
      System.out.println( "  Creating a new clock2: " );
      Clock clock2 = new Clock();
      System.out.println( "    New clock created: " + clock2.toString() );
      System.out.println( "    Testing validateAngleArg()....");
      System.out.print( "      sending '  0 degrees', expecting double value   0.0" );
      try { System.out.println( (50 == clock2.validateAngleArg( "50" )) ? " - got a   50.0" : " - got " + clock2.angle ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
      System.out.println( "    Testing validateTimeSliceArg()....");
      System.out.print( "      sending '  60 seconds', expecting double value   60.0" );
      try { System.out.println( (60 == clock2.validateTimeSliceArg( "60" )) ? " - got a   60.0" : " - got " + clock2.slice ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
      System.out.println( "  Creating a new clock3: " );
      Clock clock3 = new Clock();
      System.out.println( "    New clock created: " + clock3.toString() );
      System.out.println( "    Testing validateAngleArg()....");
      System.out.print( "      sending '  4000 degrees', expecting default value   360.0" );
      try { System.out.println( (4000 == clock3.validateAngleArg( "4000" )) ? " - got a   4000.0" : " - got " + clock3.angle ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
      System.out.println( "    Testing validateTimeSliceArg()....");
      System.out.print( "      sending '  60000 seconds', expecting default value   60.0" );
      try { System.out.println( (60000 == clock3.validateTimeSliceArg( "60" )) ? " - got a   60000.0" : " - got " + clock3.slice ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
      System.out.println( "  Creating a new clock4: " );
      Clock clock4 = new Clock();
      System.out.println( "    New clock created: " + clock4.toString() );
      System.out.println( "    Testing validateAngleArg()....");
      System.out.print( "      sending '  -1 degrees', expecting default value   360.0" );
      try { System.out.println( (-1 == clock4.validateAngleArg( "-1" )) ? " - got a   -1" : " - got" + clock4.angle ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
      System.out.println( "    Testing validateTimeSliceArg()....");
      System.out.print( "      sending '  -1 seconds', expecting default value   60.0" );
      try { System.out.println( (-1 == clock4.validateTimeSliceArg( "-1" )) ? " - got a   -1" : " - got" + clock4.slice ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
      System.out.println( "  Creating a new clock5: " );
      Clock clock5 = new Clock();
      System.out.println( "    New clock created: " + clock5.toString() );
      System.out.println( "    Testing validateAngleArg()....");
      System.out.print( "      sending '  chocolate', expecting default value   360.0" );
      try { System.out.println( (-1 == clock5.validateAngleArg( "beans" )) ? " - got a   -1" : " - got" + clock5.angle ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
      System.out.println( "    Testing validateTimeSliceArg()....");
      System.out.print( "      sending '  beans', expecting default value   60.0" );
      try { System.out.println( (-1 == clock5.validateTimeSliceArg( "beans" )) ? " - got a   -1" : " - got" + clock5.slice ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
      System.out.println( "  Creating a new clock5: " );
      Clock clock6 = new Clock();
      System.out.println( "    New clock created: " + clock6.toString() );
      System.out.println( "    Testing validateAngleArg()....");
      System.out.print( "      sending '  chocolate', expecting default value   360.0" );
      try { System.out.println( (0.000001 == clock6.validateAngleArg( "beans" )) ? " - got a   0.000001" : " - got" + clock6.angle ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
      System.out.println( "    Testing validateTimeSliceArg()....");
      System.out.print( "      sending '0.000001', expecting double value   0.000001" );
      try { System.out.println( (0.000001 == clock6.validateTimeSliceArg( "0.000001" )) ? " - got a   0.000001" : " - got" + clock6.slice ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
      System.out.println(clock.tick());
      System.out.println(clock.tick());
      clock.tick();
      System.out.println(clock.tick());
   }
}
