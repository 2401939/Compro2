package com.Salazar;

import java.util.ArrayList;
import java.util.List;

public class Coffee {
    // Properties (Attributes)
    private String name;
    private String type;
    private String size;
    private double price; // Changed back to price
    private String roastLevel;
    private String origin;
    private boolean isDecaf;
    private int stock; // Assuming stock is an integer representing quantity
    private List<String> flavorNotes;
    private String brewMethod;

    // Constructor
    public Coffee(String name, String type, String size, double price, String roastLevel, String origin, boolean isDecaf, int stock, String brewMethod) {
        this.name = name;
        this.type = type;
        this.size = size;
        this.price = price; // Updated to use price
        this.roastLevel = roastLevel;
        this.origin = origin;
        this.isDecaf = isDecaf;
        this.stock = stock;
        this.flavorNotes = new ArrayList<>();
        this.brewMethod = brewMethod;
    }

    // Methods (Actions)
    public double calculatePrice(String size) {
        switch (size.toLowerCase()) {
            case "small":
                return price; // Price for small
            case "medium":
                return price * 1.2; // 20% increase for medium
            case "large":
                return price * 1.5; // 50% increase for large
            default:
                return price; // Default to base price if size is unknown
        }
    }

    public boolean checkStock() {
        return stock > 0;
    }

    public void addFlavor(String note) {
        flavorNotes.add(note);
    }

    public void updateStock(int quantity) {
        this.stock += quantity;
    }

    public String describe() {
        return "A " + roastLevel + " roast coffee from " + origin + " with flavor notes: " + String.join(", ", flavorNotes);
    }

    public void setDecaf(boolean isDecaf) {
        this.isDecaf = isDecaf;
    }

    public void changeRoastLevel(String newRoastLevel) {
        this.roastLevel = newRoastLevel;
    }

    public void discount(double percentage) {
        price -= price * (percentage / 100);
    }

    // Getters for displaying coffee details
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getSize() {
        return size;
    }

    public double getPrice() { // Updated getter to reflect price
        return price;
    }

    public String getRoastLevel() {
        return roastLevel;
    }

    public String getOrigin() {
        return origin;
    }

    public boolean isDecaf() {
        return isDecaf;
    }

    public int getStock() {
        return stock;
    }

    public List<String> getFlavorNotes() {
        return flavorNotes;
    }

    public String getBrewMethod() {
        return brewMethod;
    }
}