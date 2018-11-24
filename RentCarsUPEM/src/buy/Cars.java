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
		return (ICar[]) allCars.values().toArray();
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

	public boolean addCar(String model, int price, int pricelocation) throws RemoteException {
		allCars.put(nextID++, new Car(nextID, model, price, pricelocation));
		return true;
	}

	public boolean rentVehicule(int id,int employee) throws RemoteException {
		/* If the car is already rented return false */
		if(allCars.get(id) == null) {
			return false;
		}
		if(allCars.get(id).getRenter().get() != -1)
			return false;
		Bank service;
		try {
			service = new BankServiceLocator().getBank();
			((BankSoapBindingStub) service).setMaintainSession(true);

			Remote r;
			try {
				r = Naming.lookup("rmi://localhost:2020/UPEMCorp");
				if (r instanceof IEmployees) {
					IEmployee employe = ((IEmployees) r).getEmployee(employee);
					if(service.withdrawMoney(employe.getMail(), employe.getPassword(), allCars.get(id).getPrice())) {
						allCars.get(id).rentMe(employee);

						return true;			

					}


				}
			} catch (MalformedURLException e) {
				return false;
			} catch (NotBoundException e) {
				return false;
			}
			
		} catch (ServiceException e) {
			return  false;
		}
	
	
			
		return false;
		
	}
	
	
	public boolean buyCar(int id) throws RemoteException {
	
		return allCars.remove(id) == null ? false : true;
	}

	public double sendCarPrice(int id) throws RemoteException {
		
		return allCars.get(id).getPrice();
	}

}
