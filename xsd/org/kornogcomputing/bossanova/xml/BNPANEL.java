//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.03.08 at 03:18:47 PM CET 
//


package org.kornogcomputing.bossanova.xml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.kornog-computing.com/bossanova/V1}COLONNE" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="BNLEVEL" type="{http://www.kornog-computing.com/bossanova/V1}level" />
 *       &lt;attribute name="READONLY" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="TITLE" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "colonne"
})
@XmlRootElement(name = "BNPANEL")
public class BNPANEL {

    @XmlElement(name = "COLONNE")
    protected List<COLONNE> colonne;
    @XmlAttribute(name = "BNLEVEL")
    protected String bnlevel;
    @XmlAttribute(name = "READONLY")
    protected Boolean readonly;
    @XmlAttribute(name = "TITLE")
    protected String title;

    /**
     * Gets the value of the colonne property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the colonne property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCOLONNE().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link COLONNE }
     * 
     * 
     */
    public List<COLONNE> getCOLONNE() {
        if (colonne == null) {
            colonne = new ArrayList<COLONNE>();
        }
        return this.colonne;
    }

    /**
     * Gets the value of the bnlevel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBNLEVEL() {
        return bnlevel;
    }

    /**
     * Sets the value of the bnlevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBNLEVEL(String value) {
        this.bnlevel = value;
    }

    /**
     * Gets the value of the readonly property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isREADONLY() {
        return readonly;
    }

    /**
     * Sets the value of the readonly property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setREADONLY(Boolean value) {
        this.readonly = value;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTITLE() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTITLE(String value) {
        this.title = value;
    }

}
