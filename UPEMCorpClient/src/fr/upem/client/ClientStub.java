package fr.upem.client;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import fr.upem.employees.*;


public class ClientStub {
	public static void main(String args[]) throws ServiceException, RemoteException {
		Employees service = new EmployeesServiceLocator().getEmployees();
		((EmployeesSoapBindingStub) service).setMaintainSession(true);
		System.out.println(service.add("Jordan", "Delver", "jdelver@upem.com", "1234"));
		service.add("Hugo", "Douoangmala", "hdouangm@upem.com", "1234");
		service.add("Rayane", "Cherifi", "rcherifi@upem.com", "1234");
		System.out.println(service.add("Jordan1", "Delver1", "jdelver@upem.com1", "12341"));
		System.out.println(service.getEmployees()[1].getFirstName());
		
	}
}
