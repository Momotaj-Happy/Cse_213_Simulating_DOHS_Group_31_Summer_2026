package com.example.cse_213_simulating_dohs_group_31_summer_2026.SecurityInCharge.Model;

import java.time.LocalTime;

public class SilentAlarm {
    private String alarmId;
    private String location;
    private String time;
    private String type;
    private boolean isActive;

    public SilentAlarm() {
    }

    public SilentAlarm(String alarmId, String location, String time, String type, boolean isActive) {
        this.alarmId = alarmId;
        this.location = location;
        this.time = time;
        this.type = type;
        this.isActive = isActive;
    }

    public String getAlarmId() {
        return alarmId;
    }

    public void setAlarmId(String alarmId) {
        this.alarmId = alarmId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "SilentAlarm{" +
                "alarmId='" + alarmId + '\'' +
                ", location='" + location + '\'' +
                ", time=" + time +
                ", type='" + type + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
