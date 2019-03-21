/*CSD 211 HW1 problem 14 part 2 page 660
Andrew Franko 4/15/18
Added an equals method and an accessor methods.  While the accessor was not 
strictly required, it did seem to be the simplest tact.
I am not assuming that a different orientation would prevent shapes from being equivalent*/

// Represents rectangle shapes.
public class Rectangle implements Shape {
    private double width;
    private double height;
    
    // Constructs a new rectangle with the given dimensions.
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // Returns the area of this rectangle.
    public double getArea() {
        return width * height;
    }
    
    // Returns the perimeter of this rectangle.
    public double getPerimeter() {
        return 2.0 * (width + height);
    }
    //Accessor to call the private width variable
   public double getWidth(){
       return width;
   }
   //Accessor to call the private height variable
   public double getHeight(){
       return height;
   }
   //Calling the accessor methods and checking each dimension
   public boolean equals(Rectangle other){
       return getWidth()==other.getWidth()&&getHeight()==other.getHeight()||
            getWidth()==other.getHeight()&&getHeight()==other.getWidth();
   }
   //Simple test to verify that the new equals method works
   public static void main (String[] args){
       Rectangle first = new Rectangle(5,30);
       Rectangle second = new Rectangle (5,30);
       Rectangle third = new Rectangle (30,5);
       Rectangle fourth = new Rectangle (1,1);
       //Same input for the objects
       System.out.println(first.equals(second));
       //Equvalent but different order for the objects
       System.out.println(second.equals(third));
       //Purposefully failing
       System.out.println(third.equals(fourth));
   }
}
