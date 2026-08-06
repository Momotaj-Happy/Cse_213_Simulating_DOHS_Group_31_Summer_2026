package com.example.cse_213_simulating_dohs_group_31_summer_2026.SiamHossain_2431050.NonUser;

public class Task {
    private String taskId;
    private String staffName;
    private String dutyType;
    private String location;
    private String timeSlot;
    private String status;       // Pending / Done / Late / Issue Reported
    private String availability; // used only while generating suggested tasks
    private String instruction;
    private String completionTime;
    private String notes;

    public Task() {
    }

    public Task(String taskId, String staffName, String dutyType, String location, String timeSlot, String status, String availability, String instruction, String completionTime, String notes) {
        this.taskId = taskId;
        this.staffName = staffName;
        this.dutyType = dutyType;
        this.location = location;
        this.timeSlot = timeSlot;
        this.status = status;
        this.availability = availability;
        this.instruction = instruction;
        this.completionTime = completionTime;
        this.notes = notes;
    }

    public String getTaskId() {return taskId;}

    public void setTaskId(String taskId) {this.taskId = taskId;}

    public String getStaffName() {return staffName;}

    public void setStaffName(String staffName) {this.staffName = staffName;}

    public String getDutyType() {return dutyType;}

    public void setDutyType(String dutyType) {this.dutyType = dutyType;}

    public String getLocation() {return location;}

    public void setLocation(String location) {this.location = location;}

    public String getTimeSlot() {return timeSlot;}

    public void setTimeSlot(String timeSlot) {this.timeSlot = timeSlot;}

    public String getStatus() {return status;}

    public void setStatus(String status) {this.status = status;}

    public String getAvailability() {return availability;}

    public void setAvailability(String availability) {this.availability = availability;}

    public String getInstruction() {return instruction;}

    public void setInstruction(String instruction) {this.instruction = instruction;}

    public String getCompletionTime() {return completionTime;}

    public void setCompletionTime(String completionTime) {this.completionTime = completionTime;}

    public String getNotes() {return notes;}

    public void setNotes(String notes) {this.notes = notes;}

    @Override
    public String toString() {
        return "Task{" +
                "taskId='" + taskId + '\'' +
                ", staffName='" + staffName + '\'' +
                ", dutyType='" + dutyType + '\'' +
                ", location='" + location + '\'' +
                ", timeSlot='" + timeSlot + '\'' +
                ", status='" + status + '\'' +
                ", availability='" + availability + '\'' +
                ", instruction='" + instruction + '\'' +
                ", completionTime='" + completionTime + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
