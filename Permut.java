/*CSD 211 HW4 problem 15 page 824
Andrew Franko 5/6/18
Recursive call that computes unique permutations of r items from a group of n or 
mathmatically n!/(n-r)!.*/

import java.io.*;
import java.util.*;

public class Permut {

    public static int permut (int n, int r){
        //While the question didnt ask of an exception, the two below seemed to be logical to have
        if(n<1 || r>n){
            throw new IllegalArgumentException();
        }
        return permut(n,r,1);
    }
    //Created private call to hold and pass running total
    private static int permut (int n, int r, int total){
        //Base case
        if(r==0){
             return total;
        } else {
            total*=n;
            return permut(n-1,r-1,total);
        }
    }
    public static void main(String[] args) {
        System.out.println("The following print out is from permut(7,4): "+permut(7,4));
        System.out.println("The following print out is from permut(6,3): "+permut(6,3));
        System.out.println("The following print out is from permut(9,5): "+permut(9,5));    
        System.out.println("Testing Exception permut(1,2):"+permut(1,2));
    }
}