package buy;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class RentCarsGateway {

	
	public RentCarsGateway() {
		
	}

	public Car[] getCars() {
		Remote r;
		try {
			r = Naming.lookup("rmi://localhost:2020/RentCarsUPEM");
			if (r instanceof ICars) {
				ICar[] allCars =  ((ICars) r).getCars();
				List<Car> toSend = new ArrayList<Car>();
				for(ICar c : allCars) {
					toSend.add(new Car(c.getID(),c.getModel(),c.getPrice(),c.getPricelocation()));
					
				}
				return (Car[]) toSend.toArray();
			}
		} catch (MalformedURLException e) {
			System.out.println("Wrong URL");
		} catch (NotBoundException e) {
			System.out.println("URL ain't exist");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return null;

	}
	
	

	
	public boolean addCar(String model, int price, int pricelocation)  {
		Remote r;
		try {
			r = Naming.lookup("rmi://localhost:2020/RentCarsUPEM");
			if (r instanceof ICars) {
				return ((ICars) r).addCar(model, price, pricelocation);
				
			}
		} catch (MalformedURLException e) {
			System.out.println("Wrong URL");
		} catch (NotBoundException e) {
			System.out.println("URL ain't exist");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	
	public boolean rentVehicule(int id, int employeeID) throws RemoteException {
		Remote r;
		try {
			r = Naming.lookup("rmi://localhost:2020/RentCarsUPEM");
			if (r instanceof ICars) {
				return ((ICars) r).rentVehicule(id, employeeID);
				
			}
		} catch (MalformedURLException e) {
			System.out.println("Wrong URL");
		} catch (NotBoundException e) {
			System.out.println("URL ain't exist");
		}
			return false;
	}

	
	public boolean buyCar(int id) throws RemoteException {
		Remote r;
		try {
			r = Naming.lookup("rmi://localhost:2020/RentCarsUPEM");
			if (r instanceof ICars) {
				return ((ICars) r).buyCar(id);
				
			}
		} catch (MalformedURLException e) {
			System.out.println("Wrong URL");
		} catch (NotBoundException e) {
			System.out.println("URL ain't exist");
		}
			return false;
	}

	
	public double sendCarPrice(int id) throws RemoteException {
		Remote r;
		try {
			r = Naming.lookup("rmi://localhost:2020/RentCarsUPEM");
			if (r instanceof ICars) {
				return ((ICars) r).sendCarPrice(id);
				
			}
		} catch (MalformedURLException e) {
			System.out.println("Wrong URL");
		} catch (NotBoundException e) {
			System.out.println("URL ain't exist");
		}
			return -1;
	}

	
	public String getSelectedCarsModel(int carID) throws RemoteException {
		Remote r;
		try {
			r = Naming.lookup("rmi://localhost:2020/RentCarsUPEM");
			if (r instanceof ICars) {
				return ((ICars) r).getSelectedCarsModel(carID);
				
			}
		} catch (MalformedURLException e) {
			System.out.println("Wrong URL");
		} catch (NotBoundException e) {
			System.out.println("URL ain't exist");
		}
			return "ERROR";
	}

	
	public double getSelectedCarsPrice(int carID) throws RemoteException {
		Remote r;
		try {
			r = Naming.lookup("rmi://localhost:2020/RentCarsUPEM");
			if (r instanceof ICars) {
				return ((ICars) r).getSelectedCarsPrice(carID);
				
			}
		} catch (MalformedURLException e) {
			System.out.println("Wrong URL");
		} catch (NotBoundException e) {
			System.out.println("URL ain't exist");
		}
			return -1;
	}

	
	public int getSelectedCarsHBR(int carID) throws RemoteException {
		Remote r;
		try {
			r = Naming.lookup("rmi://localhost:2020/RentCarsUPEM");
			if (r instanceof ICars) {
				return ((ICars) r).getSelectedCarsHBR(carID);
				
			}
		} catch (MalformedURLException e) {
			System.out.println("Wrong URL");
		} catch (NotBoundException e) {
			System.out.println("URL ain't exist");
		}
			return -1;
	}
	
	
}
