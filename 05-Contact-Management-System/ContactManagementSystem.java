import java.util.ArrayList;
import java.util.Scanner;

public class ContactManagementSystem {

    static ArrayList<Contact> contacts = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== CONTACT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Update Contact");
            System.out.println("5. Delete Contact");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addContact();
                    break;

                case 2:
                    viewContacts();
                    break;

                case 3:
                    searchContact();
                    break;

                case 4:
                    updateContact();
                    break;

                case 5:
                    deleteContact();
                    break;

                case 6:
                    System.out.println("Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    // Add Contact
    static void addContact() {

        System.out.print("Enter Contact ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Phone Number: ");
        String phone = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        contacts.add(new Contact(id, name, phone, email));

        System.out.println("Contact Added Successfully!");
    }

    // View Contacts
    static void viewContacts() {

        if (contacts.isEmpty()) {
            System.out.println("No Contacts Found.");
            return;
        }

        for (Contact c : contacts) {
            System.out.println("-------------------------");
            System.out.println(c);
        }
    }

    // Search Contact
    static void searchContact() {

        System.out.print("Enter Contact ID: ");
        int id = sc.nextInt();

        for (Contact c : contacts) {

            if (c.getId() == id) {
                System.out.println("Contact Found");
                System.out.println(c);
                return;
            }
        }

        System.out.println("Contact Not Found.");
    }

    // Update Contact
    static void updateContact() {

        System.out.print("Enter Contact ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Contact c : contacts) {

            if (c.getId() == id) {

                System.out.print("Enter New Name: ");
                c.setName(sc.nextLine());

                System.out.print("Enter New Phone Number: ");
                c.setPhoneNumber(sc.nextLine());

                System.out.print("Enter New Email: ");
                c.setEmail(sc.nextLine());

                System.out.println("Contact Updated Successfully!");
                return;
            }
        }

        System.out.println("Contact Not Found.");
    }

    // Delete Contact
    static void deleteContact() {

        System.out.print("Enter Contact ID: ");
        int id = sc.nextInt();

        for (Contact c : contacts) {

            if (c.getId() == id) {
                contacts.remove(c);
                System.out.println("Contact Deleted Successfully!");
                return;
            }
        }

        System.out.println("Contact Not Found.");
    }
}