/*CSD 211 HW3 problems 2,4,6 page 750
Andrew Franko 4/25/18
As all three of the problems developed methods using Integer Lists, it was easiest to
put all three of them together.*/


import java.io.*;
import java.util.*;

public class NumberArrays{
    //Problem 2, put two lists together simular to shufling a deck of cards
    public static ArrayList alternate(List<Integer> list1, List<Integer> list2){
        //the problem wanted a new list returned
        ArrayList<Integer> list3 = new ArrayList<Integer>();
        int max = Math.max(list1.size(), list2.size());
        //Adding one of each to the new list and stepping through them together
        for(int i = 0; i<max; i++){
            if(i<list1.size()){
                list3.add(list1.get(i));
            }
            if(i<list2.size()){
                list3.add(list2.get(i));
            }
        }
        return list3;
    }
    //Problem 4,sort a list so the all the integers in the list that are greater than the parameter
    //come before all those that are greater than the parameter
        public static void partition(List<Integer> list, int e){
        ArrayList<Integer> holder = new ArrayList <Integer>();
        for(int i = 0; i<list.size(); i++){
            //We were told that the parameter could not also be in the list
            if(list.get(i)<e){
                holder.add(0, list.get(i));
            } else {
                holder.add(holder.size(), list.get(i));
            }
        }
        //It feels like there should be a better way but this is fairly simple
        for(int j = 0; j<list.size(); j++){
            list.set(j,holder.get(j));
        }
    }
    //Problem 6, count the number of unique numbers in a list
    public static int countUnique(List<Integer> list){
        ArrayList<Integer> holder = new ArrayList <Integer>();
        for(int i =0; i<list.size(); i++){
            //Test if a number is on the holder list, if not add it to the list
            if(!holder.contains(list.get(i))){
                holder.add(list.get(i));
            }
        }
        return holder.size();
    } 

    public static void main(String[] args) {
        ArrayList<Integer> test1 = new ArrayList<Integer>();
        test1.add(1);
        test1.add(2);
        test1.add(3);
        test1.add(4);
        test1.add(5);
        LinkedList<Integer> test2 = new LinkedList<Integer>();
        test2.add(7);
        test2.add(8);
        test2.add(9);
        test2.add(10);
        test2.add(11);
        test2.add(12);
        System.out.println("Print of ArrayList test1: "+test1);
        System.out.println("Print of LinkedList test2: "+test2);
        System.out.println("Print of alternate method with test1, test2: "+alternate(test1,test2));
        ArrayList<Integer> test3= new ArrayList<Integer>(alternate(test1,test2));
        partition(test3,6);
        System.out.println("Print of partition method using the previous alternate outcome: "+test3);
        System.out.println("Print of the countUniqie using two sets of test1 and test2 through nesting the alternate method: "+
                            countUnique(alternate(alternate(test1,test2),alternate(test1,test2))));
        
        
    }
}