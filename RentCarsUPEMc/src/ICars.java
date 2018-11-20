import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ICars extends Remote {
	public List<ICar> getCars() throws RemoteException;
	public boolean addCar(String modele,double price, double pricelocation) throws RemoteException;
	public boolean rentVehicule(ICar car, IEmployee employee) throws RemoteException;
}
