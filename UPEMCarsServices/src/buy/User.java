package buy;
import java.util.ArrayList;
import java.util.List;

public class User {
	private final String firstName;
	private final String lastName;
	private final String mail;
	private String password;
	private int id;
	private List<Integer> basket = new ArrayList<>();
	private List<Integer> history = new ArrayList<>();
	
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
		return (Integer[]) basket.toArray();
	}



	public Integer[] getHistory() {
		return (Integer[]) history.toArray();
	}



	public String getMail() {
		return mail;
	}
	public void addArticleBasket(int id) {
		basket.add(id);
		
	}
	public void addArticleHistory(int id) {
		history.add(id);
		
	}

	
	
}
