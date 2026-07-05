public class Product {

    private int productId;
    private String productName;
    private String category;
    private double price;
    private int stock;

    // Constructor
    public Product(int productId, String productName, String category,
                   double price, int stock) {

        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }

    // Getters
    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    // Setters
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {

        return "Product ID   : " + productId +
               "\nProduct Name : " + productName +
               "\nCategory     : " + category +
               "\nPrice        : Rs" + String.format("%.2f", price) +
               "\nStock        : " + stock;
    }
}