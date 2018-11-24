package buy;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import fr.upem.bank.Bank;
import fr.upem.bank.BankServiceLocator;
import fr.upem.bank.BankSoapBindingStub;

public class Server {
	/*
	public static void main(String[] args) {
		try {
			//Registry r = LocateRegistry.createRegistry(1101);
			ICarService carse = new CarService();
			Naming.rebind("rmi://localhost:2020/UPEMCarsServices", carse);	
			
		
		}catch (Exception e) {
			System.out.println("Trouble : " + e);
		}
	}
	*/
}
