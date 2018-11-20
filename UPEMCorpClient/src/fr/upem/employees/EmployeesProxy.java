package fr.upem.employees;

public class EmployeesProxy implements fr.upem.employees.Employees {
  private String _endpoint = null;
  private fr.upem.employees.Employees employees = null;
  
  public EmployeesProxy() {
    _initEmployeesProxy();
  }
  
  public EmployeesProxy(String endpoint) {
    _endpoint = endpoint;
    _initEmployeesProxy();
  }
  
  private void _initEmployeesProxy() {
    try {
      employees = (new fr.upem.employees.EmployeesServiceLocator()).getEmployees();
      if (employees != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)employees)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)employees)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (employees != null)
      ((javax.xml.rpc.Stub)employees)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public boolean connection(java.lang.String mail, java.lang.String password) throws java.rmi.RemoteException{
    if (employees == null)
      _initEmployeesProxy();
    return employees.connection(mail, password);
  }
  
  public fr.upem.employees.Employee[] getEmployees() throws java.rmi.RemoteException{
    if (employees == null)
      _initEmployeesProxy();
    return employees.getEmployees();
  }
  
  public boolean add(java.lang.String firstName, java.lang.String lastName, java.lang.String mail, java.lang.String password) throws java.rmi.RemoteException{
    if (employees == null)
      _initEmployeesProxy();
    return employees.add(firstName, lastName, mail, password);
  }
  
  
}