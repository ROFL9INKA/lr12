package org.example;

public class Main {
    public static void main(String[] args) {
        Product apple = new Food("Яблоко", 2.99);
        Product laptop = new Electronics("Ноутбук", 2499.0);
        Tovar pple = new Food("Яблок", 1.99);
        Tovar aptop = new Electronics("Ноутбу", 499.0);



        System.out.println("=== Product Интерфейс ===");
        apple.displayPrice();
        laptop.displayPrice();

        System.out.println("=== Tovar Интерфейс ===");
        pple.displayPrice();
        aptop.displayPrice();

    }
}