/*CSD 211 HW1 problem 14 part 1 page 660
Andrew Franko 4/15/18
Added an equals method and an accessor method.  While the accessor was not 
strictly required, it did seem to be the simplest tact.*/


// Represents circle shapes.
public class Circle implements Shape {
    private double radius;
    
    // Constructs a new circle with the given radius.
    public Circle(double radius) {
        this.radius = radius;
    }
    
    // Returns the area of this circle.
    public double getArea() {
        return Math.PI * radius * radius;
    }
    
    // Returns the perimeter of this circle.
    public double getPerimeter() {
        return 2.0 * Math.PI * radius;
    }
    //Accessor to call the private variable
   public double getRadius(){
       return radius;
   }
   //Calling the accessor method to check agains one another
   public boolean equals(Circle other){
       return getRadius()==other.getRadius();
   }
   //Simple test to verify that the new equals method works
   public static void main (String[] args){
       Circle first = new Circle (5);
       Circle second = new Circle (5);
       System.out.println(first.equals(second));
       System.out.println(second.equals(first));
   }
}
