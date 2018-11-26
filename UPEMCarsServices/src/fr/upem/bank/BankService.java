/**
 * BankService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.upem.bank;

public interface BankService extends javax.xml.rpc.Service {
    public java.lang.String getBankAddress();

    public fr.upem.bank.Bank getBank() throws javax.xml.rpc.ServiceException;

    public fr.upem.bank.Bank getBank(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
