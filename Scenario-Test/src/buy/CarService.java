/**
 * CarService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package buy;

public interface CarService extends java.rmi.Remote {
    public int add(java.lang.String firstName, java.lang.String lastName, java.lang.String mail, java.lang.String password) throws java.rmi.RemoteException;
    public int connection(java.lang.String mail, java.lang.String password) throws java.rmi.RemoteException;
    public buy.CarSquelleton[] getUserShoppingCart(int userID) throws java.rmi.RemoteException;
    public boolean addArticleHistory(java.lang.String model, double price, int haveBeenRented, int userID) throws java.rmi.RemoteException;
    public buy.CarSquelleton getObs(int carID) throws java.rmi.RemoteException;
    public boolean buyCar(int userID, java.lang.String email, java.lang.String password) throws java.rmi.RemoteException;
    public buy.CarSquelleton[] getCars() throws java.rmi.RemoteException;
    public buy.CarSquelleton[] getUserHistory(int userID) throws java.rmi.RemoteException;
    public boolean addArticleBasket(int articleID, int userID) throws java.rmi.RemoteException;
}
