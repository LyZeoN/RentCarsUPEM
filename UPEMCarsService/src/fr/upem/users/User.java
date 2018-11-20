package fr.upem.users;
import java.util.List;

public class User {
	private final String firstName;
	private final String lastName;
	private final String mail;
	private String password;
	/*private List<String> basket;
	private List<> history;*/

	public User(String firstName, String lastName, String mail, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.mail = mail;
		this.password = password;
		//this.basket = new ArrayList<>();
		//this.history = new ArrayList<>();
		
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

	/*public List<> getBasket() {
		return basket;
	}

	public void setBasket(List<> basket) {
		this.basket = basket;
	}

	public List<> getHistory() {
		return history;
	}

	public void setHistory(List<> history) {
		this.history = history;
	}
	
	public void addBasket(Vehicule v) {
		basket.add(v);
	}
	
	public void removeBasket(Vehicule v) {
		basket.remove(v);
	}
	
	public void clearBasket() {
		basket.clear();
	}
	
	public void addHistory(Vehicule v) {
		history.add(v);
	}*/
	
}
