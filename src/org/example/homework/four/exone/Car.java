package org.example.homework.four.exone;

public abstract class Car {
    protected boolean isClean;
    protected Size size;

    public Car(boolean isClean, double length, double height, double width) {
        this.isClean = isClean;
        this.size = new Size(length, height, width);
    }

    public void setClean(boolean clean) {
        isClean = clean;
    }
}
