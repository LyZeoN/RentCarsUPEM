package buy;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;


public class CarSquelleton{
	int id;
	private final String model;
	private double price;
	private double pricelocation;
	private int globalMark;
	private int haveBeenRented = 0;
	private Optional<Integer> renter;
	private HashMap <Integer,List<IObservation>> status;
	private List<Integer> waitingQueue;

	public CarSquelleton() {
		id = -1;
		this.status = new HashMap<>();
		this.waitingQueue = new ArrayList<>();
		this.model = "";
		this.price = -1;
		this.pricelocation = -1;
		this.globalMark = -1;
		this.renter = Optional.ofNullable(-1);
	}
	public CarSquelleton(int idi,String model, double price, double pricelocation) throws RemoteException {
		id = idi;
		this.status = new HashMap<>();
		this.waitingQueue = new ArrayList<>();
		this.model = model;
		this.price = price;
		this.pricelocation = pricelocation;
		this.globalMark = 10;
		this.renter = Optional.ofNullable(-1);
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getPricelocation() {
		return pricelocation;
	}
	public void setPricelocation(double pricelocation) {
		this.pricelocation = pricelocation;
	}
	public int getGlobalMark() {
		return globalMark;
	}
	public void setGlobalMark(int globalMark) {
		this.globalMark = globalMark;
	}
	public int getHaveBeenRented() {
		return haveBeenRented;
	}
	public void setHaveBeenRented(int haveBeenRented) {
		this.haveBeenRented = haveBeenRented;
	}
	public Optional<Integer> getRenter() {
		return renter;
	}
	public void setRenter(Optional<Integer> renter) {
		this.renter = renter;
	}
	public HashMap<Integer, List<IObservation>> getStatus() {
		return status;
	}
	public void setStatus(HashMap<Integer, List<IObservation>> status) {
		this.status = status;
	}
	public List<Integer> getWaitingQueue() {
		return waitingQueue;
	}
	public void setWaitingQueue(List<Integer> waitingQueue) {
		this.waitingQueue = waitingQueue;
	}
	public String getModel() {
		return model;
	}

}
