package fr.upem.bank;


import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.rpc.ServiceException;

public class Bank {
	private final Map<String,Double> accounts = new HashMap<String,Double>();
	
	public Bank() {
		super();
	}
	
	public boolean addAccount(String currency, String mail, String password, String firstName, String lastName, String adress, String phoneNumber, double balance) {
		
		if (!mail.contains("@")) {
			return false;
		}
		if(accounts.containsKey(mail))
			return false;
		accounts.put(mail, 0.0);
		return true;
	}

	
	public boolean depositMoney(String mail, String password,double amount) throws RemoteException, ServiceException {
		if(!accounts.containsKey(mail))
			return false;
		double sold = accounts.get(mail);
		
		accounts.remove(mail);
		accounts.put(mail, sold + amount);
		return true;
	}
	
	public boolean withdrawMoney(String mail, String password, double amount) throws RemoteException, ServiceException {
		double sold = accounts.get(mail);
		if(sold - amount < 0)
			return false;
		accounts.remove(mail);
		accounts.put(mail, sold - amount);
		return true;
	}
}
