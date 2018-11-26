package buy;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICarService extends Remote{
	public boolean buyCar(int carID,String email,String password) throws RemoteException;
	public ICar[] getCars() throws RemoteException;
}
