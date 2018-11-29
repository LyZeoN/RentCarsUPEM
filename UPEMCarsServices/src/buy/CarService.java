package buy;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.rpc.ServiceException;
import fr.upem.bank.Bank;
import fr.upem.bank.BankServiceLocator;
import fr.upem.bank.BankSoapBindingStub;

public class CarService {

	private final Map<Integer, User> users = new HashMap<Integer, User>();
	private int nextID = 0;

	public int connection(String mail, String password) {
		for (User u : users.values()) {
			if (u.getMail().equals(mail) && u.getPassword().equals(password)) {
				return u.getID();
			}
		}
		return -1;
	}

	public int add(String firstName, String lastName, String mail, String password) {
		for (User u : users.values()) {
			if (u.getMail().equals(mail)) {
				return -1;
			}
		}
		users.put(nextID, new User(nextID, firstName, lastName, mail, password));
		nextID++;
		return nextID - 1;
	}

	public CarSquelleton[] getUserShoppingCart(int userID)
			throws MalformedURLException, RemoteException, NotBoundException {
		users.get(userID);
		Integer[] shoppingCart = users.get(userID).getBasket();
		ICars s = (ICars) Naming.lookup("rmi://localhost:2020/RentCarsUPEM");
		CarSquelleton[] tabCars = new CarSquelleton[shoppingCart.length];
		int i = 0;

		for (int carID : shoppingCart) {

			int haveBeenRented = s.getSelectedCarsHBR(carID);
			String model = s.getSelectedCarsModel(carID);
			double price = s.getSelectedCarsPrice(carID);
			double pricelocation = s.getSelectedCarsPriceLocation(carID);
			int globalMark = s.getSelectedCarsGlobalMark(carID);
			List<ObservationSquelleton> obs = new ArrayList<ObservationSquelleton>();
			ICar[] allCars = s.getCars();
			if (allCars[i].getStatus().size() == 0) {
				ObservationSquelleton[] obstab = new ObservationSquelleton[obs.size()];

				tabCars[i] = new CarSquelleton(obstab, s.getCars()[i].getID(), model, price, pricelocation,
						haveBeenRented,globalMark);
				i++;

				continue;

			}
			for (Entry<Integer, IObservation> observ : allCars[i].getStatus().entrySet()) {
				IObservation entry = observ.getValue();
				obs.add(new ObservationSquelleton(users.get(observ.getKey()).getFirstName(),
						users.get(observ.getKey()).getLastName(), entry.getCarroserieMark(),
						entry.getCarroserieDescription(), entry.getMoteurMark(), entry.getMoteurDescription(),
						entry.getRoueMark(), entry.getRoueDescription()));

				ObservationSquelleton[] obstab = new ObservationSquelleton[obs.size()];
				for (int j = 0; j < obs.size(); j++) {
					obstab[j] = obs.get(j);
				}
				tabCars[i] = new CarSquelleton(obstab, s.getCars()[i].getID(), model, price, pricelocation,
						haveBeenRented,globalMark);
				obs.clear();

			}

			i++;
		}
		return tabCars;
	}

	public CarSquelleton[] getUserHistory(int userID) {
		return users.get(userID).getHistory();
	}

	public boolean addArticleBasket(int articleID, int userID) {
		User user = users.get(userID);
		if (user == null)
			return false;
		for (Integer i : user.getBasket()) {
			if (i == articleID)
				return false;
		}

		user.addArticleBasket(articleID);

		return true;

	}

	public boolean addArticleHistory(String model, double price, int haveBeenRented,int globalMark, int userID)
			throws RemoteException {
		User user = users.get(userID);
		if (user == null)
			return false;
		user.addArticleHistory(model, price, haveBeenRented, globalMark);
		return true;

	}

	public CarService() throws RemoteException {
		super();
	}

	public CarSquelleton[] getCars() throws RemoteException, MalformedURLException, NotBoundException {
		ICars r = (ICars) Naming.lookup("rmi://localhost:2020/RentCarsUPEM");
		IEmployees users = (IEmployees) Naming.lookup("rmi://localhost:2021/UPEMCorp");
		CarSquelleton[] toSend = new CarSquelleton[r.getCars().length];
		List<ObservationSquelleton> obs = new ArrayList<ObservationSquelleton>();
		for (int i = 0; i < r.getCars().length; i++) {
			if(r.getCars() [i].getRenter() == -1) {
	
				if (r.getCars()[i].getStatus().size() == 0) {
					ObservationSquelleton[] obstab = new ObservationSquelleton[obs.size()];
					toSend[i] = new CarSquelleton(obstab, r.getCars()[i].getID(), r.getCars()[i].getModel(),
							r.getCars()[i].getPrice(), r.getCars()[i].getPricelocation(),
							r.getCars()[i].getHaveBeenRented(),r.getCars()[i].getGlobalMark());
					continue;
				}
	
				for (Entry<Integer, IObservation> observ : r.getCars()[i].getStatus().entrySet()) {
	
					IObservation entry = observ.getValue();
	
					obs.add(new ObservationSquelleton(users.getEmployee(observ.getKey()).getFirstName(),
							users.getEmployee(observ.getKey()).getLastName(), entry.getCarroserieMark(),
							entry.getCarroserieDescription(), entry.getMoteurMark(), entry.getMoteurDescription(),
							entry.getRoueMark(), entry.getRoueDescription()));
	
					ObservationSquelleton[] obstab = new ObservationSquelleton[obs.size()];
	
					for (int j = 0; j < obs.size(); j++) {
						obstab[j] = obs.get(j);
					}
	
					toSend[i] = new CarSquelleton(obstab, r.getCars()[i].getID(), r.getCars()[i].getModel(),
							r.getCars()[i].getPrice(), r.getCars()[i].getPricelocation(),
							r.getCars()[i].getHaveBeenRented(),r.getCars()[i].getGlobalMark());
					obs.clear();
				}
			}
		}

		return toSend;

	}

	public boolean buyCar(int userID, String email, String password)
			throws RemoteException, ServiceException, MalformedURLException, NotBoundException {

		ICars r = (ICars) Naming.lookup("rmi://localhost:2020/RentCarsUPEM");
		Bank service = new BankServiceLocator().getBank();
		((BankSoapBindingStub) service).setMaintainSession(true);
		User u = users.get(userID);
		for (int carID : u.getBasket()) {
			if (service.withdrawMoney(email, password, ((ICars) r).sendCarPrice(carID))) {
				addArticleHistory(r.getSelectedCarsModel(carID), r.getSelectedCarsPrice(carID),
						r.getSelectedCarsHBR(carID),r.getSelectedCarsGlobalMark(carID), userID);
				if (!r.buyCar(carID)) {
					return false;
				}
			} else {
				return false;
			}

		}
		u.freeBasket();
		return true;
	}

}
