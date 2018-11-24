package buy;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class UPEMCorpGateway{

	
	public boolean connection(String mail, String password) throws RemoteException {
		Remote r;
		try {
			r = Naming.lookup("rmi://localhost:2020/UPEMCorp");
			if (r instanceof IEmployees) {
				return ((IEmployees) r).connection(mail, password);
				
			}
		} catch (MalformedURLException e) {
			System.out.println("Wrong URL");
		} catch (NotBoundException e) {
			System.out.println("URL ain't exist");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	

	
	public boolean add(String firstName, String lastName, String mail, String password) throws RemoteException {
		Remote r;
		try {
			r = Naming.lookup("rmi://localhost:2020/UPEMCorp");
			if (r instanceof IEmployees) {
				return ((IEmployees) r).add(firstName, lastName, mail, password);
				
			}
		} catch (MalformedURLException e) {
			System.out.println("Wrong URL");
		} catch (NotBoundException e) {
			System.out.println("URL ain't exist");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	
	public Employee[] getEmployees() throws RemoteException {
		Remote r;
		try {
			r = Naming.lookup("rmi://localhost:2020/UPEMCorp");
			if (r instanceof IEmployees) {
				IEmployee[] allEmployee = ((IEmployees) r).getEmployees();
				List<Employee> toSend = new ArrayList<Employee>();
				
				for(IEmployee e : allEmployee) {
					toSend.add(new Employee(e.getID(), e.getFirstName(), e.getLastName(), e.getPassword(), e.getMail()));
				}
				return (Employee[]) toSend.toArray();
			}
		} catch (MalformedURLException e) {
			System.out.println("Wrong URL");
		} catch (NotBoundException e) {
			System.out.println("URL ain't exist");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	public void notifyUser(int userID, String model) throws RemoteException {
		Remote r;
		try {
			r = Naming.lookup("rmi://localhost:2020/UPEMCorp");
			if (r instanceof IEmployees) {
				((IEmployees) r).notifyUser(userID, model);;
				
			}
		} catch (MalformedURLException e) {
			System.out.println("Wrong URL");
		} catch (NotBoundException e) {
			System.out.println("URL ain't exist");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public Employee getEmployee(int employeeID) throws RemoteException {
		Remote r;
		try {
			r = Naming.lookup("rmi://localhost:2020/UPEMCorp");
			if (r instanceof IEmployees) {
				IEmployee e = ((IEmployees) r).getEmployee(employeeID);
				return new Employee(e.getID(),e.getFirstName(), e.getLastName(), e.getPassword(), e.getMail());
				
			}
		} catch (MalformedURLException e) {
			System.out.println("Wrong URL");
		} catch (NotBoundException e) {
			System.out.println("URL ain't exist");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
