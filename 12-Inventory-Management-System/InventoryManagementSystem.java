import java.util.ArrayList;
import java.util.Scanner;

public class InventoryManagementSystem {

    static ArrayList<Product> products = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n========== INVENTORY MANAGEMENT SYSTEM ==========");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Search Product");
            System.out.println("4. Update Stock");
            System.out.println("5. Delete Product");
            System.out.println("6. Inventory Summary");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addProduct();
                    break;

                case 2:
                    viewProducts();
                    break;

                case 3:
                    searchProduct();
                    break;

                case 4:
                    updateStock();
                    break;

                case 5:
                    deleteProduct();
                    break;

                case 6:
                    inventorySummary();
                    break;

                case 7:
                    System.out.println("Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    // Add Product
    static void addProduct() {

        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Product Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Category: ");
        String category = sc.nextLine();

        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        System.out.print("Enter Stock Quantity: ");
        int stock = sc.nextInt();

        products.add(new Product(id, name, category, price, stock));

        System.out.println("Product Added Successfully!");
    }

    // View Products
    static void viewProducts() {

        if (products.isEmpty()) {
            System.out.println("No Products Found.");
            return;
        }

        for (Product product : products) {
            System.out.println("----------------------------");
            System.out.println(product);
        }
    }

    // Search Product
    static void searchProduct() {

        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        for (Product product : products) {

            if (product.getProductId() == id) {
                System.out.println("Product Found");
                System.out.println(product);
                return;
            }
        }

        System.out.println("Product Not Found.");
    }

    // Update Stock
    static void updateStock() {

        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        for (Product product : products) {

            if (product.getProductId() == id) {

                System.out.print("Enter Quantity to Add: ");
                int quantity = sc.nextInt();

                if (quantity <= 0) {
                    System.out.println("Invalid Quantity!");
                    return;
                }

                product.setStock(product.getStock() + quantity);

                System.out.println("Stock Updated Successfully!");
                System.out.println("Current Stock : " + product.getStock());

                return;
            }
        }

        System.out.println("Product Not Found.");
    }

    // Delete Product
    static void deleteProduct() {

        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        for (Product product : products) {

            if (product.getProductId() == id) {
                products.remove(product);
                System.out.println("Product Deleted Successfully!");
                return;
            }
        }

        System.out.println("Product Not Found.");
    }

    // Inventory Summary
    static void inventorySummary() {

        int totalStock = 0;

        for (Product product : products) {
            totalStock += product.getStock();
        }

        System.out.println("\n========== INVENTORY SUMMARY ==========");
        System.out.println("Total Products : " + products.size());
        System.out.println("Total Stock    : " + totalStock);
    }
}