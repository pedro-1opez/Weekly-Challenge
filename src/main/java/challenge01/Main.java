package challenge01;

/*
  Challenge: #1
  Task: FIZZ BUZZ

  Statement: Write a program that displays the numbers from 1 to 100 (inclusive) on the console
             (using a print statement), replacing the following:

             - Multiples of 3 with the word "fizz"
             - Multiples of 5 with the word "buzz"
             - Multiples of both 3 and 5 with the word "fizzbuzz"
*/

public class Main {

    public static void main(String[] args) {

        for (int i = 1; i <= 100; i++){
            if(i % 3 == 0 && i % 5 == 0){
                System.out.println("fizzbuzz");
            } else if (i % 3 == 0) {
                System.out.println("fizz");
            } else if (i % 5 == 0){
                System.out.println("buzz");
            }else{
                System.out.println(i);
            }
        }

    }
}
