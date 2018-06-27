package com.example.mac.swyhealthmonitoring.entities;

import java.util.List;
import java.util.Map;

public class User {
    private String userName;
    private String phoneNumber;
    private String password;
    private String email;
    private String gender;
    private String birthDate;
    private String type;//doctor or patient
    private List<Integer> tempreture;
    private List<Integer> heartRate;
    private List<Integer> sugar;
    private Map<String,String> familyNameAndPhoneNumbers;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Integer> getTempreture() {
        return tempreture;
    }

    public void setTempreture(List<Integer> tempreture) {
        this.tempreture = tempreture;
    }

    public List<Integer> getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(List<Integer> heartRate) {
        this.heartRate = heartRate;
    }

    public List<Integer> getSugar() {
        return sugar;
    }

    public void setSugar(List<Integer> sugar) {
        this.sugar = sugar;
    }

    public Map<String, String> getFamilyNameAndPhoneNumbers() {
        return familyNameAndPhoneNumbers;
    }

    public void setFamilyNameAndPhoneNumbers(Map<String, String> familyNameAndPhoneNumbers) {
        this.familyNameAndPhoneNumbers = familyNameAndPhoneNumbers;
    }
}
