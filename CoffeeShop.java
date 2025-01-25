import java.io.*;
import java.util.*;

public class CoffeeShop {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double totalCost = 0.0;
        String receipt = "---- Coffee Order Receipt ----\n";

        while (true) {
            String menu = String.format("""
                    --- Coffee Menu ---
                    1. Espresso - 50.0 PHP
                    2. Latte - 70.0 PHP
                    3. Cappuccino - 65.0 PHP
                    4. Mocha - 80.0 PHP
                    0. Finish Order
                    """);

            System.out.println(menu);
            System.out.print("Choose your coffee (1-4, or 0 to finish): ");
            int numOfOrder = in.nextInt();

            if (numOfOrder == 0) {
                break;
            }

            if (numOfOrder < 1 || numOfOrder > 4) {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }

            System.out.print("Enter quantity: ");
            int numOfQuant = in.nextInt();

            double price = 0.0;
            String coffeeName = "";

            switch (numOfOrder) {
                case 1 -> {
                    price = 50.0;
                    coffeeName = "Espresso";
                }
                case 2 -> {
                    price = 70.0;
                    coffeeName = "Latte";
                }
                case 3 -> {
                    price = 65.0;
                    coffeeName = "Cappuccino";
                }
                case 4 -> {
                    price = 80.0;
                    coffeeName = "Mocha";
                }
            }

            double itemCost = price * numOfQuant;
            totalCost += itemCost;

            receipt += String.format("%d x %s @ %.2f each = %.2f PHP\n", numOfQuant, coffeeName, price, itemCost);
        }

        double vat = totalCost * 0.12;
        double grandTotal = totalCost + vat;

        receipt += String.format("""
                ---------------------------------
                Subtotal: %.2f PHP
                VAT (12%%): %.2f PHP
                Grand Total: %.2f PHP
                ----------------------------------
                """, totalCost, vat, grandTotal);
        System.out.println();
        System.out.println(receipt);

        try (PrintWriter writer = new PrintWriter(new FileWriter("CoffeeReceipt.txt"))) {
            writer.print(receipt);
            System.out.println("Receipt saved to CoffeeReceipt.txt");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the receipt.");
            e.printStackTrace();
        }
    }
}

