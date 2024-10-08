import java.util.Scanner;

public class NumberGuessing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = 1 + (int) (100 * Math.random());
        int maxAttempts = 5;
        int attempts = 0;
        int guess;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("A number has been chosen between 1 and 100.");
        System.out.println("Your task is to guess the number within 5 attempts.");

        while (attempts < maxAttempts) {
            System.out.println("Attempt " + (attempts + 1) + ": Enter your guess:");
            guess = scanner.nextInt();
            attempts++;

            if (guess == number) {
                System.out.println("Congratulations! You've guessed the correct number.");
                break;
            } else if (guess < number) {
                System.out.println("The number is greater than your guess.");
            } else {
                System.out.println("The number is less than your guess.");
            }
        }

        if (attempts == maxAttempts) {
            System.out.println("You've exhausted all attempts. The number was " + number);
        }

        scanner.close();
    }
}