/*CSD 210 HW4 part3(problem 9)
Andrew Franko 2/9/18
Prints out the factors of an interger that is input with the method. We are
assuming that the number is greater than 0. Used different method signatures
to account for an input of a string or a blank space.*/
public class PrintFactors {
    public static void printFactors(String input) {
    }
    public static void printFactors(int primary) {
        System.out.print("1");
        int dividor=2;
        while(primary>=dividor){
            if(primary%dividor==0){
                System.out.print(" and "+dividor);
            }
            dividor++;
        }
    }
    public static void main (String[] args) {
    }
}