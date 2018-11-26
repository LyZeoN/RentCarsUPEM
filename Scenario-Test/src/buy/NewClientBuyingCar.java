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
	/* A client deposit some money in his account then buy a car  */
	void CreateClientThenBuy() throws MalformedURLException, RemoteException, NotBoundException, ServiceException {
		Remote s;
		
		s = Naming.lookup("rmi://localhost:2020/RentCarsUPEM");
		if (s instanceof ICars) {

			((ICars) s).addCar("308", 200, 100);
			
			Remote corp = Naming.lookup("rmi://localhost:2020/UPEMCorp");
			if (corp instanceof IEmployees) {
				
				((IEmployees) corp).add("WAHEL", "Ningo", "igo@la.fr", "goku");
				((IEmployees) corp).add("leboss", "Ningo", "rania@la.fr", "goku");


				CarService carService = new CarServiceServiceLocator().getCarService();
				((CarServiceSoapBindingStub) carService).setMaintainSession(true);
				System.out.println(carService.add("WAHEL", "Ningo", "carservice@la.fr", "goku"));
				carService.add("WAHEL", "Ningo", "ehoui@la.fr", "goku");
				
				Bank bankservice;

				bankservice = new BankServiceLocator().getBank();
				((BankSoapBindingStub) bankservice).setMaintainSession(true);
				
				//bankservice.addAccount("USD", "hugo7@leonidas23.god", "bestintheworld", "Hugo", "Douangmala",
						//"In the Sky", "0606060606", 60000);
				//bankservice.depositMoney("hugo7@leonidas23.god", "bestintheworld", 50000);
				//((ICars) s).addObservation(0, 0, 10, "SUPER VOITURE !", 0, "lourd", 5, "ouai");
				//System.out.println("size" 
					//	+carService.getObs(0).getOsb().length);
				//System.out.println(carService.getObs(0).getOsb()[0].getCarroserieDescription());
				//System.out.println(carService.addArticleBasket(0, 0));
				
				System.out.println("yata" + carService.getCars()[0].getModel());
				
				//System.out.println(carService.buyCar(0, "hugo7@leonidas23.god", "bestintheworld"));
				//System.out.println(carService.getUserHistory(0)[1].getModel());
				//System.out.println(bankservice.getAccounts()[0].getBalance());

			}
			

		}

	}
	

	
	

}
