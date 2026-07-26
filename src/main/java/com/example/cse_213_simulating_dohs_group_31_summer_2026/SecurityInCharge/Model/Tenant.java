package com.example.cse_213_simulating_dohs_group_31_summer_2026.SecurityInCharge.Model;

public class Tenant {
    private String tenantId;
    private String name;
    private String apartment;
    private String mobile;

    public Tenant() {
    }

    public Tenant(String tenantId, String name, String apartment, String mobile) {
        this.tenantId = tenantId;
        this.name = name;
        this.apartment = apartment;
        this.mobile = mobile;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "Tenant{" +
                "tenantId='" + tenantId + '\'' +
                ", name='" + name + '\'' +
                ", apartment='" + apartment + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}