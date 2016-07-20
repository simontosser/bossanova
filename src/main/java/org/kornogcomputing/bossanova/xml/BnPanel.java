//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.02.28 at 09:24:51 AM CET 
//


package org.kornogcomputing.bossanova.xml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 *     &lt;extension base="{http://www.kornog-computing.com/bossanova/V1}bnComponent">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.kornog-computing.com/bossanova/V1}row" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="readOnly" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="title" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="bean" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="langage" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "row"
})
@XmlRootElement(name = "bnPanel")
public class BnPanel
    extends BnComponent
{

    protected List<Row> row;
    @XmlAttribute(name = "readOnly")
    protected Boolean readOnly;
    @XmlAttribute(name = "title")
    protected String title;
    @XmlAttribute(name = "bean")
    protected String bean;
    @XmlAttribute(name = "langage")
    protected String langage;

    /**
     * Gets the value of the row property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the row property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRow().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Row }
     * 
     * 
     */
    public List<Row> getRow() {
        if (row == null) {
            row = new ArrayList<Row>();
        }
        return this.row;
    }

    /**
     * Gets the value of the readOnly property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isReadOnly() {
        return readOnly;
    }

    /**
     * Sets the value of the readOnly property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setReadOnly(Boolean value) {
        this.readOnly = value;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
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
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the bean property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBean() {
        return bean;
    }

    /**
     * Sets the value of the bean property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBean(String value) {
        this.bean = value;
    }

    /**
     * Gets the value of the langage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLangage() {
        return langage;
    }

    /**
     * Sets the value of the langage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLangage(String value) {
        this.langage = value;
    }

}
