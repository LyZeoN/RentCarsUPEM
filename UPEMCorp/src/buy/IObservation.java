package buy;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;


public interface IObservation extends Remote{
	public Map<String, IStatus> getComponents() throws RemoteException;
	public void setComponents(Map<String, IStatus> components) throws RemoteException;
	public int getCarroserieMark() throws RemoteException;
	public String getCarroserieDescription() throws RemoteException;
	public int getMoteurMark() throws RemoteException;
	public String getMoteurDescription() throws RemoteException;
	public int getRoueMark() throws RemoteException;
	public String getRoueDescription() throws RemoteException;
}
