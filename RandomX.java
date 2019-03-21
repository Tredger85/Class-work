/*CSD 210 HW4 part1(problem 4)
Andrew Franko 2/9/18
Print a number of X's between 5 and 20 (inclusive). Once one
line has more than 15 X's, stop printing lines.  I had some trouble
making a return work to break all the while loops but that
made me refactor to a much nicer looking function.*/
import java.util.*;
public class RandomX {
    public static void randomX() {
        Random rand=new Random();
        int count=0;
        while(count<=15){
            count=0;
            int x=rand.nextInt(16)+5;
            while(x>count){
                System.out.print("x");
                count++;
            }
            //System.out.print(count); //test-prevent pysical counting of x
            System.out.println();
        }
    }
    public static void main (String[] args) {
    }
}