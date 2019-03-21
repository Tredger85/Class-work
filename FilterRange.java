/*CSD 211 HW2 problems 15 page 712
Andrew Franko 4/21/18
Method that filters out a range of integers from an ArrayList.*/

import java.io.*;
import java.util.*;

public class FilterRange {
    
    public static ArrayList<Integer> filterRange(ArrayList<Integer> list, int first, int second){
        //While not part of the question, some added robustness that the method doesnt break
        //if the first integer parameter is not less than the second integer parameter
        int min = Math.min(first, second);
        int max = Math.max(first, second);
        //Step through the Array list, back to front for so that it doesnt matter if the
        //program finds anything and moves on, and speed considerations
        for (int i = list.size()-1; i>=0; i--){
            //Test if the number falls within the range
            if(list.get(i)<=max && list.get(i)>=min){
                list.remove(i);
            }
        }
        return list;
    }
    
    public static void main(String[] args) {
        ArrayList<Integer> test2 = new ArrayList<Integer>();
        test2.add(4);
        test2.add(7);
        test2.add(9);
        test2.add(2);
        test2.add(7);
        test2.add(7);
        test2.add(5);
        test2.add(3);
        test2.add(5);
        test2.add(1);
        test2.add(7);
        test2.add(8);
        test2.add(6);
        test2.add(7);
        ArrayList<Integer> test3 = new ArrayList<Integer>();
        System.out.println("ArrayList test2 input print: " + test2);
        System.out.println("ArrayList test2 after filter -5 to 0: " + filterRange(test2, -5, 0));
        System.out.println("ArrayList test2 after filter 7 to 5: " + filterRange(test2, 7, 5));
        System.out.println("ArrayList test3 input print: " + test3);
        System.out.println("ArrayList test3 after filter: " + filterRange(test3, 5, 7));
    }
}