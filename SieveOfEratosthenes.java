/*CSD 211 for ExtraCredit project 1+ page 919
Andrew Franko 5/26/18
Use the Sieve of Eratosthenes to create a new queue filled with primes from 2 to the parameter.
Created an additional method that creates and returns primes within a given range of 2 parameters*/

import java.io.*;
import java.util.*;

public class SieveOfEratosthenes {

    public static Queue <Integer> sieve (int num){
        /* Based on my additional code that I created to cover any range not
        just starting at 2, the code could simply be:
        sieve(2, num);
        but as the question asks for the following I left it as is.
        Additionally, I refactored a bit for my any range sieve but left the
        original code as it was both the honest first stab and it works as is.*/
        if (num<2){
            throw new IllegalArgumentException("Enter an integer greater than 1");
        }
        //Creating the queue of all numbers 2 to the parameter
        Queue <Integer> numbers = new LinkedList <Integer>();
        for(int i = 2; i<=num; i++){
            numbers.add(i);
        }
        //Creating a result queue to hold the prime numbers
        Queue <Integer> result = new LinkedList <Integer>();
        //Creating an int outside of the do/while loop to test completion against
        int p = numbers.peek();
        //The sieve says you only have to test up to the square root of the parameter
        do{
            //Removing the first number
            p = numbers.remove();
            //We know that two and then any other number that makes it to the front
            //of the queue must be prime
            result.add(p);
            //Creating a static int for the size to be used in the for loop
            for(int i = numbers.size(); i>0; i--){
                //Test against the current prime, not prime remove
                if (numbers.peek()%p == 0){
                    numbers.remove();
                //Unknown if the number is prime but yet to be proven not to be prime, 
                //move to the back of the queue
                } else {
                    numbers.add(numbers.remove());
                }
            }
        } while (p<Math.sqrt(num));
        //All numbers that are still in queue must be prime and moved to the result queue
        while(numbers.size()>0){
            result.add(numbers.remove());
        }
        //Returning the queue of primes
        return result;
    }
    public static Queue <Integer> sieve (int start, int end){
        if (end<2){
            throw new IllegalArgumentException("Enter an integer greater than 1");
        } else if(start>end){
            throw new IllegalArgumentException("The first number must be less than the second");
        }
        //Creating the queue of all numbers from the first parameter to the second parameter
        Queue <Integer> numbers = new LinkedList <Integer>();
        for(int i = start; i<=end; i++){
            numbers.add(i);
        }
        //Creating a result queue to hold the prime numbers
        Queue <Integer> result = new LinkedList <Integer>();
        //Starting an incremental variable for the do/while loop
        int j = 1;
        //The sieve says you only have to test up to the square root of the end parameter
        do{
            //Incrementing within the do/while loop
            j++;
            for(int i = numbers.size(); i>0; i--){
                //Moving any numbers that equal the incremented j as they must be prime
                //This also saves time else where, not having to move them to the end constantly
                if(numbers.peek() == j){
                    result.add(numbers.remove());  
                //Test to see if the current front of the queue is a multiple of the incremental variable
                } else if (numbers.peek()%j == 0){
                    numbers.remove();
                //Unknown if the number is prime but yet to be proven not to be prime, 
                //move to the back of the queue
                } else {
                    numbers.add(numbers.remove());
                }
            }
        } while (j<Math.sqrt(end));
        
        //All numbers that are still in queue must be prime and moved to the result queue
        while(numbers.size()>0){
            result.add(numbers.remove());
        }
        //Returning the queue of primes
        return result;
    }
    public static void main(String[] args) {
        Queue <Integer> sieve1 = sieve(15);
        System.out.println("Print of primes 2 to 15: "+ sieve1);
        Queue <Integer> sieve2 = sieve(200);
        System.out.println("Print of primes 2 to 200: "+ sieve2);
        Queue <Integer> sieve3 = sieve(4,30);
        System.out.println("Print of primes 4 to 30: "+ sieve3);
        Queue <Integer> sieve4 = sieve(100,200);
        System.out.println("Print of primes 100 to 200: "+ sieve4);
    }
}