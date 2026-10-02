import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        String playAgain;

        System.out.println("===== NUMBER GUESSING GAME =====");

        do {
            int number = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 7;
            boolean guessed = false;

            System.out.println("\nI have selected a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {

                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();
                attempts++;

                if (guess == number) {
                    System.out.println("Correct! You guessed the number.");
                    System.out.println("Attempts used: " + attempts);

                    int score = (maxAttempts - attempts + 1) * 10;
                    totalScore += score;

                    System.out.println("Round Score: " + score);
                    guessed = true;
                    break;

                } else if (guess < number) {
                    System.out.println("Too low!");

                } else {
                    System.out.println("Too high!");
                }

                System.out.println("Attempts remaining: "
                        + (maxAttempts - attempts));
            }

            if (!guessed) {
                System.out.println("Game Over!");
                System.out.println("The correct number was: " + number);
            }

            System.out.print("\nDo you want to play again? (yes/no): ");
            playAgain = sc.next();

        } while (playAgain.equalsIgnoreCase("yes"));

        System.out.println("\n===== GAME OVER =====");
        System.out.println("Total Score: " + totalScore);

        sc.close();
    }
}