package org.example;

public class Food extends Product {
    public Food(String name, double price) {
        super(name, price);
    }

    @Override
    public void displayPrice() {
        System.out.println("Продукт питания '" + getName() + "': " + String.format("%.2f", getPrice()) + " BYN");

    }
}
