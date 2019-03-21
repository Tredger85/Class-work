/*CSD 211 HW#8 problems 9 and 11 from page 1105
Andrew Franko 6/9/18
Added two methods, one returns the Nth smallest number of the PriorityQueue where N is a parameter
and a method that removes all dupicate entries in a PriorityQueue.  They werent too difficult but
I do wonder if there is not a more elequint solution to stream line the processing.  I did change
the order of the heap in kthSmallest but as order does not change how the heap functions, I felt
that this met the question requirement to not change the PriorityQueue.
kthSmallest starts on line 155
removeDuplicates starts on line 176*/

import java.util.*;
import java.util.Arrays;
import java.util.NoSuchElementException;

// Implements a priority queue of integers using a
// min-heap represented as an array.
public class HeapIntPriorityQueue {
    private int[] elementData;
    private int size;
    
    // Constructs an empty queue.
    public HeapIntPriorityQueue() {
        elementData = new int[10];
        size = 0;
    }
    
    // Adds the given element to this queue.
    public void add(int value) {
        // resize if necessary
        if (size + 1 >= elementData.length) {
            elementData = Arrays.copyOf(elementData, elementData.length * 2);
        }
        
        // insert as new rightmost leaf
        elementData[size + 1] = value;
        
        // "bubble up" toward root as necessary to fix ordering
        int index = size + 1;
        boolean found = false;   // have we found the proper place yet?
        while (!found && hasParent(index)) {
            int parent = parent(index);
            if (elementData[index] < elementData[parent]) {
                swap(elementData, index, parent(index));
                index = parent(index);
            } else {
                found = true;  // found proper location; stop the loop
            }
        }
        
        size++;
    }
    
    // Returns true if there are no elements in this queue.
    public boolean isEmpty() {
        return size == 0;
    }
    
