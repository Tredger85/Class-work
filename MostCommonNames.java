/*CSD 210 HW5 part5(problem 16)
Andrew Franko 2/18/18
Input a string of names and print out which was the appeared the most.
Incomplete, while the logic is here, the turning a string into an array
with all the names does not function as I thought.*/

import java.io.*;
import java.util.*;

public class MostCommonNames {
    public static void mostCommonNames() throws FileNotFoundException {
        //Directed that a file would be the input but unsure of file name or location
        Scanner console=new Scanner(new File("C:\\Users\\andre\\Desktop\\MostCommonNames.txt"));
        while(console.hasNextLine()){
            String line=console.nextLine();
            String [] names = new String[]{line};
            int bestName=0;
            int bestCount=0;
            int counter=0;
            for(int i=0; i<names.length; i++){
                for(int j=0; j<names.length; j++){
                    if(names[i].equals(names[j])){
                        counter++;
                    }
                    if(counter>bestCount){
                        bestCount=counter;
                        bestName=i;
                    }
                 }
             }   
             System.out.println("Most common: "+names[bestName]);   
        }     
    }
    public static void main (String[] args)throws FileNotFoundException {
        mostCommonNames();
    }
}