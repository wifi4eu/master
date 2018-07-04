
package eu.europa.ec.research.fp.model.document.v5;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
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
 * <p>Java class for MetaDataValueType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MetaDataValueType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="String" type="{http://ec.europa.eu/research/fp/model/document/V5}StringType"/>
 *         &lt;element name="Date" type="{http://ec.europa.eu/research/fp/model/document/V5}DateTimeType"/>
 *         &lt;element name="Boolean" type="{http://ec.europa.eu/research/fp/model/document/V5}BooleanType"/>
 *         &lt;element name="Integer" type="{http://ec.europa.eu/research/fp/model/document/V5}IntegerType"/>
 *         &lt;element name="Decimal" type="{http://ec.europa.eu/research/fp/model/document/V5}DecimalType"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MetaDataValueType", propOrder = {
    "string",
    "date",
    "_boolean",
    "integer",
    "decimal"
})
public class MetaDataValueType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "String")
    protected StringType string;
    @XmlElement(name = "Date")
    protected DateTimeType date;
    @XmlElement(name = "Boolean")
    protected BooleanType _boolean;
    @XmlElement(name = "Integer")
    protected IntegerType integer;
    @XmlElement(name = "Decimal")
    protected DecimalType decimal;

    /**
     * Gets the value of the string property.
     * 
     * @return
     *     possible object is
     *     {@link StringType }
     *     
     */
    public StringType getString() {
        return string;
    }

    /**
     * Sets the value of the string property.
     * 
     * @param value
     *     allowed object is
     *     {@link StringType }
     *     
     */
    public void setString(StringType value) {
        this.string = value;
    }

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link DateTimeType }
     *     
     */
    public DateTimeType getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateTimeType }
     *     
     */
    public void setDate(DateTimeType value) {
        this.date = value;
    }

    /**
     * Gets the value of the boolean property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getBoolean() {
        return _boolean;
    }

    /**
     * Sets the value of the boolean property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setBoolean(BooleanType value) {
        this._boolean = value;
    }

    /**
     * Gets the value of the integer property.
     * 
     * @return
     *     possible object is
     *     {@link IntegerType }
     *     
     */
    public IntegerType getInteger() {
        return integer;
    }

    /**
     * Sets the value of the integer property.
     * 
     * @param value
     *     allowed object is
     *     {@link IntegerType }
     *     
     */
    public void setInteger(IntegerType value) {
        this.integer = value;
    }

    /**
     * Gets the value of the decimal property.
     * 
     * @return
     *     possible object is
     *     {@link DecimalType }
     *     
     */
    public DecimalType getDecimal() {
        return decimal;
    }

    /**
     * Sets the value of the decimal property.
     * 
     * @param value
     *     allowed object is
     *     {@link DecimalType }
     *     
     */
    public void setDecimal(DecimalType value) {
        this.decimal = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof MetaDataValueType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final MetaDataValueType that = ((MetaDataValueType) object);
        {
            StringType lhsString;
            lhsString = this.getString();
            StringType rhsString;
            rhsString = that.getString();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "string", lhsString), LocatorUtils.property(thatLocator, "string", rhsString), lhsString, rhsString)) {
                return false;
            }
        }
        {
            DateTimeType lhsDate;
            lhsDate = this.getDate();
            DateTimeType rhsDate;
            rhsDate = that.getDate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "date", lhsDate), LocatorUtils.property(thatLocator, "date", rhsDate), lhsDate, rhsDate)) {
                return false;
            }
        }
        {
            BooleanType lhsBoolean;
            lhsBoolean = this.getBoolean();
            BooleanType rhsBoolean;
            rhsBoolean = that.getBoolean();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "_boolean", lhsBoolean), LocatorUtils.property(thatLocator, "_boolean", rhsBoolean), lhsBoolean, rhsBoolean)) {
                return false;
            }
        }
        {
            IntegerType lhsInteger;
            lhsInteger = this.getInteger();
            IntegerType rhsInteger;
            rhsInteger = that.getInteger();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "integer", lhsInteger), LocatorUtils.property(thatLocator, "integer", rhsInteger), lhsInteger, rhsInteger)) {
                return false;
            }
        }
        {
            DecimalType lhsDecimal;
            lhsDecimal = this.getDecimal();
            DecimalType rhsDecimal;
            rhsDecimal = that.getDecimal();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "decimal", lhsDecimal), LocatorUtils.property(thatLocator, "decimal", rhsDecimal), lhsDecimal, rhsDecimal)) {
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
            StringType theString;
            theString = this.getString();
            strategy.appendField(locator, this, "string", buffer, theString);
        }
        {
            DateTimeType theDate;
            theDate = this.getDate();
            strategy.appendField(locator, this, "date", buffer, theDate);
        }
        {
            BooleanType theBoolean;
            theBoolean = this.getBoolean();
            strategy.appendField(locator, this, "_boolean", buffer, theBoolean);
        }
        {
            IntegerType theInteger;
            theInteger = this.getInteger();
            strategy.appendField(locator, this, "integer", buffer, theInteger);
        }
        {
            DecimalType theDecimal;
            theDecimal = this.getDecimal();
            strategy.appendField(locator, this, "decimal", buffer, theDecimal);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            StringType theString;
            theString = this.getString();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "string", theString), currentHashCode, theString);
        }
        {
            DateTimeType theDate;
            theDate = this.getDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "date", theDate), currentHashCode, theDate);
        }
        {
            BooleanType theBoolean;
            theBoolean = this.getBoolean();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "_boolean", theBoolean), currentHashCode, theBoolean);
        }
        {
            IntegerType theInteger;
            theInteger = this.getInteger();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "integer", theInteger), currentHashCode, theInteger);
        }
        {
            DecimalType theDecimal;
            theDecimal = this.getDecimal();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "decimal", theDecimal), currentHashCode, theDecimal);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
