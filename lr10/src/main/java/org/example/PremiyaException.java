package org.example;

public class PremiyaException extends Exception {
    private final double invalidPremiya;

    public PremiyaException(double invalidPremiya) {
        super("Отрицательная премия: " + invalidPremiya);
        this.invalidPremiya = invalidPremiya;
    }

    public double getInvalidPremiya() {
        return invalidPremiya;
    }
}


