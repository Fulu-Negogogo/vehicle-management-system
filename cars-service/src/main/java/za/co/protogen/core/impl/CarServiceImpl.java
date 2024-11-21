package za.co.protogen.core.impl;

import org.springframework.stereotype.Service;
import za.co.protogen.core.CarService;
import za.co.protogen.domain.Car;
import za.co.protogen.utility.Constant;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Override
    public void addCar(Car car) {
        Constant.cars.add(car);
    }

    @Override
    public void removeCar(String vin) {
        Constant.cars.removeIf(car -> car.getVin().equals(vin));
    }

    @Override
    public Car getCarById(String vin) {
        return Constant.cars.stream()
                .filter(car -> car.getVin().equals(vin))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Car> getAllCars() {
        return Constant.cars;
    }
}
