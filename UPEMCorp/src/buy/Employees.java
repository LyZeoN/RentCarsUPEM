package buy;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Employees extends UnicastRemoteObject implements IEmployees{
	private final Map<Integer,IEmployee> employees = new HashMap<Integer,IEmployee>();
	int nextID = 0;
	
	public Employees() throws RemoteException{
		super();
	}
	
	public int connection(String mail, String password) throws RemoteException{
		for (IEmployee e : employees.values()) {
			if (e.getMail().equals(mail) && e.getPassword().equals(password)){
				return e.getID();
			}
		}
		return -1;
	}
	
	
	public int add(String firstName, String lastName, String mail, String password) throws RemoteException{
		for (IEmployee e : employees.values()) {
			if (e.getMail().equals(mail)) {
				return -1;
			}
		}
		employees.put(nextID,new Employee(nextID,firstName, lastName, password, mail));
		nextID++;

		return nextID - 1 ;
	}
	
	public IEmployee[] getEmployees() throws RemoteException{
		IEmployee[] acc = new IEmployee[employees.size()];
		for (int i = 0; i < employees.size(); i++) {
			acc[i] = employees.get(i);
		}
		return acc;
	}
	public void notifyUser(int userID,String model) throws RemoteException{
		employees.get(userID).notifyMe(model);
	
	
	}
	public IEmployee getEmployee(int employeeID) throws RemoteException{
		return employees.get(employeeID);
		
	}
	
}
