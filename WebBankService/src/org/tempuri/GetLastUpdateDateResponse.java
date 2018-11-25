/**
 * GetLastUpdateDateResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class GetLastUpdateDateResponse  implements java.io.Serializable {
    private java.util.Calendar getLastUpdateDateResult;

    public GetLastUpdateDateResponse() {
    }

    public GetLastUpdateDateResponse(
           java.util.Calendar getLastUpdateDateResult) {
           this.getLastUpdateDateResult = getLastUpdateDateResult;
    }


    /**
     * Gets the getLastUpdateDateResult value for this GetLastUpdateDateResponse.
     * 
     * @return getLastUpdateDateResult
     */
    public java.util.Calendar getGetLastUpdateDateResult() {
        return getLastUpdateDateResult;
    }


    /**
     * Sets the getLastUpdateDateResult value for this GetLastUpdateDateResponse.
     * 
     * @param getLastUpdateDateResult
     */
    public void setGetLastUpdateDateResult(java.util.Calendar getLastUpdateDateResult) {
        this.getLastUpdateDateResult = getLastUpdateDateResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetLastUpdateDateResponse)) return false;
        GetLastUpdateDateResponse other = (GetLastUpdateDateResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getLastUpdateDateResult==null && other.getGetLastUpdateDateResult()==null) || 
             (this.getLastUpdateDateResult!=null &&
              this.getLastUpdateDateResult.equals(other.getGetLastUpdateDateResult())));
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
        if (getGetLastUpdateDateResult() != null) {
            _hashCode += getGetLastUpdateDateResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetLastUpdateDateResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetLastUpdateDateResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getLastUpdateDateResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GetLastUpdateDateResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
