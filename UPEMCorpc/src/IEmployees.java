import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IEmployees extends Remote{
	public boolean connection(String mail, String password) throws RemoteException;
	public boolean add(String firstName, String lastName, String mail, String password) throws RemoteException;
	public List<IEmployee> getEmployees() throws RemoteException;
}
