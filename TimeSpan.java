/*CSD 210 HW6 part4(problem 9)
Andrew Franko 3/1/18
Created a method that doubles the timeSpan object 
by a variable (whole number) and returns it.
Personal code that fulfills the assignment is at the end.*/

// Represents a time span of hours and minutes elapsed.
// Alternate implementation using only total minutes.

public class TimeSpan {
   private int totalMinutes;

   // Constructs a time span with the given interval.
   // pre: hours >= 0 && minutes >= 0
   public TimeSpan(int hours, int minutes) {
      totalMinutes = 0;
      add(hours, minutes);
   }
   
   // Adds the given interval to this time span.
   // pre: hours >= 0 && minutes >= 0
   public void add(int hours, int minutes) {
      totalMinutes += 60 * hours + minutes;
   }

   // Returns whether o is a TimeSpan representing the same
   // number of hours and minutes as this TimeSpan object.
   public boolean equals(Object o) {
      if (o instanceof TimeSpan) {
         TimeSpan other = (TimeSpan) o;
         return totalMinutes == other.totalMinutes;
      } else {   // not a TimeSpan object
         return false;
      }
   }

   // Returns a String for this time span such as "6h15m".
   public String toString() {
      return (totalMinutes / 60) + "h" + 
            (totalMinutes % 60) + "m";
   }
   //Scales up the TimeSpan
    public void scale(int scale){
        totalMinutes*=scale;        
    }
public static void main (String[] args){
    TimeSpan a = new TimeSpan(3, 35);
    a.scale(3);
    System.out.println(a);
    TimeSpan b = new TimeSpan(7, 15);
    b.scale(75);
    System.out.println(b);
}
}