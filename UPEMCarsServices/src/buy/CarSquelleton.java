package buy;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class CarSquelleton{
	int id;
	private final String model;
	private double price;
	private double pricelocation;
	private int globalMark;
	private int haveBeenRented = 0;
	private ObservationSquelleton[] observations;
	public CarSquelleton() {
		id = -1;
		this.model = "";
		this.price = -1;
		this.pricelocation = -1;
		this.globalMark = -1;
	}
	public CarSquelleton(ObservationSquelleton[] observationsi,int idi,String model, double price, double pricelocation,int haveBeenRented) throws RemoteException {
		id = idi;
		this.model = model;
		this.price = price;
		this.pricelocation = pricelocation;
		this.globalMark = 10;
		this.haveBeenRented = haveBeenRented;
		this.observations = observationsi;
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
	public String getModel() {
		return model;
	}

}
