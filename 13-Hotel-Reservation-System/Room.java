public class Room {

    private int roomNumber;
    private String roomType;
    private double pricePerNight;
    private boolean available;

    // Constructor
    public Room(int roomNumber, String roomType, double pricePerNight) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.available = true; // Every room is available initially
    }

    // Getters
    public int getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public boolean isAvailable() {
        return available;
    }

    // Setter
    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {

        String status;

        if (available) {
            status = "Available";
        } else {
            status = "Booked";
        }

        return "Room Number     : " + roomNumber +
               "\nRoom Type       : " + roomType +
               "\nPrice Per Night : ₹" + String.format("%.2f", pricePerNight) +
               "\nStatus          : " + status;
    }
}