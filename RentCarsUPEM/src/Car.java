import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;


public class Car extends UnicastRemoteObject implements ICar{
	int id;
	private final String model;
	private double price;
	private double pricelocation;
	private int globalMark;
	private int haveBeenRented = 0;
	private Optional<Integer> renter;
	private HashMap <Integer,List<IObservation>> status;
	private List<Integer> waitingQueue;

	public Car(int idi,String model, double price, double pricelocation) throws RemoteException {
		id = idi;
		this.status = new HashMap<>();
		this.waitingQueue = new ArrayList<>();
		this.model = model;
		this.price = price;
		this.pricelocation = pricelocation;
		this.globalMark = 10;
		
	}
	
	public HashMap<Integer, List<IObservation>> getStatus() throws RemoteException {
		return status;
	}

	public double getPricelocation() throws RemoteException {
		return pricelocation;
	}

	public void setPricelocation(double pricelocation) throws RemoteException {
		this.pricelocation = pricelocation;
	}

	public int getHaveBeenRented() throws RemoteException {
		return haveBeenRented;
	}

	public void setHaveBeenRented(int haveBeenRented) throws RemoteException {
		this.haveBeenRented = haveBeenRented;
	}

	public Optional<Integer> getRenter() throws RemoteException {
		return renter;
	}

	public void setRenter(Optional<Integer> renter) throws RemoteException {
		this.renter = renter;
	}
	
	public double getPrice() throws RemoteException {
		return price;
	}

	public void setPrice(double price) throws RemoteException {
		this.price = price;
	}
	
	public int getGlobalMark() throws RemoteException {
		return globalMark;
	}
	
	public void setGlobalMark() throws RemoteException {
		globalMark = 0;
		int cmp = 0;
		for(List<IObservation> list : status.values()) {
			for(IObservation observation : list) {
				for (IStatus status : observation.getComponents().values()) {
					globalMark = globalMark + status.getMark();
					cmp ++;
				}
			}
		}
		globalMark /= cmp;

	}
	
	public String getModel() throws RemoteException {
		return model;
	}
	
	public void addStatus(int employee, int carroserieMark,String carroserieDescription, int moteurMark,String moteurDescription, int roueMark,String roueDescription) throws RemoteException {
		status.get(employee).add(new Observation(carroserieMark,carroserieDescription,moteurMark,moteurDescription,roueMark,roueDescription));
	}

	public boolean freeMe() throws RemoteException{
		this.setGlobalMark();
		if (! waitingQueue.isEmpty()) {
			renter = Optional.ofNullable(waitingQueue.remove(0));
			try {
				Remote r = Naming.lookup("rmi://localhost:1102/UPEMCorp");
				if (r instanceof IEmployees) {
					((IEmployees) r).notifyUser(renter.get(), model);
					return true;


				}
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (RemoteException e) {
				e.printStackTrace();
			} catch (NotBoundException e) {
				e.printStackTrace();
			}
		}else {
			renter = Optional.empty();
		}
		return false;
	}

	public boolean rentMe(int userID) throws RemoteException {
		if (!renter.isPresent()) {
			renter = Optional.ofNullable(userID);
			try {
				Remote r = Naming.lookup("rmi://localhost:1102/UPEMCorp");
				if (r instanceof IEmployees) {
					((IEmployees) r).notifyUser(userID, model);
					return true;


				}
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (RemoteException e) {
				e.printStackTrace();
			} catch (NotBoundException e) {
				e.printStackTrace();
			}
		}else {
			waitingQueue.add(userID);
		}
		return false;
	}
	
	

	


}
