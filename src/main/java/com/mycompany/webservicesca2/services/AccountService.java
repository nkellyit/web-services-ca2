
package com.mycompany.webservicesca2.services;

import com.mycompany.webservicesca2.models.*;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 
 */
public class AccountService {
    
	public static List<Account> accountList = new ArrayList<>();
	public static List<Account> tempAccountList = new ArrayList<>();
    
    public static boolean init = true;
    
    public AccountService() {
  
    	if (init) {
    	
    	Account acc1 = new Account(990, 1234, "savings", 0, 101);
    	Account acc1a = new Account(990, 1234, "deposit", 0, 101);
    	//
    	Account acc2 = new Account(980, 1321, "savings", 0, 202);
    	Account acc2a = new Account(980, 1321, "deposit", 0, 202);
    	//
    	Account acc3 = new Account(960, 2765, "savings", 0, 303);
    	Account acc3a = new Account(960, 2765, "deposit", 0, 303);
    	
    	accountList.add(acc1);
    	accountList.add(acc2);
    	accountList.add(acc3);
    	//
    	accountList.add(acc1a);
    	accountList.add(acc2a);
    	accountList.add(acc3a);
    	
    	init = false;
    	
    	}
    }
    
    public List<Account> getAllAccounts() {
    	return accountList;
	}

	public int newAccountNumber(int customerId) {
		int accNum = 101;
    	while (getAccount(customerId, accNum).size() > 0) {
    		accNum++;
		}
    	return accNum;
	}
    
    public List<Account> getAccount(int customerId, int accountId) {
    	
    	System.out.println("AccountService customerId: " + customerId);
    	System.out.println("AccountService accountId: " + accountId);
    	
    	tempAccountList.clear();

    	for(int i = 0; i < accountList.size(); i++) {
    		
    		if(accountList.get(i).getCustomerId() == customerId && accountList.get(i).getAccountNumber() == accountId ) {

    			System.out.println("cust: " + accountList.get(i).getCustomerId());
    			System.out.println("acc: " + accountList.get(i).getAccountNumber());
    			    			
    			tempAccountList.add(accountList.get(i));
    			
    			if(tempAccountList.size() == 0) {
    				return new ArrayList<>();
    			}
			}	
    	}
    	
    	System.out.println("tempAccountList: " + tempAccountList.size());	
    	return tempAccountList;
	}
    
    public List<Account> getAccount(int accountId) {
    	
    	
    	System.out.println("AccountService accountId: " + accountId);
    	
    	tempAccountList.clear();

    	for(int i = 0; i < accountList.size(); i++) {
    		
    		if(accountList.get(i).getAccountNumber() == accountId) {

    			System.out.println("acc: " + accountList.get(i).getAccountNumber());
    			    			
    			tempAccountList.add(accountList.get(i));
    			
    			if(tempAccountList.size() == 0) {
    				return new ArrayList<>();
    			}
			}	
    	}
    	
    	System.out.println("tempAccountList: " + tempAccountList.size());	
    	return tempAccountList;
	}

    public Account createAccount(Account account) {
		// account.setAccountNumber(accountList.size() + 1);
		accountList.add(account);
		
		System.out.println("201 - resource created with path: /account/" + String.valueOf("Create Account: " + account.getAccountNumber()));
		
		return account;
    }

    public Account lodgeToAccount(int customerId, int accountId, Lodgement lodgement) {
    	List<Account> accounts = getAccount(customerId, accountId);
    	if (accounts.size() > 0) {
    		Account account = accounts.get(0);
			account.setBalance(account.getBalance() + lodgement.getAmount());
			return account;
		}
    	return null;
	}

	public Account withdrawFromAccount(int customerId, int accountId, Withdrawal withdrawal) {
		List<Account> accounts = getAccount(customerId, accountId);
		if (accounts.size() > 0) {
			Account account = accounts.get(0);
			if (account.getBalance() < withdrawal.getAmount()) {
				return null;
			}
			account.setBalance(account.getBalance() - withdrawal.getAmount());
			return account;
		}
		return null;
	}

	public Account transferToAccount(int customerId, int accountId, Transfer transfer) {
		List<Account> accounts = getAccount(customerId, accountId);
		Account sourceAccount = null;
		if (accounts.size() > 0) {
			sourceAccount = accounts.get(0);
		} else {
			return null;
		}
		accounts = getAccount(transfer.getDestCustomer(), transfer.getDestAccount());
		Account destAccount = null;
		if (accounts.size() > 0) {
			destAccount = accounts.get(0);
		} else {
			return null;
		}
		if (sourceAccount.getBalance() < transfer.getAmount()) {
			return null;
		}
		sourceAccount.setBalance(sourceAccount.getBalance() - transfer.getAmount());
		destAccount.setBalance(destAccount.getBalance() + transfer.getAmount());

		return sourceAccount;
	}
    
    public Account deleteAccount(int id, Account account) {
    	
    	if(account.getAccountNumber() == id) { 	
    		accountList.remove(account);
    	}
		
		System.out.println("201 - resource delete with path: /account/" + String.valueOf("Delete Account: " + account.getAccountNumber()));
		
		return new Account();
	 }



}