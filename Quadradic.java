/*CSD 210 HW3 part1(problem 8)
Andrew Franko 2/2/18
Method to calculate the quadradic equation.
I did not assume that the answers would work out evenly or that there would not 
be extra digits from using doubles, I used print f to truncate at 2 decimal points.
I found it easier to calculate the left and right parts of the equation separately 
instead of having two long equations to account for the +/-.*/
public class Quadradic {
  public static void quadradic(double a, double b, double c) {
    double left=-1*b/(2*a);
    double right=Math.sqrt(b*b-(4*a*c))/(2*a);
    double first=left+right;
    double second=left-right;
    if(first==second){
        System.out.printf("Only one solution, x=%.2f", first);
    }else {
        System.out.printf("The solution set of: x=%.2f, x=%.2f",first,second);
    }
  }
  public static void main (String[] args) {
    quadradic(1,0,-1);
}
}
