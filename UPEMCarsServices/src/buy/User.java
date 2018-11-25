package buy;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class User {
	private final String firstName;
	private final String lastName;
	private final String mail;
	private String password;
	private int id;
	private List<Integer> basket = new ArrayList<>();
	private List<CarSquelleton> history = new ArrayList<>();
	
	public User() {
		id = -1;
		firstName = "Empty one";
		lastName = "I'm empty :(";
		password = "1234";
		mail = "you can't reach me";
	}
	public User(int idi,String firstName, String lastName, String mail, String password) {
		id = idi;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mail = mail;
		this.password = password;
		
		
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

	public Integer[] getBasket() {
		Integer[] bas = new Integer[basket.size()];
		for (int i = 0; i <= basket.size(); i++) {
			bas[i] = basket.get(i);
		}
		return bas;
	}

	public CarSquelleton[] getHistory() {
		CarSquelleton[] his = new CarSquelleton[history.size()];
		for (int i = 0; i <= history.size(); i++) {
			his[i] = history.get(i);
		}
		return his;
	}



	public String getMail() {
		return mail;
	}
	public void addArticleBasket(int id) {
		basket.add(id);
		
	}
	public void addArticleHistory(String model,double price,int haveBeenRented) throws RemoteException {
		history.add(new CarSquelleton(0, model,price,haveBeenRented));
	}

	
	
}
