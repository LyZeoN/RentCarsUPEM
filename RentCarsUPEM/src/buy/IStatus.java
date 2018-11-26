package buy;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IStatus extends Remote{
	public int getMark() throws RemoteException;
	public void setMark(int mark) throws RemoteException;
	public String getDescription() throws RemoteException;
	public void setDescription(String description) throws RemoteException;
}
