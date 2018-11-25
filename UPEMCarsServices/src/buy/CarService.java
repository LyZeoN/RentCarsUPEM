package buy;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.rpc.ServiceException;
import fr.upem.bank.Bank;
import fr.upem.bank.BankServiceLocator;
import fr.upem.bank.BankSoapBindingStub;

public class CarService{
	
	private final Map<Integer,User> users = new HashMap<Integer,User>();
	private int nextID = 0;

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
		users.put(nextID++,new User(nextID,firstName, lastName, mail, password));
		return true;
	}
	
	public CarSquelleton[] getUserShoppingCart(int userID) throws MalformedURLException, RemoteException, NotBoundException {
		Integer[] shoppingCart = users.get(userID).getBasket();
		ICars s = (ICars) Naming.lookup("rmi://localhost:2020/RentCarsUPEM");
		CarSquelleton[] tabCars = new CarSquelleton[shoppingCart.length];
		int i = 0;
		for(int carID : shoppingCart) {
			int haveBeenRented = s.getSelectedCarsHBR(carID);
			String model = s.getSelectedCarsModel(carID);
			double price = s.getSelectedCarsPrice(carID);
			tabCars[i] = new CarSquelleton(carID, model,price,haveBeenRented);
			i++;
		}
		return tabCars;
	}
	
	public CarSquelleton[] getUserHistory(int userID) {
		return users.get(userID).getHistory();	
	}
	
	public boolean addArticleBasket(int articleID,int userID) {
		User user = users.get(userID);
		if(user == null)
			return false;
		user.addArticleBasket(articleID);
		return true;
		
	}
	public boolean addArticleHistory(String model,double price,int haveBeenRented,int userID) throws RemoteException {
		User user = users.get(userID);
		if(user == null)
			return false;
		user.addArticleHistory(model,price,haveBeenRented);
		return true;
		
	}
	public CarService() throws RemoteException {
		super();
	}

	public CarSquelleton[] getCars() throws RemoteException, MalformedURLException, NotBoundException {
			ICars r = (ICars) Naming.lookup("rmi://localhost:2020/RentCarsUPEM");
			CarSquelleton[] toSend = new CarSquelleton[r.getCars().length];
			for(int i = 0;i < r.getCars().length;i++) {
				toSend[i] = new CarSquelleton(r.getCars()[i].getID(), r.getCars()[i].getModel(), r.getCars()[i].getPrice(), r.getCars()[i].getHaveBeenRented());
			}
			return toSend;

	}

	public boolean buyCar(int userID,String email,String password) throws RemoteException, ServiceException, MalformedURLException, NotBoundException {
			ICars r =  (ICars) Naming.lookup("rmi://localhost:2020/RentCarsUPEM");
			Bank service = new BankServiceLocator().getBank();
			((BankSoapBindingStub) service).setMaintainSession(true);
			User u = users.get(userID);
			for(int carID : u.getBasket() ) {
				if(service.withdrawMoney(email, password, ((ICars) r).sendCarPrice(carID))) {
						if (!r.buyCar(carID)) {
							return false;
						}
				}
			}
			return true;
	}
	

}
