import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    static final String CHARACTERS =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
            "abcdefghijklmnopqrstuvwxyz" +
            "0123456789" +
            "!@#$%^&*";

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n========== PASSWORD GENERATOR ==========");
            System.out.println("1. Generate Password");
            System.out.println("2. Generate Multiple Passwords");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Password Length: ");
                    int length = sc.nextInt();

                    System.out.println("\nGenerated Password:");
                    System.out.println(generatePassword(length));
                    break;

                case 2:
                    System.out.print("Enter Password Length: ");
                    int len = sc.nextInt();

                    System.out.print("How Many Passwords: ");
                    int count = sc.nextInt();

                    for (int i = 1; i <= count; i++) {
                        System.out.println("Password " + i + ": " + generatePassword(len));
                    }
                    break;

                case 3:
                    System.out.println("Thank You!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    static String generatePassword(int length) {

        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {

            int index = random.nextInt(CHARACTERS.length());

            password.append(CHARACTERS.charAt(index));
        }

        return password.toString();
    }
}