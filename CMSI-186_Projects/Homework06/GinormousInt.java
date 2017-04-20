/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * File name  :  GinormousInt.java
 * Purpose    :  GinormousInt java class
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
 *  1.0.0  2017-04-05  Greg Ebert    Initial writing and release
 *  1.1.0  2017-04-19  Greg Ebert    Add Subtract toString
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class GinormousInt {

   public static final String ZERO = "0";
   public static final String ONE = "1";
   public static final String TEN = "10";

   public String num = " ";
   public String num2 = " ";
   public String num3 = " ";
   public String numz = " ";
   public String num2z = " ";
   public String num3z = " ";

   public int[] n1 = new int[0];
   public int[] n2 = new int[0];
   public int[] n3 = new int[0];

   //true is positive false is negative
   public boolean numb = true;
   public boolean num2b = true;
   public boolean num3b = true;

   public GinormousInt(String s) {
      super();
      num = s;

      num3= s;

      if (num3.charAt(0) == '-') {
         num3b = false;
      } else {
         num3b = true;
      }
      if (num3.charAt(0) == '-' || num3.charAt(0) == '+') {
         num3 = new StringBuilder(num3).deleteCharAt(0).toString();
      }
      n3 = new int[num3.length()];
      for (int i = 0; i< num3.length(); i++) {
         if(Character.isDigit(num3.charAt(i))) {
            n3[i] = (int)num3.charAt(i)-48;
         } else {
            throw new NumberFormatException( "\n    Try using numbers" );
         }

      }
   }

   
   public void comp(String in) {
      num2 = in;
     
      if (num2.charAt(0) == '-') {
         num2b = false;
      } else {
         num2b = true;
      }
      if (num.charAt(0) == '-') {
         numb = false;
      } else {
         numb = true;
      }
      if (num.charAt(0) == '-' || num.charAt(0) == '+') {
         num = new StringBuilder(num).deleteCharAt(0).toString();
      }
      if (num2.charAt(0) == '-' || num2.charAt(0) == '+') {
         num2 = new StringBuilder(num2).deleteCharAt(0).toString();
      }


      if(num.length() != num2.length()) {
         if(num.length()>num2.length()) {

            int zcount = num.length()-num2.length();   
            for(int i = 1; i<=zcount;i++)
            num2 = ZERO + num2;

         } else {
            int zcount = num2.length()-num.length();  
            for(int i = 1; i<=zcount;i++)
            num = ZERO + num;
         }
      }
      try {
         n2 = new int[num2.length()];
         for (int i = 0; i< num.length(); i++) {
            if(Character.isDigit(num2.charAt(i))) {
               n2[i] = (int)num2.charAt(i)-48;
            } else {
               throw new NumberFormatException( "\n    Try using numbers" );
            }
         }
         n1 = new int[num.length()];
         for (int i = 0; i< num.length(); i++) {
            if(Character.isDigit(num.charAt(i))) {
            n1[i] = (int)num.charAt(i)-48;
            } else {
               throw new NumberFormatException( "\n    Try using numbers" );
            }
         }
      } catch (NumberFormatException nfe) {
          System.out.println("Try using numbers.");
          System.exit( 0 );
      }
      numz = num;
      if (numb == false) {
         num = "-" + num;
      }
      num2z = num2;
      if (num2b == false) {
         num2 = "-" + num2;
      }
   }

   public void noZero() {
      if (num3.charAt(0) == '-') {
         while (num3.charAt(1) == '0') {
         num3 = new StringBuilder(num3).deleteCharAt(1).toString();
         } 
      } else {
         while (num3.charAt(0) == '0') {
         num3 = new StringBuilder(num3).deleteCharAt(0).toString();
         }
      }
   }

     

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to validate that all the characters in the value are valid decimal digits
   *  @return  boolean  true if all digits are good
   *  @throws  IllegalArgumentException if something is hinky
   *  note that there is no return false, because of throwing the exception
   *  note also that this must check for the '+' and '-' sign digits
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public boolean validateDigits() {
      throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to reverse the value of this GinormousInt
   *  @return GinormousInt that is the reverse of the value of this GinormousInt
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public GinormousInt reverser() {
      throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to reverse the value of a GinormousIntk passed as argument
   *  Note: static method
   *  @param  gint         GinormousInt to reverse its value
   *  @return GinormousInt that is the reverse of the value of the GinormousInt passed as argument
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public static GinormousInt reverser( GinormousInt gint ) {
      throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to add the value of a GinormousIntk passed as argument to this GinormousInt using int array
   *  @param  gint         GinormousInt to add to this
   *  @return GinormousInt that is the sum of the value of this GinormousInt and the one passed in
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public GinormousInt add( GinormousInt gint ) {
      //throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
      this.comp(gint.num);
      
      if(numb == num2b) {
         n3 = new int[n1.length + 1];
         for(int i = n1.length - 1; i >= 0; i--) {
            if (n1[i] + n2[i] < 10) {
               n3[i+1] += n1[i] + n2[i];
            } else {
               n3[i+1] += (n1[i]+n2[i])%10;
               n3[i]++;
            }
            if (n3[i+1] >= 10) {
               n3[i+1] -= 10;
               n3[i]++; 
            }
         }
         // if (numb == false && num2b== false){
         //    num3b = false;
         // } else {
         //    num3b = true;
         // }
      } else if (numb != num2b) {
         n3 = new int[n1.length]; 
         if (numz.compareTo(num2z) > 0) {
            for(int i = n1.length - 1; i >= 0; i--) {
               if (n1[i] < n2[i]) {
                  n1[i-1]--;
                  if (n1[i-1] == -1) {
                     n1[i-1] = 9;
                     n1[i-2]--;
                  }
                  n3[i] = (n1[i] + 10) - n2[i];
               } else {
                  n3[i] = n1[i] - n2[i];
               }
            }
            num3b = numb;
         }
         if (numz.compareTo(num2z) < 0) {
            for(int i = n2.length - 1; i >= 0; i--) {
               if (n2[i] < n1[i]) {
                  n2[i-1]--;
                  if (n2[i-1] == -1) {
                     n2[i-1] = 9;
                     n2[i-2]--;
                  }
                  n3[i] = (n2[i] + 10) - n1[i];
               } else {
                  n3[i] = n2[i] - n1[i];
               }
            }
            num3b = num2b;

         }
      }
      num3 = this.toString();
      this.noZero();
      GinormousInt sum = new GinormousInt(num3); 
      return sum;
   }


  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to subtract the value of a GinormousIntk passed as argument to this GinormousInt using ints
   *  @param  gint         GinormousInt to subtract from this
   *  @return GinormousInt that is the difference of the value of this GinormousInt and the one passed in
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public GinormousInt subtract( GinormousInt gint ) {
      //throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
      this.comp(gint.num);
      
      if(numb != num2b) {
         n3 = new int[n1.length + 1];
         for(int i = n1.length - 1; i >= 0; i--) {
            if (n1[i] + n2[i] < 10) {
               n3[i+1] += n1[i] + n2[i];
            } else {
               n3[i+1] += (n1[i]+n2[i])%10;
               n3[i]++;
            }
            if (n3[i+1] >= 10) {
               n3[i+1] -= 10;
               n3[i]++; 
            }
         }

      } else if (numb == num2b) {
         n3 = new int[n1.length]; 
         if (num.compareTo(num2) > 0) {
            for(int i = n1.length - 1; i >= 0; i--) {
               if (n1[i] == -1) {
                  n1[i] = 9;
                  n1[i-1]--;
               }
               if (n1[i] < n2[i]) {
                  n1[i-1]--;
                  n3[i] = (n1[i] + 10) - n2[i];
               } else {
                  n3[i] = n1[i] - n2[i];
               }
            }
         }

         if (num.compareTo(num2) < 0) {
            for(int i = n2.length - 1; i >= 0; i--) {
               if (n2[i] < n1[i]) {
                  n2[i-1]--;
                  if (n2[i-1] == -1) {
                     n2[i-1] = 9;
                     n2[i-2]--;
                  }
                  n3[i] = (n2[i] + 10) - n1[i];
               } else {
                  n3[i] = n2[i] - n1[i];
               }
            }
            num3b = !num3b;
         }
      }
      num3 = this.toString();
      this.noZero();
      GinormousInt dif = new GinormousInt(num3); 
      return dif;
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to multiply the value of a GinormousIntk passed as argument to this GinormousInt
   *  @param  gint         GinormousInt to multiply by this
   *  @return GinormousInt that is the product of the value of this GinormousInt and the one passed in
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public GinormousInt multiply( GinormousInt gint ) {
      throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to divide the value of this GinormousIntk by the GinormousInt passed as argument
   *  @param  gint         GinormousInt to divide this by
   *  @return GinormousInt that is the dividend of this GinormousInt divided by the one passed in
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public GinormousInt divide( GinormousInt gint ) {
      throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to get the remainder of division of this GinormousInt by the one passed as argument
   *  @param  gint         GinormousInt to divide this one by
   *  @return GinormousInt that is the remainder of division of this GinormousInt by the one passed in
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public GinormousInt remainder( GinormousInt gint ) {
      throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to compare a GinormousInt passed as argument to this GinormousInt
   *  @param  gint  GinormousInt to add to this
   *  @return int   that is one of neg/0/pos if this GinormousInt precedes/equals/follows the argument
   *  NOTE: this method performs a lexicographical comparison using the java String "compareTo()" method
   *        THAT was easy.....
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public int compareTo( GinormousInt gint ) {
      return (num.compareTo(gint.num));
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to check if a GinormousInt passed as argument is equal to this GinormousInt
   *  @param  gint     GinormousInt to compare to this
   *  @return boolean  that is true if they are equal and false otherwise
   *  NOTE: this method performs a similar lexicographical comparison as the "compareTo()" method above
   *        also using the java String "equals()" method -- THAT was easy, too..........
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public boolean equals( GinormousInt gint ) {

      return (num.equals( gint.num ));
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to return a GinormousInt given a long value passed as argument
   *  @param  value         long type number to make into a GinormousInt
   *  @return GinormousInt  which is the GinormousInt representation of the long
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   // public static GinormousInt valueOf( long value ) throws NumberFormatException {
   //    GinormousInt gi = null;
   //    try {
   //       gi = new GinormousInt( new Long( value ).toString() );
   //    }
   //    catch( NumberFormatException nfe ) {
   //       System.out.println( "\n  Sorry, the value must be numeric of type long." );
   //    }
   //    return gi;
   // }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to return a String representation of this GinormousInt
   *  @return String  which is the String representation of this GinormousInt
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public String toString() {
      String output = "";
      if (num3b == false) {
         output = "-";
      }
      for( int i = 0; i < n3.length; i++ ) {
         output += n3[i];
      }
      return output;
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to display an Array representation of this GinormousInt as its ints
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   // public void toArray( int[] d ) {
   //    System.out.println( Arrays.toString( d ) );
   // }

   public static void main( String[] args ) {
      System.out.println("EYY!!!");
   }
}
