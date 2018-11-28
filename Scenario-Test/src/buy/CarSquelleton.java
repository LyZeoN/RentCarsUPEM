/**
 * CarSquelleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package buy;

public class CarSquelleton  implements java.io.Serializable {
    private int globalMark;

    private int haveBeenRented;

    private int id;

    private java.lang.String model;

    private buy.ObservationSquelleton[] osb;

    private double price;

    private double pricelocation;

    public CarSquelleton() {
    }

    public CarSquelleton(
           int globalMark,
           int haveBeenRented,
           int id,
           java.lang.String model,
           buy.ObservationSquelleton[] osb,
           double price,
           double pricelocation) {
           this.globalMark = globalMark;
           this.haveBeenRented = haveBeenRented;
           this.id = id;
           this.model = model;
           this.osb = osb;
           this.price = price;
           this.pricelocation = pricelocation;
    }


    /**
     * Gets the globalMark value for this CarSquelleton.
     * 
     * @return globalMark
     */
    public int getGlobalMark() {
        return globalMark;
    }


    /**
     * Sets the globalMark value for this CarSquelleton.
     * 
     * @param globalMark
     */
    public void setGlobalMark(int globalMark) {
        this.globalMark = globalMark;
    }


    /**
     * Gets the haveBeenRented value for this CarSquelleton.
     * 
     * @return haveBeenRented
     */
    public int getHaveBeenRented() {
        return haveBeenRented;
    }


    /**
     * Sets the haveBeenRented value for this CarSquelleton.
     * 
     * @param haveBeenRented
     */
    public void setHaveBeenRented(int haveBeenRented) {
        this.haveBeenRented = haveBeenRented;
    }


    /**
     * Gets the id value for this CarSquelleton.
     * 
     * @return id
     */
    public int getId() {
        return id;
    }


    /**
     * Sets the id value for this CarSquelleton.
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Gets the model value for this CarSquelleton.
     * 
     * @return model
     */
    public java.lang.String getModel() {
        return model;
    }


    /**
     * Sets the model value for this CarSquelleton.
     * 
     * @param model
     */
    public void setModel(java.lang.String model) {
        this.model = model;
    }


    /**
     * Gets the osb value for this CarSquelleton.
     * 
     * @return osb
     */
    public buy.ObservationSquelleton[] getOsb() {
        return osb;
    }


    /**
     * Sets the osb value for this CarSquelleton.
     * 
     * @param osb
     */
    public void setOsb(buy.ObservationSquelleton[] osb) {
        this.osb = osb;
    }


    /**
     * Gets the price value for this CarSquelleton.
     * 
     * @return price
     */
    public double getPrice() {
        return price;
    }


    /**
     * Sets the price value for this CarSquelleton.
     * 
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }


    /**
     * Gets the pricelocation value for this CarSquelleton.
     * 
     * @return pricelocation
     */
    public double getPricelocation() {
        return pricelocation;
    }


    /**
     * Sets the pricelocation value for this CarSquelleton.
     * 
     * @param pricelocation
     */
    public void setPricelocation(double pricelocation) {
        this.pricelocation = pricelocation;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CarSquelleton)) return false;
        CarSquelleton other = (CarSquelleton) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.globalMark == other.getGlobalMark() &&
            this.haveBeenRented == other.getHaveBeenRented() &&
            this.id == other.getId() &&
            ((this.model==null && other.getModel()==null) || 
             (this.model!=null &&
              this.model.equals(other.getModel()))) &&
            ((this.osb==null && other.getOsb()==null) || 
             (this.osb!=null &&
              java.util.Arrays.equals(this.osb, other.getOsb()))) &&
            this.price == other.getPrice() &&
            this.pricelocation == other.getPricelocation();
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
        _hashCode += getGlobalMark();
        _hashCode += getHaveBeenRented();
        _hashCode += getId();
        if (getModel() != null) {
            _hashCode += getModel().hashCode();
        }
        if (getOsb() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOsb());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOsb(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += new Double(getPrice()).hashCode();
        _hashCode += new Double(getPricelocation()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CarSquelleton.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://buy", "CarSquelleton"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("globalMark");
        elemField.setXmlName(new javax.xml.namespace.QName("http://buy", "globalMark"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("haveBeenRented");
        elemField.setXmlName(new javax.xml.namespace.QName("http://buy", "haveBeenRented"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://buy", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("model");
        elemField.setXmlName(new javax.xml.namespace.QName("http://buy", "model"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("osb");
        elemField.setXmlName(new javax.xml.namespace.QName("http://buy", "osb"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://buy", "ObservationSquelleton"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://buy", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("price");
        elemField.setXmlName(new javax.xml.namespace.QName("http://buy", "price"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pricelocation");
        elemField.setXmlName(new javax.xml.namespace.QName("http://buy", "pricelocation"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
