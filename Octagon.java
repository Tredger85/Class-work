/*CSD 211 HW1 problems 15 page 660
Andrew Franko 4/15/18
Create an octagon shape that implements the shape class.
We are told to assume that it is a regular octagon ie all the sides are the same.*/
public class Octagon implements Shape {
    
    private double sideLength;
    
    //Initailzing the object
    public Octagon(double side){
        sideLength=side;
    }
    //Calculate the area of an octagon
    public double getArea(){
        return 2*(1+Math.sqrt(2))*sideLength*sideLength;
    }
    //Calculate the perimeter of an octagon
    public double getPerimeter(){
        return sideLength*8;
    }
    //testing the new object
    public static void main (String []args){
        Octagon oct = new Octagon(2);
        System.out.println(oct.getArea());
        System.out.println(oct.getPerimeter());
    }
}

