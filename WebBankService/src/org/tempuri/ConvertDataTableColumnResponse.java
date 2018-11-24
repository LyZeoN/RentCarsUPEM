/**
 * ConvertDataTableColumnResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class ConvertDataTableColumnResponse  implements java.io.Serializable {
    private org.tempuri.ConvertDataTableColumnResponseDs ds;

    public ConvertDataTableColumnResponse() {
    }

    public ConvertDataTableColumnResponse(
           org.tempuri.ConvertDataTableColumnResponseDs ds) {
           this.ds = ds;
    }


    /**
     * Gets the ds value for this ConvertDataTableColumnResponse.
     * 
     * @return ds
     */
    public org.tempuri.ConvertDataTableColumnResponseDs getDs() {
        return ds;
    }


    /**
     * Sets the ds value for this ConvertDataTableColumnResponse.
     * 
     * @param ds
     */
    public void setDs(org.tempuri.ConvertDataTableColumnResponseDs ds) {
        this.ds = ds;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConvertDataTableColumnResponse)) return false;
        ConvertDataTableColumnResponse other = (ConvertDataTableColumnResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.ds==null && other.getDs()==null) || 
             (this.ds!=null &&
              this.ds.equals(other.getDs())));
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
        if (getDs() != null) {
            _hashCode += getDs().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConvertDataTableColumnResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">ConvertDataTableColumnResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ds");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "ds"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>ConvertDataTableColumnResponse>ds"));
        elemField.setMinOccurs(0);
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
