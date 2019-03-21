/* Andrew Franko 6/3/18
Testing of the three methods and some prints to visually check.
I am some what frustrated/disapointed that there did not appear to
me to be a way (without writing a new constructor myself) to 
generate the custome trees that look like the ones in the book
to test my methods against.  The build constructor generates a heep,
so there is no way to test that the toString will print a empty left
or that it would follow any kind of mostly empty tree the whole way 
down.  I believe, theoretically, that the methods would handle any 
tree but I cant test it.  While it could be done to make the custome 
constructor, I do think it is a few steps beyond the scope of the problems.*/

// Short program that demonstrates the use of the IntTree class.

public class IntTreeClient {
    public static void main(String[] args) {
        IntTree t = new IntTree(15);
        System.out.println("Tree structure:");
        t.printSideways();
        System.out.println();
        System.out.println("Count of left Nodes: "+t.countLeftNodes());
        System.out.println("Tree toString: "+t);
        System.out.println();
        System.out.println("PrintLevel (4):");
        t.printLevel(4);
        System.out.println();
        System.out.println("Created a new Tree");
        IntTree likeTree3 = new IntTree(5);
        System.out.println();
        likeTree3.printSideways();
        System.out.println();
        System.out.println("Count of left Nodes: "+likeTree3.countLeftNodes());
        System.out.println("Tree toString: "+likeTree3);
        System.out.println();
        System.out.println("PrintLevel (3):");
        likeTree3.printLevel(3);
        System.out.println();
        System.out.println("Created a new Tree");
        IntTree likeTree = new IntTree(22);
        System.out.println();
        likeTree.printSideways();
        System.out.println();
        System.out.println("Count of left Nodes: "+likeTree.countLeftNodes());
        System.out.println("Tree toString: "+likeTree);
        System.out.println();
        System.out.println("PrintLevel (5):");
        likeTree.printLevel(5);
        System.out.println();
    }
}
