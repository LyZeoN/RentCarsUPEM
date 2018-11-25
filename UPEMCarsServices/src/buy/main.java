package buy;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.xml.rpc.ServiceException;

import fr.upem.bank.Bank;
import fr.upem.bank.BankServiceLocator;
import fr.upem.bank.BankSoapBindingStub;

public class main {
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException, ServiceException {
		
		/*
		Remote s = Naming.lookup("rmi://localhost:2020/RentCarsUPEM");

		if(s instanceof ICars) {
			System.out.println("ici");

			((ICars) s).addCar("308", 200, 100);
			Remote corp = Naming.lookup("rmi://localhost:2020/UPEMCorp");
			if(corp instanceof IEmployees) {
				((IEmployees) corp).add("WAHEL", "Ningo", "igo@la.fr", "goku");
				Remote service = Naming.lookup("rmi://localhost:2020/UPEMCarsServices");
				Bank bankservice = new BankServiceLocator().getBank();
				((BankSoapBindingStub) bankservice).setMaintainSession(true);
				bankservice.addAccount("USD", "hugo7@leonidas23.god", "bestintheworld", "Hugo", "Douangmala", "In the Sky", "0606060606", 60000);
				bankservice.depositMoney("hugo7@leonidas23.god", "bestintheworld", 50000);
				if(service instanceof ICarService) {
					System.out.println(((ICarService) service).buyCar(0,"hugo7@leonidas23.god" , "bestintheworld"));
					System.out.println(bankservice.getAccounts()[0].getBalance());
				}
			}
			
			
		}
		
		*/
	}
}
