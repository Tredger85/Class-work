/*CSD 210 HW4 part4(problem 12)
Andrew Franko 2/9/18
Prompt and take input. Continue as long as the input is not negative.
I considered casting the final average but realized that the program
would be better served if the it could take doubles as input.*/
import java.util.*;
public class PrintAverage {
    public static void printAverage() {
        Scanner console=new Scanner(System.in);
        System.out.print("Type a number: ");
        double number = console.nextDouble();
        double sum=0;
        int count=0;
        while (number>=0){
            sum+=number;
            count++;
            System.out.print("Type a number: ");
            number = console.nextDouble();
        }
        if(count>0){
            System.out.printf("Average was %.1f",sum/count);
        }
            
    }
    public static void main (String[] args) {
    printAverage();
    }
}