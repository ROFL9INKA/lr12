package org.example;

public class Game extends Product {
    public Game(String name, double price) {
        super(name, price);
    }

    @Override
    public void displayPrice() {
        System.out.println("Магазин игр '" + getName() + "': " + String.format("%.2f", getPrice()) + " BYN");

    }
}