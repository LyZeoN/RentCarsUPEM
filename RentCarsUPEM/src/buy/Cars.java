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
import java.util.Map;

import javax.xml.rpc.ServiceException;
import fr.upem.bank.Bank;
import fr.upem.bank.BankServiceLocator;
import fr.upem.bank.BankSoapBindingStub;

public class Cars extends UnicastRemoteObject implements ICars {
	private final Map<Integer, ICar> allCars = new HashMap<Integer, ICar>();
	int nextID = 0;

	public Cars() throws RemoteException {
		super();
	}

	public ICar[] getCars() throws RemoteException {
		int j = allCars.size();
		ICar[] acc = new ICar[j];
		int i = 0;
		for (ICar c : allCars.values()) {
			acc[i] = c;
			i++;
		}
		return acc;
	}

	public String getSelectedCarsModel(int carID) throws RemoteException {
		return allCars.get(carID).getModel();
	}

	public double getSelectedCarsPrice(int carID) throws RemoteException {
		return allCars.get(carID).getPrice();
	}

	public int getSelectedCarsHBR(int carID) throws RemoteException {
		return allCars.get(carID).getHaveBeenRented();
	}
	
	public int getSelectedCarsGlobalMark(int carID) throws RemoteException {
		return allCars.get(carID).getGlobalMark();
	}
	
	public double getSelectedCarsPriceLocation(int carID) throws RemoteException {
		return allCars.get(carID).getPricelocation();
	}

	public boolean addCar(String model, int price, int pricelocation) throws RemoteException {
		allCars.put(nextID, new Car(nextID, model, price, pricelocation));
		nextID++;

		return true;
	}
	
	public IObservation[] getObs(int carID) throws RemoteException {
		if(allCars.get(carID).getStatus().size() == 0) {
			return new IObservation[0];
		}
		IObservation[] acc = new IObservation[allCars.get(carID).getStatus().size()];
		int i = 0;
		
		for (IObservation obs : allCars.get(carID).getStatus().values()) {
			acc[i] = obs;
			i++;
		}
		return acc;
		
	}
	public Integer[] getUsersObsID(int carID) throws RemoteException {
		if(allCars.get(carID).getStatus().size() == 0) {
			return new Integer[0];
		}
		Integer[] tmp = new Integer[allCars.get(carID).getStatus().size()];
		
		int i = 0;
		for (Integer id : allCars.get(carID).getStatus().keySet()) {
			tmp[i] = id;
			i++;
			
		}
		
		return tmp;
		
	}
	public boolean rentVehicule(int id, int employeeid, String mail, String password) throws RemoteException, MalformedURLException, NotBoundException, ServiceException {
		/* If the car is already rented return false */
		if(allCars.get(id) == null) {
			return false;
		}
		Bank service;
		service = new BankServiceLocator().getBank();
		((BankSoapBindingStub) service).setMaintainSession(true);
		if(service.withdrawMoney(mail, password, allCars.get(id).getPricelocation())) {
			allCars.get(id).rentMe(employeeid);
			allCars.get(id).setGone(-1);
			return true;			
		}
		return false;
	}
	
	public boolean freeCar(int id) throws RemoteException, MalformedURLException, NotBoundException {
		/* If the car is already rented return false */
		if(allCars.get(id) == null) {
			return false;
		}
		allCars.get(id).freeMe();
		return true;
		
	}

	public boolean buyCar(int id) throws RemoteException {
		allCars.remove(id);
		return true;
	}
	
	public int getCarGone(int id) throws RemoteException{
		return allCars.get(id).getGone();
	}

	public double sendCarPrice(int id) throws RemoteException {
		return allCars.get(id).getPrice();
	}
	
	public void addObservation(int userID,int carID,int carroserieMark, String carroserieDescription,int moteurMark, String moteurDescription, int roueMark, String roueDescription) throws RemoteException {
		allCars.get(carID).addStatus(userID, carroserieMark, carroserieDescription, moteurMark, moteurDescription, roueMark, roueDescription);
	}

}
