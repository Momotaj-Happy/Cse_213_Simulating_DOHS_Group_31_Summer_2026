package com.example.cse_213_simulating_dohs_group_31_summer_2026.SiamHossain_2431050.NonUser;

import java.time.LocalDate;

public class StaffNotice {
    private String audience;
    private String title;
    private String message;
    private LocalDate datePosted;


    public StaffNotice(String audience, String title, String message, LocalDate datePosted) {
        this.audience = audience;
        this.title = title;
        this.message = message;
        this.datePosted = datePosted;
    }

    public String getAudience() {
        return audience;
    }

    public void setAudience(String audience) {
        this.audience = audience;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDate getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(LocalDate datePosted) {
        this.datePosted = datePosted;
    }

    @Override
    public String toString() {
        return "StaffNotice{" +
                "audience='" + audience + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
