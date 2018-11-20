import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
	public static void main(String[] args) {
		try {
			Registry r = LocateRegistry.createRegistry(1099);
			ICars cars = new Cars();
			Naming.rebind("rmi://localhost:1099/RentCarsUPEM", cars);	
		}catch (Exception e) {
			System.out.println("Trouble : " + e);
		}
	}
}
