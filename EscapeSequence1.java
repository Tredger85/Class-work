public class Method_CallMethod {

   public static void first() {
      System.out.println("inside first method");
      }
   public static void second() {
      System.out.println("inside second method");
      }
   public static void third() {
      System.out.println("inside third method");
      }

   public static void main(String[] args) {
      first();
      third();
      second();
      third();
      }
      }