package fr.upem.bank;

public class BankProxy implements fr.upem.bank.Bank {
  private String _endpoint = null;
  private fr.upem.bank.Bank bank = null;
  
  public BankProxy() {
    _initBankProxy();
  }
  
  public BankProxy(String endpoint) {
    _endpoint = endpoint;
    _initBankProxy();
  }
  
  private void _initBankProxy() {
    try {
      bank = (new fr.upem.bank.BankServiceLocator()).getBank();
      if (bank != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)bank)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)bank)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (bank != null)
      ((javax.xml.rpc.Stub)bank)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public fr.upem.bank.Bank getBank() {
    if (bank == null)
      _initBankProxy();
    return bank;
  }
  
  public boolean depositMoney(java.lang.String mail, java.lang.String password, double amount) throws java.rmi.RemoteException{
    if (bank == null)
      _initBankProxy();
    return bank.depositMoney(mail, password, amount);
  }
  
  public boolean addAccount(java.lang.String currency, java.lang.String mail, java.lang.String password, java.lang.String firstName, java.lang.String lastName, java.lang.String adress, java.lang.String phoneNumber, double balance) throws java.rmi.RemoteException{
    if (bank == null)
      _initBankProxy();
    return bank.addAccount(currency, mail, password, firstName, lastName, adress, phoneNumber, balance);
  }
  
  public boolean withdrawMoney(java.lang.String mail, java.lang.String password, double amount) throws java.rmi.RemoteException{
    if (bank == null)
      _initBankProxy();
    return bank.withdrawMoney(mail, password, amount);
  }
  
  
}