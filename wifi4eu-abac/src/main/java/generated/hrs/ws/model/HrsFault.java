
package generated.hrs.ws.model;

import java.util.ArrayList;
import java.util.List;
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
 * <p>Java class for HrsFault complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HrsFault">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="code">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="HRS_INTERNAL_FAULT"/>
 *               &lt;enumeration value="HRS_NO_OBJECT_FAULT"/>
 *               &lt;enumeration value="HRS_LOCK_FAULT"/>
 *               &lt;enumeration value="HRS_PERMISSION_FAULT"/>
 *               &lt;enumeration value="HRS_BUSINESS_FAULT"/>
 *               &lt;enumeration value="HRS_CONCURRENT_MODIFICATION_FAULT"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="key" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="stackTrace" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="line" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HrsFault", propOrder = {
    "id",
    "code",
    "key",
    "stackTrace"
})
public class HrsFault
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected String id;
    @XmlElement(required = true)
    protected String code;
    protected String key;
    protected HrsFault.StackTrace stackTrace;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Gets the value of the key property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKey() {
        return key;
    }

    /**
     * Sets the value of the key property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKey(String value) {
        this.key = value;
    }

    /**
     * Gets the value of the stackTrace property.
     * 
     * @return
     *     possible object is
     *     {@link HrsFault.StackTrace }
     *     
     */
    public HrsFault.StackTrace getStackTrace() {
        return stackTrace;
    }

    /**
     * Sets the value of the stackTrace property.
     * 
     * @param value
     *     allowed object is
     *     {@link HrsFault.StackTrace }
     *     
     */
    public void setStackTrace(HrsFault.StackTrace value) {
        this.stackTrace = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof HrsFault)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final HrsFault that = ((HrsFault) object);
        {
            String lhsId;
            lhsId = this.getId();
            String rhsId;
            rhsId = that.getId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "id", lhsId), LocatorUtils.property(thatLocator, "id", rhsId), lhsId, rhsId)) {
                return false;
            }
        }
        {
            String lhsCode;
            lhsCode = this.getCode();
            String rhsCode;
            rhsCode = that.getCode();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "code", lhsCode), LocatorUtils.property(thatLocator, "code", rhsCode), lhsCode, rhsCode)) {
                return false;
            }
        }
        {
            String lhsKey;
            lhsKey = this.getKey();
            String rhsKey;
            rhsKey = that.getKey();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "key", lhsKey), LocatorUtils.property(thatLocator, "key", rhsKey), lhsKey, rhsKey)) {
                return false;
            }
        }
        {
            HrsFault.StackTrace lhsStackTrace;
            lhsStackTrace = this.getStackTrace();
            HrsFault.StackTrace rhsStackTrace;
            rhsStackTrace = that.getStackTrace();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "stackTrace", lhsStackTrace), LocatorUtils.property(thatLocator, "stackTrace", rhsStackTrace), lhsStackTrace, rhsStackTrace)) {
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
            String theId;
            theId = this.getId();
            strategy.appendField(locator, this, "id", buffer, theId);
        }
        {
            String theCode;
            theCode = this.getCode();
            strategy.appendField(locator, this, "code", buffer, theCode);
        }
        {
            String theKey;
            theKey = this.getKey();
            strategy.appendField(locator, this, "key", buffer, theKey);
        }
        {
            HrsFault.StackTrace theStackTrace;
            theStackTrace = this.getStackTrace();
            strategy.appendField(locator, this, "stackTrace", buffer, theStackTrace);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String theId;
            theId = this.getId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "id", theId), currentHashCode, theId);
        }
        {
            String theCode;
            theCode = this.getCode();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "code", theCode), currentHashCode, theCode);
        }
        {
            String theKey;
            theKey = this.getKey();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "key", theKey), currentHashCode, theKey);
        }
        {
            HrsFault.StackTrace theStackTrace;
            theStackTrace = this.getStackTrace();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "stackTrace", theStackTrace), currentHashCode, theStackTrace);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }


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
     *         &lt;element name="line" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "line"
    })
    public static class StackTrace
        implements Equals, HashCode, ToString
    {

        protected List<String> line;

        /**
         * Gets the value of the line property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the line property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getLine().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getLine() {
            if (line == null) {
                line = new ArrayList<String>();
            }
            return this.line;
        }

        public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
            if (!(object instanceof HrsFault.StackTrace)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final HrsFault.StackTrace that = ((HrsFault.StackTrace) object);
            {
                List<String> lhsLine;
                lhsLine = (((this.line!= null)&&(!this.line.isEmpty()))?this.getLine():null);
                List<String> rhsLine;
                rhsLine = (((that.line!= null)&&(!that.line.isEmpty()))?that.getLine():null);
                if (!strategy.equals(LocatorUtils.property(thisLocator, "line", lhsLine), LocatorUtils.property(thatLocator, "line", rhsLine), lhsLine, rhsLine)) {
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
                List<String> theLine;
                theLine = (((this.line!= null)&&(!this.line.isEmpty()))?this.getLine():null);
                strategy.appendField(locator, this, "line", buffer, theLine);
            }
            return buffer;
        }

        public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
            int currentHashCode = 1;
            {
                List<String> theLine;
                theLine = (((this.line!= null)&&(!this.line.isEmpty()))?this.getLine():null);
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "line", theLine), currentHashCode, theLine);
            }
            return currentHashCode;
        }

        public int hashCode() {
            final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
            return this.hashCode(null, strategy);
        }

    }

}
