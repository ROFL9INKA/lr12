package org.example.pets;

public class Turtle {
    public String name;
    protected int age;
    private String color;

    public Turtle() {
        this("Коко", 1, "green");
    }

    public Turtle(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void celebrateBirthday() {
        age += 1;
    }

    public String describe() {
        return "Turtle{name='" + name + "', age=" + age + ", color='" + color + "'}";
    }
}


