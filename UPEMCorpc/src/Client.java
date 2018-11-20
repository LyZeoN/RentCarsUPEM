import java.rmi.Naming;


public class Client {

	public static void main(String[] args) {
		try {
			IEmployees employees = (IEmployees) Naming.lookup("UPEMCorp");
			System.out.println(employees.add("Jordan", "Delver", "jdelver@upem.com", "1234"));
			System.out.println(employees.add("Hugo", "Douoangmala", "hdouangm@upem.com", "1234"));
			System.out.println(employees.add("Rayane", "Cherifi", "rcherifi@upem.com", "1234"));
			System.out.println(employees.getEmployees().get(0).getFirstName());
		}catch (Exception e) {
			System.out.println("Exception" + e);
		}

	}

}

