package buy;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

public interface ICar extends Remote {
	public double getPricelocation() throws RemoteException;
	public void setPricelocation(double pricelocation) throws RemoteException;
	public int getHaveBeenRented() throws RemoteException;
	public void setHaveBeenRented(int haveBeenRented) throws RemoteException;
	public int getRenter() throws RemoteException;
	public void setRenter(int renter) throws RemoteException;
	public double getPrice() throws RemoteException;
	public void setPrice(double price) throws RemoteException;
	public int getGlobalMark() throws RemoteException;
	public void setGlobalMark() throws RemoteException;
	public String getModel() throws RemoteException;
	public Map<Integer, IObservation> getStatus() throws RemoteException;
	public void addStatus(int employee, int carroserieMark,String carroserieDescription, int moteurMark,String moteurDescription, int roueMark,String roueDescription) throws RemoteException;
	public boolean freeMe() throws RemoteException, MalformedURLException, NotBoundException;
	public boolean rentMe(int userID) throws RemoteException, MalformedURLException, NotBoundException;
	public int getID() throws RemoteException;
	public void setGone(int e) throws RemoteException;
	public int getGone() throws RemoteException;
		
}