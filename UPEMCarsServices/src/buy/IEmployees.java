package buy;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IEmployees extends Remote{
	public int connection(String mail, String password) throws RemoteException;
	public int add(String firstName, String lastName, String mail, String password) throws RemoteException;
	public IEmployee[] getEmployees() throws RemoteException;
	public void notifyUser(int userID,String model) throws RemoteException;
	public IEmployee getEmployee(int employeeID) throws RemoteException;
}
