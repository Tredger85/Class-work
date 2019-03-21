/*CSD 210 HW5 part1(problem 4)
Andrew Franko 2/18/18
Import a file that has a number of integer and string pairs.
The hardest part was getting the program to input the test which you will have to change from
my test case.  I also added the possiblity that the coin would be input in the singular or have
a miss spelled coin type.*/

import java.io.*;
import java.util.*;


public class CountCoins {
    public static void countCoins()throws FileNotFoundException {
        //Directed that a file would be the input but unsure of file name and location
        Scanner console = new Scanner(new File("C:\\Users\\andre\\Desktop\\CountCoins.txt"));
        double total=0;
        while(console.hasNext()){
            int number=console.nextInt();
            String coin=console.next();
            if (coin.equalsIgnoreCase("PENNIES")||coin.equalsIgnoreCase("PENNY")){
                total+=number;
            }else if(coin.equalsIgnoreCase("NICKELS")||coin.equalsIgnoreCase("NICKEL")){
                total+=(5*number);
            }else if(coin.equalsIgnoreCase("DIMES")||coin.equalsIgnoreCase("DIME")){
                total+=(10*number);
            }else if(coin.equalsIgnoreCase("QUARTERS")||coin.equalsIgnoreCase("QUARTER")){
                total+=(25*number);
            }else{
                System.out.print("One or more coins names are not recognized");
            }
        }
        System.out.printf("Total money: $%.2f", (total/100));
    }
    public static void main (String[] args) throws FileNotFoundException {
        countCoins();
    }
}