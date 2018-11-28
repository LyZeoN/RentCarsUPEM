/**
 * ObservationSquelleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package buy;

public class ObservationSquelleton  implements java.io.Serializable {
    private java.lang.String carroserieDescription;

    private int carroserieMark;

    private java.lang.String firstName;

    private java.lang.String lastName;

    private java.lang.String moteurDescription;

    private int moteurMark;

    private java.lang.String roueDescription;

    private int roueMark;

    public ObservationSquelleton() {
    }

    public ObservationSquelleton(
           java.lang.String carroserieDescription,
           int carroserieMark,
           java.lang.String firstName,
           java.lang.String lastName,
           java.lang.String moteurDescription,
           int moteurMark,
           java.lang.String roueDescription,
           int roueMark) {
           this.carroserieDescription = carroserieDescription;
           this.carroserieMark = carroserieMark;
           this.firstName = firstName;
           this.lastName = lastName;
           this.moteurDescription = moteurDescription;
           this.moteurMark = moteurMark;
           this.roueDescription = roueDescription;
           this.roueMark = roueMark;
    }


    /**
     * Gets the carroserieDescription value for this ObservationSquelleton.
     * 
     * @return carroserieDescription
     */
    public java.lang.String getCarroserieDescription() {
        return carroserieDescription;
    }


    /**
     * Sets the carroserieDescription value for this ObservationSquelleton.
     * 
     * @param carroserieDescription
     */
    public void setCarroserieDescription(java.lang.String carroserieDescription) {
        this.carroserieDescription = carroserieDescription;
    }


    /**
     * Gets the carroserieMark value for this ObservationSquelleton.
     * 
     * @return carroserieMark
     */
    public int getCarroserieMark() {
        return carroserieMark;
    }


    /**
     * Sets the carroserieMark value for this ObservationSquelleton.
     * 
     * @param carroserieMark
     */
    public void setCarroserieMark(int carroserieMark) {
        this.carroserieMark = carroserieMark;
    }


    /**
     * Gets the firstName value for this ObservationSquelleton.
     * 
     * @return firstName
     */
    public java.lang.String getFirstName() {
        return firstName;
    }


    /**
     * Sets the firstName value for this ObservationSquelleton.
     * 
     * @param firstName
     */
    public void setFirstName(java.lang.String firstName) {
        this.firstName = firstName;
    }


    /**
     * Gets the lastName value for this ObservationSquelleton.
     * 
     * @return lastName
     */
    public java.lang.String getLastName() {
        return lastName;
    }


    /**
     * Sets the lastName value for this ObservationSquelleton.
     * 
     * @param lastName
     */
    public void setLastName(java.lang.String lastName) {
        this.lastName = lastName;
    }


    /**
     * Gets the moteurDescription value for this ObservationSquelleton.
     * 
     * @return moteurDescription
     */
    public java.lang.String getMoteurDescription() {
        return moteurDescription;
    }


    /**
     * Sets the moteurDescription value for this ObservationSquelleton.
     * 
     * @param moteurDescription
     */
    public void setMoteurDescription(java.lang.String moteurDescription) {
        this.moteurDescription = moteurDescription;
    }


    /**
     * Gets the moteurMark value for this ObservationSquelleton.
     * 
     * @return moteurMark
     */
    public int getMoteurMark() {
        return moteurMark;
    }


    /**
     * Sets the moteurMark value for this ObservationSquelleton.
     * 
     * @param moteurMark
     */
    public void setMoteurMark(int moteurMark) {
        this.moteurMark = moteurMark;
    }


    /**
     * Gets the roueDescription value for this ObservationSquelleton.
     * 
     * @return roueDescription
     */
    public java.lang.String getRoueDescription() {
        return roueDescription;
    }


    /**
     * Sets the roueDescription value for this ObservationSquelleton.
     * 
     * @param roueDescription
     */
    public void setRoueDescription(java.lang.String roueDescription) {
        this.roueDescription = roueDescription;
    }


    /**
     * Gets the roueMark value for this ObservationSquelleton.
     * 
     * @return roueMark
     */
    public int getRoueMark() {
        return roueMark;
    }


    /**
     * Sets the roueMark value for this ObservationSquelleton.
     * 
     * @param roueMark
     */
    public void setRoueMark(int roueMark) {
        this.roueMark = roueMark;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObservationSquelleton)) return false;
        ObservationSquelleton other = (ObservationSquelleton) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.carroserieDescription==null && other.getCarroserieDescription()==null) || 
             (this.carroserieDescription!=null &&
              this.carroserieDescription.equals(other.getCarroserieDescription()))) &&
            this.carroserieMark == other.getCarroserieMark() &&
            ((this.firstName==null && other.getFirstName()==null) || 
             (this.firstName!=null &&
              this.firstName.equals(other.getFirstName()))) &&
            ((this.lastName==null && other.getLastName()==null) || 
             (this.lastName!=null &&
              this.lastName.equals(other.getLastName()))) &&
            ((this.moteurDescription==null && other.getMoteurDescription()==null) || 
             (this.moteurDescription!=null &&
              this.moteurDescription.equals(other.getMoteurDescription()))) &&
            this.moteurMark == other.getMoteurMark() &&
            ((this.roueDescription==null && other.getRoueDescription()==null) || 
             (this.roueDescription!=null &&
              this.roueDescription.equals(other.getRoueDescription()))) &&
            this.roueMark == other.getRoueMark();
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
        if (getCarroserieDescription() != null) {
            _hashCode += getCarroserieDescription().hashCode();
        }
        _hashCode += getCarroserieMark();
        if (getFirstName() != null) {
            _hashCode += getFirstName().hashCode();
        }
        if (getLastName() != null) {
            _hashCode += getLastName().hashCode();
        }
        if (getMoteurDescription() != null) {
            _hashCode += getMoteurDescription().hashCode();
        }
        _hashCode += getMoteurMark();
        if (getRoueDescription() != null) {
            _hashCode += getRoueDescription().hashCode();
        }
        _hashCode += getRoueMark();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObservationSquelleton.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://buy", "ObservationSquelleton"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("carroserieDescription");
        elemField.setXmlName(new javax.xml.namespace.QName("http://buy", "carroserieDescription"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("carroserieMark");
        elemField.setXmlName(new javax.xml.namespace.QName("http://buy", "carroserieMark"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("firstName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://buy", "firstName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lastName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://buy", "lastName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("moteurDescription");
        elemField.setXmlName(new javax.xml.namespace.QName("http://buy", "moteurDescription"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("moteurMark");
        elemField.setXmlName(new javax.xml.namespace.QName("http://buy", "moteurMark"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("roueDescription");
        elemField.setXmlName(new javax.xml.namespace.QName("http://buy", "roueDescription"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("roueMark");
        elemField.setXmlName(new javax.xml.namespace.QName("http://buy", "roueMark"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
