package buy;


import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IEmployee extends Remote{
	public String getFirstName() throws RemoteException;
	public String getLastName() throws RemoteException;
	public String getMail() throws RemoteException;
	public String getPassword() throws RemoteException;
	public void notifyMe(String model) throws RemoteException;
	public int getID() throws RemoteException;

}
