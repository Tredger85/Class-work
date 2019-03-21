/*CSD 211 HW2 problems 18 page 713
Andrew Franko 4/21/18
Adding the compareTo method to the Point Class, 
so the point class can implement Comparable.*/

// A Point object represents a pair of (x, y) coordinates.
// Seventh version: Immutable.
// Class invariant: x >= 0 && y >= 0.

import java.io.*;
import java.util.*;

public class Point implements Comparable<Point>{
    private int x;
    private int y;

    // Constructs a new point at the origin, (0, 0).
    public Point() {
        this(0, 0);    // calls Point(int, int) constructor
    }

    // Constructs a new point with the given (x, y) location.
    // pre: x >= 0 && y >= 0
    public Point(int x, int y) {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException();
        }
    
        this.x = x;
        this.y = y;
    }

    // Returns the distance between this Point and (0, 0).
    public double distanceFromOrigin() {
        return Math.sqrt(x * x + y * y);
    }

    // Returns whether o refers to a point with the same (x, y)
    // coordinates as this point.
    public boolean equals(Object o) {
        if (o instanceof Point) {
            Point other = (Point) o;
            return x == other.x && y == other.y;
        } else {  // not a Point object
            return false;
        }
    }

    // Returns the x-coordinate of this point.
    public int getX() {
        return x;
    }

    // Returns the y-coordinate of this point.
    public int getY() {
        return y;
    }

    // Returns a String representation of this point.
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    // Shifts this point's location by the given amount.
    // pre: x + dx >= 0 && y + dy >= 0
    public Point translate(int dx, int dy) {
        return new Point(x + dx, y + dy);
    }
    //Added method to implement Comparable
    public int compareTo(Point other){
        //if the points are equal
        if(getY()==other.getY() && getX()==other.getX()){
            return 0;
        //if the first point is greater than the second
        }else if(getY()>other.getY() || (getY()==other.getY() && getX()>other.getX())){
            return 1;
        //if the second point is greater than the first
        } else {
            return -1;
        }
    }
    public static void main(String[] args) {
        ArrayList<Point> test4 = new ArrayList<Point>();
        test4.add(new Point(5,1));
        test4.add(new Point(0,0));
        test4.add(new Point(1,5));
        test4.add(new Point(1,7));
        test4.add(new Point(7,1));
        test4.add(new Point(0,0));
        System.out.println("ArrayList test4 as input: " + test4);
        Collections.sort(test4);
        System.out.println("ArrayList test4 after natural sorting: " + test4);
    }
}
