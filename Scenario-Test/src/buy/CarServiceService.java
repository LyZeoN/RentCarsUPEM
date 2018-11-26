/**
 * CarServiceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package buy;

public interface CarServiceService extends javax.xml.rpc.Service {
    public java.lang.String getCarServiceAddress();

    public buy.CarService getCarService() throws javax.xml.rpc.ServiceException;

    public buy.CarService getCarService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
