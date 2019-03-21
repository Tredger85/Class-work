/*CSD 211 HW1 problem 14 part 3 page 660
Andrew Franko 4/15/18
Added an equals method and an accessor methods.  While the accessor was not 
strictly required, it did seem to be the simplest tact.
I am not assuming that a different orientation would prevent shapes from being equivalent*/

// Represents triangle shapes.
public class Triangle implements Shape {
    private double a;
    private double b;
    private double c;
    
    // Constructs a new Triangle given side lengths.
    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    // Returns this triangle's area using Heron's formula.
    public double getArea() {
        double s = (a + b + c) / 2.0;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    // Returns the perimeter of this triangle.
    public double getPerimeter() {
        return a + b + c;
    }
    //Accessor to call the private A variable
    public double getA(){
        return a;
    }
    //Accessor to call the private b variable
    public double getB(){
        return b;
    }
    //Accessor to call the private c variable
    public double getC(){
        return c;
    }
    //Calling the accessor methods and checking each dimension, covering mirror images and rotations
    public boolean equals(Triangle other){
        return getA()==other.getA()&&getB()==other.getB()&&getC()==other.getC()||
             getA()==other.getA()&&getB()==other.getC()&&getC()==other.getB()||
             getA()==other.getB()&&getB()==other.getA()&&getC()==other.getC()||
             getA()==other.getB()&&getB()==other.getC()&&getC()==other.getA()||
             getA()==other.getC()&&getB()==other.getB()&&getC()==other.getA()||
             getA()==other.getC()&&getB()==other.getA()&&getC()==other.getB();
    }
    //Simple test to verify that the new equals method works
    public static void main (String[] args){
        Triangle first = new Triangle(3,4,5);
        Triangle second = new Triangle(3,4,5);
        Triangle third = new Triangle(5,4,3);
        Triangle fourth = new Triangle(2,2,2);
        //Same input for the objects
        System.out.println(first.equals(second));
        //Equvalent but different order for the objects
        System.out.println(second.equals(third));
        //Purposefully failing
        System.out.println(third.equals(fourth));
    }
}
