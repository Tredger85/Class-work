public class printBinaray{
   public static void printBinaray(int n){
      if(n<2){
         System.out.print(n);
      }else{
         printBinaray(n/2);
         printBinaray(n%2);
      }
   }
   public static void main(String[] args){
      printBinaray(255);
   }
}