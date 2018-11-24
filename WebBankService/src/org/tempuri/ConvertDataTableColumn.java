/**
 * ConvertDataTableColumn.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class ConvertDataTableColumn  implements java.io.Serializable {
    private org.tempuri.ConvertDataTableColumnDs ds;

    private int tableIndex;

    private java.lang.String columnName;

    private java.lang.String fromCurrency;

    private java.lang.String toCurrency;

    public ConvertDataTableColumn() {
    }

    public ConvertDataTableColumn(
           org.tempuri.ConvertDataTableColumnDs ds,
           int tableIndex,
           java.lang.String columnName,
           java.lang.String fromCurrency,
           java.lang.String toCurrency) {
           this.ds = ds;
           this.tableIndex = tableIndex;
           this.columnName = columnName;
           this.fromCurrency = fromCurrency;
           this.toCurrency = toCurrency;
    }


    /**
     * Gets the ds value for this ConvertDataTableColumn.
     * 
     * @return ds
     */
    public org.tempuri.ConvertDataTableColumnDs getDs() {
        return ds;
    }


    /**
     * Sets the ds value for this ConvertDataTableColumn.
     * 
     * @param ds
     */
    public void setDs(org.tempuri.ConvertDataTableColumnDs ds) {
        this.ds = ds;
    }


    /**
     * Gets the tableIndex value for this ConvertDataTableColumn.
     * 
     * @return tableIndex
     */
    public int getTableIndex() {
        return tableIndex;
    }


    /**
     * Sets the tableIndex value for this ConvertDataTableColumn.
     * 
     * @param tableIndex
     */
    public void setTableIndex(int tableIndex) {
        this.tableIndex = tableIndex;
    }


    /**
     * Gets the columnName value for this ConvertDataTableColumn.
     * 
     * @return columnName
     */
    public java.lang.String getColumnName() {
        return columnName;
    }


    /**
     * Sets the columnName value for this ConvertDataTableColumn.
     * 
     * @param columnName
     */
    public void setColumnName(java.lang.String columnName) {
        this.columnName = columnName;
    }


    /**
     * Gets the fromCurrency value for this ConvertDataTableColumn.
     * 
     * @return fromCurrency
     */
    public java.lang.String getFromCurrency() {
        return fromCurrency;
    }


    /**
     * Sets the fromCurrency value for this ConvertDataTableColumn.
     * 
     * @param fromCurrency
     */
    public void setFromCurrency(java.lang.String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }


    /**
     * Gets the toCurrency value for this ConvertDataTableColumn.
     * 
     * @return toCurrency
     */
    public java.lang.String getToCurrency() {
        return toCurrency;
    }


    /**
     * Sets the toCurrency value for this ConvertDataTableColumn.
     * 
     * @param toCurrency
     */
    public void setToCurrency(java.lang.String toCurrency) {
        this.toCurrency = toCurrency;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConvertDataTableColumn)) return false;
        ConvertDataTableColumn other = (ConvertDataTableColumn) obj;
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
              this.ds.equals(other.getDs()))) &&
            this.tableIndex == other.getTableIndex() &&
            ((this.columnName==null && other.getColumnName()==null) || 
             (this.columnName!=null &&
              this.columnName.equals(other.getColumnName()))) &&
            ((this.fromCurrency==null && other.getFromCurrency()==null) || 
             (this.fromCurrency!=null &&
              this.fromCurrency.equals(other.getFromCurrency()))) &&
            ((this.toCurrency==null && other.getToCurrency()==null) || 
             (this.toCurrency!=null &&
              this.toCurrency.equals(other.getToCurrency())));
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
        _hashCode += getTableIndex();
        if (getColumnName() != null) {
            _hashCode += getColumnName().hashCode();
        }
        if (getFromCurrency() != null) {
            _hashCode += getFromCurrency().hashCode();
        }
        if (getToCurrency() != null) {
            _hashCode += getToCurrency().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConvertDataTableColumn.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">ConvertDataTableColumn"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ds");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "ds"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>ConvertDataTableColumn>ds"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tableIndex");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "TableIndex"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("columnName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "ColumnName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fromCurrency");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "FromCurrency"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("toCurrency");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "ToCurrency"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
