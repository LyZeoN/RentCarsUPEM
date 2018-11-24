package buy;

import static org.junit.jupiter.api.Assertions.*;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import org.junit.jupiter.api.Test;

import fr.upem.bank.Bank;
import fr.upem.bank.BankServiceLocator;
import fr.upem.bank.BankSoapBindingStub;

class NewClientRentingCar {

	@Test
	/* Create a bank's client account */		
	void CreateClient() throws MalformedURLException, RemoteException, NotBoundException, ServiceException {
		Bank bankservice = new BankServiceLocator().getBank();
		((BankSoapBindingStub) bankservice).setMaintainSession(true);
		bankservice.addAccount("USD", "hugo7@leonidas23.god", "bestintheworld", "Hugo", "Douangmala",
				"In the Sky", "0606060606", 60000);
		bankservice.depositMoney("hugo7@leonidas23.god", "bestintheworld", 50000);


		

	}
	@Test
	/* A client try to rent a car but doesn't have enough money in his account */
	void CreateClientThenBuyFailing() throws MalformedURLException, RemoteException, NotBoundException, ServiceException {
		Remote s;
		boolean worked;
		s = Naming.lookup("rmi://localhost:2020/RentCarsUPEM");
		if (s instanceof ICars) {
			System.out.println("ici");

			((ICars) s).addCar("308", 200, 100);
			Remote corp = Naming.lookup("rmi://localhost:2020/UPEMCorp");
			if (corp instanceof IEmployees) {
				((IEmployees) corp).add("WAHEL", "Ningo", "igo@la.fr", "goku");
				Remote rentCars = Naming.lookup("rmi://localhost:2020/RentCarsUPEM");
				
				Bank bankservice;

				bankservice = new BankServiceLocator().getBank();
				((BankSoapBindingStub) bankservice).setMaintainSession(true);
				if(rentCars instanceof ICars) {
					worked = ((ICars) rentCars).rentVehicule(0, 0);
					/* Client hasn't enough money on his account so it should return false */
					assertEquals(false, worked);
					System.out.println(bankservice.getAccounts()[0].getBalance());
				}
				
				

			}

		}

	}
}
