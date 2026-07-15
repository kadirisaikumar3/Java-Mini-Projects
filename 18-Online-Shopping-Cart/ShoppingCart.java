import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingCart {

    static ArrayList<Product> products = new ArrayList<>();
    static ArrayList<Product> cart = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // Preloaded Products
        products.add(new Product(101, "Laptop", 55000));
        products.add(new Product(102, "Mouse", 800));
        products.add(new Product(103, "Keyboard", 1500));
        products.add(new Product(104, "Headphones", 2500));
        products.add(new Product(105, "Monitor", 12000));

        while (true) {

            System.out.println("\n========== ONLINE SHOPPING CART ==========");
            System.out.println("1. View Products");
            System.out.println("2. Add Product to Cart");
            System.out.println("3. Remove Product from Cart");
            System.out.println("4. View Shopping Cart");
            System.out.println("5. Checkout");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    viewProducts();
                    break;

                case 2:
                    addToCart();
                    break;

                case 3:
                    removeFromCart();
                    break;

                case 4:
                    viewCart();
                    break;

                case 5:
                    checkout();
                    break;

                case 6:
                    System.out.println("Thank You!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    // View Products
    static void viewProducts() {

        for (Product product : products) {
            System.out.println("---------------------------");
            System.out.println(product);
        }
    }

    // Add Product to Cart
    static void addToCart() {

        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        for (Product product : products) {

            if (product.getProductId() == id) {

                cart.add(product);

                System.out.println("Product Added to Cart!");
                return;
            }
        }

        System.out.println("Product Not Found.");
    }

    // Remove Product from Cart
    static void removeFromCart() {

        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        for (Product product : cart) {

            if (product.getProductId() == id) {

                cart.remove(product);

                System.out.println("Product Removed Successfully!");
                return;
            }
        }

        System.out.println("Product Not Found in Cart.");
    }

    // View Cart
    static void viewCart() {

        if (cart.isEmpty()) {
            System.out.println("Cart is Empty.");
            return;
        }

        for (Product product : cart) {
            System.out.println("---------------------------");
            System.out.println(product);
        }
    }

    // Checkout
    static void checkout() {

        if (cart.isEmpty()) {
            System.out.println("Cart is Empty.");
            return;
        }

        double total = 0;

        System.out.println("\n========== BILL ==========");

        for (Product product : cart) {

            System.out.printf("%-15s Rs%.2f%n",
                    product.getProductName(),
                    product.getPrice());

            total += product.getPrice();
        }

        System.out.println("----------------------------");
        System.out.printf("Total Bill : Rs%.2f%n", total);
    }
}