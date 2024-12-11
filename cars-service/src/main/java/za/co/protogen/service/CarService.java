package za.co.protogen.service;

import za.co.protogen.dto.CarDTO;

import java.util.List;

public interface CarService {

    CarDTO getCarById(Long id);
    List<CarDTO> getAllCars();
    CarDTO addCar(CarDTO carDTO);
    CarDTO updateCar(Long id, CarDTO carDTO);
    void deleteCar(Long id);
}
