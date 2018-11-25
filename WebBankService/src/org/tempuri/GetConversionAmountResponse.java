/**
 * GetConversionAmountResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class GetConversionAmountResponse  implements java.io.Serializable {
    private java.math.BigDecimal getConversionAmountResult;

    public GetConversionAmountResponse() {
    }

    public GetConversionAmountResponse(
           java.math.BigDecimal getConversionAmountResult) {
           this.getConversionAmountResult = getConversionAmountResult;
    }


    /**
     * Gets the getConversionAmountResult value for this GetConversionAmountResponse.
     * 
     * @return getConversionAmountResult
     */
    public java.math.BigDecimal getGetConversionAmountResult() {
        return getConversionAmountResult;
    }


    /**
     * Sets the getConversionAmountResult value for this GetConversionAmountResponse.
     * 
     * @param getConversionAmountResult
     */
    public void setGetConversionAmountResult(java.math.BigDecimal getConversionAmountResult) {
        this.getConversionAmountResult = getConversionAmountResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetConversionAmountResponse)) return false;
        GetConversionAmountResponse other = (GetConversionAmountResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getConversionAmountResult==null && other.getGetConversionAmountResult()==null) || 
             (this.getConversionAmountResult!=null &&
              this.getConversionAmountResult.equals(other.getGetConversionAmountResult())));
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
        if (getGetConversionAmountResult() != null) {
            _hashCode += getGetConversionAmountResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetConversionAmountResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetConversionAmountResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getConversionAmountResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GetConversionAmountResult"));
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
