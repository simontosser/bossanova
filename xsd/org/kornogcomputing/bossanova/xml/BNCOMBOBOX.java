//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.03.08 at 03:18:47 PM CET 
//


package org.kornogcomputing.bossanova.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BNCOMBOBOX complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BNCOMBOBOX">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.kornog-computing.com/bossanova/V1}BNCOMPONENT">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.kornog-computing.com/bossanova/V1}OBJECTS" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="MANDATORY" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="FIELD" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BNCOMBOBOX", propOrder = {
    "objects"
})
public class BNCOMBOBOX
    extends BNCOMPONENT
{

    @XmlElement(name = "OBJECTS")
    protected OBJECTS objects;
    @XmlAttribute(name = "MANDATORY")
    protected Boolean mandatory;
    @XmlAttribute(name = "FIELD")
    protected String field;

    /**
     * Gets the value of the objects property.
     * 
     * @return
     *     possible object is
     *     {@link OBJECTS }
     *     
     */
    public OBJECTS getOBJECTS() {
        return objects;
    }

    /**
     * Sets the value of the objects property.
     * 
     * @param value
     *     allowed object is
     *     {@link OBJECTS }
     *     
     */
    public void setOBJECTS(OBJECTS value) {
        this.objects = value;
    }

    /**
     * Gets the value of the mandatory property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMANDATORY() {
        return mandatory;
    }

    /**
     * Sets the value of the mandatory property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMANDATORY(Boolean value) {
        this.mandatory = value;
    }

    /**
     * Gets the value of the field property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFIELD() {
        return field;
    }

    /**
     * Sets the value of the field property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFIELD(String value) {
        this.field = value;
    }

}
