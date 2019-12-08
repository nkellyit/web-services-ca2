package com.mycompany.webservicesca2.models;

public class Withdrawal {

    //Variables
    private double amount;
    private String ccNum;
    private int pin;

    //Setters and Getters
    public String getCcNum() {
        return ccNum;
    }

    public void setCcNum(String ccNum) {
        this.ccNum = ccNum;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }
}
