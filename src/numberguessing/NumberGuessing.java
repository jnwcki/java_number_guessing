/*
 * Simple Java program to have the user try to guess a random number
 */
package numberguessing;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;
import java.util.InputMismatchException;
/**
 *
 * @author jude
 */
public class NumberGuessing {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("I am thinking of a number between 1 and 99.");
        System.out.println("You have 5 guesses and I'll let you know if it's "
                + "too high or low.");
        int random = ThreadLocalRandom.current().nextInt(1, 99 + 1);
        int guess_count = 5;
        
        for (int i=0; i<guess_count; i++) {
            try {
                System.out.println("Enter your guess:");
                int guess = input.nextInt();
                String responseCheck = checkNumber(guess, random);
                if ("same".equals(responseCheck)) {
                    System.out.println("You Guessed It! Congrats!");
                    return;
                } else if ("greater".equals(responseCheck)) {
                    System.out.println("Your guess was too high.");
                } else if ("smaller".equals(responseCheck)) {
                    System.out.println("Your guess was too low.");
                }
            } catch (InputMismatchException e) {
                System.out.println("That was not a number!");   
            }
            input.nextLine();
        }
    } 
    
    public static String checkNumber(int guess, int secret) {
        if (guess == secret) {
            return "same";
        } else if (guess > secret) {
            return "greater";
        } else {
            return "smaller";
        }
    }
}
