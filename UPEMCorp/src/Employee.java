import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Employee extends UnicastRemoteObject implements IEmployee{
	private int id;
	private final String firstName;
	private final String lastName;
	private final String mail;
	private String password;
	
	public Employee(int idi,String firstName, String lastName, String password, String mail) throws RemoteException{
		super();
		idi = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.mail = mail;
	}
	
	public String getFirstName() throws RemoteException{
		return firstName;
	}
	
	public String getLastName() throws RemoteException{
		return lastName;
	}
	
	public String getMail() throws RemoteException{
		return mail;
	}
	
	public String getPassword() throws RemoteException{
		return password;
	}
	
	public void notifyMe(String model) throws RemoteException {
		System.out.println("#### You rent :" + model);
	}


}
