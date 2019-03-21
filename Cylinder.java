/*Andrew Franko 4/7/18
Group project 1(Team Batman)*/

public class Cylinder extends RectangularPrism interface Shape (){
    
    private double height;
    private double radius;
    
    public Cylinder(double height, double radius){
        this.height = height;
        this.radius = radius;
    }
    public double getLength(){
        return radius*2;
    }
    public double getWidth(){
        return radius*2;
    }
    public double getRadius(){
        return radius;
    }
    public double getVolume(){
        return getBase()*height;
    }
    public double getBase(){
        return Math.pi*radius*radius;
    }
    public double getSideArea(){
        return 2*Math.pi*radius*height;
    }
    public double getSufaceArea(){
        return getSideArea()+2*getBase();
    }
}