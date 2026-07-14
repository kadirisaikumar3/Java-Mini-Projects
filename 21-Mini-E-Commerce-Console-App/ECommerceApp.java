import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ECommerceApp {

    static ArrayList<Product> products = new ArrayList<>();
    static ArrayList<Product> cart = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static final String FILE_NAME = "orders.txt";

    public static void main(String[] args) {

        products.add(new Product(101, "Laptop", 55000));
        products.add(new Product(102, "Mouse", 800));
        products.add(new Product(103, "Keyboard", 1500));
        products.add(new Product(104, "Headphones", 2500));
        products.add(new Product(105, "Monitor", 12000));

        while (true) {

            System.out.println("\n========== MINI E-COMMERCE ==========");
            System.out.println("1. View Products");
            System.out.println("2. Add Product to Cart");
            System.out.println("3. Remove Product from Cart");
            System.out.println("4. View Cart");
            System.out.println("5. Checkout");
            System.out.println("6. View Order History");
            System.out.println("7. Exit");

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
                    viewOrderHistory();
                    break;

                case 7:
                    System.out.println("Thank You!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    static void viewProducts() {

        for (Product product : products) {
            System.out.println("---------------------------");
            System.out.println(product);
        }
    }

    static void addToCart() {

        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        for (Product product : products) {

            if (product.getProductId() == id) {

                cart.add(product);
                System.out.println("Product Added Successfully!");
                return;
            }
        }

        System.out.println("Product Not Found.");
    }

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

        System.out.println("Product Not Found In Cart.");
    }

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

    static void checkout() {

        if (cart.isEmpty()) {

            System.out.println("Cart is Empty.");
            return;
        }

        double total = 0;

        System.out.println("\n========== BILL ==========");

        try {

            FileWriter fw = new FileWriter(FILE_NAME, true);

            for (Product product : cart) {

                System.out.printf("%-15s Rs%.2f%n",
                        product.getProductName(),
                        product.getPrice());

                fw.write(product.getProductName() + " - Rs" + product.getPrice() + "\n");

                total += product.getPrice();
            }

            System.out.println("---------------------------");
            System.out.printf("Total Bill : Rs%.2f%n", total);

            fw.write("Total : Rs" + total + "\n");
            fw.write("----------------------------\n");

            fw.close();

            cart.clear();

        } catch (IOException e) {

            System.out.println("File Error!");
        }
    }

    static void viewOrderHistory() {

        try {

            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));

            String line;

            System.out.println("\n========== ORDER HISTORY ==========");

            while ((line = br.readLine()) != null) {

                System.out.println(line);
            }

            br.close();

        } catch (IOException e) {

            System.out.println("No Order History Found.");
        }
    }
}