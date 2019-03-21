/*CSD 211 HW4 problem 4 page 823
Andrew Franko 5/5/18
Recursive program that takes any number and duplicates the numbers in the return.*/

import java.io.*;
import java.util.*;

public class DoubleDigits {

    public static int doubleDigits (int n){
        //Excluding an edge case
        if(n==0){
            return n;
        //Adapting to an edge case
        }else if(n<0){
            return -(doubleDigits(n*-1));
        //This is the base case to double up one number
        }else if (n<10){
            return n*10+n;
        }else{
            return(doubleDigits(n/10)*100+(n%10)*10+(n%10));
        }
    }
    public static void main(String[] args) {
        System.out.println("The following print out is from doubleDigits(3456): "+doubleDigits(3456));
        System.out.println("The following print out is from doubleDigits(-1001): "+doubleDigits(-1001));
        System.out.println("The following print out is from doubleDigits(0): "+doubleDigits(0));   
    }
}