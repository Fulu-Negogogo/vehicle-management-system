package za.co.protogen.domain;

import java.util.List;
import java.util.Objects;

public class Car {

    private String vin; // Unique identifier for the car
    private String make;
    private String model;
    private int year;
    private String color;
    private String engine;
    private String transmission;
    private String fuelType;
    private int mileage; // Cannot be negative
    private double price; // Cannot be negative
    private int ownerId; // Optional: ID of the owner
    private List<String> features; // Optional: Extra features

    // Default constructor
    public Car() {
    }

    // Constructor with required fields
    public Car(String vin, String make, String model, int year, String color, double price) {
        this.vin = vin;
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.price = price;
    }

    // Full constructor
    public Car(String vin, String make, String model, int year, String color, String engine,
               String transmission, String fuelType, int mileage, double price, int ownerId, List<String> features) {
        this.vin = vin;
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.engine = engine;
        this.transmission = transmission;
        this.fuelType = fuelType;
        this.mileage = mileage;
        this.price = price;
        this.ownerId = ownerId;
        this.features = features;
    }

    // Getters and setters with validation
    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        if (mileage < 0) {
            throw new IllegalArgumentException("Mileage cannot be negative");
        }
        this.mileage = mileage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.price = price;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public List<String> getFeatures() {
        return features;
    }

    public void setFeatures(List<String> features) {
        this.features = features;
    }

    // Override toString for easier logging
    @Override
    public String toString() {
        return "Car{" +
                "vin='" + vin + '\'' +
                ", make='" + make + '\'' +
                ", domain='" + model + '\'' +
                ", year=" + year +
                ", color='" + color + '\'' +
                ", engine='" + engine + '\'' +
                ", transmission='" + transmission + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", mileage=" + mileage +
                ", price=" + price +
                ", ownerId=" + ownerId +
                ", features=" + features +
                '}';
    }

    // Override equals and hashCode for proper comparisons
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return vin.equals(car.vin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vin);
    }
}
