/*CSD 211 HW5 problem 8 page 917
Andrew Franko 5/10/18
Rearrange a queue so all the evens come before odds, keeping them relative order
as before. No return or print was asked for.*/

import java.io.*;
import java.util.*;

public class Rearrange {

    public static void rearrange (Queue<Integer> q){
        //Split odds and evens, odds are in reverse order
        arrange(q);
        //While somewhat redundent, reverses the odds back to the correct order
        arrange(q);
    }    
     //Created a method for code reuse
     public static void arrange (Queue<Integer> queue){   
        Stack <Integer> holder = new Stack <Integer>();
        int qsize=queue.size();
        //Splitting the queue into evens and odds, odds added to the stack
        for(int i =1; i<=qsize; i++){
            int hold = queue.remove();
            if(hold%2==0){
                queue.add(hold);
            }else{
                holder.push(hold);
            }
        }
        //Added the stack back to the end of queue
        while(!holder.isEmpty()){
            queue.add(holder.pop());
        }   
    }
    public static void main(String[] args) {
        Queue<Integer> test1 = new LinkedList<Integer>();
        test1.add(3);
        test1.add(8);
        test1.add(17);
        test1.add(9);
        test1.add(17);
        test1.add(8);
        test1.add(3);
        System.out.println("Queue test1: "+test1);
        rearrange(test1);
        System.out.println("Test set 1 rearranged: "+test1);
        Queue<Integer> test2 = new LinkedList<Integer>();
        test2.add(3);
        test2.add(7);
        test2.add(12);
        test2.add(9);
        test2.add(4);
        test2.add(17);
        test2.add(8);
        test2.add(6);
        System.out.println("Queue test2: "+test2);
        rearrange(test2);
        System.out.println("Test set 2 rearranged: "+test2);
    }
}