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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BNCOMPONENT complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BNCOMPONENT">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="label" type="{http://www.kornog-computing.com/bossanova/V1}BNLABEL"/>
 *         &lt;element name="buttonBar" type="{http://www.kornog-computing.com/bossanova/V1}BNBUTTONBARPANEL"/>
 *         &lt;element name="checkBox" type="{http://www.kornog-computing.com/bossanova/V1}BNCHECKBOX"/>
 *         &lt;element name="comboBox" type="{http://www.kornog-computing.com/bossanova/V1}BNCOMBOBOX"/>
 *         &lt;element name="textField" type="{http://www.kornog-computing.com/bossanova/V1}BNTEXTFIELD"/>
 *         &lt;element name="scrollPane" type="{http://www.kornog-computing.com/bossanova/V1}BNSCROLLPANE"/>
 *         &lt;element name="separator" type="{http://www.kornog-computing.com/bossanova/V1}BNSEPARATOR"/>
 *         &lt;element name="dateAndTime" type="{http://www.kornog-computing.com/bossanova/V1}BNDATEANDTIME"/>
 *         &lt;element name="lineBreak" type="{http://www.kornog-computing.com/bossanova/V1}BNLINEBREAK"/>
 *       &lt;/choice>
 *       &lt;attribute name="BNLEVEL" type="{http://www.kornog-computing.com/bossanova/V1}level" />
 *       &lt;attribute name="WIDTH" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BNCOMPONENT", propOrder = {
    "label",
    "buttonBar",
    "checkBox",
    "comboBox",
    "textField",
    "scrollPane",
    "separator",
    "dateAndTime",
    "lineBreak"
})
@XmlSeeAlso({
    BNLABEL.class,
    BNBUTTONBARPANEL.class,
    BNCHECKBOX.class,
    BNCOMBOBOX.class,
    BNTEXTFIELD.class,
    BNSCROLLPANE.class,
    BNSEPARATOR.class,
    BNDATEANDTIME.class,
    BNLINEBREAK.class,
    BNASTEROMARK.class,
    BNBUTTON.class
})
public class BNCOMPONENT {

    protected BNLABEL label;
    protected BNBUTTONBARPANEL buttonBar;
    protected BNCHECKBOX checkBox;
    protected BNCOMBOBOX comboBox;
    protected BNTEXTFIELD textField;
    protected BNSCROLLPANE scrollPane;
    protected BNSEPARATOR separator;
    protected BNDATEANDTIME dateAndTime;
    protected BNLINEBREAK lineBreak;
    @XmlAttribute(name = "BNLEVEL")
    protected String bnlevel;
    @XmlAttribute(name = "WIDTH")
    protected Integer width;

    /**
     * Gets the value of the label property.
     * 
     * @return
     *     possible object is
     *     {@link BNLABEL }
     *     
     */
    public BNLABEL getLabel() {
        return label;
    }

    /**
     * Sets the value of the label property.
     * 
     * @param value
     *     allowed object is
     *     {@link BNLABEL }
     *     
     */
    public void setLabel(BNLABEL value) {
        this.label = value;
    }

    /**
     * Gets the value of the buttonBar property.
     * 
     * @return
     *     possible object is
     *     {@link BNBUTTONBARPANEL }
     *     
     */
    public BNBUTTONBARPANEL getButtonBar() {
        return buttonBar;
    }

    /**
     * Sets the value of the buttonBar property.
     * 
     * @param value
     *     allowed object is
     *     {@link BNBUTTONBARPANEL }
     *     
     */
    public void setButtonBar(BNBUTTONBARPANEL value) {
        this.buttonBar = value;
    }

    /**
     * Gets the value of the checkBox property.
     * 
     * @return
     *     possible object is
     *     {@link BNCHECKBOX }
     *     
     */
    public BNCHECKBOX getCheckBox() {
        return checkBox;
    }

    /**
     * Sets the value of the checkBox property.
     * 
     * @param value
     *     allowed object is
     *     {@link BNCHECKBOX }
     *     
     */
    public void setCheckBox(BNCHECKBOX value) {
        this.checkBox = value;
    }

    /**
     * Gets the value of the comboBox property.
     * 
     * @return
     *     possible object is
     *     {@link BNCOMBOBOX }
     *     
     */
    public BNCOMBOBOX getComboBox() {
        return comboBox;
    }

    /**
     * Sets the value of the comboBox property.
     * 
     * @param value
     *     allowed object is
     *     {@link BNCOMBOBOX }
     *     
     */
    public void setComboBox(BNCOMBOBOX value) {
        this.comboBox = value;
    }

    /**
     * Gets the value of the textField property.
     * 
     * @return
     *     possible object is
     *     {@link BNTEXTFIELD }
     *     
     */
    public BNTEXTFIELD getTextField() {
        return textField;
    }

    /**
     * Sets the value of the textField property.
     * 
     * @param value
     *     allowed object is
     *     {@link BNTEXTFIELD }
     *     
     */
    public void setTextField(BNTEXTFIELD value) {
        this.textField = value;
    }

    /**
     * Gets the value of the scrollPane property.
     * 
     * @return
     *     possible object is
     *     {@link BNSCROLLPANE }
     *     
     */
    public BNSCROLLPANE getScrollPane() {
        return scrollPane;
    }

    /**
     * Sets the value of the scrollPane property.
     * 
     * @param value
     *     allowed object is
     *     {@link BNSCROLLPANE }
     *     
     */
    public void setScrollPane(BNSCROLLPANE value) {
        this.scrollPane = value;
    }

    /**
     * Gets the value of the separator property.
     * 
     * @return
     *     possible object is
     *     {@link BNSEPARATOR }
     *     
     */
    public BNSEPARATOR getSeparator() {
        return separator;
    }

    /**
     * Sets the value of the separator property.
     * 
     * @param value
     *     allowed object is
     *     {@link BNSEPARATOR }
     *     
     */
    public void setSeparator(BNSEPARATOR value) {
        this.separator = value;
    }

    /**
     * Gets the value of the dateAndTime property.
     * 
     * @return
     *     possible object is
     *     {@link BNDATEANDTIME }
     *     
     */
    public BNDATEANDTIME getDateAndTime() {
        return dateAndTime;
    }

    /**
     * Sets the value of the dateAndTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link BNDATEANDTIME }
     *     
     */
    public void setDateAndTime(BNDATEANDTIME value) {
        this.dateAndTime = value;
    }

    /**
     * Gets the value of the lineBreak property.
     * 
     * @return
     *     possible object is
     *     {@link BNLINEBREAK }
     *     
     */
    public BNLINEBREAK getLineBreak() {
        return lineBreak;
    }

    /**
     * Sets the value of the lineBreak property.
     * 
     * @param value
     *     allowed object is
     *     {@link BNLINEBREAK }
     *     
     */
    public void setLineBreak(BNLINEBREAK value) {
        this.lineBreak = value;
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
     * Gets the value of the width property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getWIDTH() {
        return width;
    }

    /**
     * Sets the value of the width property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setWIDTH(Integer value) {
        this.width = value;
    }

}
