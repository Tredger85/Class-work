/*CSD 211 HW4 problem 6 page 823
Andrew Franko 5/5/18
Recursive printing of Odd numbers(stepping down to 1) and Even numbers(stepping up from 2)
to the input parameters square.*/

import java.io.*;
import java.util.*;

public class WriteSquares {

    public static void writeSquares(int n){
        if(n<1){
            throw new IllegalArgumentException("Out of range, enter positive integer");
        }
        //Base case and turning point from decreasing output to increasing output
        if(n==1){  
            System.out.print(n);
        //Test if n is odd, and there for pre recursive printing
        }else if(n%2==1){  
            System.out.print(n*n+", ");
            writeSquares(n-1);
        //If n is not odd, and there for even, only post recursive printing
        }else{     
            writeSquares(n-1);
            System.out.print(", "+(n*n));
        }
    }
    public static void main(String[] args) {
        System.out.println("The following print out is from writeSquares(5):");
        writeSquares(5);
        System.out.println();
        System.out.println("The following print out is from writeSquares(12):");
        writeSquares(12);
        System.out.println();
        System.out.println("Testing exception:");
        writeSquares(-1);
    }
}