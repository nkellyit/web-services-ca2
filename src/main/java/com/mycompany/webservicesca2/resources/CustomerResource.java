
package com.mycompany.webservicesca2.resources;

import com.mycompany.webservicesca2.models.*;
import com.mycompany.webservicesca2.services.AccountService;
import com.mycompany.webservicesca2.services.CustomerService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/customers")

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CustomerResource {

    //Variables
    CustomerService customerService = new CustomerService();
    AccountService accountService = new AccountService();

    //GET request - get all customers
    @GET
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    //GET request - get specific customer
    @GET
    @Path("/{customerId}")
    public Customer getCustomer(@PathParam("customerId") int id) {
        return customerService.getCustomer(id);
    }

    //POST request - create new bank account
    @POST
    @Path("/{customerId}/accounts/{pin}/{sortCode}/{accountType}")
    public Account createAccount(@PathParam("customerId") int customerId, @PathParam("pin") int pin, @PathParam("sortCode") int sortCode, @PathParam("accountType") String accountType) {
        //Check PIN method should return the same, if not return null
        if (!customerService.checkPin(customerId, pin)) {
            return null;
        }
        Account account = new Account();
        account.setAccountType(accountType);
        account.setCustomerId(customerId);
        account.setBalance(0.0);
        account.setSortCode(sortCode);
        account.setAccountNumber(accountService.newAccountNumber(customerId));
        accountService.createAccount(account);
        return account;
    }

    //POST request - lodge money from credit card into account
    @POST
    @Path("/{customerId}/accounts/{accountId}/lodge")
    public Account lodgeToAccount(@PathParam("customerId") int customerId, @PathParam("accountId") int accountId, Lodgement lodgement) {
        if (!customerService.checkPin(customerId, lodgement.getPin())) {
            return null;
        }
        return accountService.lodgeToAccount(customerId, accountId, lodgement);
    }

    //POST request - transfer money from one account to another valid account
    @POST
    @Path("/{customerId}/accounts/{accountId}/transfer")
    public Account transferToAccount(@PathParam("customerId") int customerId, @PathParam("accountId") int accountId, Transfer transfer) {
        if (!customerService.checkPin(customerId, transfer.getPin())) {
            return null;
        }
        return accountService.transferToAccount(customerId, accountId, transfer);
    }

    //POST request - withdraw funds from account to credit card
    @POST
    @Path("/{customerId}/accounts/{accountId}/withdraw")
    public Account withdrawFromAccount(@PathParam("customerId") int customerId, @PathParam("accountId") int accountId, Withdrawal withdrawal) {
        if (!customerService.checkPin(customerId, withdrawal.getPin())) {
            return null;
        }
        return accountService.withdrawFromAccount(customerId, accountId, withdrawal);
    }

    //GET request - retrieves user's account details
    @GET
    @Path("/{customerId}/accounts/{accountId}")
    public List<Account> getAccount(@PathParam("customerId") int customerId, @PathParam("accountId") int accountId) {

        System.out.println("CustomerResource customerId: " + customerId);
        System.out.println("CustomerResource accountId: " + accountId);

        return accountService.getAccount(customerId, accountId);
    }

    //GET request - retrieves user's balance
    @GET
    @Path("/{customerId}/accounts/{accountId}/balance")
    public Balance getBalance(@PathParam("customerId") int customerId, @PathParam("accountId") int accountId) {
        Balance balance = new Balance();
        balance.setBalance(accountService.getAccount(customerId, accountId).get(0).getBalance());
        return balance;
    }

    //POST request - creates new customer account
    @POST
    public Customer postCustomer(Customer c) {
        return customerService.createCustomer(c);
    }
}
