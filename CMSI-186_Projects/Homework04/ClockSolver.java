/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  ClockSolver.java
 *  Purpose       :  The main program for the ClockSolver class
 *  @see
 *  @author       :  Greg Ebert
 *  Date written  :  2017-02-28
 *  Description   :  This class provides a bunch of methods which may be useful for the ClockSolver class
 *                   for Homework 4, part 1.  Includes the following:
  *
 *  Notes         :  None right now.  I'll add some as they occur.
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the input arguments are "hinky"
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-28  Greg Ebert    Initial writing and release
 *  @version 2.0.0  2017-03-15  Greg Ebert    final release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class ClockSolver {
  /**
   *  Class field definintions go here
   */
   private final double MAX_TIME_SLICE_IN_SECONDS  = 1800.00;
   private final double DEFAULT_TIME_SLICE_SECONDS = 60.0;
   private final double EPSILON_VALUE              = 0.1;      // small value for double-precision comparisons
   double vari = EPSILON_VALUE;
  /**
   *  Constructor
   *  This just calls the superclass constructor, which is "Object"
   */
   public ClockSolver() {
      super();
   }

  /**
   *  Method to handle all the input arguments from the command line
   *   this sets up the variables for the simulation
   */
   public void handleInitialArguments( String args[] ) {
     // args[0] specifies the angle for which you are looking
     //  your simulation will find all the angles in the 12-hour day at which those angles occur
     // args[1] if present will specify a time slice value; if not present, defaults to 60 seconds
     // you may want to consider using args[2] for an "angle window"

      System.out.println( "\n   Welcome to the ClockSolver program!!\n\n" ) ;
      if( 0 == args.length ) {
        System.out.println( "   Sorry you must enter at least one argument\n" +
                            "   Usage: java ClockSolver <angle> [timeSlice]\n" +
                            "   Please try again..........." );
        System.exit( 1 );
      }
      Clock clock    = new Clock();
      
   }

  /**
   *  The main program starts here
   *  remember the constraints from the project description
   *  @see  http://bjohnson.lmu.build/cmsi186web/homework04.html
   *  @param  args  String array of the arguments from the command line
   *                args[0] is the angle for which we are looking
   *                args[1] is the time slice; this is optional and defaults to 60 seconds
   */
   public static void main( String args[] ) {
      ClockSolver cs = new ClockSolver();
      Clock clock    = new Clock();
      double[] timeValues = new double[3];
      cs.handleInitialArguments( args );

      System.out.println("Angle: " + clock.validateAngleArg(args[0]));
      if( args.length > 1 ) {
        clock.validateTimeSliceArg(args[1]);
        System.out.println("Time Slice: " + clock.validateTimeSliceArg(args[1]));
      } else {
        clock.validateTimeSliceArg(Double.toString(cs.DEFAULT_TIME_SLICE_SECONDS));
        System.out.println("Time Slice: " + clock.validateTimeSliceArg(Double.toString(cs.DEFAULT_TIME_SLICE_SECONDS)));
      }

      while(clock.seconds < 43200) {
        clock.getHourHand();
        clock.getMinuteHand();
        clock.getHandAngle();
        
        if ( clock.angle-cs.vari <= clock.ha && clock.ha <= clock.angle+cs.vari ) {
          System.out.println(clock.toString());
        }
        clock.tick();
      }
   }
}
