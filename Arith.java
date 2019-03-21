import java.util.*;
public class Arith {
  public static double hasMidpoint(int a, int b, int c) {
  int max=max.Math(a,b,c);
  int min=min.Math(a,b,c);
  return((max+min)/2==((a+b+c)-(min+max)));
  }
  public static void main (String[] args) {
hasMidpoint(4, 6, 8);
hasMidpoint(2, 10, 6);
hasMidpoint(8, 8, 8);
hasMidpoint(25, 10, -5);
}
}
