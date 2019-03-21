/*CSD 211 HW5 problem 3 page 917
Andrew Franko 5/10/18
Copy a stack to another stack using only an auxilary queue.  The original should come back unchanged.*/

import java.io.*;
import java.util.*;

public class CopyStack {

    public static Stack<Integer> copyStack (Stack<Integer> start){
        Stack <Integer> copy = new Stack <Integer>();
        Queue <Integer> holder = new LinkedList <Integer>();
        //Flip the order of the paramater, stack to stack
        while(!start.isEmpty()){
            copy.push(start.pop());
        }
        //Hold reversed order in the queue, stack to queue
        while(!copy.isEmpty()){
            holder.add(copy.pop());
        }
        //Move through the queue, filling both the copy and original stacks
        while(!holder.isEmpty()){
            int hold = holder.remove();
            start.push(hold);
            copy.push(hold);
        }
        return copy;
    }
    public static void main(String[] args) {
        Stack <Integer> test1 = new Stack <Integer>();
        for(int i = 5; i>0; i--){
            test1.push(i);
        }
        System.out.println("Test stack, test1: "+ test1);
        System.out.println("Copy of test1, copyStack(test1): "+copyStack(test1));
        System.out.println("Testing that they are copies and do not share the same pointer (!=):");
        System.out.println(test1!=copyStack(test1));
    }
}