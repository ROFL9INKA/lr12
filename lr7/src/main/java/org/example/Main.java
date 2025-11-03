package org.example;

public class Main {
    public static void main(String[] args) {
        Product apple = new Food("Яблоко", 2.99);
        Product laptop = new Electronics("Ноутбук", 2499.0);
        Game net = new Game ("Игра", 30.99);
        Product net1 = new Game ("Игра1", 40.99);

        apple.displayPrice();
        laptop.displayPrice();
        net1.displayPrice();
        net.displayPrice();
    }
}