    // Returns the minimum value in the queue without modifying the queue.
    // If the queue is empty, throws a NoSuchElementException.
    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return elementData[1];
    }
    
    // Removes and returns the minimum value in the queue.
    // If the queue is empty, throws a NoSuchElementException.
    public int remove() {
        int result = peek();

        // move rightmost leaf to become new root
        elementData[1] = elementData[size];
        size--;
        
        // "bubble down" root as necessary to fix ordering
        int index = 1;
        boolean found = false;   // have we found the proper place yet?
        while (!found && hasLeftChild(index)) {
            int left = leftChild(index);
            int right = rightChild(index);
            int child = left;
            if (hasRightChild(index) &&
                    elementData[right] < elementData[left]) {
                child = right;
            }
            
            if (elementData[index] > elementData[child]) {
                swap(elementData, index, child);
                index = child;
            } else {
                found = true;  // found proper location; stop the loop
            }
        }
        
        return result;
    }
    
    // Returns the number of elements in the queue.
    public int size() {
        return size;
    }
    
    // Returns a string representation of this queue, such as "[10, 20, 30]";
    // The elements are not guaranteed to be listed in sorted order.
    public String toString() {
        String result = "[";
        if (!isEmpty()) {
            result += elementData[1];
            for (int i = 2; i <= size; i++) {
                result += ", " + elementData[i];
            }
        }
        return result + "]";
    }
    
    
    // helpers for navigating indexes up/down the tree
    private int parent(int index) {
        return index / 2;
    }
    
    // returns index of left child of given index
    private int leftChild(int index) {
        return index * 2;
    }
    
    // returns index of right child of given index
    private int rightChild(int index) {
        return index * 2 + 1;
    }
    
    // returns true if the node at the given index has a parent (is not the root)
    private boolean hasParent(int index) {
        return index > 1;
    }
    
    // returns true if the node at the given index has a non-empty left child
    private boolean hasLeftChild(int index) {
        return leftChild(index) <= size;
    }
    
    // returns true if the node at the given index has a non-empty right child
    private boolean hasRightChild(int index) {
        return rightChild(index) <= size;
    }
    
    // switches the values at the two given indexes of the given array
    private void swap(int[] a, int index1, int index2) {
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }
    
    //Method that returns the k smallest int, while returning the queue unchanged
    public static int kthSmallest(HeapIntPriorityQueue pq, int k){
        //Exception clause
        if(k<1 || k>pq.size()){
            throw new IllegalArgumentException();
        }
        //Auxiliary queue
        Queue <Integer> holder = new LinkedList<Integer>();
        int toReturn = 0;
        //Cycling through to get to the kth position
        for (int i=0; i<k; i++){
            toReturn = pq.remove();
            holder.add(toReturn);
        }
        //Refilling the PriorityQueue from the auxiliary queue
        while (!holder.isEmpty()){
            pq.add(holder.remove());
        }
        return toReturn;
    }
    
    //Method that will remove dupicates
    public static void removeDuplicates(HeapIntPriorityQueue dupes){
        //Auxillery queue to hold the non-dupes
        Queue <Integer> holder = new LinkedList<Integer>();
        //Exception clause
        if(dupes.isEmpty()){
            throw new IllegalArgumentException();
        //Test parameter, if the PriorityQueue only has one int it falls through
        }else if (dupes.size()>1){
            int first = dupes.remove();
            int second = 0;
            //If we are not at the end, keep going
            while(!dupes.isEmpty()){
                second = dupes.remove();
                if(first!=second){
                    holder.add(first);
                    first=second;
                }
            }
            //Move the remaining int to the holder
            holder.add(first);
        }
        //Shift everything from the holder back to the parameter PriorityQueue
        while (!holder.isEmpty()){
            dupes.add(holder.remove());
        }
    }
            
    public static void main(String[] args) {
        HeapIntPriorityQueue pq1 = new HeapIntPriorityQueue();
        pq1.add(5);
        pq1.add(-7);
        pq1.add(55);
        pq1.add(67);
        pq1.add(-5);
        pq1.add(16);
        pq1.add(14);
        System.out.println("Print of PriorityQueue pq1: "+pq1);
        System.out.println("Print of 4th in pq1 using kthSmallest: "+kthSmallest(pq1,4));
        System.out.println("Print of pq1 after kthSmallest (contents are the same but the order is different: "+pq1);
        System.out.println("Print of 4th in pq1 using kthSmallest (showing queue order is irrelevent): "+kthSmallest(pq1,4));
        HeapIntPriorityQueue pq2 = new HeapIntPriorityQueue();
        pq2.add(5);
        HeapIntPriorityQueue pq3 = new HeapIntPriorityQueue();
        pq3.add(6);
        pq3.add(6);
        pq3.add(6);
        HeapIntPriorityQueue pq4 = new HeapIntPriorityQueue();
        pq4.add(5);
        pq4.add(5);
        pq4.add(5);
        pq4.add(5);
        pq4.add(5);
        pq4.add(1);
        pq4.add(2);
        pq4.add(3);
        pq4.add(4);
        pq4.add(1);
        pq4.add(2);
        pq4.add(3);
        pq4.add(4);
        pq4.add(1);
        pq4.add(2);
        pq4.add(3);
        pq4.add(4);
        System.out.println("Print of PriorityQueue pq2: "+pq1);
        removeDuplicates(pq1);
        System.out.println("Print of PriorityQueue pq2 after removeDuplicates: "+pq1);
        System.out.println("Print of PriorityQueue pq2: "+pq2);
        removeDuplicates(pq2);
        System.out.println("Print of PriorityQueue pq2 after removeDuplicates: "+pq2);
        System.out.println("Print of PriorityQueue pq3: "+pq3);
        removeDuplicates(pq3);
        System.out.println("Print of PriorityQueue pq3 after removeDuplicates: "+pq3);
        System.out.println("Print of PriorityQueue pq4: "+pq4);
        removeDuplicates(pq4);
        System.out.println("Print of PriorityQueue pq4 after removeDuplicates: "+pq4);
    }
}
