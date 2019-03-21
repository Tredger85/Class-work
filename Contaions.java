public class Contaions {
static boolean contains(String s, char c){
    for (int i = 0; i<s.length(); i++){
        if (c==s.charAt(i)){
            return true;
        }
    }
    return false;
}
   public static void main (String[] args) {
      System.out.println(contains("boot",'a'));
      System.out.println(contains("ace",'a'));
      System.out.println(contains("banana",'a'));
      System.out.println(contains("case",'c'));
      System.out.println(contains("CAB",'c'));
      System.out.println(contains("Canada",'C'));
   }
}