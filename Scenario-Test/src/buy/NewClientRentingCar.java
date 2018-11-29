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
		bankservice.addAccount("USD", "hugo7@leonidas23.god", "bestintheworld", "Hugo", "Douangmala", "In the Sky",
				"0606060606", 60000);
		bankservice.depositMoney("hugo7@leonidas23.god", "bestintheworld", 50000);

	}

	@Test
	/* A client try to rent a car but doesn't have enough money in his account */
	void CreateClientThenRentFailing()
			throws MalformedURLException, RemoteException, NotBoundException, ServiceException {
		Remote s;
		boolean worked;
		s = Naming.lookup("rmi://localhost:2020/RentCarsUPEM");
		if (s instanceof ICars) {

			((ICars) s).addCar("308", 200, 100);
			Remote corp = Naming.lookup("rmi://localhost:2021/UPEMCorp");
			if (corp instanceof IEmployees) {
				((IEmployees) corp).add("WAHEL", "Ningo", "igo@la.fr", "goku");
				Remote rentCars = Naming.lookup("rmi://localhost:2020/RentCarsUPEM");

				Bank bankservice;

				bankservice = new BankServiceLocator().getBank();
				((BankSoapBindingStub) bankservice).setMaintainSession(true);
				bankservice.addAccount("USD", "hugo9@leonidas23.god", "bestintheworld", "Hugo", "Douangmala",
						"In the Sky", "0606060606", 0);
				if (rentCars instanceof ICars) {
					worked = ((ICars) rentCars).rentVehicule(0, 0, "hugo9@leonidas23.god", "bestintheworld");
					/* Client hasn't enough money on his account so it should return false */
					assertEquals(false, worked);
				}

			}

		}

	}

	@Test
	/* A client deposit some money and rent a car */
	void CreateClientThenRentSuccess()
			throws MalformedURLException, RemoteException, NotBoundException, ServiceException {
		Remote s;
		boolean worked;
		s = Naming.lookup("rmi://localhost:2020/RentCarsUPEM");
		if (s instanceof ICars) {

			((ICars) s).addCar("308", 200, 100);
			Remote corp = Naming.lookup("rmi://localhost:2021/UPEMCorp");
			if (corp instanceof IEmployees) {
				((IEmployees) corp).add("WAHEL", "Ningo", "igo@la.fr", "goku");
				Remote rentCars = Naming.lookup("rmi://localhost:2020/RentCarsUPEM");

				Bank bankservice;

				bankservice = new BankServiceLocator().getBank();
				((BankSoapBindingStub) bankservice).setMaintainSession(true);
				bankservice.addAccount("USD", "hugo11@leonidas23.god", "bestintheworld", "Hugo", "Douangmala",
						"In the Sky", "0606060606", 0);
				bankservice.depositMoney("hugo11@leonidas23.god", "bestintheworld", 6000);
				if (rentCars instanceof ICars) {
					worked = ((ICars) rentCars).rentVehicule(1, 0, "hugo11@leonidas23.god", "bestintheworld");
					/* Client has enough money on his account so it should return true */
					assertEquals(true, worked);
				}

			}

		}

	}

	@Test
	/* Same client give the car back then add an observation about this car */
	void FreeCarThenObs() throws MalformedURLException, RemoteException, NotBoundException, ServiceException {
		Remote s;
		boolean worked;
		s = Naming.lookup("rmi://localhost:2020/RentCarsUPEM");
		if (s instanceof ICars) {

			((ICars) s).addCar("308", 200, 100);
			Remote corp = Naming.lookup("rmi://localhost:2021/UPEMCorp");
			if (corp instanceof IEmployees) {
				((IEmployees) corp).add("WAHEL", "Ningo", "igo@la.fr", "goku");
				Remote rentCars = Naming.lookup("rmi://localhost:2020/RentCarsUPEM");

				System.out.println(((ICars) s).getSelectedCarsPrice(1));
				if (rentCars instanceof ICars) {
					worked = ((ICars) rentCars).freeCar(1);
					assertEquals(true, worked);
					((ICars) s).addObservation(0, 1, 10, "SUPER VOITURE !", 0, "lourd", 5, "ouai");
					/* Check the observation */
					assertEquals("SUPER VOITURE !", ((ICars) s).getObs(1)[0].getCarroserieDescription());
					assertEquals(10, ((ICars) s).getObs(1)[0].getCarroserieMark());


				}

			}

		}

	}

}
