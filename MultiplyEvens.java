/*CSD 211 HW4 problem 8 page 823
Andrew Franko 5/5/18
Recursive multiplication of the number of even numbers equal to the input parameter
ie multiplyEvens(4)=2*4*6*8(the first four even numbers).*/

import java.io.*;
import java.util.*;

public class MultiplyEvens {

    public static int multiplyEvens (int n){
        return multiplyEvens(n,2);
    }
    //Created private call to hold and pass running total
    private static int multiplyEvens (int n, int total){
        if(n<=0){
            throw new IllegalArgumentException("Out of range, enter positive integer");
        }
        //Base case
        if(n==1){
        //Public call started with total being 2 or could have multiplied on last time before final return
            return total;
        }else{
            total*=(n*2);
            return multiplyEvens(n-1,total);
        }
    }
    public static void main(String[] args) {
        System.out.println("The following print out is from multiplyEvens(4): "+multiplyEvens(4));
        System.out.println("The following print out is from multiplyEvens(1): "+multiplyEvens(1));
        System.out.println("Testing exception, multiplyEvens(0): "+multiplyEvens(0));
    }
}