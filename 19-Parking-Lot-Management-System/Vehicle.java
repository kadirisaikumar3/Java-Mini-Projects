public class Vehicle {

    private int slotNumber;
    private String vehicleNumber;
    private String vehicleType;
    private boolean parked;

    // Constructor
    public Vehicle(int slotNumber) {
        this.slotNumber = slotNumber;
        this.vehicleNumber = "";
        this.vehicleType = "";
        this.parked = false;
    }

    // Getters
    public int getSlotNumber() {
        return slotNumber;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public boolean isParked() {
        return parked;
    }

    // Setters
    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setParked(boolean parked) {
        this.parked = parked;
    }

    @Override
    public String toString() {

        String status = parked ? "Occupied" : "Available";

        return "Slot Number    : " + slotNumber +
               "\nVehicle Number : " + (parked ? vehicleNumber : "-") +
               "\nVehicle Type   : " + (parked ? vehicleType : "-") +
               "\nStatus         : " + status;
    }
}