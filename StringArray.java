/*CSD 211 HW2 problems 1, 3 and 7 page 711
Andrew Franko 4/20/18
As all three questions ask to manipulate a ArrayList of strings,
I combined them for the same test ArrayList would work with each.*/

import java.io.*;
import java.util.*;

public class StringArray {
    //Method of question 1
    public static double averageVowels(ArrayList<String> list){
        
        double totalVowels = 0;
        String vowels = "aeiouAEIOU";
        
        //Step through the Array
        for(String word : list){
            //Step through the word in each position of the Array
            for (int i = 0; i<word.length(); i++){
                //Step through each of the vowels, it seems silly but 
                //is more simple than 10 test conditions in the if statement
                for(int v = 0; v <vowels.length(); v++){
                    //Testing if the character is a valid vowel
                    if(word.charAt(i)==vowels.charAt(v)){
                        totalVowels++;
                    }
                }
            }
        }
        return totalVowels/list.size();
    }
    //Method for question 3
    public static ArrayList<String> removeEvenLength(ArrayList<String> noneven){
        //Step through the Array, working back to front for speed considerations
        for(int i = noneven.size()-1; i>=0; i--){
            String word = noneven.get(i);
            //Testing the length if even
            if(word.length()%2==0){
                noneven.remove(i);
            }
        }
        return noneven;
    } 
    //Method for question 7
    public static ArrayList<String> removeDuplicates(ArrayList<String> dupes){
        //Step through the Array, working back to front for speed considerations
        for(int i = dupes.size()-1; i>0; i--){
            //Test if two adjacent strings are equal
            if(dupes.get(i).equals(dupes.get(i-1))){
                dupes.remove(i);
            }
        }
        return dupes;
    }
    public static void main(String[] args) {
        ArrayList<String> test1 = new ArrayList<String>();
        test1.add("Led Zeppelin");
        test1.add("Led Zeppelin");
        test1.add("Led Zeppelin");
        test1.add("Eagles");
        test1.add("Eagles");
        test1.add("Queen");
        test1.add("KISS");
        test1.add("KISS");
        System.out.println("ArrayList test1 input print: " + test1);
        System.out.println("AverageVowels average from test1 ArrayList: "+ averageVowels(test1));
        System.out.println("ArrayList test1 after removeDuplicates: "+ removeDuplicates(test1));
        System.out.println("ArrayList test1 after removeEvenLength: "+ removeEvenLength(test1));
    }
}
