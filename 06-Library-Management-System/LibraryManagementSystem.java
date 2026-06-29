import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManagementSystem {

    static ArrayList<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Delete Book");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addBook();
                    break;

                case 2:
                    viewBooks();
                    break;

                case 3:
                    searchBook();
                    break;

                case 4:
                    issueBook();
                    break;

                case 5:
                    returnBook();
                    break;

                case 6:
                    deleteBook();
                    break;

                case 7:
                    System.out.println("Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    // Add Book
    static void addBook() {

        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author Name: ");
        String author = sc.nextLine();

        books.add(new Book(id, title, author));

        System.out.println("Book Added Successfully!");
    }

    // View Books
    static void viewBooks() {

        if (books.isEmpty()) {
            System.out.println("No Books Found.");
            return;
        }

        for (Book book : books) {
            System.out.println("--------------------------");
            System.out.println(book);
        }
    }

    // Search Book
    static void searchBook() {

        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();

        for (Book book : books) {

            if (book.getId() == id) {
                System.out.println("Book Found");
                System.out.println(book);
                return;
            }
        }

        System.out.println("Book Not Found.");
    }

    // Issue Book
    static void issueBook() {

        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();

        for (Book book : books) {

            if (book.getId() == id) {

                if (book.isIssued()) {
                    System.out.println("Book is already issued.");
                } else {
                    book.setIssued(true);
                    System.out.println("Book Issued Successfully!");
                }

                return;
            }
        }

        System.out.println("Book Not Found.");
    }

    // Return Book
    static void returnBook() {

        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();

        for (Book book : books) {

            if (book.getId() == id) {

                if (!book.isIssued()) {
                    System.out.println("Book is already available.");
                } else {
                    book.setIssued(false);
                    System.out.println("Book Returned Successfully!");
                }

                return;
            }
        }

        System.out.println("Book Not Found.");
    }

    // Delete Book
    static void deleteBook() {

        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();

        for (Book book : books) {

            if (book.getId() == id) {
                books.remove(book);
                System.out.println("Book Deleted Successfully!");
                return;
            }
        }

        System.out.println("Book Not Found.");
    }
}