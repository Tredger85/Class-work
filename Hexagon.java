/*CSD 211 HW1 problem 16 page 660
Andrew Franko 4/15/18
Create an hexagon shape that implements the shape class.
We are told to assume that it is a regular hexagon ie all the sides are the same.*/
public class Hexagon implements Shape {
    
    private double sideLength;
    
    //Initailzing the object
    public Hexagon(double side){
        sideLength=side;
    }
    //Calculate the area of an octagon
    public double getArea(){
        return (3*Math.sqrt(3)/2)*sideLength*sideLength;
    }
    //Calculate the perimeter of an octagon
    public double getPerimeter(){
        return sideLength*6;
    }
    //testing the new object
    public static void main (String []args){
        Hexagon hex = new Hexagon(2);
        System.out.println(hex.getArea());
        System.out.println(hex.getPerimeter());
    }
}

