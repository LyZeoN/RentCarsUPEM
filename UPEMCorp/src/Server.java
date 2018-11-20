import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {

	public static void main(String[] args) {
		try {
			Registry r = LocateRegistry.createRegistry(27017);
			IEmployees employees = new Employees();
			Naming.rebind("rmi://localhost:27017/UPEMCorp", employees);	
		}catch (Exception e) {
			System.out.println("Trouble : " + e);
		}
	}

}
