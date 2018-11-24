package buy;
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


public class Car{
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
		this.renter = Optional.ofNullable(-1);
		
	}
	
	
	
	

	


}
