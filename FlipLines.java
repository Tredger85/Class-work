/*CSD 210 HW5 part2(problem 7)
Andrew Franko 2/18/18
Take a file as an input and switch the odd and even lines and print.
I almost had a section that treated the strings/lines as object but
realized that would all be redundent if I just print them in reverse order.
Please again remove my test file location and replace.*/

import java.io.*;
import java.util.*;

public class FlipLines {
    public static void flipLines() 
        throws FileNotFoundException {
        //Directed that a file would be the input but unsure of file name or location
        Scanner console=new Scanner(new File("C:\\Users\\andre\\Desktop\\FlipLines.txt"));
        while(console.hasNextLine()){
            String lineA=console.nextLine();
                if(console.hasNextLine()){
                    String lineB=console.nextLine();
                    System.out.println(lineB);
                    System.out.println(lineA);
                } else {
                    System.out.println(lineA);
                }
            }
        }
    public static void main (String[] args)throws FileNotFoundException {
        flipLines();
    }
}