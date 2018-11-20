/**
 * EmployeesServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.upem.employees;

public class EmployeesServiceLocator extends org.apache.axis.client.Service implements fr.upem.employees.EmployeesService {

    public EmployeesServiceLocator() {
    }


    public EmployeesServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public EmployeesServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Employees
    private java.lang.String Employees_address = "http://localhost:8080/UPEMCorp/services/Employees";

    public java.lang.String getEmployeesAddress() {
        return Employees_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String EmployeesWSDDServiceName = "Employees";

    public java.lang.String getEmployeesWSDDServiceName() {
        return EmployeesWSDDServiceName;
    }

    public void setEmployeesWSDDServiceName(java.lang.String name) {
        EmployeesWSDDServiceName = name;
    }

    public fr.upem.employees.Employees getEmployees() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Employees_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getEmployees(endpoint);
    }

    public fr.upem.employees.Employees getEmployees(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            fr.upem.employees.EmployeesSoapBindingStub _stub = new fr.upem.employees.EmployeesSoapBindingStub(portAddress, this);
            _stub.setPortName(getEmployeesWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setEmployeesEndpointAddress(java.lang.String address) {
        Employees_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (fr.upem.employees.Employees.class.isAssignableFrom(serviceEndpointInterface)) {
                fr.upem.employees.EmployeesSoapBindingStub _stub = new fr.upem.employees.EmployeesSoapBindingStub(new java.net.URL(Employees_address), this);
                _stub.setPortName(getEmployeesWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("Employees".equals(inputPortName)) {
            return getEmployees();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://employees.upem.fr", "EmployeesService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://employees.upem.fr", "Employees"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Employees".equals(portName)) {
            setEmployeesEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
