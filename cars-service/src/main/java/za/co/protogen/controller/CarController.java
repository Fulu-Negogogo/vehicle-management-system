package za.co.protogen.controller;

import org.springframework.web.bind.annotation.*;
import za.co.protogen.core.CarService;
import za.co.protogen.domain.Car;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @PostMapping
    public void addCar(@RequestBody Car car) {
        carService.addCar(car);
    }

    @DeleteMapping("/{vin}")
    public void removeCar(@PathVariable String vin) {
        carService.removeCar(vin);
    }
}
