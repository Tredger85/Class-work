import java.util.*;   // for ArrayList

public class SolveDominoes {
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
    
public static ArrayList<Domino> hasChain(List<Domino> dominoes, 
                                   int start, int end){
    List<Domino> solution = new ArrayList<Domino>();
    if (start == end) {
        return true;                         // base case
    } else {
        for (int i = 0; i < dominoes.size(); i++) {
            Domino d = dominoes.remove(i);   // choose
            add.solution(d);
            if (d.first() == start) {        // explore
                if (hasChain(dominoes, d.second(), end)) {
                    System.out.println(solution);
                }
            } else if (d.second() == start) {
                if (hasChain(dominoes, d.first(), end)) {
                    System.out.println(solution);
                }
            }
            dominoes.add(i, d);              // un-choose
        }
        return false;
    }
}
}