package za.co.protogen;

import za.co.protogen.core.CarService;
import za.co.protogen.core.impl.CarServiceImpl;
import za.co.protogen.domain.Car;
import za.co.protogen.utility.Constant;

public class Application {

    public static void main(String[] args) {
        CarService carService = new CarServiceImpl();

        // Print all cars
        System.out.println("All Cars:");
        carService.getAllCars().forEach(car -> System.out.println(car.getModel()));

        // Add a new car
        Car car = new Car();
        car.setMake("Ford");
        car.setModel("Mustang");
        car.setYear(2022);
        car.setColor("Blue");
        car.setEngine("5.0L V8");
        car.setTransmission("Manual");
        car.setFuelType("Gasoline");
        car.setMileage(5000);
        car.setVin("DEF123");
        car.setPrice(35000);
        car.setOwnerId(789);
        carService.addCar(car);

        // Get and print a specific car by VIN
        Car retrievedCar = carService.getCarById("DEF123");
        System.out.println("Retrieved Car: " + retrievedCar.getModel());
    }
}
