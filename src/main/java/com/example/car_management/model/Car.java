package com.example.car_management.model;


import java.math.BigDecimal;


import org.springframework.stereotype.Component;


@Component
public class Car {

   
    private int carId;

    private String registrationNumber;
    private String model;
    private String company;
    private BigDecimal mileage; 
    private int seatingCapacity;
    private String fuelType;

    private String insuranceNumber;
    private String carCondition;

    private String currentStatus;
    private BigDecimal rentalRate;


    // Default constructor
    public Car() {}

    // Parameterized constructor
    public Car(int carId, String registrationNumber, String model, String company, BigDecimal mileage, 
               int seatingCapacity, String fuelType, String insuranceNumber, String carCondition, 
               String currentStatus, BigDecimal rentalRate) {
        this.carId = carId;
        this.registrationNumber = registrationNumber;
        this.model = model;
        this.company = company;
        this.mileage = mileage;
        this.seatingCapacity = seatingCapacity;
        this.fuelType = fuelType;
        this.insuranceNumber = insuranceNumber;
        this.carCondition = carCondition;
        this.currentStatus = currentStatus;
        this.rentalRate = rentalRate;
    }

    // Getters and setters for all fields
    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public BigDecimal getMileage() {
        return mileage;
    }

    public void setMileage(BigDecimal mileage) { 
        this.mileage = mileage;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(String insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

    public String getCarCondition() {
        return carCondition;
    }

    public void setCarCondition(String carCondition) {
        this.carCondition = carCondition;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public BigDecimal getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(BigDecimal rentalRate) {
        this.rentalRate = rentalRate;
    }

    @Override
    public String toString() {
        return "Car [id=" + carId + ", registrationNumber=" + registrationNumber + ", model=" + model + ", company="
                + company + ", mileage=" + mileage + ", seatingCapacity=" + seatingCapacity + ", fuelType=" + fuelType
                + ", insuranceNumber=" + insuranceNumber + ", carCondition=" + carCondition + ", currentStatus="
                + currentStatus + ", rentalRate=" + rentalRate + "]";
    }
}
