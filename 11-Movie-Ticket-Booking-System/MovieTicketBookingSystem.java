import java.util.ArrayList;
import java.util.Scanner;

public class MovieTicketBookingSystem {

    static ArrayList<Movie> movies = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // Preloaded Movies
        movies.add(new Movie(101, "Leo", 200, 50));
        movies.add(new Movie(102, "Salaar", 250, 50));
        movies.add(new Movie(103, "Pushpa 2", 300, 50));

        while (true) {

            System.out.println("\n========== MOVIE TICKET BOOKING SYSTEM ==========");
            System.out.println("1. View Movies");
            System.out.println("2. Book Tickets");
            System.out.println("3. Cancel Booking");
            System.out.println("4. View Booking Summary");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    viewMovies();
                    break;

                case 2:
                    bookTickets();
                    break;

                case 3:
                    cancelBooking();
                    break;

                case 4:
                    viewSummary();
                    break;

                case 5:
                    System.out.println("Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    // View Movies
    static void viewMovies() {

        for (Movie movie : movies) {
            System.out.println("----------------------------");
            System.out.println(movie);
        }
    }

    // Book Tickets
    static void bookTickets() {

        System.out.print("Enter Movie ID: ");
        int id = sc.nextInt();

        System.out.print("Enter Number of Tickets: ");
        int tickets = sc.nextInt();

        for (Movie movie : movies) {

            if (movie.getMovieId() == id) {

                if (tickets <= 0) {
                    System.out.println("Invalid Number of Tickets!");
                    return;
                }

                if (tickets > movie.getAvailableSeats()) {
                    System.out.println("Not Enough Seats Available!");
                    return;
                }

                movie.setAvailableSeats(movie.getAvailableSeats() - tickets);

                double total = tickets * movie.getTicketPrice();

                System.out.println("Booking Successful!");
                System.out.println("Movie : " + movie.getMovieName());
                System.out.println("Tickets : " + tickets);
                System.out.printf("Total Amount : ₹%.2f%n", total);

                return;
            }
        }

        System.out.println("Movie Not Found.");
    }

    // Cancel Booking
    static void cancelBooking() {

        System.out.print("Enter Movie ID: ");
        int id = sc.nextInt();

        System.out.print("Enter Number of Tickets to Cancel: ");
        int tickets = sc.nextInt();

        for (Movie movie : movies) {

            if (movie.getMovieId() == id) {

                if (tickets <= 0) {
                    System.out.println("Invalid Number of Tickets!");
                    return;
                }

                movie.setAvailableSeats(movie.getAvailableSeats() + tickets);

                System.out.println("Booking Cancelled Successfully!");
                System.out.println("Available Seats : " + movie.getAvailableSeats());

                return;
            }
        }

        System.out.println("Movie Not Found.");
    }

    // View Booking Summary
    static void viewSummary() {

        System.out.println("\n========== MOVIE SUMMARY ==========");

        for (Movie movie : movies) {
            System.out.println("----------------------------");
            System.out.println(movie);
        }
    }
}