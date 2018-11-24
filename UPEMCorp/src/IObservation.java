
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

public interface IObservation extends Remote{
	public Map<String, IStatus> getComponents() throws RemoteException;
	public void setComponents(Map<String, IStatus> components) throws RemoteException;
}
