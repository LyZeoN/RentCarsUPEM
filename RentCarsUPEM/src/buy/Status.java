package buy;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Status extends UnicastRemoteObject implements IStatus{
	private int mark;
	private String description;
	
	public Status(int mark, String description) throws RemoteException {
		this.description = description;
		this.mark = mark;
	}

	public int getMark() throws RemoteException{
		return mark;
	}

	public void setMark(int mark) throws RemoteException{
		this.mark = mark;
	}

	public String getDescription() throws RemoteException {
		return description;
	}

	public void setDescription(String description) throws RemoteException {
		this.description = description;
	}
	

}
