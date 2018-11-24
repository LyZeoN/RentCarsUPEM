package fr.upem.bank;


import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.rpc.ServiceException;

public class Bank {
	private final List<Account> accounts;
	
	public Bank() {
		this.accounts = new ArrayList<Account>();
	}
	
	public boolean addAccount(String currency, String mail, String password, String firstName, String lastName, String adress, String phoneNumber, double balance) {
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getMail().equals(mail)) {
				return false;
			}
		}
		if (!mail.contains("@")) {
			return false;
		}
		accounts.add(new Account(currency, mail, password, firstName, lastName, adress, phoneNumber, 0));
		return true;
	}
	
	public Account[] getAccounts() {
		Account[] acc = new Account[accounts.size()];
		for (int i = 0; i < accounts.size(); i++) {
			acc[i] = accounts.get(i);
		}
		return acc;
	}
	
	public boolean depositMoney(String mail, String password,double amount) throws RemoteException, ServiceException {
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getMail().equals(mail)) {
				return accounts.get(i).deposit(amount);
			}
		}
		return false;
	}
	
	public boolean withdrawMoney(String mail, String password, double amount) throws RemoteException, ServiceException {
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getMail().equals(mail)) {
				return accounts.get(i).withdraw(amount);
			}
		}
		return false;
	}
}
