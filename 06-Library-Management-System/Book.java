public class Book {

    private int id;
    private String title;
    private String author;
    private boolean issued;

    // Constructor
    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.issued = false;   // Book is available by default
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isIssued() {
        return issued;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setIssued(boolean issued) {
        this.issued = issued;
    }

    @Override
    public String toString() {

        String status;

        if (issued) {
            status = "Issued";
        } else {
            status = "Available";
        }

        return "Book ID   : " + id +
               "\nTitle      : " + title +
               "\nAuthor     : " + author +
               "\nStatus     : " + status;
    }
}