package org.example.homework.four.exone;

public class Bus extends Car {
    private final int maxPassengers;

    public Bus(boolean isClean, double length, double height, double width) {
        super(isClean, length, height, width);
        this.maxPassengers = 100;
    }
}
