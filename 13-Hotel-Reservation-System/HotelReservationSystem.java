import java.util.ArrayList;
import java.util.Scanner;

public class HotelReservationSystem {

    static ArrayList<Room> rooms = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // Preloaded Rooms
        rooms.add(new Room(101, "Deluxe", 2500));
        rooms.add(new Room(102, "Deluxe", 2500));
        rooms.add(new Room(201, "Premium", 4000));
        rooms.add(new Room(202, "Premium", 4000));
        rooms.add(new Room(301, "Suite", 6000));

        while (true) {

            System.out.println("\n========== HOTEL RESERVATION SYSTEM ==========");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. View Reservation Summary");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    viewRooms();
                    break;

                case 2:
                    bookRoom();
                    break;

                case 3:
                    cancelReservation();
                    break;

                case 4:
                    reservationSummary();
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

    // View Rooms
    static void viewRooms() {

        for (Room room : rooms) {
            System.out.println("----------------------------");
            System.out.println(room);
        }
    }

    // Book Room
    static void bookRoom() {

        System.out.print("Enter Room Number: ");
        int roomNumber = sc.nextInt();

        for (Room room : rooms) {

            if (room.getRoomNumber() == roomNumber) {

                if (!room.isAvailable()) {
                    System.out.println("Room Already Booked!");
                    return;
                }

                room.setAvailable(false);

                System.out.println("Reservation Successful!");
                System.out.println("Room Number : " + room.getRoomNumber());
                System.out.println("Room Type   : " + room.getRoomType());
                System.out.printf("Price       : ₹%.2f%n", room.getPricePerNight());

                return;
            }
        }

        System.out.println("Room Not Found.");
    }

    // Cancel Reservation
    static void cancelReservation() {

        System.out.print("Enter Room Number: ");
        int roomNumber = sc.nextInt();

        for (Room room : rooms) {

            if (room.getRoomNumber() == roomNumber) {

                if (room.isAvailable()) {
                    System.out.println("Room is already available.");
                    return;
                }

                room.setAvailable(true);

                System.out.println("Reservation Cancelled Successfully!");
                return;
            }
        }

        System.out.println("Room Not Found.");
    }

    // Reservation Summary
    static void reservationSummary() {

        System.out.println("\n========== RESERVATION SUMMARY ==========");

        for (Room room : rooms) {
            System.out.println("----------------------------");
            System.out.println(room);
        }
    }
}