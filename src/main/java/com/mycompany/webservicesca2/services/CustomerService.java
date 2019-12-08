
package com.mycompany.webservicesca2.services;

import com.mycompany.webservicesca2.models.Customer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author
 */

public class CustomerService {

	//Variables
	public static List<Customer> list = new ArrayList<>();
	public static boolean init = true;

	public CustomerService() {

		if (init) {

			//Dummy data
			Customer kevin = new Customer(101, "Kevin", "Kerin", "kkkkkkkkkkevin@gmail.com");
			Customer johnathan = new Customer(202, "Johnathan", "Munster", "jjjjjjjjjjjohnathan@gmail.com");
			Customer niall = new Customer(303, "Niall", "Kelly", "nnnnnnnnnnnniall@gmail.com");

			list.add(kevin);
			list.add(johnathan);
			list.add(niall);

			init = false;
		}
	}

	//Method that retrieves list containing all customer data
	public List<Customer> getAllCustomers() {
		return list;
	}

	//Method that returns Customer object
	//Parameter - customer ID
	//returns Customer
	public Customer getCustomer(int id) {

		for(Customer customer : list) {
			if(customer.getId() == id) {
				return customer;
			}
		}
		return new Customer(0, "", "", "");
	}

	//Method that creates new customer
	//Parameter - Customer c
	//returns new Customer
	public Customer createCustomer(Customer c) {
		list.add(c);

		System.out.println("201 - resource created with path: /customers/" + String.valueOf("Create Customer: " + c.getId()));

		return c;
	}

	//Method that verifies correct PIN entry
	//Parameters - customer ID, attempted PIN
	//returns true for correct PIN, false for incorrect
	public boolean checkPin(int customerId, int pin) {
		Customer customer = getCustomer(customerId);
		return pin == customer.getPin();
	}


}
