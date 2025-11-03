package org.example;

public class Electronics implements Product, Tovar {
    private String model;
    private double price;

    public Electronics(String model, double price) {
        this.model = model;
        this.price = price;
    }

    @Override
    public void displayPrice() {
        System.out.println(model + ": " + String.format("%.2f", price) + " BYN");
    }

}


