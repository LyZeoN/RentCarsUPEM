package fr.upem.users;

import java.util.ArrayList;
import java.util.List;

public class Users {
	private final List<User> users;

	public Users() {
		this.users = new ArrayList<>();
	}
	
	public boolean connection(String mail, String password) {
		for (User u : users) {
			if (u.getMail().equals(mail) && u.getPassword().equals(password)){
				return true;
			}
		}
		return false;
	}
	
	
	public boolean add(String firstName, String lastName, String mail, String password) {
		for (User u : users) {
			if (u.getMail().equals(mail)) {
				return false;
			}
		}
		users.add(new User(firstName, lastName, password, mail));
		return true;
	}
	
	/*public boolean buy (String mail, String identifiant,String password,Vehicule v) {
	 	
		
		
		return false;
		
	}*/
}
