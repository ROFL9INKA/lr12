package org.example;

public class Electronics extends Product {
    public Electronics(String name, double price) {
        super(name, price);
    }

    @Override
    public void displayPrice() {
        System.out.println("Электроника '" + getName() + "': " + String.format("%.2f", getPrice()) + " BYN");
    }
}

