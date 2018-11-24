package buy;

public class CarServiceProxy implements buy.CarService {
  private String _endpoint = null;
  private buy.CarService carService = null;
  
  public CarServiceProxy() {
    _initCarServiceProxy();
  }
  
  public CarServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initCarServiceProxy();
  }
  
  private void _initCarServiceProxy() {
    try {
      carService = (new buy.CarServiceServiceLocator()).getCarService();
      if (carService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)carService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)carService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (carService != null)
      ((javax.xml.rpc.Stub)carService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public buy.CarService getCarService() {
    if (carService == null)
      _initCarServiceProxy();
    return carService;
  }
  
  public boolean add(java.lang.String firstName, java.lang.String lastName, java.lang.String mail, java.lang.String password) throws java.rmi.RemoteException{
    if (carService == null)
      _initCarServiceProxy();
    return carService.add(firstName, lastName, mail, password);
  }
  
  public boolean connection(java.lang.String mail, java.lang.String password) throws java.rmi.RemoteException{
    if (carService == null)
      _initCarServiceProxy();
    return carService.connection(mail, password);
  }
  
  public buy.CarSquelleton[] getUserShoppingCart(int userID) throws java.rmi.RemoteException{
    if (carService == null)
      _initCarServiceProxy();
    return carService.getUserShoppingCart(userID);
  }
  
  public boolean addArticleHistory(int articleID, int userID) throws java.rmi.RemoteException{
    if (carService == null)
      _initCarServiceProxy();
    return carService.addArticleHistory(articleID, userID);
  }
  
  public buy.CarSquelleton[] getUserHistory(int userID) throws java.rmi.RemoteException{
    if (carService == null)
      _initCarServiceProxy();
    return carService.getUserHistory(userID);
  }
  
  public boolean addArticleBasket(int articleID, int userID) throws java.rmi.RemoteException{
    if (carService == null)
      _initCarServiceProxy();
    return carService.addArticleBasket(articleID, userID);
  }
  
  public buy.CarSquelleton[] getCars() throws java.rmi.RemoteException{
    if (carService == null)
      _initCarServiceProxy();
    return carService.getCars();
  }
  
  public boolean buyCar(int carID, java.lang.String email, java.lang.String password) throws java.rmi.RemoteException{
    if (carService == null)
      _initCarServiceProxy();
    return carService.buyCar(carID, email, password);
  }
  
  
}