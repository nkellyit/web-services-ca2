
package com.mycompany.webservicesca2.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 
 */

// [TO-DO] Unsure about XMLRootElement line - please confirm
// [TO-DO] How to make ID incremental?

@XmlRootElement
public class Customer {

	private String firstName;
    private String lastName;
    private String email;
    private int id;
    
	public Customer() {  }

    public Customer(int id, String firstName, String lastName, String email) {
    	this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    
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
	
}
















