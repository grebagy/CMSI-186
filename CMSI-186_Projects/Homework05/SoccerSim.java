/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  SoccerSim.java
 *  Purpose       :  The main program for the Soccer doodad
 *  @see
 *  @author       :  Greg Ebert
 *  Date written  :  2017-02-28
 *  Description   :  the final part to the SoccerSim project, The Lord of the Rings: The Return of the King is a 2003 epic high fantasy adventure film produced, written and directed by Peter Jackson based on the second and third volumes of J. R. R. Tolkien's The Lord of the Rings.[7][8] It is the third and final installment in The Lord of the Rings trilogy, following The Fellowship of the Ring (2001) and The Two Towers (2002), preceding The Hobbit film trilogy
 *                   Im goiung to be perfectly honest i stole this from the clock solver thing. RIP any neatness...
 *  Notes         :  None right now.  I'll add some as they occur.
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException everywhere.
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-28  Greg Ebert    Initial writing and release
 *  @version 2.0.0  2017-04-03  Greg Ebert    Final writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
import java.lang.Math;
import java.text.DecimalFormat;

public class SoccerSim {
  /**
   *  Class field definintions go here
   */
   private final int DEFAULT_TIME_SLICE = 1;
   int timeslice = DEFAULT_TIME_SLICE;
   int balln = 0;
   int time = 0;
   private final int MAX_TIME = 43200;
   DecimalFormat df = new DecimalFormat("#0.00");

    Field fld = new Field();
    Ball[] ball = new Ball[99];
 
  /**
   *  Method to handle all the input arguments from the command line
   *   this sets up the variables for the simulation
   */
   public void handleInitialArguments( String args[] ) {

      System.out.println( "\n   SOCCERSIM BEGIN!\n\n" ) ;
      if( 0 == args.length ) {
        System.out.println( "   Sorry you must enter at least 4 arguments. or a number of arguments that is a multiple of four. or that plus one for a new timeslice\n" +
                            "   Usage: java SoccerSim <ball 1 x value> <ball 1 y value> <ball 1 x speed> <ball 1 y speed> [new time slice in whole seconds]\n" +
                            "   Please try again..........." );
        System.exit( 1 );
      } else if( args.length%4 > 1) {
        System.out.println( "   Sorry you must enter a correct number of arguments (4 per ball, and one(optional) at the end for timeslice).\n" +
                            "   Usage: java SoccerSim <ball 1 x value> <ball 1 y value> <ball 1 x speed> <ball 1 y speed> [new timeslice in whole seconds]\n" +
                            "   Please try again..........." );
        System.exit( 1 );
      }
      balln = args.length/4;
   }

  /**
   *  ball check for hits with other balls and pole
   */
  public boolean check(Ball[] ball) {
    for(int i = 0; i < balln-1; i++) {
      for(int j = i+1; j < balln; j++) {
        if( balln>1 && (2*0.3708) >= Math.sqrt(Math.pow((ball[i].posx-ball[j].posx), 2 ) + Math.pow((ball[i].posy-ball[j].posy), 2 )) ) {
          System.out.println("Ball " + (i + 1) + " at (" + df.format(ball[i].posx) + "," + df.format(ball[i].posy) + ") and Ball " + 
                                       (j + 1) + " at (" + df.format(ball[j].posx) + "," + df.format(ball[j].posy) + ") at " + time());
          System.exit(0);
        }
      }
      if( 0.3708 >= Math.sqrt( Math.pow( (ball[i].posx - fld.pol[0]) , 2 ) + Math.pow( (ball[i].posy - fld.pol[1]) , 2 )) ) {
          System.out.println("Ball " + (i + 1) + " at (" + df.format(ball[i].posx) + "," + df.format(ball[i].posy) + ") and the Pole at (" + 
                                                       df.format(fld.pol[0]) + ","   + df.format(fld.pol[1])   + ") at " + time());
          System.exit(0);
        }
    }
    return false;
  }

  //time formatting
  public String time() {
      int hours = (int)time/3600;
      int minutes = ((int)time%3600)/60;
      return "[" + hours + ":" + minutes + ":" + time%60 + "]";
  }
  /**
   *  tick method(s)
   */
  public void tick(Ball[] ball) {
    for  (int n=0; n < timeslice; n++) {
      for(int o=0; o < balln;     o++) {
        ball[o].move();
      }
    }
    time += timeslice;
  }

  /**
   *  The main program starts here
   *  remember the constraints from the project description
   */
  public static void main( String args[] ) {
    SoccerSim ss = new SoccerSim();
    Field fld = new Field();
    fld.pole();
    ss.handleInitialArguments( args );
    Ball[] ball = new Ball[ss.balln];


            int m = 0;
            for(int p = 0; p<ss.balln; p++ ) {
              ball[p] = new Ball();
                
                try {
            
                   ball[p].posx = Double.parseDouble(args[m]);
                   m++;
                   ball[p].posy = Double.parseDouble(args[m]);
                   m++;
                   ball[p].velx = Double.parseDouble(args[m]);
                   m++;
                   ball[p].vely = Double.parseDouble(args[m]);
                   m++;
                }
                catch (NumberFormatException nfe) {
                    System.out.println("Try using numbers.");
                    System.exit( 0 );
                }
              
            }

    if(args.length%4 == 1) {
      try {
         ss.timeslice = Integer.parseInt(args[args.length-1]);
      }
      catch (NumberFormatException nfe) {
          System.out.println("Try using whole numbers for the timeslice.");
          System.exit( 0 );
      }
    }
    for(int i = 0;i <= ss.MAX_TIME ; ) {

      ss.check(ball);
      ss.tick(ball);
      i += ss.timeslice;
    }
    System.out.println("no collisions.\n");

      DecimalFormat df = new DecimalFormat("#0.00");
    for(int i = 0; i<ss.balln; i++) {
      System.out.println("Final Ball " + i + " location: (" + df.format(ball[i].posx) + "," + df.format(ball[i].posy) + ")");
    }
    System.exit( 0 );
  }
}
