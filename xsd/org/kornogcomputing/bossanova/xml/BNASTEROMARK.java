//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.03.08 at 03:18:47 PM CET 
//


package org.kornogcomputing.bossanova.xml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BNASTEROMARK complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BNASTEROMARK">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.kornog-computing.com/bossanova/V1}BNCOMPONENT">
 *       &lt;sequence>
 *         &lt;element name="label" type="{http://www.kornog-computing.com/bossanova/V1}BNLABEL" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BNASTEROMARK", propOrder = {
    "rest"
})
public class BNASTEROMARK
    extends BNCOMPONENT
{

    @XmlElementRef(name = "label", namespace = "http://www.kornog-computing.com/bossanova/V1", type = JAXBElement.class)
    protected List<JAXBElement<BNLABEL>> rest;

    /**
     * Gets the rest of the content model. 
     * 
     * <p>
     * You are getting this "catch-all" property because of the following reason: 
     * The field name "Label" is used by two different parts of a schema. See: 
     * line 58 of file:/home/herve/Workspaces/iktusTrunk/KComponents/xsd/bossanova-1.0.xsd
     * line 10 of file:/home/herve/Workspaces/iktusTrunk/KComponents/xsd/bossanova-1.0.xsd
     * <p>
     * To get rid of this property, apply a property customization to one 
     * of both of the following declarations to change their names: 
     * Gets the value of the rest property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rest property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRest().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link BNLABEL }{@code >}
     * 
     * 
     */
    public List<JAXBElement<BNLABEL>> getRest() {
        if (rest == null) {
            rest = new ArrayList<JAXBElement<BNLABEL>>();
        }
        return this.rest;
    }

}
