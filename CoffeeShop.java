import java.io.*;
import java.util.*;

public class CoffeeShop {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double totalCost = 0.0;
        String receipt = "---- Coffee Order Receipt ----\n";

        // Array to store quantities for each coffee type
        int[] quantities = new int[4]; // Index 0: Espresso, 1: Latte, 2: Cappuccino, 3: Mocha

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

            // Update the quantity for the selected coffee type
            quantities[numOfOrder - 1] += numOfQuant;
        }

        // Calculate the total cost and generate the receipt
        String[] coffeeNames = {"Espresso", "Latte", "Cappuccino", "Mocha"};
        double[] prices = {50.0, 70.0, 65.0, 80.0};

        for (int i = 0; i < quantities.length; i++) {
            if (quantities[i] > 0) {
                double itemCost = prices[i] * quantities[i];
                totalCost += itemCost;
                receipt += String.format("%d x %s @ %.2f each = %.2f PHP\n", quantities[i], coffeeNames[i], prices[i], itemCost);
            }
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
