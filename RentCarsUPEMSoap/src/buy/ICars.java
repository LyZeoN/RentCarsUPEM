package buy;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

public interface ICars extends Remote {
	public ICar[] getCars() throws RemoteException;
	public boolean addCar(String model, int price, int pricelocation) throws RemoteException;
	public boolean buyCar(int id) throws RemoteException;
	public boolean rentVehicule(int id, int employeeid, String mail, String password) throws RemoteException, MalformedURLException, NotBoundException, ServiceException;
	public double sendCarPrice(int id) throws RemoteException;
	public boolean freeCar(int id) throws RemoteException, MalformedURLException, NotBoundException;
	public String getSelectedCarsModel(int carID) throws RemoteException;
	public double getSelectedCarsPrice(int carID) throws RemoteException;
	public int getSelectedCarsHBR(int carID) throws RemoteException;
	public double getSelectedCarsPriceLocation(int carID) throws RemoteException;
	public IObservation[] getObs(int carID) throws RemoteException;
	public Integer[] getUsersObsID(int carID) throws RemoteException;
	public void addObservation(int userID,int carID,int carroserieMark, String carroserieDescription,int moteurMark, String moteurDescription, int roueMark, String roueDescription) throws RemoteException;
	public int getCarGone(int id) throws RemoteException;
	public int getSelectedCarsGlobalMark(int carID) throws RemoteException;
}
