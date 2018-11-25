package buy;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Users {
	private final Map<Integer,User> users = new HashMap<Integer,User>();
	private int nextID = 0;
	public Users() {
		
	}
	
	public boolean connection(String mail, String password) {
		for (User u : users.values()) {
			if (u.getMail().equals(mail) && u.getPassword().equals(password)){
				return true;
			}
		}
		return false;
	}
	
	
	public boolean add(String firstName, String lastName, String mail, String password) {
		for (User u : users.values()) {
			if (u.getMail().equals(mail)) {
				return false;
			}
		}
		users.put(nextID++,new User(nextID,firstName, lastName, password, mail));
		return true;
	}
	
	public CarSquelleton[] getUserShoppingCart(int userID) throws RemoteException, MalformedURLException, NotBoundException {
		
		ArrayList<CarSquelleton> tabCars = new ArrayList<CarSquelleton>();
		Integer[] shoppingCart = users.get(userID).getBasket();
		ICars s = (ICars) Naming.lookup("rmi://localhost:2020/RentCarsUPEM");
		for(int carID : shoppingCart) {
			int haveBeenRented = s.getSelectedCarsHBR(carID);
			String model = s.getSelectedCarsModel(carID);
			double price = s.getSelectedCarsPrice(carID);
			tabCars.add(new CarSquelleton(carID, model,price,haveBeenRented));
		}
		return (CarSquelleton[]) tabCars.toArray();	
	}
}
