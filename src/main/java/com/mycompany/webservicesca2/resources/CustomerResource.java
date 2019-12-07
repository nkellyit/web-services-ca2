
package com.mycompany.webservicesca2.resources;

import com.mycompany.webservicesca2.models.*;
import com.mycompany.webservicesca2.services.AccountService;
import com.mycompany.webservicesca2.services.CustomerService;

import java.util.List;
import javax.ws.rs.*;
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

    @POST
    @Path("/{customerId}/accounts")
    public Account createAccount(@PathParam("customerId") int customerId,@QueryParam("accountType") String accountType) {
        Account account = new Account();
        account.setAccountType(accountType);
        account.setCustomerId(customerId);
        account.setBalance(0.0);
        account.setSortCode(776634);
        account.setAccountNumber(accountService.newAccountNumber(customerId));
        accountService.createAccount(account);
        return account;
    }

    @POST
    @Path("/{customerId}/accounts/{accountId}/lodge")
    public Account lodgeToAccount(@PathParam("customerId") int customerId, @PathParam("accountId") int accountId, Lodgement lodgement) {
        return accountService.lodgeToAccount(customerId, accountId, lodgement);
    }

    @POST
    @Path("/{customerId}/accounts/{accountId}/transfer")
    public Account transferToAccount(@PathParam("customerId") int customerId, @PathParam("accountId") int accountId, Transfer transfer) {
        return accountService.transferToAccount(customerId, accountId, transfer);
    }

    @POST
    @Path("/{customerId}/accounts/{accountId}/withdraw")
    public Account withdrawFromAccount(@PathParam("customerId") int customerId, @PathParam("accountId") int accountId, Withdrawal withdrawal) {
        return accountService.withdrawFromAccount(customerId, accountId, withdrawal);
    }

    @GET
    @Path("/{customerId}/accounts/{accountId}")
    public List<Account> getAccount(@PathParam("customerId") int customerId, @PathParam("accountId") int accountId) {
    	
    	System.out.println("CustomerResource customerId: " + customerId);
    	System.out.println("CustomerResource accountId: " + accountId);
    	
        return accountService.getAccount(customerId, accountId);
    }

    @GET
    @Path("/{customerId}/accounts/{accountId}/balance")
    public Balance getBalance(@PathParam("customerId") int customerId, @PathParam("accountId") int accountId) {
        Balance balance = new Balance();
        balance.setBalance(accountService.getAccount(customerId, accountId).get(0).getBalance());
        return balance;
    }
    
    @POST
    public Customer postCustomer(Customer c) {
		return customerService.createCustomer(c);
    }   
}