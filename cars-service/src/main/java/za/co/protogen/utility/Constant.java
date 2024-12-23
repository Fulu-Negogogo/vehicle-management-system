package za.co.protogen.utility;

import za.co.protogen.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class Constant {
    // List to hold car objects
    public static List<Car> cars = new ArrayList<>();

    static {
        // Add some sample cars
        Car car1 = new Car();
        car1.setMake("Toyota");
        car1.setModel("Corolla");
        car1.setYear(2021);
        car1.setColor("White");
        car1.setEngine("1.8L");
        car1.setTransmission("Automatic");
        car1.setFuelType("Gasoline");
        car1.setMileage(10000);
        car1.setVin("ABC123");
        car1.setPrice(25000);
        car1.setOwnerId(123);
        car1.setFeatures(new ArrayList<>());
        cars.add(car1);

        Car car2 = new Car();
        car2.setMake("Honda");
        car2.setModel("Civic");
        car2.setYear(2020);
        car2.setColor("Red");
        car2.setEngine("1.5L");
        car2.setTransmission("CVT");
        car2.setFuelType("Gasoline");
        car2.setMileage(15000);
        car2.setVin("XYZ789");
        car2.setPrice(22000);
        car2.setOwnerId(456);
        car2.setFeatures(new ArrayList<>());
        cars.add(car2);
    }
}
