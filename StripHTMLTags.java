/*CSD 210 HW5 part3(problem 12)
Andrew Franko 2/18/18
Take an input of an html file and remove the tags.
This appears to work but on my IDE it will error at the end
for no reason that I can determine.*/

import java.io.*;
import java.util.*;

public class StripHTMLTags {
    public static void stripHtmlTags() throws FileNotFoundException {
        //Directed that a file would be the input but unsure of file name or location
        Scanner console=new Scanner(new File("C:\\Users\\andre\\Desktop\\basic_page.htm"));
        while(console.hasNextLine()){
            String line=console.nextLine();
            System.out.println(console.nextLine());
            
            if(line.length()==0){
                line=console.nextLine();
            }
            int start=0;
            int stop=0;
            int counter=0;
            while(counter<line.length()-1){
                stop=start;
                while(line.charAt(counter)!='<'){
                    stop++;
                    counter++;
                }
                if(start<stop){
                    start++;
                    System.out.println(line.substring(start,stop));
                }
                start=stop;
                while(line.charAt(counter)!='>'){
                    start++;
                    counter++;
                }
            }
        }     
    }
    public static void main (String[] args)throws FileNotFoundException {
        stripHtmlTags();
    }
}