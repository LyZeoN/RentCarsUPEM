package buy;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;


public class Observation extends UnicastRemoteObject implements IObservation{
	private Map<String, IStatus> components;

	public Observation(int carroserieMark,String carroserieDescription, int moteurMark,String moteurDescription, int roueMark,String roueDescription) throws RemoteException {
		this.components = new HashMap<String, IStatus>();
		components.put("Carroserie", new Status(carroserieMark,carroserieDescription));
		components.put("Moteur", new Status(moteurMark,moteurDescription));
		components.put("Roue", new Status(roueMark,roueDescription));
	}

	public Map<String, IStatus> getComponents() throws RemoteException {
		return components;
	}

	public void setComponents(Map<String, IStatus> components) throws RemoteException {
		this.components = components;
	}
	

}
