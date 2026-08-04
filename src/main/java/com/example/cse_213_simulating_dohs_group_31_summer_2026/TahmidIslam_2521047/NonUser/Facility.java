package com.example.cse_213_simulating_dohs_group_31_summer_2026.TahmidIslam_2521047.NonUser;

import java.io.Serializable;

public class Facility implements Serializable {
    private int facilityId, bookingPrice;
    private String facilityType, location, facilityName;
    private boolean availability;

    public int getFacilityId() {
        return facilityId;
    }

    public String getFacilityType() {
        return facilityType;
    }

    public String getLocation() {
        return location;
    }

    public void setBookingPrice(int bookingPrice) {
        this.bookingPrice = bookingPrice;
    }

    public int getBookingPrice() {
        return bookingPrice;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setFacilityType(String facilityType) {
        this.facilityType = facilityType;
    }

    public void setLocation(String location) {
        location = location;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public Facility(int facilityId, int bookingPrice, String facilityType, String location, String facilityName, boolean availability) {
        this.facilityId = facilityId;
        this.bookingPrice = bookingPrice;
        this.facilityType = facilityType;
        this.location = location;
        this.facilityName = facilityName;
        this.availability = availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;


    }
}
