import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cars extends UnicastRemoteObject implements ICars{
	private final Map<Integer,ICar> allCars = new HashMap<Integer,ICar>();
	int nextID = 0;
	
	public Cars() throws RemoteException{
		super();
	}
	
	public ICar[] getCars() throws RemoteException{
		return (ICar[]) allCars.values().toArray();
	}

	public boolean addCar(String model,int price, int pricelocation) throws RemoteException {
		allCars.put(nextID++,new Car(nextID,model,price,pricelocation));
		return true;
	}
	
	public boolean rentVehicule(int id,int employee) throws RemoteException {
		allCars.get(id).rentMe(employee);
		return false;
		
	}

	
	public boolean buyCar(int id) throws RemoteException {
		try {
			Remote r = Naming.lookup("rmi://localhost:1102/UPEMCorp");
			if (r instanceof IEmployees) {
				((IEmployees) r).notifyUser(id, allCars.get(id).getModel());
				return true;


			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return allCars.remove(id)==null?false:true;
	}
	
	public double sendCarPrice(int id) throws RemoteException {
		return allCars.get(id).getPrice();
	}
	

}
