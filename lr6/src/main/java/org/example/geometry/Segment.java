package org.example.geometry;

public class Segment {
    private final Point start;
    private final Point end;

    public Segment(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    public double length() {
        double dx = end.getX() - start.getX();
        double dy = end.getY() - start.getY();
        return Math.hypot(dx, dy);
    }
}


