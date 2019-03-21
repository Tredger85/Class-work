/*CSD 211 HW#8 problems 1, 2, and 3 from page 1104
Andrew Franko 6/9/18
Added three methods, addAll, containsAll and equals.  While none of the methods were
particularly conceptually difficult.  The hard part was working out how to step through
the hash.  I thought long about implementing an iterator.  Things I considered not to 
implement an iterator: I knew that my efforts were getting me closer and eventually
was successful with out the iterator i.e. I had an amount of sunk cost compared to 
scrapping and then working out how to implement the iterator, additionally, it appears
to me that even with out an iterator I ended up with O(N) or O(2N) for the methods which
isnt bad.  I am particularly please with how simple the equals method is.
addAll starts on line 161
containsAll starts on line 184
equals starts on line 205*/

// Implements a set of integers using a hash table.
// The hash table uses separate chaining to resolve collisions.
import java.util.*;

public class HashIntSet{
    private static final double MAX_LOAD_FACTOR = 0.75;
    private HashEntry[] elementData;
    private int size;
    
    // Constructs an empty set.
    public HashIntSet() {
        elementData = new HashEntry[10];
        size = 0;
    }
    
    // Adds the given element to this set, if it was not already
    // contained in the set.
    public void add(int value) {
        if (!contains(value)) {
            if (loadFactor() >= MAX_LOAD_FACTOR) {
                rehash();
            }
            
            // insert new value at front of list
            int bucket = hashFunction(value);
            elementData[bucket] = new HashEntry(value, elementData[bucket]);
            size++;
        }
    }
    
    // Removes all elements from the set.
    public void clear() {
        for (int i = 0; i < elementData.length; i++) {
            elementData[i] = null;
        }
        size = 0;
    }
    
    // Returns true if the given value is found in this set.
    public boolean contains(int value) {
        int bucket = hashFunction(value);
        HashEntry current = elementData[bucket];
        while (current != null) {
            if (current.data == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    // Returns true if there are no elements in this queue.
    public boolean isEmpty() {
        return size == 0;
    }
    
    // Removes the given value if it is contained in the set.
    // If the set does not contain the value, has no effect.
    public void remove(int value) {
        int bucket = hashFunction(value);
        if (elementData[bucket] != null) {
            // check front of list
            if (elementData[bucket].data == value) {
                elementData[bucket] = elementData[bucket].next;
                size--;
            } else {
                // check rest of list
                HashEntry current = elementData[bucket];
                while (current.next != null && current.next.data != value) {
                    current = current.next;
                }
                
                // if the element is found, remove it
                if (current.next != null && current.next.data == value) {
					current.next = current.next.next;
					size--;
				}
            }
        }
    }
    
    // Returns the number of elements in the queue.
    public int size() {
        return size;
    }
    
    // Returns a string representation of this queue, such as "[10, 20, 30]";
    // The elements are not guaranteed to be listed in sorted order.
    public String toString() {
        String result = "[";
        boolean first = true;
        if (!isEmpty()) {
            for (int i = 0; i < elementData.length; i++) {
                HashEntry current = elementData[i];
                while (current != null) {
                    if (!first) {
                        result += ", ";
                    }
                    result += current.data;
                    first = false;
                    current = current.next;
                }
            }
        }
        return result + "]";
    }
    
    
    // Returns the preferred hash bucket index for the given value.
    private int hashFunction(int value) {
        return Math.abs(value) % elementData.length;
    }
    
    private double loadFactor() {
        return (double) size / elementData.length;
    }
    
    // Resizes the hash table to twice its former size.
    private void rehash() {
        // replace element data array with a larger empty version
        HashEntry[] oldElementData = elementData;
        elementData = new HashEntry[2 * oldElementData.length];
        size = 0;

        // re-add all of the old data into the new array
        for (int i = 0; i < oldElementData.length; i++) {
            HashEntry current = oldElementData[i];
            while (current != null) {
                add(current.data);
                current = current.next;
            }
        }
    }
    
    // Represents a single value in a chain stored in one hash bucket.
    private class HashEntry {
        public int data;
        public HashEntry next;

        public HashEntry(int data) {
            this(data, null);
        }

        public HashEntry(int data, HashEntry next) {
            this.data = data;
            this.next = next;
        }
    }      
    
    //Method that combines two HashIntSets
    public void addAll(HashIntSet toAdd){
        //Stepping through the underlying array
        for(int i= 0; i<toAdd.elementData.length; i++){
            HashEntry current = toAdd.elementData[i];
            //Testing to see if we hit a filled location
            if(current!=null){
                add(current.data);
                //Working down the chain of a filled location
                while(current.next!=null){
                    current=current.next;
                    add(current.data);
                }
            }
        }
    }
    
    //Method to see if the first set has all the entries of the second set
    public boolean containsAll(HashIntSet search){
        //Stepping through the underlying array
        for(int i= 0; i<search.elementData.length; i++){
            HashEntry current = search.elementData[i];
            //Testing to see if we hit a filled location
            if(current!=null){
                //Test if the first item in a possable location chain is in the this.hashintset
                if(!contains(current.data)){
                    //first time we can not find a number we can exit as the whole thing is false
                    return false;
                }
                //Working down the chain
                while(current.next!=null){
                    current=current.next;
                    if(!contains(current.data)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    //Method that tests that two HashIntSets have the same numbers
    public boolean equals(HashIntSet set2){
        return this.containsAll(set2) && set2.containsAll(this);
    }
    
    public static void main(String[] args) {
        HashIntSet set1 = new HashIntSet();
        set1.add(5);
        set1.add(-7);
        set1.add(55);
        set1.add(67);
        set1.add(-5);
        set1.add(16);
        set1.add(5);
        HashIntSet set2 = new HashIntSet();
        set2.add(5);
        set2.add(-7);
        set2.add(55);
        set2.add(67);
        set2.add(-5);
        set2.add(16);
        HashIntSet set3 = new HashIntSet();
        set3.add(27);
        set3.add(-27);
        set3.add(55);
        System.out.println("Print of set1: "+set1);
        System.out.println("Print of set2: "+set2);
        System.out.println("Print of set3: "+set3);
        System.out.println("Print of set1 equals set2: "+set1.equals(set2));
        System.out.println("Print of set2 equals set1: "+set2.equals(set1));
        System.out.println("Print of set3 equals set1: "+set3.equals(set1));
        set1.addAll(set3);
        System.out.println("Print of set1 addAll set3: "+set1);
        System.out.println("New set1 containsAll of set2: "+set1.containsAll(set2));
        System.out.println("New set1 containsAll of set3: "+set1.containsAll(set3));
        System.out.println("Print that set3 contains set2: "+set3.containsAll(set2));
    }
}
