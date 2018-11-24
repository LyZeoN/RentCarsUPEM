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
	
	public CarSquelleton[] getUserShoppingCart(int userID) {
		
		ArrayList<CarSquelleton> tabCars = new ArrayList<CarSquelleton>();
		
		Integer[] shoppingCart = users.get(userID).getBasket();
		try {
			Remote s = Naming.lookup("rmi://localhost:2020/RentCarsUPEM");
			if(s instanceof ICars) {
				for(int carID : shoppingCart) {
					int haveBeenRented = ((ICars) s).getSelectedCarsHBR(carID);
					String model = ((ICars) s).getSelectedCarsModel(carID);
					double price = ((ICars) s).getSelectedCarsPrice(carID);
					tabCars.add(new CarSquelleton(model,price,haveBeenRented));

				}
				return (CarSquelleton[]) tabCars.toArray();
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

		
		
	}
	public CarSquelleton[] getUserHistory(int userID) {
		
		ArrayList<CarSquelleton> tabCars = new ArrayList<CarSquelleton>();
		
		Integer[] shoppingCart = users.get(userID).getHistory();
		try {
			Remote s = Naming.lookup("rmi://localhost:2020/RentCarsUPEM");
			if(s instanceof ICars) {
				for(int carID : shoppingCart) {
					int haveBeenRented = ((ICars) s).getSelectedCarsHBR(carID);
					String model = ((ICars) s).getSelectedCarsModel(carID);
					double price = ((ICars) s).getSelectedCarsPrice(carID);
					tabCars.add(new CarSquelleton(model,price,haveBeenRented));

				}
				return (CarSquelleton[]) tabCars.toArray();
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

		
		
	}
	public boolean addArticleBasket(int articleID,int userID) {
		User user = users.get(userID);
		if(user == null)
			return false;
		user.addArticleBasket(articleID);
		return true;
		
	}
	public boolean addArticleHistory(int articleID,int userID) {
		User user = users.get(userID);
		if(user == null)
			return false;
		user.addArticleHistory(articleID);
		return true;
		
	}
}
