package org.example.homework.four.exone;

public class Size {
    private final double length;
    private final double width;
    private final double height;

    public Size(double length, double height, double width) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}
