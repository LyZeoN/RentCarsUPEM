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

class NewClientBuyingCar {

	@Test
	/* Create a bank's client account */
	void CreateClient() throws MalformedURLException, RemoteException, NotBoundException, ServiceException {
		boolean worked;

		Bank bankservice = new BankServiceLocator().getBank();
		((BankSoapBindingStub) bankservice).setMaintainSession(true);
		worked = bankservice.addAccount("USD", "hugoagt@leonidas23.god", "bestintheworld", "Hugo", "Douangmala",
				"In the Sky", "0606060606", 60000);

		assertEquals(true, worked);

	}

	@Test
	/*
	 * Same client forgot he has an account and try to create a new one with the
	 * same email but doesn't work and false should be returned
	 */
	void CreateDuplicatedClient() throws MalformedURLException, RemoteException, NotBoundException, ServiceException {
		boolean worked;
		Bank bankservice = new BankServiceLocator().getBank();
		((BankSoapBindingStub) bankservice).setMaintainSession(true);
		worked = bankservice.addAccount("USD", "hugo7@leonidas23.god", "bestintheworld", "Hugo", "Douangmala",
				"In the Sky", "0606060606", 0);
		worked = bankservice.addAccount("USD", "hugo7@leonidas23.god", "bestintheworld", "Hugo", "Douangmala",
				"In the Sky", "0606060606", 0);

		assertEquals(false, worked);

	}

	@Test
	/* A client try to buy a car but doesn't have enough money in his account */
	void CreateClientThenBuyFailing()
			throws MalformedURLException, RemoteException, NotBoundException, ServiceException {
		Remote s;
		boolean worked;
		s = Naming.lookup("rmi://localhost:2020/RentCarsUPEM");
		if (s instanceof ICars) {

			((ICars) s).addCar("308", 200, 100);
			Remote corp = Naming.lookup("rmi://localhost:2021/UPEMCorp");
			if (corp instanceof IEmployees) {
				((IEmployees) corp).add("WAHEL", "Ningo", "igo@la.fr", "goku");
				CarService carService = new CarServiceServiceLocator().getCarService();
				((CarServiceSoapBindingStub) carService).setMaintainSession(true);

				carService.add("WAHEL", "Ningo", "carservice@la.fr", "goku");
				carService.add("WAHEL", "Ningo", "ehoui@la.fr", "goku");
				Bank bankservice;

				bankservice = new BankServiceLocator().getBank();
				((BankSoapBindingStub) bankservice).setMaintainSession(true);
				worked = bankservice.addAccount("USD", "hugo7@leonidas234.god", "bestintheworld", "Hugo", "Douangmala",
						"In the Sky", "0606060606", 0);
				carService.addArticleBasket(0, 0);
				worked = carService.buyCar(0, "hugo7@leonidas234.god", "bestintheworld");
				/* Client hasn't enough money on his account so it should return false */
				assertEquals(false, worked);
				// System.out.println(bankservice.getAccounts()[0].getBalance());

			}

		}

	}

	@Test
	/* A client deposit some money in his account and buy a car */
	void CreateClientThenBuy() throws MalformedURLException, RemoteException, NotBoundException, ServiceException {
		Remote s;
		boolean worked;
		s = Naming.lookup("rmi://localhost:2020/RentCarsUPEM");
		if (s instanceof ICars) {

			((ICars) s).addCar("308", 200, 100);

			Remote corp = Naming.lookup("rmi://localhost:2021/UPEMCorp");
			if (corp instanceof IEmployees) {

				((IEmployees) corp).add("WAHEL", "Ningo", "igo@la.fr", "goku");
				((IEmployees) corp).add("leboss", "Ningo", "rania@la.fr", "goku");

				CarService carService = new CarServiceServiceLocator().getCarService();
				((CarServiceSoapBindingStub) carService).setMaintainSession(true);
				carService.add("WAHEL", "Ningo", "carservice@la.fr", "goku");
				carService.add("WAHEL", "Ningo", "ehoui@la.fr", "goku");

				Bank bankservice;

				bankservice = new BankServiceLocator().getBank();
				((BankSoapBindingStub) bankservice).setMaintainSession(true);

				bankservice.addAccount("USD", "hugo7@leonidas23.god", "bestintheworld", "Hugo", "Douangmala",
						"In the Sky", "0606060606", 0);
				bankservice.depositMoney("hugo7@leonidas23.god", "bestintheworld", 50000);

				worked = carService.buyCar(0, "hugo7@leonidas23.god", "bestintheworld");
				assertEquals(true, worked);

			}

		}

	}

}
