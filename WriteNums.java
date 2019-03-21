/*CSD 211 HW4 problem 2 page 822
Andrew Franko 5/5/18
Recursive print of numbers up to the integer passed as parameter input.*/

import java.io.*;
import java.util.*;

public class WriteNums {

    public static void writeNums(int n){
        if(n<1){
            throw new IllegalArgumentException("Out of range, enter positive integer");
        }
        //Base case
        if(n==1){
            System.out.print(n);
        } else {
            writeNums(n-1);
            System.out.print(", "+n);
        }
    }   
    public static void main(String[] args) {
        System.out.println("The following print out is from writeNums(5):");
        writeNums(5);
        System.out.println();
        System.out.println("The following print out is from writeNums(12):");
        writeNums(12);
        System.out.println();
        System.out.println("Testing exception:");
        writeNums(-1);
    }
}