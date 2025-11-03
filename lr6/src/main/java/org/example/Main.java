package org.example;

import org.example.geometry.Point;
import org.example.geometry.Square;
import org.example.pets.Turtle;

import java.awt.Color;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Turtle turtle = new Turtle("Лео", 5, "зеленая");
        turtle.celebrateBirthday();
        System.out.println(turtle.describe());

        Point center = new Point(0, 0);
        Square sq = new Square(center, 10);
        sq.stretch(1.5);
        sq.rotate(Math.PI / 4);
        sq.setColor(Color.BLUE);
        System.out.println("Square side=" + sq.getSide() + ", angle(rad)=" + sq.getAngleRadians() + ", color=" + sq.getColor());
    }
}