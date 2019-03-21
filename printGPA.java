/*CSD 210 HW3 part3(problem 10)
Andrew Franko 2/2/18
Using a scanner, input a number of grades, the grades themselves and calculate an average.
The robustness of the program fails my expectations. The program works if the input is formatted 
correctly, in the sense that the first digit and count of the grades match. I tried without success 
to break out of a while(console.hasNext()) loop so I could kick it to an if/else chain (commented 
out below) if the first digit was higher or lower than the number of grades.  Currently the program 
will wait (presenting new lines) until there are enough grades to match the first digit or leave 
off any additional grades after the stated number of scores.  I did consider turning the whole 
thing into a string, substrings and casting the numbers but that would both have been ugly and not 
in the spirit of the problem.*/
import java.util.*;
public class printGPA {
    public static void main (String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Enter your name followed by the number of scores");
        System.out.println("followed by each result separated by spaces:");
        System.out.println("(Example: John 5 75 85 95 63 87)");
        String name=console.next();
        int numberOfGrades=console.nextInt();
        double total=0;
        int counter=0;
        while(counter!=numberOfGrades){
            total+=console.nextDouble();
            counter++;
        }
        /*if(counter>numberOfGrades){
            System.out.println("It appears that you entered more scores than the stated number.");
            System.out.println("Please make sure that number of scores matches the results");
            System.out.println("entered to correctly calculate the average.");
        }else if(counter<numberOfGrades){   
            System.out.println("It appears that you entered less scores than the stated number.");
            System.out.println("Please make sure that number of scores matches the results");
            System.out.println("entered to correctly calculate the average.");
        }else{*/
        double gpa=total/numberOfGrades;
        System.out.printf(name+"'s grade is %.1f", gpa);
    }
}
