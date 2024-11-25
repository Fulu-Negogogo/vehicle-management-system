package za.co.protogen.service;

import za.co.protogen.domain.Car;

import java.util.List;

public interface CarService {
    void addCar(Car car);
    void removeCar(String vin);
    Car getCarById(String vin);
    List<Car> getAllCars();
}
