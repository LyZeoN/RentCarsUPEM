import java.rmi.Naming;


public class Client {

	public static void main(String[] args) {
		try {
			ICars cars = (ICars) Naming.lookup("RentCarsUPEM");
			System.out.println(cars.addCar("308", 15000, 300));
			System.out.println(cars.addCar("309", 15000, 300));
			System.out.println(cars.addCar("310", 15000, 300));
		}catch (Exception e) {
			System.out.println("Exception" + e);
		}
	}
}

