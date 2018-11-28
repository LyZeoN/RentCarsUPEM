package org.tempuri;

public class ConverterSoapProxy implements org.tempuri.ConverterSoap {
  private String _endpoint = null;
  private org.tempuri.ConverterSoap converterSoap = null;
  
  public ConverterSoapProxy() {
    _initConverterSoapProxy();
  }
  
  public ConverterSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initConverterSoapProxy();
  }
  
  private void _initConverterSoapProxy() {
    try {
      converterSoap = (new org.tempuri.ConverterLocator()).getConverterSoap();
      if (converterSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)converterSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)converterSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (converterSoap != null)
      ((javax.xml.rpc.Stub)converterSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.tempuri.ConverterSoap getConverterSoap() {
    if (converterSoap == null)
      _initConverterSoapProxy();
    return converterSoap;
  }
  
  public java.lang.String[] getCurrencies() throws java.rmi.RemoteException{
    if (converterSoap == null)
      _initConverterSoapProxy();
    return converterSoap.getCurrencies();
  }
  
  public java.math.BigDecimal getCurrencyRate(java.lang.String currency, java.util.Calendar rateDate) throws java.rmi.RemoteException{
    if (converterSoap == null)
      _initConverterSoapProxy();
    return converterSoap.getCurrencyRate(currency, rateDate);
  }
  
  public org.tempuri.GetCurrencyRatesResponseGetCurrencyRatesResult getCurrencyRates(java.util.Calendar rateDate) throws java.rmi.RemoteException{
    if (converterSoap == null)
      _initConverterSoapProxy();
    return converterSoap.getCurrencyRates(rateDate);
  }
  
  public java.math.BigDecimal getConversionRate(java.lang.String currencyFrom, java.lang.String currencyTo, java.util.Calendar rateDate) throws java.rmi.RemoteException{
    if (converterSoap == null)
      _initConverterSoapProxy();
    return converterSoap.getConversionRate(currencyFrom, currencyTo, rateDate);
  }
  
  public java.math.BigDecimal getConversionAmount(java.lang.String currencyFrom, java.lang.String currencyTo, java.util.Calendar rateDate, java.math.BigDecimal amount) throws java.rmi.RemoteException{
    if (converterSoap == null)
      _initConverterSoapProxy();
    return converterSoap.getConversionAmount(currencyFrom, currencyTo, rateDate, amount);
  }
  
  public java.lang.String getCultureInfo(java.lang.String currency) throws java.rmi.RemoteException{
    if (converterSoap == null)
      _initConverterSoapProxy();
    return converterSoap.getCultureInfo(currency);
  }
  
  public org.tempuri.ConvertDataTableColumnResponseDs convertDataTableColumn(org.tempuri.ConvertDataTableColumnDs ds, int tableIndex, java.lang.String columnName, java.lang.String fromCurrency, java.lang.String toCurrency) throws java.rmi.RemoteException{
    if (converterSoap == null)
      _initConverterSoapProxy();
    return converterSoap.convertDataTableColumn(ds, tableIndex, columnName, fromCurrency, toCurrency);
  }
  
  public java.util.Calendar getLastUpdateDate() throws java.rmi.RemoteException{
    if (converterSoap == null)
      _initConverterSoapProxy();
    return converterSoap.getLastUpdateDate();
  }
  
  
}