package org.example.homework.four.exone;

public class CarWash {
    private static final double PRICE_BIG_CAR = 4_000;
    private static final double PRICE_SMALL_CAR = 2_000;
    private static final double LENGTH_MAX = 6;
    private static final double WIDTH_MAX = 2;
    private static final double HEIGHT_MAX = 2.5;

    public double washingCar(Car car) {
        car.setClean(true);
        return calculationPrice(car.size);
    }

    public double washingCars(Car[] cars) {
        double priceAll = 0;
        for (Car car : cars) {
            priceAll += washingCar(car);
        }
        return priceAll;
    }

    private double calculationPrice(Size size) {
        if (size.getLength() > LENGTH_MAX || size.getWidth() > WIDTH_MAX
                || size.getHeight() > HEIGHT_MAX) {
            return PRICE_BIG_CAR;
        }
        return PRICE_SMALL_CAR;
    }
}
