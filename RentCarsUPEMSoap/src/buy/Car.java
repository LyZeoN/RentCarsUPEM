package buy;
import java.rmi.RemoteException;

public class Car{
	private int id;
	private final String model;
	private double price;
	private double pricelocation;
	private int globalMark;
	private int idRenter = 0;
	private int haveBeenRented = 0;
	private ObservationSquelleton[] observations;
	public Car() {
		id = -1;
		this.model = "";
		this.price = -1;
		this.pricelocation = -1;
		this.globalMark = -1;
	}
	public Car(ObservationSquelleton[] observationsi,int idi,String model, double price, double pricelocation,int idRenter, int haveBeenRented,int globalMark) throws RemoteException {
		id = idi;
		this.model = model;
		this.price = price;
		this.pricelocation = pricelocation;
		this.globalMark = globalMark;
		this.idRenter = idRenter;
		this.observations = observationsi;
		this.haveBeenRented = haveBeenRented;
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

	public int getIdRenter() {
		return idRenter;
	}
	public void setIdRenter(int idRenter) {
		this.idRenter = idRenter;
	}

	public void setObservations(ObservationSquelleton[] observations) {
		this.observations = observations;
	}
	public String getModel() {
		return model;
	}
	public int getHaveBeenRented() {
		return haveBeenRented;
	}
	public void setHaveBeenRented(int haveBeenRented) {
		this.haveBeenRented = haveBeenRented;
	}
	public ObservationSquelleton[] getObservations() {
		return observations;
	}

}
