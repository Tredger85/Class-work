/*CSD 211 HW#7 problems 1, 5, and 8 from page 1066
Andrew Franko 6/3/18
Added three methods. CountLeftNodes, as the name suggests it counts the number of left pointer
that are in a tree.  PrintLevel takes a number as a parameter and prints each entry on the level 
of the parameter as a new line.  ToString a specific nesting of each branch an leaf using parenteses.
CountLeftNodes starts on line 118
PrintLevel starts on line 143
ToString starts on line 168
Testing is in the IntTreeClient file*/



/* Simple binary tree class that includes methods to construct a
tree of ints, to print the structure, and to print the data
using a preorder, inorder or postorder traversal.  The trees
built have nodes numbered starting with 1 and numbered
sequentially level by level with no gaps in the tree.  The
documentation refers to these as "sequential trees."*/


import java.util.*;

public class IntTree {
    private IntTreeNode overallRoot;

    // pre : max > 0
    // post: constructs a sequential tree with given number of
    //       nodes
    public IntTree(int max) {
        if (max <= 0) {
            throw new IllegalArgumentException("max: " + max);
        }
        overallRoot = buildTree(1, max);
    }

    // post: returns a sequential tree with n as its root unless
    //       n is greater than max, in which case it returns an
    //       empty tree
    private IntTreeNode buildTree(int n, int max) {
        if (n > max) {
            return null;
        } else {
            return new IntTreeNode(n, buildTree(2 * n, max),
                                   buildTree(2 * n + 1, max));
        }
    }

    // post: prints the tree contents using a preorder traversal
    public void printPreorder() {
        System.out.print("preorder:");
        printPreorder(overallRoot);
        System.out.println();
    }

    // post: prints the tree contents using a preorder traversal
    // post: prints in preorder the tree with given root
    private void printPreorder(IntTreeNode root) {
        if (root != null) {
            System.out.print(" " + root.data);
            printPreorder(root.left);
            printPreorder(root.right);
        }
    }

    // post: prints the tree contents using a inorder traversal
    public void printInorder() {
        System.out.print("inorder:");
        printInorder(overallRoot);
        System.out.println();
    }

    // post: prints in inorder the tree with given root
    private void printInorder(IntTreeNode root) {
        if (root != null) {
            printInorder(root.left);
            System.out.print(" " + root.data);
            printInorder(root.right);
        }
    }

    // post: prints the tree contents using a postorder traversal
    public void printPostorder() {
        System.out.print("postorder:");
        printPostorder(overallRoot);
        System.out.println();
    }

    // post: prints in postorder the tree with given root
    private void printPostorder(IntTreeNode root) {
        if (root != null) {
            printPostorder(root.left);
            printPostorder(root.right);
            System.out.print(" " + root.data);
        }
    }

    // post: prints the tree contents, one per line, following an
    //       inorder traversal and using indentation to indicate
    //       node depth; prints right to left so that it looks
    //       correct when the output is rotated.
    public void printSideways() {
        printSideways(overallRoot, 0);
    }

    // post: prints in reversed preorder the tree with given
    //       root, indenting each line to the given level
    private void printSideways(IntTreeNode root, int level) {
        if (root != null) {
            printSideways(root.right, level + 1);
            for (int i = 0; i < level; i++) {
                System.out.print("    ");
            }
            System.out.println(root.data);
            printSideways(root.left, level + 1);
        }
    }
    
    //Public method that freeds the private method the over all root as the pointer as a parameter
    public int countLeftNodes(){
        return countLeftNodes(0, overallRoot);
    }
    
    //Private method that passes the count back and forth and keeps track of where it is
    private int countLeftNodes(int n, IntTreeNode current){
        //Helpful print for determining where the pointer is and why the count is working as expected
        //System.out.println("count:"+n+" Data point:"+current.data);
        //Declared vairiable to prervent localization
        int count = n;
        //Test to see if we can go down the left path and the recursion
        if (current.left!=null){
            count=countLeftNodes(count, current.left);
            //Add to the counter since we following the path that counts
            count++;
        }
        //Test to see if we can go down the left path and the recursion
        if (current.right!=null){
            count=countLeftNodes(count, current.right);
        }  
        //Return that passes the lower count up to the previous recursion
        return count;
    }
    
    //Simple public method for IllegalArgument and to start the pointer
    public void printLevel(int n){
        if(n<1){
            throw new IllegalArgumentException();
        } else {
            printLevel(1,n, overallRoot);
        }
    }
    
    //Private method that keeps track of the level it is on, the goal printing level and pointer
    private void printLevel(int a, int b, IntTreeNode current){
        //Test if we are on the correct level
        if(a==b){
            System.out.println(current.data);
        } else {
            //Not on the goal level, test if they can go further down the tree and recursion
            if (current.left != null){
                printLevel(a+1, b, current.left);
            }
            if (current.right != null){
                printLevel(a+1, b, current.right);
            }
         }
    }
    
    //Simple string start
    public String toString(){
        //Specific empty response that is in the question
        if (overallRoot == null){
            return "empty";
        //Seems a bit redundent but allows of simpler recursion in the private method
        } else if (overallRoot.left == null && overallRoot.right == null){
            return "("+overallRoot.data+")";
        } else {
            return toString(overallRoot);
        }
    }
    
    //Private method with the node pointer
    private String toString(IntTreeNode current){
        //First of four stats that a node could be in, both null
        if (current.left == null && current.right == null){
            //Seems silly but to keep as a string and casting didnt want to work
            return ""+current.data;
        //Second state, left null and right full
        } else if (current.left == null){
            return "("+current.data+", empty"+ toString(current.right)+")";
        //Third state, left has data and right null
        } else if (current.right == null){
            return "("+current.data+", "+ toString(current.left)+", empty)";
        //Final state, full node
        } else {
            return "("+current.data+", "+ toString(current.left)+", "+toString(current.right)+")";
        }
    }   
}