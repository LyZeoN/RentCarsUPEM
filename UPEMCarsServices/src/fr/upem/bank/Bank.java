/**
 * Bank.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.upem.bank;

public interface Bank extends java.rmi.Remote {
    public fr.upem.bank.Account[] getAccounts() throws java.rmi.RemoteException;
    public boolean addAccount(java.lang.String currency, java.lang.String mail, java.lang.String password, java.lang.String firstName, java.lang.String lastName, java.lang.String adress, java.lang.String phoneNumber, double balance) throws java.rmi.RemoteException;
    public boolean depositMoney(java.lang.String mail, java.lang.String password, double amount) throws java.rmi.RemoteException;
    public boolean withdrawMoney(java.lang.String mail, java.lang.String password, double amount) throws java.rmi.RemoteException;
}
