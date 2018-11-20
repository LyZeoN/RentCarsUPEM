import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class Cars extends UnicastRemoteObject implements ICars{
	private final List<ICar> cars;
	
	
	public Cars() throws RemoteException{
		super();
		cars = new ArrayList<ICar>();
	}
	
	public List<ICar> getCars() throws RemoteException{
		return cars;
	}

	public ICar addCar(String model,int price, int pricelocation) throws RemoteException {
		ICar car = new Car(model,price,pricelocation); 
		cars.add(new Car(model,price,pricelocation));
		return car;
	}
	
	public boolean rentVehicule(ICar car,IEmployee employee) throws RemoteException {
		for(ICar c : cars) {
			if(c.equals(car)) { 
				c.rentMe(employee);
				return true;
			}
		}
		return false;
		
	}

}
