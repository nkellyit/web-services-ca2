
package com.mycompany.webservicesca2.models;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 
 */

@XmlRootElement
public class Customer {

	//Variables
	private String firstName;
    private String lastName;
    private String email;
    private int id;
    private int pin;

	//Empty Constructor
	public Customer() {

	}
	//Constructor with parameters
    public Customer(int id, String firstName, String lastName, String email) {
    	this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

	//Setters and Getters
    public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}
}