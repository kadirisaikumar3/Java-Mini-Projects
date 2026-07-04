public class Movie {

    private int movieId;
    private String movieName;
    private double ticketPrice;
    private int availableSeats;

    // Constructor
    public Movie(int movieId, String movieName, double ticketPrice, int availableSeats) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.ticketPrice = ticketPrice;
        this.availableSeats = availableSeats;
    }

    // Getters
    public int getMovieId() {
        return movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    // Setter
    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    @Override
    public String toString() {

        return "Movie ID        : " + movieId +
               "\nMovie Name      : " + movieName +
               "\nTicket Price    : ₹" + String.format("%.2f", ticketPrice) +
               "\nAvailable Seats : " + availableSeats;
    }
}