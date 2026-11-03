import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        // Generate a random number between 1 and 100
        int number = random.nextInt(100) + 1;

        int attempts = 0;

        while (true) {

            System.out.print("Guess the number (1-100): ");
            int guess = sc.nextInt();

            attempts++;

            if (guess == number) {

                System.out.println("Congratulations! You guessed the correct number.");
                System.out.println("Number of attempts: " + attempts);

                break;

            } else if (guess < number) {

                System.out.println("Too low! Try again.");

            } else {

                System.out.println("Too high! Try again.");
            }
        }

        sc.close();
    }
}