/**
 * CarServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package buy;

public class CarServiceServiceLocator extends org.apache.axis.client.Service implements buy.CarServiceService {

    public CarServiceServiceLocator() {
    }


    public CarServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CarServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for CarService
    private java.lang.String CarService_address = "http://localhost:8080/UPEMCarsServices/services/CarService";

    public java.lang.String getCarServiceAddress() {
        return CarService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String CarServiceWSDDServiceName = "CarService";

    public java.lang.String getCarServiceWSDDServiceName() {
        return CarServiceWSDDServiceName;
    }

    public void setCarServiceWSDDServiceName(java.lang.String name) {
        CarServiceWSDDServiceName = name;
    }

    public buy.CarService getCarService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(CarService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCarService(endpoint);
    }

    public buy.CarService getCarService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            buy.CarServiceSoapBindingStub _stub = new buy.CarServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getCarServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCarServiceEndpointAddress(java.lang.String address) {
        CarService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (buy.CarService.class.isAssignableFrom(serviceEndpointInterface)) {
                buy.CarServiceSoapBindingStub _stub = new buy.CarServiceSoapBindingStub(new java.net.URL(CarService_address), this);
                _stub.setPortName(getCarServiceWSDDServiceName());
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
        if ("CarService".equals(inputPortName)) {
            return getCarService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://buy", "CarServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://buy", "CarService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("CarService".equals(portName)) {
            setCarServiceEndpointAddress(address);
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
