/**
 * GetConversionAmount.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class GetConversionAmount  implements java.io.Serializable {
    private java.lang.String currencyFrom;

    private java.lang.String currencyTo;

    private java.util.Calendar rateDate;

    private java.math.BigDecimal amount;

    public GetConversionAmount() {
    }

    public GetConversionAmount(
           java.lang.String currencyFrom,
           java.lang.String currencyTo,
           java.util.Calendar rateDate,
           java.math.BigDecimal amount) {
           this.currencyFrom = currencyFrom;
           this.currencyTo = currencyTo;
           this.rateDate = rateDate;
           this.amount = amount;
    }


    /**
     * Gets the currencyFrom value for this GetConversionAmount.
     * 
     * @return currencyFrom
     */
    public java.lang.String getCurrencyFrom() {
        return currencyFrom;
    }


    /**
     * Sets the currencyFrom value for this GetConversionAmount.
     * 
     * @param currencyFrom
     */
    public void setCurrencyFrom(java.lang.String currencyFrom) {
        this.currencyFrom = currencyFrom;
    }


    /**
     * Gets the currencyTo value for this GetConversionAmount.
     * 
     * @return currencyTo
     */
    public java.lang.String getCurrencyTo() {
        return currencyTo;
    }


    /**
     * Sets the currencyTo value for this GetConversionAmount.
     * 
     * @param currencyTo
     */
    public void setCurrencyTo(java.lang.String currencyTo) {
        this.currencyTo = currencyTo;
    }


    /**
     * Gets the rateDate value for this GetConversionAmount.
     * 
     * @return rateDate
     */
    public java.util.Calendar getRateDate() {
        return rateDate;
    }


    /**
     * Sets the rateDate value for this GetConversionAmount.
     * 
     * @param rateDate
     */
    public void setRateDate(java.util.Calendar rateDate) {
        this.rateDate = rateDate;
    }


    /**
     * Gets the amount value for this GetConversionAmount.
     * 
     * @return amount
     */
    public java.math.BigDecimal getAmount() {
        return amount;
    }


    /**
     * Sets the amount value for this GetConversionAmount.
     * 
     * @param amount
     */
    public void setAmount(java.math.BigDecimal amount) {
        this.amount = amount;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetConversionAmount)) return false;
        GetConversionAmount other = (GetConversionAmount) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.currencyFrom==null && other.getCurrencyFrom()==null) || 
             (this.currencyFrom!=null &&
              this.currencyFrom.equals(other.getCurrencyFrom()))) &&
            ((this.currencyTo==null && other.getCurrencyTo()==null) || 
             (this.currencyTo!=null &&
              this.currencyTo.equals(other.getCurrencyTo()))) &&
            ((this.rateDate==null && other.getRateDate()==null) || 
             (this.rateDate!=null &&
              this.rateDate.equals(other.getRateDate()))) &&
            ((this.amount==null && other.getAmount()==null) || 
             (this.amount!=null &&
              this.amount.equals(other.getAmount())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getCurrencyFrom() != null) {
            _hashCode += getCurrencyFrom().hashCode();
        }
        if (getCurrencyTo() != null) {
            _hashCode += getCurrencyTo().hashCode();
        }
        if (getRateDate() != null) {
            _hashCode += getRateDate().hashCode();
        }
        if (getAmount() != null) {
            _hashCode += getAmount().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetConversionAmount.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetConversionAmount"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("currencyFrom");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "CurrencyFrom"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("currencyTo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "CurrencyTo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rateDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "RateDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("amount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Amount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
