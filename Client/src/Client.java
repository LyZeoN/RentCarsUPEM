import java.rmi.Naming;


public class Client {

	public static void main(String[] args) {
		try {
			ICars cars = (ICars) Naming.lookup("RentCarsUPEM");
			IEmployees employees = (IEmployees) Naming.lookup("rmi://localhost:27017/UPEMCorp");
			ICar car1 = cars.addCar("308", 15000, 300);
			ICar car2 = cars.addCar("309", 15000, 300);
			ICar car3 = cars.addCar("310", 15000, 300);
			System.out.println(employees.add("Jordan", "Delver", "jdelver@upem.com", "1234"));
			System.out.println(employees.add("Hugo", "Douoangmala", "hdouangm@upem.com", "1234"));
			System.out.println(employees.add("Rayane", "Cherifi", "rcherifi@upem.com", "1234"));
			System.out.println(cars.rentVehicule(car1, employees.getEmployees().get(0)));
		}catch (Exception e) {
			System.out.println("Exception" + e);
		}

	}

}

