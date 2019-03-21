
// This program tests the IntSearchTree class by constructing a
// binary search tree of integers and printing its contents as
// well as its structure.import java.util.*;

import java.util.*;

public class IntSearchTreeClient {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        IntSearchTree numbers = new IntSearchTree();
        Random r = new Random();
        for (int i = 0; i < 16; i++) {
            numbers.add(r.nextInt(50) + 1);
            }
  
        /*System.out.print("Next int (0 to quit)? ");
        int number = console.nextInt();
        while (number != 0) {
            numbers.add(number);
            System.out.print("Next int (0 to quit)? ");
            number = console.nextInt();
            }
         System.out.println();*/
            
         System.out.println("Tree Structure:");
         numbers.printSideways();
         System.out.println("Sorted list:");
         numbers.print();
         if (numbers.contains(1000)) {
         System.out.println("A strange event!");
         } else {
         System.out.println("World is alright!");
         }
     //My crazy method to generat a random tree
        IntSearchTree tree = new IntSearchTree ();
        for(int i=7; i<50; i+=3){
            if(i%2==0){
                tree.add(i/3);
            } else {
                tree.add(i+5);
            }
        }
        tree.printSideways();
    //Testing in client
        System.out.println("Print of numbers.getMin: "+numbers.getMin());
        System.out.println("Print of tree.getMin: "+tree.getMin());
        }
}
