
package com.mycompany.webservicesca2.models;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 *
 * @author 
 */
//Unsure about XMLRootElement line - please confirm
@XmlRootElement
public class Transaction {

    //Variables
    private String transactionType;
    private Date date;
    private double amount;
    private String description;
    private double newBalance;

    //Constructor with parameters
    public Transaction(String transactionType, double amount, String description, double initialBalance) {
        this.transactionType = transactionType;
        this.amount = amount;
        this.description = description;
        this.date = new Date();
        if(transactionType.equalsIgnoreCase("debit")){
            newBalance = initialBalance - amount;
        } else {
            newBalance = initialBalance + amount;
        }
    }

    //Setters and Getters
    public String getTransactionType() {
        return transactionType;
    }

    public Date getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public double getNewBalance() {
        return newBalance;
    }
    
}
