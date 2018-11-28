package buy;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;


public class RentCarsGateway {

	
	public RentCarsGateway() {
		
	}

	public Car[] getCars() throws MalformedURLException, RemoteException, NotBoundException {
		ICars r = (ICars) Naming.lookup("rmi://localhost:2020/RentCarsUPEM");
		Car[] toSend = new Car[r.getCars().length];
		for(int i = 0;i < r.getCars().length;i++) {
			toSend[i] = new Car(null,r.getCars()[i].getID(), r.getCars()[i].getModel(), r.getCars()[i].getPrice(), r.getCars()[i].getPricelocation(),r.getCars()[i].getRenter(),r.getCars()[i].getHaveBeenRented(),r.getCars()[i].getGlobalMark());
		}
		return toSend;
	}
	
	
	public boolean addCar(String model, int price, int pricelocation) throws MalformedURLException, RemoteException, NotBoundException  {
		ICars r = (ICars) Naming.lookup("rmi://localhost:2020/RentCarsUPEM");
		return r.addCar(model, price, pricelocation);
	}

	
	public boolean rentVehicule(int id, int employeeid, String mail, String password) throws RemoteException, MalformedURLException, NotBoundException, ServiceException {
		ICars r = (ICars) Naming.lookup("rmi://localhost:2020/RentCarsUPEM");
		return r.rentVehicule(id, employeeid, mail, password);
	}

	
	public boolean buyCar(int id) throws RemoteException, MalformedURLException, NotBoundException {
		ICars r = (ICars) Naming.lookup("rmi://localhost:2020/RentCarsUPEM");
		return r.buyCar(id);
	}

	
	public double sendCarPrice(int id) throws RemoteException, MalformedURLException, NotBoundException {
		ICars r = (ICars) Naming.lookup("rmi://localhost:2020/RentCarsUPEM");
		return r.sendCarPrice(id);
	}

	
	public String getSelectedCarsModel(int carID) throws RemoteException, MalformedURLException, NotBoundException {
		ICars r = (ICars) Naming.lookup("rmi://localhost:2020/RentCarsUPEM");
		return r.getSelectedCarsModel(carID);
	}

	
	public double getSelectedCarsPrice(int carID) throws RemoteException, MalformedURLException, NotBoundException {
		ICars r = (ICars) Naming.lookup("rmi://localhost:2020/RentCarsUPEM");
		return r.getSelectedCarsPrice(carID);
	}

	
	public int getSelectedCarsHBR(int carID) throws RemoteException, MalformedURLException, NotBoundException {
		ICars r = (ICars) Naming.lookup("rmi://localhost:2020/RentCarsUPEM");
		return r.getSelectedCarsHBR(carID);
	}
	
	public boolean freeCar(int carID) throws MalformedURLException, RemoteException, NotBoundException {
		ICars r = (ICars) Naming.lookup("rmi://localhost:2020/RentCarsUPEM");
		return r.freeCar(carID);
	}
	
	public boolean setObservation(int userID,int carID,int carroserieMark,String carroserieDescription) throws RemoteException, MalformedURLException, NotBoundException {
        ICars r = (ICars) Naming.lookup("rmi://localhost:2020/RentCarsUPEM");
        r.addObservation(userID, carID, carroserieMark, carroserieDescription, 0, "", 0, "");
        return true;
    }
	
	public Car getObs(int carID) throws RemoteException, MalformedURLException, NotBoundException {
		ICars r = (ICars) Naming.lookup("rmi://localhost:2020/RentCarsUPEM");
		IEmployees u = (IEmployees) Naming.lookup("rmi://localhost:2021/UPEMCorp");

		IObservation[] obs = r.getObs(carID);

		Integer[] obsID = r.getUsersObsID(carID);
		Car toSend;
		ObservationSquelleton[] allobs = new ObservationSquelleton[obsID.length];

		int i = 0;

		if (obs.length == 0 || obsID.length == 0) {
			toSend = new Car(null, r.getCars()[carID].getID(), r.getCars()[carID].getModel(),
					r.getCars()[carID].getPrice(), r.getCars()[carID].getPricelocation(), r.getCars()[carID].getRenter(),r.getCars()[carID].getHaveBeenRented(),r.getCars()[carID].getGlobalMark());
			return toSend;
		}


		for (IObservation obscpy : obs) {
			allobs[i] = new ObservationSquelleton(u.getEmployee(obsID [i]).getFirstName(), u.getEmployee(obsID[i]).getLastName(),
					obscpy.getCarroserieMark(), obscpy.getCarroserieDescription(), obscpy.getMoteurMark(),
					obscpy.getMoteurDescription(), obscpy.getRoueMark(), obscpy.getMoteurDescription());
			i++;
		}

		toSend = new Car(allobs, r.getCars()[carID].getID(), r.getCars()[carID].getModel(), r.getCars()[carID].getPrice(),
				r.getCars()[carID].getPricelocation(), r.getCars()[carID].getRenter(), r.getCars()[carID].getHaveBeenRented(),r.getCars()[carID].getGlobalMark());
		return toSend;

	}
	
}
