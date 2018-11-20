import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class Employees extends UnicastRemoteObject implements IEmployees{
	private final List<IEmployee> employees;
	
	
	public Employees() throws RemoteException{
		super();
		employees = new ArrayList<IEmployee>();
	}
	
	public boolean connection(String mail, String password) throws RemoteException{
		for (IEmployee e : employees) {
			if (e.getMail().equals(mail) && e.getPassword().equals(password)){
				return true;
			}
		}
		return false;
	}
	
	
	public boolean add(String firstName, String lastName, String mail, String password) throws RemoteException{
		for (IEmployee e : employees) {
			if (e.getMail().equals(mail)) {
				return false;
			}
		}
		employees.add(new Employee(firstName, lastName, password, mail));
		return true;
	}
	
	public List<IEmployee> getEmployees() throws RemoteException{
		return employees;
	}
	
}
