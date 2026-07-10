import java.util.ArrayList;
import java.util.Scanner;

public class VotingSystem {

    static ArrayList<Candidate> candidates = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // Preloaded Candidates
        candidates.add(new Candidate(101, "Alice"));
        candidates.add(new Candidate(102, "Bob"));
        candidates.add(new Candidate(103, "Charlie"));

        while (true) {

            System.out.println("\n========== VOTING SYSTEM ==========");
            System.out.println("1. View Candidates");
            System.out.println("2. Cast Vote");
            System.out.println("3. View Results");
            System.out.println("4. Display Winner");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    viewCandidates();
                    break;

                case 2:
                    castVote();
                    break;

                case 3:
                    viewResults();
                    break;

                case 4:
                    displayWinner();
                    break;

                case 5:
                    System.out.println("Thank You!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    static void viewCandidates() {

        for (Candidate candidate : candidates) {
            System.out.println("----------------------------");
            System.out.println(candidate);
        }
    }

    static void castVote() {

        System.out.print("Enter Candidate ID: ");
        int id = sc.nextInt();

        for (Candidate candidate : candidates) {

            if (candidate.getCandidateId() == id) {

                candidate.addVote();

                System.out.println("Vote Cast Successfully!");
                return;
            }
        }

        System.out.println("Candidate Not Found.");
    }

    static void viewResults() {

        System.out.println("\n========== RESULTS ==========");

        for (Candidate candidate : candidates) {

            System.out.println(candidate.getCandidateName()
                    + " : "
                    + candidate.getVotes()
                    + " Votes");
        }
    }

    static void displayWinner() {

        Candidate winner = candidates.get(0);

        for (Candidate candidate : candidates) {

            if (candidate.getVotes() > winner.getVotes()) {
                winner = candidate;
            }
        }

        System.out.println("\n🏆 Winner");
        System.out.println("Name  : " + winner.getCandidateName());
        System.out.println("Votes : " + winner.getVotes());
    }
}