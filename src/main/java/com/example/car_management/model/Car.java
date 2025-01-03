
package com.example.car_management.model;



import java.time.LocalDate;



import org.springframework.stereotype.Component;




@Component
public class Car {

   
    private int carId;

    private String registrationNumber;
    private String model;
    private String company;


    private double mileage;


    private int seatingCapacity;


    private String fuelType;

    private String insuranceNumber;

   
    private String carCondition;

    
    private String currentStatus;

   
    private double rentalRate;

   
    private LocalDate previousServiceDate;

   
    private LocalDate nextServiceDate;

   
    private String maintenanceStatus;



   
    public Car() {}

    // Getters and setters

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

    public double getMaileage() {
        return mileage;
    }

    public void setMaileage(double mileage) {
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

    public double getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(double rentalRate) {
        this.rentalRate = rentalRate;
    }

    public LocalDate getPreviousServiceDate() {
        return previousServiceDate;
    }

    public void setPreviousServiceDate(LocalDate previousServiceDate) {
        this.previousServiceDate = previousServiceDate;
    }

    public LocalDate getNextServiceDate() {
        return nextServiceDate;
    }

    public void setNextServiceDate(LocalDate nextServiceDate) {
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
		return "Car [carId=" + carId + ", registrationNumber=" + registrationNumber + ", model=" + model + ", company="
				+ company + ", maileage=" + mileage + ", seatingCapacity=" + seatingCapacity + ", fuelType=" + fuelType
				+ ", insuranceNumber=" + insuranceNumber + ", carCondition=" + carCondition + ", currentStatus="
				+ currentStatus + ", rentalRate=" + rentalRate + ", previousServiceDate=" + previousServiceDate
				+ ", nextServiceDate=" + nextServiceDate + ", maintenanceStatus=" + maintenanceStatus + "]";
	}
    
    

}
