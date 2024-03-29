package buy;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class UPEMCorpGateway{

	
	public int connection(String mail, String password) throws RemoteException, MalformedURLException, NotBoundException {
		IEmployees r = (IEmployees) Naming.lookup("rmi://localhost:2021/UPEMCorp");
		return r.connection(mail, password);
	}
	
	public int add(String firstName, String lastName, String mail, String password) throws RemoteException, MalformedURLException, NotBoundException {
		IEmployees r = (IEmployees) Naming.lookup("rmi://localhost:2021/UPEMCorp");
		return r.add(firstName, lastName, mail, password);
	}

	
	public Employee[] getEmployees() throws RemoteException, MalformedURLException, NotBoundException {
		IEmployees r = (IEmployees) Naming.lookup("rmi://localhost:2021/UPEMCorp");
		Employee[] toSend = new Employee[r.getEmployees().length];
		for(int i = 0; i < r.getEmployees().length; i++) {
			toSend[i] = new Employee(r.getEmployees()[i].getID(), r.getEmployees()[i].getFirstName(), r.getEmployees()[i].getLastName(), r.getEmployees()[i].getPassword(), r.getEmployees()[i].getMail());
		}
		return toSend;

	}

	
	public void notifyUser(int userID, String model) throws RemoteException, MalformedURLException, NotBoundException {
		IEmployees r = (IEmployees) Naming.lookup("rmi://localhost:2021/UPEMCorp");
		r.notifyUser(userID, model);	
	}

	
	public Employee getEmployee(int employeeID) throws RemoteException, MalformedURLException, NotBoundException {
			IEmployees r = (IEmployees) Naming.lookup("rmi://localhost:2021/UPEMCorp");
			IEmployee e = r.getEmployee(employeeID);
			return new Employee(e.getID(),e.getFirstName(), e.getLastName(), e.getPassword(), e.getMail());
	}

}
