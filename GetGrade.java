/*CSD 210 HW3 part4(problem 15)
Andrew Franko 2/2/18
Method to convert a percentage grade into a number for gpa purposes.
While this ended up four cases, large ranges of possilbilites are covered in each*/
public class GetGrade {
    public static void getGrade(double grade) {
        if(grade<60){
            System.out.println("Your grade is 0.0.");
        } else if(grade<=63){
            System.out.println("Your grade is 0.8.");
        } else if(grade>95){
            System.out.println("Your grade is 4.0.");
        } else {
            System.out.printf("Your grade is %.1f",((grade-63)/10+.8));
        }
    }
    public static void main (String[] args) {
    }
}
