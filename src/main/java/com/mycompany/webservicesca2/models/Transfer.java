package com.mycompany.webservicesca2.models;

public class Transfer {

    //Variables
    private int destCustomer;
    private int destAccount;
    private double amount;
    private int pin;

    //Setters and Getters
    public int getDestCustomer() {
        return destCustomer;
    }

    public void setDestCustomer(int destCustomer) {
        this.destCustomer = destCustomer;
    }

    public int getDestAccount() {
        return destAccount;
    }

    public void setDestAccount(int destAccount) {
        this.destAccount = destAccount;
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
