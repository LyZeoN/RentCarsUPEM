package buy;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import org.junit.jupiter.api.Test;

import fr.upem.bank.Bank;
import fr.upem.bank.BankServiceLocator;
import fr.upem.bank.BankSoapBindingStub;
/* Launch this to setup the database */
class SetupProject {

	@Test
	void addAccount() throws ServiceException, RemoteException, MalformedURLException, NotBoundException {
		Bank bankservice = new BankServiceLocator().getBank();
		IEmployees corp = (IEmployees) Naming.lookup("rmi://localhost:2021/UPEMCorp");
		
		((BankSoapBindingStub) bankservice).setMaintainSession(true);
		bankservice.addAccount("USD", "jo@gmail.com", "super", "Hugo", "Douangmala",
				"In the Sky", "0606060606", 60000000);	
		
		corp.add("Rayane", "CHERIFI", "rc@gmail.com", "nice");
	}
	@Test
	void addCars() throws ServiceException, RemoteException, MalformedURLException, NotBoundException{
		ICars s = (ICars) Naming.lookup("rmi://localhost:2020/RentCarsUPEM");
		s.addCar("Peugeot 308", 5000, 80);
		s.addCar("Peugeot 206", 3000, 50);
		s.addCar("Mercedes A180", 15000, 130);
		s.addCar("Reunault Clio IV", 10000, 80);
		s.addCar("MERCEDES-BENZ CLASSE S 350", 95000, 200);
		s.addCar("NISSAN QASHQAI 2", 10000, 80);		

		
		
		
	}

}
