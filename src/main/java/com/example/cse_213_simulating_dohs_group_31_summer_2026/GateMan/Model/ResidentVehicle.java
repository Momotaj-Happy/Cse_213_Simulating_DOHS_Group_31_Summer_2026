package com.example.cse_213_simulating_dohs_group_31_summer_2026.GateMan.Model;

public class ResidentVehicle {
    private String licensePlate;
    private String ownerName;
    private String apartmentNo;

    public ResidentVehicle() {
    }

    public ResidentVehicle(String licensePlate, String ownerName, String apartmentNo) {
        this.licensePlate = licensePlate;
        this.ownerName = ownerName;
        this.apartmentNo = apartmentNo;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getApartmentNo() {
        return apartmentNo;
    }

    public void setApartmentNo(String apartmentNo) {
        this.apartmentNo = apartmentNo;
    }

    @Override
    public String toString() {
        return "ResidentVehicle{" +
                "licensePlate='" + licensePlate + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", apartmentNo='" + apartmentNo + '\'' +
                '}';
    }
}
