
package generated.hrs.ws.model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import org.jvnet.jaxb2_commons.lang.Equals;
import org.jvnet.jaxb2_commons.lang.EqualsStrategy;
import org.jvnet.jaxb2_commons.lang.HashCode;
import org.jvnet.jaxb2_commons.lang.HashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBEqualsStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBHashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;
import org.jvnet.jaxb2_commons.locator.util.LocatorUtils;


/**
 * <p>Java class for SpecificMetadata complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SpecificMetadata">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="namespace" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *         &lt;element name="string1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="string2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="string3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="string4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="string5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="string6" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="string7" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="date1" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="date2" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="date3" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="double1" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="double2" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="double3" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="boolean1" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="boolean2" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="boolean3" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SpecificMetadata", propOrder = {
    "namespace",
    "string1",
    "string2",
    "string3",
    "string4",
    "string5",
    "string6",
    "string7",
    "date1",
    "date2",
    "date3",
    "double1",
    "double2",
    "double3",
    "boolean1",
    "boolean2",
    "boolean3"
})
public class SpecificMetadata
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    @XmlSchemaType(name = "anyURI")
    protected String namespace;
    @XmlElementRef(name = "string1", namespace = "http://ec.europa.eu/sg/hrs/types", type = JAXBElement.class)
    protected JAXBElement<String> string1;
    @XmlElementRef(name = "string2", namespace = "http://ec.europa.eu/sg/hrs/types", type = JAXBElement.class)
    protected JAXBElement<String> string2;
    @XmlElementRef(name = "string3", namespace = "http://ec.europa.eu/sg/hrs/types", type = JAXBElement.class)
    protected JAXBElement<String> string3;
    @XmlElementRef(name = "string4", namespace = "http://ec.europa.eu/sg/hrs/types", type = JAXBElement.class)
    protected JAXBElement<String> string4;
    @XmlElementRef(name = "string5", namespace = "http://ec.europa.eu/sg/hrs/types", type = JAXBElement.class)
    protected JAXBElement<String> string5;
    @XmlElementRef(name = "string6", namespace = "http://ec.europa.eu/sg/hrs/types", type = JAXBElement.class)
    protected JAXBElement<String> string6;
    @XmlElementRef(name = "string7", namespace = "http://ec.europa.eu/sg/hrs/types", type = JAXBElement.class)
    protected JAXBElement<String> string7;
    @XmlElementRef(name = "date1", namespace = "http://ec.europa.eu/sg/hrs/types", type = JAXBElement.class)
    protected JAXBElement<XMLGregorianCalendar> date1;
    @XmlElementRef(name = "date2", namespace = "http://ec.europa.eu/sg/hrs/types", type = JAXBElement.class)
    protected JAXBElement<XMLGregorianCalendar> date2;
    @XmlElementRef(name = "date3", namespace = "http://ec.europa.eu/sg/hrs/types", type = JAXBElement.class)
    protected JAXBElement<XMLGregorianCalendar> date3;
    @XmlElementRef(name = "double1", namespace = "http://ec.europa.eu/sg/hrs/types", type = JAXBElement.class)
    protected JAXBElement<Double> double1;
    @XmlElementRef(name = "double2", namespace = "http://ec.europa.eu/sg/hrs/types", type = JAXBElement.class)
    protected JAXBElement<Double> double2;
    @XmlElementRef(name = "double3", namespace = "http://ec.europa.eu/sg/hrs/types", type = JAXBElement.class)
    protected JAXBElement<Double> double3;
    @XmlElementRef(name = "boolean1", namespace = "http://ec.europa.eu/sg/hrs/types", type = JAXBElement.class)
    protected JAXBElement<Boolean> boolean1;
    @XmlElementRef(name = "boolean2", namespace = "http://ec.europa.eu/sg/hrs/types", type = JAXBElement.class)
    protected JAXBElement<Boolean> boolean2;
    @XmlElementRef(name = "boolean3", namespace = "http://ec.europa.eu/sg/hrs/types", type = JAXBElement.class)
    protected JAXBElement<Boolean> boolean3;

    /**
     * Gets the value of the namespace property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNamespace() {
        return namespace;
    }

    /**
     * Sets the value of the namespace property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNamespace(String value) {
        this.namespace = value;
    }

    /**
     * Gets the value of the string1 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getString1() {
        return string1;
    }

    /**
     * Sets the value of the string1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setString1(JAXBElement<String> value) {
        this.string1 = value;
    }

    /**
     * Gets the value of the string2 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getString2() {
        return string2;
    }

    /**
     * Sets the value of the string2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setString2(JAXBElement<String> value) {
        this.string2 = value;
    }

    /**
     * Gets the value of the string3 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getString3() {
        return string3;
    }

    /**
     * Sets the value of the string3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setString3(JAXBElement<String> value) {
        this.string3 = value;
    }

    /**
     * Gets the value of the string4 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getString4() {
        return string4;
    }

    /**
     * Sets the value of the string4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setString4(JAXBElement<String> value) {
        this.string4 = value;
    }

    /**
     * Gets the value of the string5 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getString5() {
        return string5;
    }

    /**
     * Sets the value of the string5 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setString5(JAXBElement<String> value) {
        this.string5 = value;
    }

    /**
     * Gets the value of the string6 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getString6() {
        return string6;
    }

    /**
     * Sets the value of the string6 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setString6(JAXBElement<String> value) {
        this.string6 = value;
    }

    /**
     * Gets the value of the string7 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getString7() {
        return string7;
    }

    /**
     * Sets the value of the string7 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setString7(JAXBElement<String> value) {
        this.string7 = value;
    }

    /**
     * Gets the value of the date1 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getDate1() {
        return date1;
    }

    /**
     * Sets the value of the date1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setDate1(JAXBElement<XMLGregorianCalendar> value) {
        this.date1 = value;
    }

    /**
     * Gets the value of the date2 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getDate2() {
        return date2;
    }

    /**
     * Sets the value of the date2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setDate2(JAXBElement<XMLGregorianCalendar> value) {
        this.date2 = value;
    }

    /**
     * Gets the value of the date3 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getDate3() {
        return date3;
    }

    /**
     * Sets the value of the date3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setDate3(JAXBElement<XMLGregorianCalendar> value) {
        this.date3 = value;
    }

    /**
     * Gets the value of the double1 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public JAXBElement<Double> getDouble1() {
        return double1;
    }

    /**
     * Sets the value of the double1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public void setDouble1(JAXBElement<Double> value) {
        this.double1 = value;
    }

    /**
     * Gets the value of the double2 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public JAXBElement<Double> getDouble2() {
        return double2;
    }

    /**
     * Sets the value of the double2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public void setDouble2(JAXBElement<Double> value) {
        this.double2 = value;
    }

    /**
     * Gets the value of the double3 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public JAXBElement<Double> getDouble3() {
        return double3;
    }

    /**
     * Sets the value of the double3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public void setDouble3(JAXBElement<Double> value) {
        this.double3 = value;
    }

    /**
     * Gets the value of the boolean1 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getBoolean1() {
        return boolean1;
    }

    /**
     * Sets the value of the boolean1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setBoolean1(JAXBElement<Boolean> value) {
        this.boolean1 = value;
    }

    /**
     * Gets the value of the boolean2 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getBoolean2() {
        return boolean2;
    }

    /**
     * Sets the value of the boolean2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setBoolean2(JAXBElement<Boolean> value) {
        this.boolean2 = value;
    }

    /**
     * Gets the value of the boolean3 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getBoolean3() {
        return boolean3;
    }

    /**
     * Sets the value of the boolean3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setBoolean3(JAXBElement<Boolean> value) {
        this.boolean3 = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof SpecificMetadata)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final SpecificMetadata that = ((SpecificMetadata) object);
        {
            String lhsNamespace;
            lhsNamespace = this.getNamespace();
            String rhsNamespace;
            rhsNamespace = that.getNamespace();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "namespace", lhsNamespace), LocatorUtils.property(thatLocator, "namespace", rhsNamespace), lhsNamespace, rhsNamespace)) {
                return false;
            }
        }
        {
            JAXBElement<String> lhsString1;
            lhsString1 = this.getString1();
            JAXBElement<String> rhsString1;
            rhsString1 = that.getString1();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "string1", lhsString1), LocatorUtils.property(thatLocator, "string1", rhsString1), lhsString1, rhsString1)) {
                return false;
            }
        }
        {
            JAXBElement<String> lhsString2;
            lhsString2 = this.getString2();
            JAXBElement<String> rhsString2;
            rhsString2 = that.getString2();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "string2", lhsString2), LocatorUtils.property(thatLocator, "string2", rhsString2), lhsString2, rhsString2)) {
                return false;
            }
        }
        {
            JAXBElement<String> lhsString3;
            lhsString3 = this.getString3();
            JAXBElement<String> rhsString3;
            rhsString3 = that.getString3();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "string3", lhsString3), LocatorUtils.property(thatLocator, "string3", rhsString3), lhsString3, rhsString3)) {
                return false;
            }
        }
        {
            JAXBElement<String> lhsString4;
            lhsString4 = this.getString4();
            JAXBElement<String> rhsString4;
            rhsString4 = that.getString4();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "string4", lhsString4), LocatorUtils.property(thatLocator, "string4", rhsString4), lhsString4, rhsString4)) {
                return false;
            }
        }
        {
            JAXBElement<String> lhsString5;
            lhsString5 = this.getString5();
            JAXBElement<String> rhsString5;
            rhsString5 = that.getString5();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "string5", lhsString5), LocatorUtils.property(thatLocator, "string5", rhsString5), lhsString5, rhsString5)) {
                return false;
            }
        }
        {
            JAXBElement<String> lhsString6;
            lhsString6 = this.getString6();
            JAXBElement<String> rhsString6;
            rhsString6 = that.getString6();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "string6", lhsString6), LocatorUtils.property(thatLocator, "string6", rhsString6), lhsString6, rhsString6)) {
                return false;
            }
        }
        {
            JAXBElement<String> lhsString7;
            lhsString7 = this.getString7();
            JAXBElement<String> rhsString7;
            rhsString7 = that.getString7();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "string7", lhsString7), LocatorUtils.property(thatLocator, "string7", rhsString7), lhsString7, rhsString7)) {
                return false;
            }
        }
        {
            JAXBElement<XMLGregorianCalendar> lhsDate1;
            lhsDate1 = this.getDate1();
            JAXBElement<XMLGregorianCalendar> rhsDate1;
            rhsDate1 = that.getDate1();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "date1", lhsDate1), LocatorUtils.property(thatLocator, "date1", rhsDate1), lhsDate1, rhsDate1)) {
                return false;
            }
        }
        {
            JAXBElement<XMLGregorianCalendar> lhsDate2;
            lhsDate2 = this.getDate2();
            JAXBElement<XMLGregorianCalendar> rhsDate2;
            rhsDate2 = that.getDate2();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "date2", lhsDate2), LocatorUtils.property(thatLocator, "date2", rhsDate2), lhsDate2, rhsDate2)) {
                return false;
            }
        }
        {
            JAXBElement<XMLGregorianCalendar> lhsDate3;
            lhsDate3 = this.getDate3();
            JAXBElement<XMLGregorianCalendar> rhsDate3;
            rhsDate3 = that.getDate3();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "date3", lhsDate3), LocatorUtils.property(thatLocator, "date3", rhsDate3), lhsDate3, rhsDate3)) {
                return false;
            }
        }
        {
            JAXBElement<Double> lhsDouble1;
            lhsDouble1 = this.getDouble1();
            JAXBElement<Double> rhsDouble1;
            rhsDouble1 = that.getDouble1();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "double1", lhsDouble1), LocatorUtils.property(thatLocator, "double1", rhsDouble1), lhsDouble1, rhsDouble1)) {
                return false;
            }
        }
        {
            JAXBElement<Double> lhsDouble2;
            lhsDouble2 = this.getDouble2();
            JAXBElement<Double> rhsDouble2;
            rhsDouble2 = that.getDouble2();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "double2", lhsDouble2), LocatorUtils.property(thatLocator, "double2", rhsDouble2), lhsDouble2, rhsDouble2)) {
                return false;
            }
        }
        {
            JAXBElement<Double> lhsDouble3;
            lhsDouble3 = this.getDouble3();
            JAXBElement<Double> rhsDouble3;
            rhsDouble3 = that.getDouble3();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "double3", lhsDouble3), LocatorUtils.property(thatLocator, "double3", rhsDouble3), lhsDouble3, rhsDouble3)) {
                return false;
            }
        }
        {
            JAXBElement<Boolean> lhsBoolean1;
            lhsBoolean1 = this.getBoolean1();
            JAXBElement<Boolean> rhsBoolean1;
            rhsBoolean1 = that.getBoolean1();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "boolean1", lhsBoolean1), LocatorUtils.property(thatLocator, "boolean1", rhsBoolean1), lhsBoolean1, rhsBoolean1)) {
                return false;
            }
        }
        {
            JAXBElement<Boolean> lhsBoolean2;
            lhsBoolean2 = this.getBoolean2();
            JAXBElement<Boolean> rhsBoolean2;
            rhsBoolean2 = that.getBoolean2();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "boolean2", lhsBoolean2), LocatorUtils.property(thatLocator, "boolean2", rhsBoolean2), lhsBoolean2, rhsBoolean2)) {
                return false;
            }
        }
        {
            JAXBElement<Boolean> lhsBoolean3;
            lhsBoolean3 = this.getBoolean3();
            JAXBElement<Boolean> rhsBoolean3;
            rhsBoolean3 = that.getBoolean3();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "boolean3", lhsBoolean3), LocatorUtils.property(thatLocator, "boolean3", rhsBoolean3), lhsBoolean3, rhsBoolean3)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object object) {
        final EqualsStrategy strategy = JAXBEqualsStrategy.INSTANCE;
        return equals(null, null, object, strategy);
    }

    public String toString() {
        final ToStringStrategy strategy = JAXBToStringStrategy.INSTANCE;
        final StringBuilder buffer = new StringBuilder();
        append(null, buffer, strategy);
        return buffer.toString();
    }

    public StringBuilder append(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
        strategy.appendStart(locator, this, buffer);
        appendFields(locator, buffer, strategy);
        strategy.appendEnd(locator, this, buffer);
        return buffer;
    }

    public StringBuilder appendFields(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
        {
            String theNamespace;
            theNamespace = this.getNamespace();
            strategy.appendField(locator, this, "namespace", buffer, theNamespace);
        }
        {
            JAXBElement<String> theString1;
            theString1 = this.getString1();
            strategy.appendField(locator, this, "string1", buffer, theString1);
        }
        {
            JAXBElement<String> theString2;
            theString2 = this.getString2();
            strategy.appendField(locator, this, "string2", buffer, theString2);
        }
        {
            JAXBElement<String> theString3;
            theString3 = this.getString3();
            strategy.appendField(locator, this, "string3", buffer, theString3);
        }
        {
            JAXBElement<String> theString4;
            theString4 = this.getString4();
            strategy.appendField(locator, this, "string4", buffer, theString4);
        }
        {
            JAXBElement<String> theString5;
            theString5 = this.getString5();
            strategy.appendField(locator, this, "string5", buffer, theString5);
        }
        {
            JAXBElement<String> theString6;
            theString6 = this.getString6();
            strategy.appendField(locator, this, "string6", buffer, theString6);
        }
        {
            JAXBElement<String> theString7;
            theString7 = this.getString7();
            strategy.appendField(locator, this, "string7", buffer, theString7);
        }
        {
            JAXBElement<XMLGregorianCalendar> theDate1;
            theDate1 = this.getDate1();
            strategy.appendField(locator, this, "date1", buffer, theDate1);
        }
        {
            JAXBElement<XMLGregorianCalendar> theDate2;
            theDate2 = this.getDate2();
            strategy.appendField(locator, this, "date2", buffer, theDate2);
        }
        {
            JAXBElement<XMLGregorianCalendar> theDate3;
            theDate3 = this.getDate3();
            strategy.appendField(locator, this, "date3", buffer, theDate3);
        }
        {
            JAXBElement<Double> theDouble1;
            theDouble1 = this.getDouble1();
            strategy.appendField(locator, this, "double1", buffer, theDouble1);
        }
        {
            JAXBElement<Double> theDouble2;
            theDouble2 = this.getDouble2();
            strategy.appendField(locator, this, "double2", buffer, theDouble2);
        }
        {
            JAXBElement<Double> theDouble3;
            theDouble3 = this.getDouble3();
            strategy.appendField(locator, this, "double3", buffer, theDouble3);
        }
        {
            JAXBElement<Boolean> theBoolean1;
            theBoolean1 = this.getBoolean1();
            strategy.appendField(locator, this, "boolean1", buffer, theBoolean1);
        }
        {
            JAXBElement<Boolean> theBoolean2;
            theBoolean2 = this.getBoolean2();
            strategy.appendField(locator, this, "boolean2", buffer, theBoolean2);
        }
        {
            JAXBElement<Boolean> theBoolean3;
            theBoolean3 = this.getBoolean3();
            strategy.appendField(locator, this, "boolean3", buffer, theBoolean3);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String theNamespace;
            theNamespace = this.getNamespace();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "namespace", theNamespace), currentHashCode, theNamespace);
        }
        {
            JAXBElement<String> theString1;
            theString1 = this.getString1();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "string1", theString1), currentHashCode, theString1);
        }
        {
            JAXBElement<String> theString2;
            theString2 = this.getString2();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "string2", theString2), currentHashCode, theString2);
        }
        {
            JAXBElement<String> theString3;
            theString3 = this.getString3();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "string3", theString3), currentHashCode, theString3);
        }
        {
            JAXBElement<String> theString4;
            theString4 = this.getString4();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "string4", theString4), currentHashCode, theString4);
        }
        {
            JAXBElement<String> theString5;
            theString5 = this.getString5();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "string5", theString5), currentHashCode, theString5);
        }
        {
            JAXBElement<String> theString6;
            theString6 = this.getString6();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "string6", theString6), currentHashCode, theString6);
        }
        {
            JAXBElement<String> theString7;
            theString7 = this.getString7();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "string7", theString7), currentHashCode, theString7);
        }
        {
            JAXBElement<XMLGregorianCalendar> theDate1;
            theDate1 = this.getDate1();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "date1", theDate1), currentHashCode, theDate1);
        }
        {
            JAXBElement<XMLGregorianCalendar> theDate2;
            theDate2 = this.getDate2();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "date2", theDate2), currentHashCode, theDate2);
        }
        {
            JAXBElement<XMLGregorianCalendar> theDate3;
            theDate3 = this.getDate3();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "date3", theDate3), currentHashCode, theDate3);
        }
        {
            JAXBElement<Double> theDouble1;
            theDouble1 = this.getDouble1();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "double1", theDouble1), currentHashCode, theDouble1);
        }
        {
            JAXBElement<Double> theDouble2;
            theDouble2 = this.getDouble2();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "double2", theDouble2), currentHashCode, theDouble2);
        }
        {
            JAXBElement<Double> theDouble3;
            theDouble3 = this.getDouble3();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "double3", theDouble3), currentHashCode, theDouble3);
        }
        {
            JAXBElement<Boolean> theBoolean1;
            theBoolean1 = this.getBoolean1();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "boolean1", theBoolean1), currentHashCode, theBoolean1);
        }
        {
            JAXBElement<Boolean> theBoolean2;
            theBoolean2 = this.getBoolean2();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "boolean2", theBoolean2), currentHashCode, theBoolean2);
        }
        {
            JAXBElement<Boolean> theBoolean3;
            theBoolean3 = this.getBoolean3();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "boolean3", theBoolean3), currentHashCode, theBoolean3);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
