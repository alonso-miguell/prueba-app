package com.udemy.model;

public class UserCredential {
    
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserCredential(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserCredential() { }

    @Override
    public String toString() {
        return "UserCredential [password=" + password + ", username=" + username + "]";
    }

    

}
