
package com.mycompany.webservicesca2.resources;

import com.mycompany.webservicesca2.models.Account;
import com.mycompany.webservicesca2.models.Customer;
import com.mycompany.webservicesca2.services.AccountService;
import com.mycompany.webservicesca2.services.CustomerService;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/customers")

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CustomerResource {
 
    CustomerService customerService = new CustomerService();
    AccountService accountService = new AccountService();
    
    @GET
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }
    
    @GET
    @Path("/{customerId}")
    public Customer getCustomer(@PathParam("customerId") int id) {
        return customerService.getCustomer(id);
    }

    @GET
    @Path("/{customerId}/accounts/{accountId}")
    public List<Account> getAccount(@PathParam("customerId") int customerId, @PathParam("accountId") int accountId) {
    	
    	System.out.println("CustomerResource customerId: " + customerId);
    	System.out.println("CustomerResource accountId: " + accountId);
    	
        return accountService.getAccount(customerId, accountId);
    }
    
    @POST
    public Customer postCustomer(Customer c) {
		return customerService.createCustomer(c);
    }   
}