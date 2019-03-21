/*CSD 210 HW6 part2(problem 18)
Andrew Franko 2/27/18
Imports a file, counts the length of all the tokens(avaluated as strings regardless of type)
in the file and then printing a histogram of the counts.
This was fairly straight forward as we have looked at the parts that make up this program
indiviually before.*/
import java.io.*;
import java.util.*;
public class WordLengths {
    public static void wordLengths (Scanner console) {
        /*we were told to assume that none of the words would be more
        than 80 characters long*/
        int [] array = new int [81];
        String next;
        int last=0;
        while (console.hasNext()){
            next=console.next();
            array[next.length()]++;
            if(next.length()>last){
                last = next.length();
            }
        }
        for(int i=1; i<=last; i++){
            System.out.print(i+ " : "+array[i] +" ");
            for(int j=0; j<array[i]; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void main (String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("C:/Users/andre/Desktop/wordLength.txt"));
        wordLengths(input);
    }
}