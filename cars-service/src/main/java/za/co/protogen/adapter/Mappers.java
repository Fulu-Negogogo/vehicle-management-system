package za.co.protogen.adapter;

import za.co.protogen.domain.Car;
import za.co.protogen.domain.CarFeature;
import za.co.protogen.dto.CarDTO;
import za.co.protogen.dto.CarFeatureDTO;

import java.util.List;
import java.util.stream.Collectors;

public class Mappers {

    // Convert Car to CarDTO
    public static CarDTO carToCarDTO(Car car) {
        if (car == null) return null;

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

        // Convert List<CarFeature> to List<CarFeatureDTO> for features
        if (car.getFeatures() != null) {
            carDTO.setFeatures(car.getFeatures().stream()
                    .map(feature -> {
                        CarFeatureDTO featureDTO = new CarFeatureDTO();
                        featureDTO.setId(feature.getId());
                        featureDTO.setFeatureName(feature.getFeatureName());
                        featureDTO.setFeatureDescription(feature.getFeatureDescription()); // map description
                        return featureDTO;
                    })
                    .collect(Collectors.toList()));
        }

        return carDTO;
    }

    // Convert CarDTO to Car
    public static Car carDTOToCar(CarDTO carDTO) {
        if (carDTO == null) return null;

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

        // Convert List<CarFeatureDTO> to List<CarFeature> for features
        if (carDTO.getFeatures() != null) {
            car.setFeatures(carDTO.getFeatures().stream()
                    .map(featureDTO -> {
                        CarFeature feature = new CarFeature();
                        feature.setFeatureName(featureDTO.getFeatureName());
                        feature.setFeatureDescription(featureDTO.getFeatureDescription()); // map description
                        return feature;
                    })
                    .collect(Collectors.toList()));
        }

        return car;
    }

    // Convert a List of Car to a List of CarDTO
    public static List<CarDTO> carsToCarDTOs(List<Car> cars) {
        return cars.stream().map(Mappers::carToCarDTO).collect(Collectors.toList());
    }

    // Convert a List of CarDTO to a List of Car
    public static List<Car> carDTOsToCars(List<CarDTO> carDTOs) {
        return carDTOs.stream().map(Mappers::carDTOToCar).collect(Collectors.toList());
    }
}
