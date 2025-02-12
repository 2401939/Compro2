package com.Salazar;
public class Main {
    public static void main(String[] args) {
        Coffee espresso = new Coffee("Espresso", "Arabica", "Small", 70.00, "Dark", "Colombia", false, 10, new String[]{"Chocolate", "Nutty"}, "Espresso");
        Coffee latte = new Coffee("Latte", "Robusta", "Medium", 80.00, "Medium", "Brazil", false, 5, new String[]{"Creamy", "Vanilla"}, "Drip");

        espresso.calculatePrice("medium");
        System.out.println("Espresso stock available: " + espresso.checkStock());
        espresso.addFlavor("Caramel");
        espresso.updateStock(-2);
        System.out.println(espresso.describe());
        espresso.setDecaf(true);
        espresso.changeRoastLevel("Light");
        espresso.discount(10);

        latte.calculatePrice("large");
        System.out.println("Latte stock available: " + latte.checkStock());
        latte.addFlavor("Hazelnut");
        latte.updateStock(3);
        System.out.println(latte.describe());
        latte.setDecaf(false);
        latte.changeRoastLevel("Dark");
        latte.discount(15);
    }
}