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

import fr.upem.bank.Account;
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
		int j = 0;
		for(ICar e : allCars.values()) {
			if(e.getGone() != -1) {
				j++;
			}
		}
		ICar[] acc = new ICar[j];
		for (int i = 0; i < j; i++) {
			if(allCars.get(i).getGone() != -1)
				acc[i] = allCars.get(i);
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
			System.out.println("cest nul");
			return new IObservation[0];
		}
		System.out.println("la getOBSCARS");
		IObservation[] acc = new IObservation[allCars.get(carID).getStatus().size()];
		int i = 0;
		
		for (IObservation obs : allCars.get(carID).getStatus().values()) {
			System.out.println("une fois" + allCars.get(carID).getStatus().size() + "i = " + i);
			acc[i] = obs;
			i++;


			
			
		}
		System.out.println("envoye");
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
	public boolean rentVehicule(int id,int employee) throws RemoteException, MalformedURLException, NotBoundException, ServiceException {
		/* If the car is already rented return false */
		if(allCars.get(id) == null) {
			return false;
		}
		if(allCars.get(id).getRenter().get() != -1)
			return false;
		Bank service;
		service = new BankServiceLocator().getBank();
		((BankSoapBindingStub) service).setMaintainSession(true);
		IEmployees r = (IEmployees) Naming.lookup("rmi://localhost:2020/UPEMCorp");
		IEmployee employe = r.getEmployee(employee);
		if(service.withdrawMoney(employe.getMail(), employe.getPassword(), allCars.get(id).getPrice())) {
			allCars.get(id).rentMe(employee);
			return true;			
		}


		return false;

	}

	
	public boolean buyCar(int id) throws RemoteException {
		
		allCars.get(id).setGone(-1);
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