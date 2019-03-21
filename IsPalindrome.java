/*CSD 211 HW5 problem 8 page 917
Andrew Franko 5/10/18
Taking a queue and checking to see if it is a palindrome.  Only using one auxiliary stack.*/

import java.io.*;
import java.util.*;

public class IsPalindrome {

    public static boolean isPalindrome (Queue<Integer> pal){
        Stack <Integer> holder = new Stack <Integer>();
        int size=pal.size();
        //Loading the first half of the queue into the string
        //and also moving that half to the back of the queue
        for(int i =1; i<=size/2; i++){
            int hold=pal.remove();
            pal.add(hold);
            holder.push(hold);
        }
        //Accounting for an odd length queue and moving the middle number to the end
        if(size%2==1){
            pal.add(pal.remove());
        }
        //Testing to see if the numbers are the same
        while(holder.size()>=1 && pal.peek()==holder.peek()){
            pal.add(pal.remove());
            holder.pop();
        }
        //Holding the result while the queue is put back together if it is not a palindrome
        boolean result = holder.isEmpty();
        //Finish cycling through the queue and clearing the stack
        while(!holder.isEmpty()){
            pal.add(pal.remove());
            holder.pop();
        }
        return result;
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
        System.out.println("Is it a palindrome? "+isPalindrome(test1));
        System.out.println("Reprint of unaffected queue: "+test1);
        Queue<Integer> test2 = new LinkedList<Integer>();
        test2.add(3);
        test2.add(8);
        test2.add(17);
        test2.add(9);
        test2.add(4);
        test2.add(17);
        test2.add(8);
        test2.add(3);
        System.out.println("Queue test2: "+test2);
        System.out.println("Is it a palindrome? "+isPalindrome(test2));
        System.out.println("Reprint of unaffected queue: "+test2);
        Queue<Integer> test3 = new LinkedList<Integer>();
        System.out.println("Queue test3: "+test3);
        System.out.println("Is it a palindrome? "+isPalindrome(test3));
    }
}