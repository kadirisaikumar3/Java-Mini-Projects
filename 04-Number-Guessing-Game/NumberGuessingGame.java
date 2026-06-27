import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        boolean playAgain = true;

        while (playAgain) {

            System.out.println("\n===== NUMBER GUESSING GAME =====");
            System.out.println("1. Easy (1-50)");
            System.out.println("2. Medium (1-100)");
            System.out.println("3. Hard (1-500)");
            System.out.println("4. Exit");

            System.out.print("Choose Difficulty: ");
            int choice = sc.nextInt();

            int maxNumber;

            switch (choice) {
                case 1:
                    maxNumber = 50;
                    break;

                case 2:
                    maxNumber = 100;
                    break;

                case 3:
                    maxNumber = 500;
                    break;

                case 4:
                    System.out.println("Thank you for playing!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice!");
                    continue;
            }

            int secretNumber = random.nextInt(maxNumber) + 1;

            int attempts = 0;

            while (true) {

                System.out.print("Enter your guess (1-" + maxNumber + "): ");
                int guess = sc.nextInt();

                attempts++;

                if (guess < secretNumber) {
                    System.out.println("Too Low!");
                }
                else if (guess > secretNumber) {
                    System.out.println("Too High!");
                }
                else {
                    System.out.println("\nCongratulations!");
                    System.out.println("You guessed the number correctly.");
                    System.out.println("Attempts: " + attempts);

                    if (attempts <= 3)
                        System.out.println("Rating: Excellent");
                    else if (attempts <= 6)
                        System.out.println("Rating: Good");
                    else
                        System.out.println("Rating: Keep Practicing");

                    break;
                }
            }

            System.out.print("\nDo you want to play again? (yes/no): ");
            String answer = sc.next();

            playAgain = answer.equalsIgnoreCase("yes");
        }

        System.out.println("Thank you for playing!");
        sc.close();
    }
}