import java.util.ArrayList;
import java.util.Scanner;

public class ParkingLotManagementSystem {

    static ArrayList<Vehicle> parkingSlots = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // Create 5 Parking Slots
        for (int i = 1; i <= 5; i++) {
            parkingSlots.add(new Vehicle(i));
        }

        while (true) {

            System.out.println("\n========== PARKING LOT MANAGEMENT SYSTEM ==========");
            System.out.println("1. View Parking Slots");
            System.out.println("2. Park Vehicle");
            System.out.println("3. Remove Vehicle");
            System.out.println("4. View Parked Vehicles");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    viewParkingSlots();
                    break;

                case 2:
                    parkVehicle();
                    break;

                case 3:
                    removeVehicle();
                    break;

                case 4:
                    viewParkedVehicles();
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

    // View Parking Slots
    static void viewParkingSlots() {

        System.out.println("\n========== PARKING SLOTS ==========");

        for (Vehicle slot : parkingSlots) {
            System.out.println("----------------------------");
            System.out.println(slot);
        }
    }

    // Park Vehicle
    static void parkVehicle() {

        System.out.print("Enter Slot Number: ");
        int slotNumber = sc.nextInt();
        sc.nextLine();

        if (slotNumber < 1 || slotNumber > parkingSlots.size()) {
            System.out.println("Invalid Slot Number!");
            return;
        }

        Vehicle slot = parkingSlots.get(slotNumber - 1);

        if (slot.isParked()) {
            System.out.println("Slot Already Occupied!");
            return;
        }

        System.out.print("Enter Vehicle Number: ");
        String vehicleNumber = sc.nextLine();

        System.out.print("Enter Vehicle Type: ");
        String vehicleType = sc.nextLine();

        slot.setVehicleNumber(vehicleNumber);
        slot.setVehicleType(vehicleType);
        slot.setParked(true);

        System.out.println("Vehicle Parked Successfully!");
    }

    // Remove Vehicle
    static void removeVehicle() {

        System.out.print("Enter Slot Number: ");
        int slotNumber = sc.nextInt();

        if (slotNumber < 1 || slotNumber > parkingSlots.size()) {
            System.out.println("Invalid Slot Number!");
            return;
        }

        Vehicle slot = parkingSlots.get(slotNumber - 1);

        if (!slot.isParked()) {
            System.out.println("Slot is Already Empty!");
            return;
        }

        slot.setVehicleNumber("");
        slot.setVehicleType("");
        slot.setParked(false);

        System.out.println("Vehicle Removed Successfully!");
    }

    // View Parked Vehicles
    static void viewParkedVehicles() {

        boolean found = false;

        System.out.println("\n========== PARKED VEHICLES ==========");

        for (Vehicle slot : parkingSlots) {

            if (slot.isParked()) {
                System.out.println("----------------------------");
                System.out.println(slot);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No Vehicles Parked.");
        }
    }
}