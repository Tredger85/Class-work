/*CSD 210 HW6 part 5 and 6(problems 11 and 12)
Andrew Franko 3/1/18
Created a methods transactionFee and toString.
In addition I also added the code to accept a sting
when initailizing the object though this was required
take a name so the toString would have something to print.*/

//Bank account class for problem 11, chapter 8 of BJP4
//Taken from the text.
//Each BankAccount object represents one user's account information
//including name and balance of money.
//
public class BankAccount {
    String name;
    double balance;
    int transactionsCounter=0;
    
    public BankAccount(String id){
        name = id;
    }
    
    public void deposit (double amount) {
        balance = balance + amount;
        transactionsCounter++;
    }
    
    public void withdraw(double amount) {
        balance = balance - amount;
        transactionsCounter++;
    }
    public String toString() {
        return name + ", " + balance;
    }
    public boolean transactionFee(double x){
        for(int i=1;i<=transactionsCounter; i++){
            balance = balance-(i*x);
            if(balance<=0){
                balance=0;
                return false;
            }
        }
        return true;
    }
    public static void main (String[] args){
        BankAccount savings = new BankAccount("Steve");
        savings.deposit(50.00);
        savings.deposit(50.00);
        savings.deposit(50.00);
        System.out.println(savings);
        savings.transactionFee(5.00);
        System.out.println(savings);
    }
}