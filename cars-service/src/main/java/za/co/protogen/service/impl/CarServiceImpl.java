package za.co.protogen.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.protogen.domain.Car;
import za.co.protogen.domain.CarFeature;
import za.co.protogen.dto.CarDTO;
import za.co.protogen.dto.CarFeatureDTO;
import za.co.protogen.repository.CarRepository;
import za.co.protogen.repository.CarFeatureRepository;
import za.co.protogen.service.CarService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CarFeatureRepository carFeatureRepository;

    @Override
    public CarDTO getCarById(Long id) {
        Car car = carRepository.findById(id).orElseThrow(() -> new RuntimeException("Car not found"));
        return mapToDTO(car);
    }

    @Override
    public List<CarDTO> getAllCars() {
        List<Car> cars = carRepository.findAll();
        return cars.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public CarDTO addCar(CarDTO carDTO) {
        Car car = mapToEntity(carDTO);
        Car savedCar = carRepository.save(car);

        // Save car features if present
        if (carDTO.getFeatures() != null) {
            for (CarFeatureDTO featureDTO : carDTO.getFeatures()) {
                CarFeature carFeature = new CarFeature();
                carFeature.setFeatureName(featureDTO.getFeatureName());
                carFeature.setFeatureDescription(featureDTO.getFeatureDescription()); // Added description
                carFeature.setCar(savedCar);
                carFeatureRepository.save(carFeature);
            }
        }

        return mapToDTO(savedCar);
    }

    @Override
    public CarDTO updateCar(Long id, CarDTO carDTO) {
        Car existingCar = carRepository.findById(id).orElseThrow(() -> new RuntimeException("Car not found"));

        existingCar.setMake(carDTO.getMake());
        existingCar.setModel(carDTO.getModel());
        existingCar.setYear(carDTO.getYear());
        existingCar.setColor(carDTO.getColor());
        existingCar.setEngine(carDTO.getEngine());
        existingCar.setTransmission(carDTO.getTransmission());
        existingCar.setFuelType(carDTO.getFuelType());
        existingCar.setMileage(carDTO.getMileage());
        existingCar.setVin(carDTO.getVin());
        existingCar.setPrice(carDTO.getPrice());
        existingCar.setOwnerId(carDTO.getOwnerId());

        Car updatedCar = carRepository.save(existingCar);

        // Delete existing car features and add the new ones
        carFeatureRepository.deleteByCarId(id);

        if (carDTO.getFeatures() != null) {
            for (CarFeatureDTO featureDTO : carDTO.getFeatures()) {
                CarFeature carFeature = new CarFeature();
                carFeature.setFeatureName(featureDTO.getFeatureName());
                carFeature.setFeatureDescription(featureDTO.getFeatureDescription()); // Added description
                carFeature.setCar(updatedCar);
                carFeatureRepository.save(carFeature);
            }
        }

        return mapToDTO(updatedCar);
    }

    @Override
    public void deleteCar(Long id) {
        Car car = carRepository.findById(id).orElseThrow(() -> new RuntimeException("Car not found"));
        carRepository.delete(car);
    }

    // Helper method to map Car entity to CarDTO
    private CarDTO mapToDTO(Car car) {
        CarDTO carDTO = new CarDTO();
        carDTO.setId(car.getId());
        carDTO.setMake(car.getMake());
        carDTO.setModel(car.getModel());
        carDTO.setYear(car.getYear());
        carDTO.setColor(car.getColor());
        carDTO.setEngine(car.getEngine());
        carDTO.setTransmission(car.getTransmission());
        carDTO.setFuelType(car.getFuelType());
        carDTO.setMileage(car.getMileage());
        carDTO.setVin(car.getVin());
        carDTO.setPrice(car.getPrice());
        carDTO.setOwnerId(car.getOwnerId());

        if (car.getFeatures() != null) {
            List<CarFeatureDTO> featureDTOs = car.getFeatures().stream()
                    .map(carFeature -> {
                        CarFeatureDTO featureDTO = new CarFeatureDTO();
                        featureDTO.setId(carFeature.getId());
                        featureDTO.setFeatureName(carFeature.getFeatureName());
                        featureDTO.setFeatureDescription(carFeature.getFeatureDescription()); // Added description
                        return featureDTO;
                    })
                    .collect(Collectors.toList());
            carDTO.setFeatures(featureDTOs);
        }

        return carDTO;
    }

    // Helper method to map CarDTO to Car entity
    private Car mapToEntity(CarDTO carDTO) {
        Car car = new Car();
        car.setId(carDTO.getId());
        car.setMake(carDTO.getMake());
        car.setModel(carDTO.getModel());
        car.setYear(carDTO.getYear());
        car.setColor(carDTO.getColor());
        car.setEngine(carDTO.getEngine());
        car.setTransmission(carDTO.getTransmission());
        car.setFuelType(carDTO.getFuelType());
        car.setMileage(carDTO.getMileage());
        car.setVin(carDTO.getVin());
        car.setPrice(carDTO.getPrice());
        car.setOwnerId(carDTO.getOwnerId());
        return car;
    }
}
