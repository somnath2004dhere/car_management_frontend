package com.example.car_management.model;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class Car {
   
    private int id;
    private String registrationNumber;
    private String model;
    private String company;
    private double maileage; 
    private int seatingCapacity;
    private String fuelType;
    private String insuranceNumber;
    private String carCondition;
    private String currentStatus;
    private Date previousServiceDate;
    private Date nextServiceDate;
    private String maintenanceStatus;
    private double rentalRate;

    // Default constructor
    public Car() {}

    // Parameterized constructor
    public Car(int id, String registrationNumber, String model, String company, double maileage, 
               int seatingCapacity, String fuelType, String insuranceNumber, String carCondition, 
               String currentStatus, double rentalRate, Date previousServiceDate, 
               Date nextServiceDate, String maintenanceStatus) {
        this.id = id;
        this.registrationNumber = registrationNumber;
        this.model = model;
        this.company = company;
        this.maileage = maileage;
        this.seatingCapacity = seatingCapacity;
        this.fuelType = fuelType;
        this.insuranceNumber = insuranceNumber;
        this.carCondition = carCondition;
        this.currentStatus = currentStatus;
        this.rentalRate = rentalRate;
        this.previousServiceDate = previousServiceDate;
        this.nextServiceDate = nextServiceDate;
        this.maintenanceStatus = maintenanceStatus;
    }

    // Getters and setters for all fields
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public double getMaileage() {
        return maileage;
    }

    public void setMaileage(double maileage) { // Ensure it's a double
        this.maileage = maileage;
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

    public double getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(double rentalRate) {
        this.rentalRate = rentalRate;
    }

    public Date getPreviousServiceDate() {
        return previousServiceDate;
    }

    public void setPreviousServiceDate(Date previousServiceDate) {
        this.previousServiceDate = previousServiceDate;
    }

    public Date getNextServiceDate() {
        return nextServiceDate;
    }

    public void setNextServiceDate(Date nextServiceDate) {
        this.nextServiceDate = nextServiceDate;
    }

    public String getMaintenanceStatus() {
        return maintenanceStatus;
    }

    public void setMaintenanceStatus(String maintenanceStatus) {
        this.maintenanceStatus = maintenanceStatus;
    }

    @Override
    public String toString() {
        return "Car [id=" + id + ", registrationNumber=" + registrationNumber + ", model=" + model + ", company="
                + company + ", maileage=" + maileage + ", seatingCapacity=" + seatingCapacity + ", fuelType=" + fuelType
                + ", insuranceNumber=" + insuranceNumber + ", carCondition=" + carCondition + ", currentStatus="
                + currentStatus + ", previousServiceDate=" + previousServiceDate + ", nextServiceDate="
                + nextServiceDate + ", maintenanceStatus=" + maintenanceStatus + ", rentalRate=" + rentalRate + "]";
    }
}
