
package com.mycompany.webservicesca2.models;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 
 */

@XmlRootElement
public class Account {

    //Variables
	private int sortCode;
	private int accountNumber;
    private String accountType;
    private double balance;
    private int customerId;

    //Empty Constructor
    public Account() {  }

    //Constructor with parameters
    public Account(int sortCode, int accountNumber, String accountType, double balance, int customerId) {
        this.sortCode = sortCode;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.customerId = customerId;
        this.balance = balance;
    }

    //Setters and Getters
    public int getSortCode() {
		return sortCode;
	}

	public void setSortCode(int sortCode) {
		this.sortCode = sortCode;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
}