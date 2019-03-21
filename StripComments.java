/*CSD 210 HW5 part4(problem 13)
Andrew Franko 2/18/18
Take a java file and remove the comments
While this seems to have the correct logic, the program will not catch the block
comments as it should.  I did also see that this program will also mess with the
formating of an line comment.*/

import java.io.*;
import java.util.*;

public class StripComments {
    public static void stripComments() throws FileNotFoundException {
        //Directed that a file would be the input but unsure of file name or location
        Scanner console=new Scanner(new File("C:\\Users\\andre\\Desktop\\StripHTMLTags.java"));
        boolean print=true;
        while(console.hasNextLine()){
            String line=console.nextLine();
            int counter=0;   
            while(counter<line.length()){
                if(line.charAt(counter)=='/' && line.charAt(counter+1)=='/'){
                    line=console.nextLine();
                    counter=0;
                    print=true;
                }
                if(line.charAt(counter)=='/' && line.charAt(counter+1)=='*'){
                    print=false;
                }
                if(line.charAt(counter)=='*' && line.charAt(counter+1)=='/'){
                    print=true;
                    counter++;
                }
                if(print);
                    System.out.print(line.charAt(counter));
                    counter++;
            }
            System.out.println();
        }     
    }
    public static void main (String[] args)throws FileNotFoundException {
        stripComments();
    }
}