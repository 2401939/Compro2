package com.Salazar;

import java.io.*;
import java.util.*;

public class CoffeeShop {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double totalCost = 0.0;
        String receipt = "---- Coffee Order Receipt ----\n";

        // 2D array: Each row represents a coffee type.
        // Column 0: Price, Column 1: Quantity
        double[][] coffeeData = {
                {50.0, 0},  // Espresso
                {70.0, 0},  // Latte
                {65.0, 0},  // Cappuccino
                {80.0, 0}   // Mocha
        };

        String[] coffeeNames = {"Espresso", "Latte", "Cappuccino", "Mocha"};

        while (true) {
            System.out.println("""
                    --- Coffee Menu ---
                    1. Espresso - 50.0 PHP
                    2. Latte - 70.0 PHP
                    3. Cappuccino - 65.0 PHP
                    4. Mocha - 80.0 PHP
                    0. Finish Order
                    """);

            System.out.print("Choose your coffee (1-4, or 0 to finish): ");
            if (!in.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                in.next(); // Discard invalid input
                continue;
            }
            int numOfOrder = in.nextInt();

            if (numOfOrder == 0) {
                break;
            }

            if (numOfOrder < 1 || numOfOrder > 4) {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }

            System.out.print("Enter quantity: ");
            if (!in.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid quantity.");
                in.next();
                continue;
            }
            int numOfQuant = in.nextInt();

            if (numOfQuant <= 0) {
                System.out.println("Quantity must be greater than zero. Try again.");
                continue;
            }

            // Update the quantity in the 2D array
            coffeeData[numOfOrder - 1][1] += numOfQuant;
        }

        // Generate receipt and calculate total cost
        for (int i = 0; i < coffeeData.length; i++) {
            if (coffeeData[i][1] > 0) {
                double itemCost = coffeeData[i][0] * coffeeData[i][1];
                totalCost += itemCost;
                receipt += String.format("%d x %s @ %.2f each = %.2f PHP\n",
                        (int) coffeeData[i][1], coffeeNames[i], coffeeData[i][0], itemCost);
            }
        }

        double vat = totalCost * 0.12;
        double grandTotal = totalCost + vat;

        receipt += String.format("""
                ---------------------------------
                Subtotal: %.2f PHP
                VAT (12%%): %.2f PHP
                Grand Total: %.2f PHP
                """, totalCost, vat, grandTotal);

        // Payment Process
        double payment = 0.0;
        while (true) {
            System.out.print("\nEnter payment amount: ");
            if (!in.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a valid amount.");
                in.next(); // Discard invalid input
                continue;
            }
            payment = in.nextDouble();

            if (payment < grandTotal) {
                System.out.printf("Insufficient payment. You need %.2f PHP more.\n", grandTotal - payment);
            } else {
                break;
            }
        }

        double change = payment - grandTotal;
        receipt += String.format("""
                Payment: %.2f PHP
                Change: %.2f PHP
                ----------------------------------
                """, payment, change);

        System.out.println();
        System.out.println(receipt);

        // Save receipt to file
        try (PrintWriter writer = new PrintWriter(new FileWriter("CoffeeReceipt.txt"))) {
            writer.print(receipt);
            System.out.println("Receipt saved to CoffeeReceipt.txt");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the receipt.");
            e.printStackTrace();
        }
    }
}
