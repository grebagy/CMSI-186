/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Ball.java
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
 *  @version 1.0.0  2017-03-21  Greg Ebert    Initial writing and release
 *  @version 1.0.1  2017-03-23  Greg Ebert    Second release. set up variables for ball
 *  @version 2.0.0  2017-04-03  Greg Ebert    Final writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
import java.lang.Math;

public class Ball {
  /**
   *  Class field definintions go here
   * length units are FEET, time units are seconds. make sure to translate between feet and inches
   */
   static final double DEFAULT_BALL_RAD = 0.3708;
   private static final double FRICTION_MULTIPLIER = 0.99;
   private static final double LOWEST_SPEED = 0.0833333333;
   public static double DEFAULT_TIMESLICE = 1;
   public double posx = 0;
   public double posy = 0;
   public double velx = 0;
   public double vely = 0;
   public double velC = Math.sqrt(Math.pow(velx, 2) + Math.pow(vely, 2));
   public static double timeslice = DEFAULT_TIMESLICE;
   double[] pos = new double[2];

  /**
   * Okay so get this. I've been doing some research, and as it turns out, these balls are bowling balls. BOWLING BALLS?!?!?
   * yeah. bowling balls. some lunatic decided to set up a SOCCER simulation with BOWLING BALLS! EVERYONES GONNA BREAK THEIR FEET TRYING TO KICK THOSE THINGS
   * and you know whats worse?
   * THE WALLS
   * ARE MADE
   * OF GLUE.
   * THATS RIGHT, THEYRE MADE OF GLUE. SO WHEN YOU GO TO KICK THE BALL AND IT SO MUCH AS *TOUCHES* THE WALL, IT JUST STOPS. i mean WHAT!?!?!?
   * I'm so done with this.
   * 
   * I assume that the minimum time slice is 1 seconds and is ONLY given in WHOLE SECOND VALUES. WHOLE. SECONDS.
   */
   public void move() {
      velC = Math.sqrt(Math.pow(velx, 2) + Math.pow(vely, 2));      
      if ( velC < LOWEST_SPEED ||
           posx + DEFAULT_BALL_RAD >= Field.MAX[0] ||
           posx - DEFAULT_BALL_RAD <= Field.MIN[0] ||
           posy + DEFAULT_BALL_RAD >= Field.MAX[1] ||
           posy - DEFAULT_BALL_RAD <= Field.MIN[1] ) {
         velx = 0;
         vely = 0;
      }
      posx += velx;
      posy += vely;
      velx *= FRICTION_MULTIPLIER;
      vely *= FRICTION_MULTIPLIER;
      velC = Math.sqrt(Math.pow(velx, 2) + Math.pow(vely, 2));      
      pos[0] = posx;
      pos[1] = posy;
      if        (posx + DEFAULT_BALL_RAD >= Field.MAX[0]) {
         posx = Field.MAX[0] - DEFAULT_BALL_RAD;
      }
      if (posx - DEFAULT_BALL_RAD <= Field.MIN[0]) {
         posx = Field.MIN[0] + DEFAULT_BALL_RAD;
      }
      if (posx + DEFAULT_BALL_RAD >= Field.MAX[1]) {
         posy = Field.MAX[1] - DEFAULT_BALL_RAD;
      }
      if (posx - DEFAULT_BALL_RAD <= Field.MIN[1]) {
         posy = Field.MIN[1] + DEFAULT_BALL_RAD;
      }    
   }
   // If you want to call the position, just access name.posx or name.posy

   public double[] getVelocity() {
      double[] vel = new double[2];
      vel[0] = velx;
      vel[1] = vely;
      return vel;
   }

  /**
   * Tester
   */
   public static void main( String args[] ) {
      Ball b1 = new Ball();
      System.out.println("posx: " + b1.posx + " \nposy: " + b1.posy + " \nvelC: " + b1.velC + " \ntimeslice: " + b1.timeslice );
      b1.posx = -399.9;
      b1.posy = -300;
      b1.velx = 20;
      b1.vely = 10;
      System.out.println("add values");
      System.out.println("posx: " + b1.posx + " \nposy: " + b1.posy + " \nvelC: " + b1.velC + " \ntimeslice: " + b1.timeslice );
      b1.move();
      System.out.println("posx: " + b1.posx + " \nposy: " + b1.posy + " \nvelC: " + b1.velC + " \ntimeslice: " + b1.timeslice );
      b1.move();
      System.out.println("posx: " + b1.posx + " \nposy: " + b1.posy + " \nvelC: " + b1.velC + " \ntimeslice: " + b1.timeslice );
      b1.move();
      System.out.println("posx: " + b1.posx + " \nposy: " + b1.posy + " \nvelC: " + b1.velC + " \ntimeslice: " + b1.timeslice );
      b1.move();
      System.out.println("posx: " + b1.posx + " \nposy: " + b1.posy + " \nvelC: " + b1.velC + " \ntimeslice: " + b1.timeslice );
      b1.move();
      System.out.println("posx: " + b1.posx + " \nposy: " + b1.posy + " \nvelC: " + b1.velC + " \ntimeslice: " + b1.timeslice );
      b1.move();
      System.out.println("posx: " + b1.posx + " \nposy: " + b1.posy + " \nvelC: " + b1.velC + " \ntimeslice: " + b1.timeslice );
      b1.posx = -300;
      b1.posy = -300;
      b1.velx = 200;
      b1.vely = 10;
      b1.timeslice = 60;
      System.out.println("add values");
      System.out.println("posx: " + b1.posx + " \nposy: " + b1.posy + " \nvelC: " + b1.velC + " \ntimeslice: " + b1.timeslice );
      b1.move();
      System.out.println("posx: " + b1.posx + " \nposy: " + b1.posy + " \nvelC: " + b1.velC + " \ntimeslice: " + b1.timeslice );
      b1.move();
      System.out.println("posx: " + b1.posx + " \nposy: " + b1.posy + " \nvelC: " + b1.velC + " \ntimeslice: " + b1.timeslice );
      b1.move();
      System.out.println("posx: " + b1.posx + " \nposy: " + b1.posy + " \nvelC: " + b1.velC + " \ntimeslice: " + b1.timeslice );
      b1.move();
      System.out.println("posx: " + b1.posx + " \nposy: " + b1.posy + " \nvelC: " + b1.velC + " \ntimeslice: " + b1.timeslice );
      b1.move();
      System.out.println("posx: " + b1.posx + " \nposy: " + b1.posy + " \nvelC: " + b1.velC + " \ntimeslice: " + b1.timeslice );
      b1.move();
      System.out.println("posx: " + b1.posx + " \nposy: " + b1.posy + " \nvelC: " + b1.velC + " \ntimeslice: " + b1.timeslice );


   }
}
