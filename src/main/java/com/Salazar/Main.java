package com.Salazar;

public class Main {
    public static void main(String[] args) {
        // Create two Coffee objects
        Coffee coffee1 = new Coffee("Espresso", "Arabica", "Small", 50.0, "Dark", "Colombia", false, 10, "Espresso");
        Coffee coffee2 = new Coffee("Latte", "Robusta", "Medium", 75.0, "Medium", "Brazil", true, 5, "Drip");

        // Call methods on coffee1
        System.out.println("Coffee Name: " + coffee1.getName());
        System.out.println("Price for Small: ₱" + coffee1.calculatePrice("Small")); // Price for small
        System.out.println("In Stock: " + coffee1.checkStock());
        coffee1.addFlavor("Chocolate");
        coffee1.addFlavor("Nutty");
        System.out.println("Description: " + coffee1.describe());
        coffee1.discount(10); // Apply a 10% discount
        System.out.println("Price after discount: ₱" + coffee1.getPrice());

        // Call methods on coffee2
        System.out.println("\nCoffee Name: " + coffee2.getName());
        System.out.println("Base Price: ₱" + coffee2.getPrice()); // Show base price
        System.out.println("Price for Medium: ₱" + coffee2.calculatePrice("Medium")); // Price for medium
        System.out.println("In Stock: " + coffee2.checkStock());
        coffee2.addFlavor("Citrus");
        System.out.println("Description: " + coffee2.describe());
        coffee2.discount(15); // Apply a 15% discount
        System.out.println("Price after discount: ₱" + coffee2.getPrice());
    }
}