package com.example.cse_213_simulating_dohs_group_31_summer_2026;

public class User {
    private int userId;
    private String name;
    private String role;
    private String password;
    public boolean isLoggedIn;

    public User() {
        this.userId = 0;
        this.name = "";
        this.role = "";
        this.password = "";
        this.isLoggedIn = false;
    }

    public User(int userId, String name, String role, String password, boolean isLoggedIn) {
        this.userId = userId;
        this.name = name;
        this.role = role;
        this.password = password;
        this.isLoggedIn = isLoggedIn;
    }

    public User(int userId, String name, String role, boolean isLoggedIn) {
        this.userId = userId;
        this.name = name;
        this.role = role;
        this.isLoggedIn = isLoggedIn;
    }

    public User(int userId, String name, String password) {
        this.userId = userId;
        this.name = name;
        this.password = password;
    }

    public boolean login(int userid, String password) {
        if (password.equals(this.password) && userid == this.userId) {

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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
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