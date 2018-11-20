/**
 * EmployeesService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.upem.employees;

public interface EmployeesService extends javax.xml.rpc.Service {
    public java.lang.String getEmployeesAddress();

    public fr.upem.employees.Employees getEmployees() throws javax.xml.rpc.ServiceException;

    public fr.upem.employees.Employees getEmployees(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
