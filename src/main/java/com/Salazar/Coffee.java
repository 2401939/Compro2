package com.Salazar;
class Coffee {
    String name;
    String type;
    String size;
    double price;
    String roastLevel;
    String origin;
    boolean isDecaf;
    int stock;
    String[] flavorNotes;
    String brewMethod;

    public Coffee(String name, String type, String size, double price, String roastLevel, String origin, boolean isDecaf, int stock, String[] flavorNotes, String brewMethod) {
        this.name = name;
        this.type = type;
        this.size = size;
        this.price = price;
        this.roastLevel = roastLevel;
        this.origin = origin;
        this.isDecaf = isDecaf;
        this.stock = stock;
        this.flavorNotes = flavorNotes;
        this.brewMethod = brewMethod;
    }

    public void calculatePrice(String size) {
        switch (size.toLowerCase()) {
            case "small":
                this.price = price;
                break;
            case "medium":
                this.price = price * 1.2;
                break;
            case "large":
                this.price = price * 1.5;
                break;
        }
        System.out.println("Price for " + size + " " + name + ": $" + this.price);
    }

    public boolean checkStock() {
        return stock > 0;
    }

    public void addFlavor(String note) {
        String[] newFlavorNotes = new String[flavorNotes.length + 1];
        System.arraycopy(flavorNotes, 0, newFlavorNotes, 0, flavorNotes.length);
        newFlavorNotes[flavorNotes.length] = note;
        flavorNotes = newFlavorNotes;
        System.out.println("Added flavor note: " + note);
    }

    public void updateStock(int quantity) {
        this.stock += quantity;
        System.out.println("Stock updated. New stock: " + this.stock);
    }

    public String describe() {
        return "A " + roastLevel + " roast " + name + " coffee with " + String.join(", ", flavorNotes) + " notes.";
    }

    public void setDecaf(boolean isDecaf) {
        this.isDecaf = isDecaf;
        System.out.println(name + " is now " + (isDecaf ? "decaf" : "regular"));
    }

    public void changeRoastLevel(String newRoastLevel) {
        this.roastLevel = newRoastLevel;
        System.out.println("Roast level changed to: " + newRoastLevel);
    }

    public void discount(double percentage) {
        this.price -= this.price * (percentage / 100);
        System.out.println("New discounted price: $" + this.price);
    }
}