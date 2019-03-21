/*CSD 210 HW6 part1(problem 15)
Andrew Franko 2/27/18
Method that will add pairs of numbers from an array into a new array, if the old array is
an odd number of locations then keep the last number in the last location of the new array.
It would have been nice to combine the both if statements and the array intialization
into one if statement but that would have localized the array. Origanally had a println
for testing but the question asked for a return statement*/
import java.util.*;
public class Collapse {
    public static int[] collapse(int[]old) {
        int arraylength = 0;
        if (old.length%2>0){
            arraylength = old.length/2+1;
        } else {
            arraylength = old.length/2;
        }
        int [] collapsed = new int[arraylength];
        int counter=0;
        for(int i=0; i<old.length/2; i++){
            counter=i*2;
            collapsed[i]=old[counter]+old[counter+1];
        }
        if (old.length%2>0){
            collapsed[collapsed.length-1]=old[old.length-1];
        }
        return collapsed;
        //System.out.println(Arrays.toString(collapsed));
    }
    public static void main (String[] args) {
        int [] test1 = {7, 2, 8, 9, 4, 13, 7, 1, 9, 10};
        int [] test2 = {9, 17, 17, 8, 19};
        collapse(test1);
        collapse(test2);
    }
}