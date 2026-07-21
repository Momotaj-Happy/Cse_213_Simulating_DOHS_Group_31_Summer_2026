package com.example.cse_213_simulating_dohs_group_31_summer_2026;

public class User {
    private String userId;
    private String name;
    private String role;
    private String password;
    private boolean isLoggedIn;

    public User() {
        this.userId = "";
        this.name = "";
        this.role = "";
        this.password = "";
        this.isLoggedIn = false;
    }

    public User(String userId, String name, String role, String password, boolean isLoggedIn) {
        this.userId = userId;
        this.name = name;
        this.role = role;
        this.password = password;
        this.isLoggedIn = isLoggedIn;
    }

    public boolean login(String username, String password) {
        if (username != null && password != null &&
                (username.trim().equalsIgnoreCase(this.userId) || username.trim().equalsIgnoreCase(this.name)) &&
                password.equals(this.password)) {

            this.isLoggedIn = true;
            return true;
        }
        this.isLoggedIn = false;
        return false;
    }

    public boolean logout() {
        this.isLoggedIn = false;
        return true;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", isLoggedIn=" + isLoggedIn +
                '}';
    }
}