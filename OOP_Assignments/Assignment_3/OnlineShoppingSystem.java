//L1F23BSSE0389

import java.util.ArrayList;
import java.util.Scanner;

class Products {
    private String name;
    private  double price;
    private  int quantity;

    public Products(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
class Electronics extends Products{
    private String brand;
    private int warrantyPeriod;

    public Electronics(String name, double price, int quantity, String brand, int warrantyPeriod) {
        super(name, price, quantity);
        this.brand = brand;
        this.warrantyPeriod = warrantyPeriod;
    }

    public String warrantyCoverage() {
        if (warrantyPeriod > 0) {
            return "This " + getName() + " by " + brand + " is covered under warranty for " + warrantyPeriod + " months.";
        } else {
            return "This " + getName() + " by " + brand + " has no warranty coverage.";
        }
    }
}
class Clothing extends Products{
    private String brand;
    private String color;
    private String material;          // Example Linen, Silk, cotton...
    private String specialFeatures;      //Any unique features, such as pockets, buttons, or zippers


    public Clothing(String name, double price, int quantity, String brand, String color, String material, String specialFeatures) {
        super(name, price, quantity);
        this.brand = brand;
        this.color = color;
        this.material = material;
        this.specialFeatures = specialFeatures;
    }
}
class Books extends Products{
    private String title;
    private String authorName;

    public Books(String name, double price, int quantity, String title, String authorName) {
        super(name, price, quantity);
        this.title = title;
        this.authorName = authorName;
    }
}

class Customer{
    private String name;
    private String email;
    private String address;

    public Customer(String name, String address, String email) {
        this.name = name;
        this.address = address;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}

class RegularCustomer extends Customer {
    private double discountRate;

    public RegularCustomer(String name, String email, String address, double discountRate) {
        super(name, email, address);
        this.discountRate = discountRate;
    }
    public double calculateDiscount(double purchaseAmount) {
        if (purchaseAmount <= 0) {
            return 0.0;
        }
        return (purchaseAmount * discountRate) / 100;
    }

}

class PremiumCustomer extends Customer {
    private double loyaltyPoints;
    private String membershipLevel;

    public PremiumCustomer(String name, String email, String address, double loyaltyPoints, String membershipLevel) {
        super(name, email, address);
        this.loyaltyPoints = loyaltyPoints;
        this.membershipLevel = membershipLevel;
    }

    public double calculateDiscountByPoints() {
        if (loyaltyPoints >= 1000) {
            return 15.0;
        } else if (loyaltyPoints >= 500) {
            return 10.0;
        } else if (loyaltyPoints >= 100) {
            return 5.0;
        } else {
            return 0.0;
        }
    }

    public double calculateDiscountByMembership() {
        switch (membershipLevel.toLowerCase()) {
            case "platinum":
                return 20.0;
            case "gold":
                return 15.0;
            case "silver":
                return 10.0;
            default:
                return 0.0;
        }
    }

    public double calculateTotalDiscount() {
        double pointsDiscount = calculateDiscountByPoints();
        double membershipDiscount = calculateDiscountByMembership();
        return pointsDiscount + membershipDiscount;
    }
}

class ShoppingCart {
    private ArrayList<Products> cartItems;

    public ShoppingCart() {
        cartItems = new ArrayList<>();
    }

    public void addProduct(Products product) {
        if (product != null) {
            cartItems.add(product);
            System.out.println(product.getName() + " added to the cart.");
        } else {
            System.out.println("Invalid product.");
        }
    }

    public void removeProduct(Products product) {
        if (cartItems.remove(product)) {
            System.out.println(product.getName() + " removed from the cart.");
        } else {
            System.out.println("Product not found in the cart.");
        }
    }

    public double calculateTotalPrice() {
        double total = 0.0;
        for (Products product : cartItems) {
            total += product.getPrice() * product.getQuantity();
        }
        return total;
    }

    public String generateOrderSummary() {
        if (cartItems.isEmpty()) {
            return "Your cart is empty.";
        }
        StringBuilder summary = new StringBuilder("Order Summary:\n");
        for (Products product : cartItems) {
            summary.append(product.getName())
                    .append(" - Quantity: ").append(product.getQuantity())
                    .append(" - Price: $").append(product.getPrice())
                    .append("\n");
        }
        summary.append("Total Price: $").append(calculateTotalPrice());
        return summary.toString();
    }
}



public class OnlineShoppingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShoppingCart cart = new ShoppingCart();

        System.out.println("Welcome to the Online Shopping System!");

        // Create products
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add a new product");
            System.out.println("2. View cart and proceed");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.println("Select product type:");
                System.out.println("1. Electronics");
                System.out.println("2. Clothing");
                System.out.println("3. Books");
                int productType = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Enter product name:");
                String name = scanner.nextLine();
                System.out.println("Enter price:");
                double price = scanner.nextDouble();
                System.out.println("Enter quantity:");
                int quantity = scanner.nextInt();
                scanner.nextLine();

                Products product;
                switch (productType) {
                    case 1: // Electronics
                        System.out.println("Enter brand:");
                        String brand = scanner.nextLine();
                        System.out.println("Enter warranty period (in months):");
                        int warranty = scanner.nextInt();
                        scanner.nextLine();
                        product = new Electronics(name, price, quantity, brand, warranty);
                        break;
                    case 2: // Clothing
                        System.out.println("Enter brand:");
                        brand = scanner.nextLine();
                        System.out.println("Enter color:");
                        String color = scanner.nextLine();
                        System.out.println("Enter material:");
                        String material = scanner.nextLine();
                        System.out.println("Enter special features:");
                        String features = scanner.nextLine();
                        product = new Clothing(name, price, quantity, brand, color, material, features);
                        break;
                    case 3: // Books
                        System.out.println("Enter title:");
                        String title = scanner.nextLine();
                        System.out.println("Enter author name:");
                        String author = scanner.nextLine();
                        product = new Books(name, price, quantity, title, author);
                        break;
                    default:
                        System.out.println("Invalid product type. Try again.");
                        continue;
                }

                cart.addProduct(product);
            } else if (choice == 2) {
                break;
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }

        System.out.println("\nSelect customer type:");
        System.out.println("1. Regular Customer");
        System.out.println("2. Premium Customer");
        int customerType = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter your name:");
        String customerName = scanner.nextLine();
        System.out.println("Enter your email:");
        String email = scanner.nextLine();
        System.out.println("Enter your address:");
        String address = scanner.nextLine();

        Customer customer;
        if (customerType == 1) {
            System.out.println("Enter discount rate (percentage):");
            double discountRate = scanner.nextDouble();
            customer = new RegularCustomer(customerName, email, address, discountRate);
        } else {
            System.out.println("Enter loyalty points:");
            double loyaltyPoints = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("Enter membership level (Platinum/Gold/Silver):");
            String membershipLevel = scanner.nextLine();
            customer = new PremiumCustomer(customerName, email, address, loyaltyPoints, membershipLevel);
        }

        System.out.println("\nGenerating Order Summary...");
        System.out.println(cart.generateOrderSummary());
        System.out.println("Thank you for shopping with us!");

        scanner.close();
    }
}
