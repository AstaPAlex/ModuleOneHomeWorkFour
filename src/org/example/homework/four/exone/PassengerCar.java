package org.example.homework.four.exone;

public class PassengerCar extends Car {
    private final boolean hasCruise;

    public PassengerCar(boolean isClean, double length, double height, double width) {
        super(isClean, length, height, width);
        this.hasCruise = true;
    }

    public boolean isHasCruise() {
        return hasCruise;
    }
}
