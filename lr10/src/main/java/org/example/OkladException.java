package org.example;

public class OkladException extends Exception {
    private final double invalidOklad;

    public OkladException(double invalidOklad) {
        super("Отрицательный оклад: " + invalidOklad);
        this.invalidOklad = invalidOklad;
    }

    public double getInvalidOklad() {
        return invalidOklad;
    }
}


