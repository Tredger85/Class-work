/*CSD 211 HW3 problem 8 page 751
Andrew Franko 4/26/18
Take a set of strings and find the length of the longest string.
With for-each this turned out compact*/


import java.io.*;
import java.util.*;

public class MaxLength{
    
    public static int maxLength(Set<String> set){
        int max = 0;
        //Cycle through the elements in the set
        for(String element:set){
            if (element.length()>max){
                max=element.length();
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Set<String> test1 = new HashSet<String>();    
        System.out.println("Print of Set test1(empty) maxLength: "+maxLength(test1));   
        test1.add("a");
        test1.add("an");
        test1.add("any"); 
        test1.add("aunt");
        test1.add("add");
        test1.add("as");
        System.out.println("Print of Set test1 filled: "+test1);
        System.out.println("Print of Set test1(filled) maxLength: "+maxLength(test1));
        test1.add("highfive");
        test1.add("a really long string of words as one string in the set");
        System.out.println("Print of Set test1 with more words added: "+test1);
        System.out.println("Print of Set test1(added) maxLength: "+maxLength(test1));
    }
}