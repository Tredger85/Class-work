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

   // Returns a String for this time span such as "6h15m".
   public String toString() {
      return (totalMinutes / 60) + "h" + 
            (totalMinutes % 60) + "m";
   }
   //Accessor to call the private variable
   public int getTotalMinutes(){
       return totalMinutes;
   }
   //
   public boolean equals(TimeSpan other){
       return getTotalMinutes()==other.getTotalMinutes();
   }
   //Simple test to verify that 
   public static void main (String[] args){
       TimeSpan first = new TimeSpan(5,30);
       TimeSpan second = new TimeSpan (5,30);
       System.out.println(first.equals(second));
       System.out.println(second.equals(first));
   }
}
