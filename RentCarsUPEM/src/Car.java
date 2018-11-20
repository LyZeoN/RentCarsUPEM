import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class Car extends UnicastRemoteObject implements ICar{
	private final String model;
	private double price;
	private double pricelocation;
	private int globalMark;
	private int haveBeenRented = 0;
	private Optional<IEmployee> renter;
	private HashMap <IEmployee,List<IObservation>> status;
	private List<IEmployee> waitingQueue;

	public Car(String model, double price, double pricelocation) throws RemoteException {
		this.status = new HashMap<>();
		this.waitingQueue = new ArrayList<>();
		this.model = model;
		this.price = price;
		this.pricelocation = pricelocation;
		this.globalMark = 10;
		
	}
	
	public HashMap<IEmployee, List<IObservation>> getStatus() throws RemoteException {
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

	public Optional<IEmployee> getRenter() throws RemoteException {
		return renter;
	}

	public void setRenter(Optional<IEmployee> renter) throws RemoteException {
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
	
	public void addStatus(IEmployee employee, int carroserieMark,String carroserieDescription, int moteurMark,String moteurDescription, int roueMark,String roueDescription) throws RemoteException {
		status.get(employee).add(new Observation(carroserieMark,carroserieDescription,moteurMark,moteurDescription,roueMark,roueDescription));
	}

	public void freeMe() throws RemoteException{
		this.setGlobalMark();
		if (! waitingQueue.isEmpty()) {
			renter = Optional.ofNullable(waitingQueue.remove(0));
			renter.get().notifyMe(this);
		}else {
			renter = Optional.empty();
		}
	}

	public void rentMe(IEmployee employee) throws RemoteException {
		if (!renter.isPresent()) {
			renter = Optional.ofNullable(employee);
			renter.get().notifyMe(this);
		}else {
			waitingQueue.add(employee);
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (globalMark != other.globalMark)
			return false;
		if (haveBeenRented != other.haveBeenRented)
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (Double.doubleToLongBits(pricelocation) != Double.doubleToLongBits(other.pricelocation))
			return false;
		if (renter == null) {
			if (other.renter != null)
				return false;
		} else if (!renter.equals(other.renter))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (waitingQueue == null) {
			if (other.waitingQueue != null)
				return false;
		} else if (!waitingQueue.equals(other.waitingQueue))
			return false;
		return true;
	}
}
