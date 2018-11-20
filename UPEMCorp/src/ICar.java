import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Optional;

public interface ICar extends Remote {
	public double getPricelocation() throws RemoteException;
	public void setPricelocation(double pricelocation) throws RemoteException;
	public int getHaveBeenRented() throws RemoteException;
	public void setHaveBeenRented(int haveBeenRented) throws RemoteException;
	public Optional<IEmployee> getRenter() throws RemoteException;
	public void setRenter(Optional<IEmployee> renter) throws RemoteException;
	public double getPrice() throws RemoteException;
	public void setPrice(double price) throws RemoteException;
	public int getGlobalMark() throws RemoteException;
	public void setGlobalMark() throws RemoteException;
	public String getModel() throws RemoteException;
	public void addStatus(IEmployee employee, int carroserieMark,String carroserieDescription, int moteurMark,String moteurDescription, int roueMark,String roueDescription);
	public void freeMe() throws RemoteException;
	public void rentMe(IEmployee employee) throws RemoteException;
		
}
