package org.example.geometry;

import java.awt.Color;

public class Square {
    private Point center;
    private double side;
    private double angleRadians; // rotation angle
    private Color color;

    public Square(Point center, double side) {
        this.center = center;
        this.side = side;
        this.angleRadians = 0.0;
        this.color = Color.BLACK;
    }

    public void setSize(double newSide) {
        if (newSide > 0) {
            this.side = newSide;
        }
    }

    public void stretch(double factor) {
        if (factor > 0) {
            this.side *= factor;
        }
    }

    public void squeeze(double factor) {
        if (factor > 0) {
            this.side /= factor;
        }
    }

    public void rotate(double angleRadians) {
        this.angleRadians += angleRadians;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getSide() {
        return side;
    }

    public double getAngleRadians() {
        return angleRadians;
    }

    public Color getColor() {
        return color;
    }

    public Point getCenter() {
        return center;
    }
}


