/*CSD 211 HW#7 problems 8 and 12 from pages 1013 and 1014
Andrew Franko 6/2/18
Added two methods.  SwitchPairs that swaps each adjacent pairs and Split that moves
all the negative numbers to the front of the linkedlist.  I built this off of the 
same base that I used for the in class exersize, so there is some other additional methods
that I had writen before.
SwitchPairs starts on line 151
Split starts on line 168*/

// Class LinkedIntList can be used to store a list of integers.

import java.util.*;

public class LinkedIntList implements IntList {
    private ListNode front;  // first value in the list

    // post: constructs an empty list
    public LinkedIntList() {
        front = null;
    }

    // post: returns the current number of elements in the list
    public int size() {
        int count = 0;
        ListNode current = front;
        while (current != null) {
            current = current.next;
            count++;
        }
        return count;
    }

    // pre : 0 <= index < size()
    // post: returns the integer at the given index in the list
    public int get(int index) {
        return nodeAt(index).data;
    }

    // post: creates a comma-separated, bracketed version of the list
    public String toString() {
        if (front == null) {
            return "[]";
        } else {
            String result = "[" + front.data;
            ListNode current = front.next;
            while (current != null) {
                result += ", " + current.data;
                current = current.next;
            }
            result += "]";
            return result;
        }
    }

    // post : returns the position of the first occurrence of the given
    //        value (-1 if not found)
    public int indexOf(int value) {
        int index = 0;
        ListNode current = front;
        while (current !=  null) {
            if (current.data == value) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }

    // post: appends the given value to the end of the list
    public void add(int value) {
        if (front == null) {
            front = new ListNode(value);
        } else {
            ListNode current = front;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new ListNode(value);
        }
    }

    // pre: 0 <= index <= size()
    // post: inserts the given value at the given index
    public void add(int index, int value) {
        if (index == 0) {
            front = new ListNode(value, front);
        } else {
            ListNode current = nodeAt(index - 1);
            current.next = new ListNode(value, current.next);
        }
    }

    // pre : 0 <= index < size()
    // post: removes value at the given index
    public void remove(int index) {
        if (index == 0) {
            front = front.next;
        } else {
            ListNode current = nodeAt(index - 1);
            current.next = current.next.next;
        }
    }

    // pre : 0 <= i < size()
    // post: returns a reference to the node at the given index
    private ListNode nodeAt(int index) {
        ListNode current = front;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }
    //Find the minimum int in the list
    public int min() {
        if (front == null) {
            throw new NoSuchElementException();
        } 
        ListNode current = front;
        //Setting the first int to min as a start
        int min = current.data;
        while (current != null) {
            //testing to see if any int is less than what is currently held
            if(min>current.data){
                min = current.data;
            }
            current = current.next;
        }
        return min;
    }
    
    public void firstToLast(){
        //Testing for an empty list or list of 1
        if(front!=null && front.next!=null){
            //classic step through the list
            ListNode current = front;
            while (current.next != null) {
                current = current.next;
            }
            //double up the pointer to the front
            ListNode mover = front;
            //mover the total list pointer to the new first item
            front = front.next; 
            //decouple the mover from the front of the list
            mover.next=null;
            //add the decoupled node to the end
            current.next = mover; 
        } 
    }
    
    public void switchPairs(){
        //Testing for an empty list or list of 1
        if(front!=null && front.next!=null){
            //classic step through the list
            ListNode current = front;
            //accounting for 
            while (current != null && current.next != null) {
                int temp = current.data;
                current.data = current.next.data;
                current.next.data = temp;
                
                current = current.next.next;
            }
        } 
    }
        
    
    public void split(){
        //Testing for an empty list or list of 1
        if(front!=null && front.next!=null){
            //creating a pointer to move through the list
            ListNode current = front;
            //continue until we hit the end of the list
            while (current.next != null) {
                //test to see if we want to move the next node
                if(current.next.data < 0){
                    //new pointer to the node we want to move
                    ListNode toMove = current.next;
                    //link around the node we are moving
                    current.next = current.next.next;
                    //linking the moving node to the front of the list
                    toMove.next = front;
                    //reestablishing the front of the list
                    front = toMove;
                //step through to the next node 
                }else{
                    current = current.next;
                }
            }
        }
    }
    
    public static void main(String[] args) {
    //Testing
    LinkedIntList list1 = new LinkedIntList();
    list1.add(5);
    list1.add(-2);
    list1.add(-4);
    list1.add(7);
    list1.add(0);
    list1.add(9);
    list1.add(2);
    list1.add(-5);
    System.out.println("LinkedIntList list1: "+list1);
    list1.split();
    System.out.println("LinkedIntList list1 after split: "+list1);
    list1.switchPairs();
    System.out.println("LinkedIntList list1 then after switchPairs(even length):");
    System.out.println(list1);
    list1.remove(0);
    list1.switchPairs();
    System.out.println("LinkedIntList list1 then after switchPairs(removing index 0 to make length odd):");
    System.out.println(list1);
    System.out.println();
    System.out.println("The next print outs are to demonstrate robustness of empty lists"); 
    System.out.println("and lists that only contain on element.");
    System.out.println();
    LinkedIntList list2 = new LinkedIntList();
    System.out.println("LinkedIntList list2: "+list2);
    list2.split();
    System.out.println("LinkedIntList list2 after split: "+list2);
    list2.switchPairs();
    System.out.println("LinkedIntList list2 then after switchPairs: "+list2);
    LinkedIntList list3 = new LinkedIntList();
    list3.add(-5);
    System.out.println("LinkedIntList list3: "+list3);
    list3.split();
    System.out.println("LinkedIntList list3 after split: "+list3);
    list3.switchPairs();
    System.out.println("LinkedIntList list3 then after switchPairs: "+list3);
    }
}
