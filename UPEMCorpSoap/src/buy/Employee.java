package buy;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Employee{
	private int id;
	private final String firstName;
	private final String lastName;
	private final String mail;
	private String password;
	
	public Employee() {
		id = -1;
		this.firstName = "I";
		this.lastName = "DON'T EXIST";
		this.password = "1234";
		this.mail = "hello.word";
	}
	public Employee(int id,String firstName, String lastName, String password, String mail) throws RemoteException{
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.mail = mail;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getMail() {
		return mail;
	}

}
