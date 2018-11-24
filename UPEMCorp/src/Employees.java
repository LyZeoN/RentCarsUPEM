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
	
	public boolean connection(String mail, String password) throws RemoteException{
		for (IEmployee e : employees.values()) {
			if (e.getMail().equals(mail) && e.getPassword().equals(password)){
				return true;
			}
		}
		return false;
	}
	
	
	public boolean add(String firstName, String lastName, String mail, String password) throws RemoteException{
		for (IEmployee e : employees.values()) {
			if (e.getMail().equals(mail)) {
				return false;
			}
		}
		employees.put(nextID++,new Employee(nextID,firstName, lastName, password, mail));
		return true;
	}
	
	public IEmployee[] getEmployees() throws RemoteException{
	
		return (IEmployee[]) employees.values().toArray();
	}
	public void notifyUser(int userID,String model) throws RemoteException{
		employees.get(userID).notifyMe(model);
	
	
	}
	
}
