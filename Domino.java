/*Andrew Franko 4/26/18 IC3
I have the constructor and toString work but 
I just cant get it to print correctly.
Additionally I see that the templet is flawed, if start and end are 
the same no dominoes are pulled*/

import java.util.*;   // for ArrayList

public class Domino{
    private int x;
    private int y;
    int DEPTH=0;
    
    public Domino(int x, int y){
        this.x=x;
        this.y=y;
        if (x < 0 || y < 0 || x>6 || y >6){
            throw new IllegalArgumentException();
        }
    }
    public int first(){
        return x;
    }
    public int second(){
        return y;
    }
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
    
    public static String hasChain(List<Domino> dominoes, int start, int end){
        if (start == end) {
            return "";
        } else if (start != end){
            for (int i = 0; i < dominoes.size(); i++) {
                Domino d = dominoes.remove(i);   // choose
                if (d.first() == start) {       // explore
                    System.out.print(d);
                    System.out.print(hasChain(dominoes, d.second(), end));
                    return "";
                } else if (d.second() == start){
                    Domino print=new Domino(d.second(),d.first());
                    System.out.print(print);
                    System.out.print(hasChain(dominoes, print.second(), end));
                    return "";
                }else{
                    dominoes.add(i, d); 
                }             // un-choose
            }
        }
        return "No solution";
    }
    public static void main(String[] args) {
        // [(1|4), (2|6), (4|5), (1|5), (3|5)]
        List<Domino> dominoes = new ArrayList<Domino>();
        dominoes.add(new Domino(1, 4));
        dominoes.add(new Domino(2, 6));
        dominoes.add(new Domino(4, 5));
        dominoes.add(new Domino(1, 5));
        dominoes.add(new Domino(3, 5));
        System.out.println(hasChain(dominoes, 5, 5));   // true
        System.out.println(hasChain(dominoes, 1, 5));   // true
        System.out.println(hasChain(dominoes, 1, 3));   // true
        System.out.println(hasChain(dominoes, 1, 6));   // false
        System.out.println(hasChain(dominoes, 1, 2));   // false
    }
}