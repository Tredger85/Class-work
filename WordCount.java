/*Andrew Franko 4/20/18
inclass exersize 2
Inhancing and mutating exhisting code, so the text is searchable and
improved parsing of words to minimize extranius charcheters*/

// Uses maps to implement a word count, so that the user
// can see which words occur the most in the book Moby Dick.

import java.io.*;
import java.util.*;

public class WordCount {
    /*// minimum number of occurrences needed to be printed
    Not used in this version of the program, and could have left alone but
    didnt want extra things that were not in use being viable
    public static final int OCCURRENCES = 2000;*/
    
    public static void main(String[] args) 
            throws FileNotFoundException {
       //Uneeded display from the origanal program
       /* System.out.println("This program displays the most");
        System.out.println("frequently occurring words from");
        System.out.println("the book Moby Dick.");
        System.out.println();*/
        
        // read the book into a map
        //Static creation of the map, this is what takes the processing time
        Scanner in = new Scanner(new File("mobydick.txt"));
        Map<String, Integer> wordCountMap = getCountMap(in);
        
        //Unneeded display from the origanal program
        /*for (String word : wordCountMap.keySet()) {
            int count = wordCountMap.get(word);
            if (count > OCCURRENCES) {
                System.out.println(word + " occurs " + count + " times.");
            }
        }*/
        //Start of new code and general prompt/info for the user
        System.out.println("This program will return the number of times");
        System.out.println("that the entered word was used in Moby Dick");
        Boolean contin = true;
        while(contin){
            //Search prompt and input
            System.out.println("Enter a word you are searching for:");
            Scanner console = new Scanner(System.in);
            String input = console.next();
            String search = input.toLowerCase();
            //Success/failure of search test and output info
            if (wordCountMap.containsKey(search)){
                System.out.println("Your word: " + search + ", appears " + wordCountMap.get(search) + " number of times in Moby Dick.");
            } else {
                System.out.println("Your word: " + search + ", does not appear in the book Moby Dick.");
            }
            //Search loop prompt
            System.out.println("Would you like to search for another (y/n)?");
            String answer = console.next();
            //Question to exit the search loop
            if(answer.toUpperCase().equals("N")||answer.toUpperCase().equals("NO")){
                contin=false;
            }
        }
    }
    
    // Reads book text and returns a map from words to counts
    public static Map<String, Integer> getCountMap(Scanner in) {
        //only line of new code in the method
        in.useDelimiter("[^a-zA-Z']+");
        Map<String, Integer> wordCountMap = new TreeMap<String, Integer>();
        while (in.hasNext()) {
            String word = in.next().toLowerCase();
            if (!wordCountMap.containsKey(word)) {
                // never seen this word before
                wordCountMap.put(word, 1);
            } else {
                // seen this word before; increment count
                int count = wordCountMap.get(word);
                wordCountMap.put(word, count + 1);
            }
        }
        
        return wordCountMap;
    }
}
