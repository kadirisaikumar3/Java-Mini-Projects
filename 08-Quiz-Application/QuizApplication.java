import java.util.ArrayList;
import java.util.Scanner;

public class QuizApplication {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Question> questions = new ArrayList<>();

        // Add Questions
        questions.add(new Question(
                "What is the size of int in Java?",
                new String[]{"2 Bytes", "4 Bytes", "8 Bytes", "16 Bytes"},
                2));

        questions.add(new Question(
                "Which keyword is used to inherit a class?",
                new String[]{"implements", "extends", "inherit", "super"},
                2));

        questions.add(new Question(
                "Which collection allows duplicate elements?",
                new String[]{"Set", "HashSet", "ArrayList", "TreeSet"},
                3));

        questions.add(new Question(
                "Which method is the entry point of a Java program?",
                new String[]{"start()", "main()", "run()", "init()"},
                2));

        questions.add(new Question(
                "Which company developed Java?",
                new String[]{"Google", "Microsoft", "Sun Microsystems", "Oracle"},
                3));

        int score = 0;

        System.out.println("\n===== JAVA QUIZ APPLICATION =====");

        for (int i = 0; i < questions.size(); i++) {

            Question q = questions.get(i);

            System.out.println("\nQuestion " + (i + 1));
            System.out.println(q.getQuestion());

            String[] options = q.getOptions();

            for (int j = 0; j < options.length; j++) {
                System.out.println((j + 1) + ". " + options[j]);
            }

            System.out.print("Enter your answer (1-4): ");
            int answer = sc.nextInt();

            if (answer == q.getCorrectAnswer()) {
                System.out.println("✅ Correct!");
                score++;
            } else {
                System.out.println("❌ Wrong!");
            }
        }

        System.out.println("\n===== QUIZ RESULT =====");

        System.out.println("Total Questions : " + questions.size());
        System.out.println("Correct Answers : " + score);
        System.out.println("Wrong Answers   : " + (questions.size() - score));

        double percentage = (score * 100.0) / questions.size();

        System.out.printf("Score           : %.2f%%\n", percentage);

        if (percentage >= 80) {
            System.out.println("Excellent!");
        } else if (percentage >= 60) {
            System.out.println("Good Job!");
        } else {
            System.out.println("Keep Practicing!");
        }

        sc.close();
    }
}