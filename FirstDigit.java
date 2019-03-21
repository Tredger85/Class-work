/*CSD 210 HW4 part5(problem 19)
Andrew Franko 2/9/18
Function that takes an integer paramater and returns only the first number.
I considered using an if statement to multiply by -1 but the math class is 
clearer and less typing/space. */
public class FirstDigit {
    public static int firstDigit(int digit) {
        digit=Math.abs(digit);
        while(digit/10!=0){
            digit=digit/10;
        }
        //System.out.print(digit); //Test to see the return
        return(digit);    
    }
    public static void main (String[] args) {
    }
}