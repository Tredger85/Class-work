/*CSD 210 HW3 part2(problem 11)
Andrew Franko 2/2/18
Method to calculate the distance between two points on a cartisian plane.
I did not assume that the answers would work out evenly or that there would not 
be extra digits from using doubles, I used print f to truncate at 3 decimal points.*/
public class Distance {
    public static void measureDistance(double x1, double y1, double x2,double y2) {
        System.out.printf("The distance between the two points is: %.3f units", 
                            Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1)));
    }
    public static void main (String[] args) {
    }
}
