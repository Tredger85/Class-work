/*CSD 210 HW4 part2(problem 7)
Andrew Franko 2/9/18
Taking an input, adding two virtual dice(standard 6 sided) printing and seeing if you add
up to the input number. Repeating as nessisary until they do add up to the input. 
Added some robustness incase the entered number is outside of the possible range.*/
import java.util.*;
public class DiceSum {
    public static void diceSum() {
        Random rand=new Random();
        int die1=rand.nextInt(6)+1;
        int die2=rand.nextInt(6)+1;
        System.out.print("Desired dice sum (between 2 and 12 inclusive): ");
        Scanner console=new Scanner(System.in);
        int entered=console.nextInt();
        while(entered<2||entered>12){
            System.out.println("Entered sum outside of sum range, enter a new number");
            System.out.print("Desired dice sum (between 2 and 12 inclusive): ");
            entered=console.nextInt();
        }
        System.out.println(die1+" and "+die2+" = "+(die1+die2));
        while(die1+die2!=entered){
            die1=rand.nextInt(6)+1;
            die2=rand.nextInt(6)+1;
            System.out.println(die1+" and "+die2+" = "+(die1+die2));
        }
    }
    public static void main (String[] args) {
    diceSum();
    }
}