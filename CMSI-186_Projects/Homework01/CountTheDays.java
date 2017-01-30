/**
 *  File name     :  CountTheDays.java
 *  Purpose       :  be able to count the days like a real program
 *  Author        :  B.J. Johnson (prototype)
 *  Date          :  2017-01-02 (prototype)
 *  Author        :  Greg Ebert
 *  Date          :  01-29-17
 *  Description   :  This program will calculate the number of days between two dates.
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ----------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 0.0.1  2017-01-29  Greg Ebert    initial writing
 **/

public class CountTheDays {

	public static void main ( String [] args ) {
		long month1 = 0;
		long day1 = 0;
		long year1 = 0;
		long month2 = 0;
		long day2 = 0;
		long year2 = 0;
		if (args.length < 6) {
			System.out.println( "\n  Too few command line arguments. you have " + args.length + ", you need 6 (e.g. 1 2 1997 5 21 2007)\n" );
         	System.exit( 0 );
		} else if (args.length > 6) {
			System.out.println( "\n  Too many command line arguments. you have " + args.length + ", you need 6 (e.g. 1 2 1997 5 21 2007)\n" );
         	System.exit( 0 );
		}
				//turning args into ints while also making sure they are numbers
		        try {
		            month1 = Integer.parseInt(args[0]);
		        }
		        catch (NumberFormatException nfe) {
		            System.out.println("The first argument must be a number.");
		            System.exit( 0 );
		        }

		        try {
		            day1 = Integer.parseInt(args[1]);
		        }
		        catch (NumberFormatException nfe) {
		            System.out.println("The second argument must be a number.");
		            System.exit( 0 );
		        }

		        try {
		            year1 = Integer.parseInt(args[2]);
		        }
		        catch (NumberFormatException nfe) {
		            System.out.println("The thirst argument must be a number.");
		            System.exit( 0 );
		        }

		        try {
		            month2 = Integer.parseInt(args[3]);
		        }
		        catch (NumberFormatException nfe) {
		            System.out.println("The fourth argument must be a number.");
		            System.exit( 0 );
		        }

		        try {
		            day2 = Integer.parseInt(args[4]);
		        }
		        catch (NumberFormatException nfe) {
		            System.out.println("The fifth argument must be a number.");
		            System.exit( 0 );
		        }

		        try {
		            year2 = Integer.parseInt(args[5]);
		        }
		        catch (NumberFormatException nfe) {
		            System.out.println("The sixth argument must be a number.");
		            System.exit( 0 );
				}
			//testing validity of dates 
			if (CalendarStuff.isValidDate( month2,  day2, year2 ) != true) {
					System.out.println( "invalid second date" );
					System.exit(0); 
			} 
			if (CalendarStuff.isValidDate( month1,  day1, year1 ) != true) {
					System.out.println( "invalid first date" );
					System.exit(0); 
			}
			System.out.println( "there are" );
			//main code. i have a re-ordering operation just because the way my daysbetween function works it can "cause issues"
			//its totally unnecessary, but allows 
			if (CalendarStuff.compareDate( (long)month1, (long)day1, (long)year1, (long)month2, (long)day2, (long)year2 ) == 1 ) {
	            CalendarStuff.daysBetween( (long)month2, (long)day2, (long)year2, (long)month1, (long)day1, (long)year1 );
	        } else { CalendarStuff.daysBetween( (long)month1, (long)day1, (long)year1, (long)month2, (long)day2, (long)year2 );
	        }
	    System.out.println( "days between " + month1 +"/"+ day1 +"/"+ year1 +" and "+ month2 +"/"+ day2 +"/"+ year2 );
	}
}
