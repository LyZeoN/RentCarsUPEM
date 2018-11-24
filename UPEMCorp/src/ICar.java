import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public interface ICar extends Remote {
	public double getPricelocation() throws RemoteException;
	public void setPricelocation(double pricelocation) throws RemoteException;
	public int getHaveBeenRented() throws RemoteException;
	public void setHaveBeenRented(int haveBeenRented) throws RemoteException;
	public Optional<Integer> getRenter() throws RemoteException;
	public void setRenter(Optional<Integer> renter) throws RemoteException;
	public double getPrice() throws RemoteException;
	public void setPrice(double price) throws RemoteException;
	public int getGlobalMark() throws RemoteException;
	public void setGlobalMark() throws RemoteException;
	public String getModel() throws RemoteException;
	public HashMap<Integer, List<IObservation>> getStatus() throws RemoteException;
	public void addStatus(Integer employee, int carroserieMark,String carroserieDescription, int moteurMark,String moteurDescription, int roueMark,String roueDescription) throws RemoteException;
	public void freeMe() throws RemoteException;
	public boolean rentMe(int employeeID) throws RemoteException;
		
}
