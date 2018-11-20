/**
 * Employees.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.upem.employees;

public interface Employees extends java.rmi.Remote {
    public boolean connection(java.lang.String mail, java.lang.String password) throws java.rmi.RemoteException;
    public fr.upem.employees.Employee[] getEmployees() throws java.rmi.RemoteException;
    public boolean add(java.lang.String firstName, java.lang.String lastName, java.lang.String mail, java.lang.String password) throws java.rmi.RemoteException;
}
