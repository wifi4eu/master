
package generated.hrs.ws.model;

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
 * A task used in a Signatory workflow
 * 
 * <p>Java class for SignatoryTask complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SignatoryTask">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ec.europa.eu/sg/hrs/types}Task">
 *       &lt;sequence>
 *         &lt;element name="code">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="RED"/>
 *               &lt;enumeration value="CONTRIB"/>
 *               &lt;enumeration value="VISA"/>
 *               &lt;enumeration value="SIGN"/>
 *               &lt;enumeration value="EXP"/>
 *               &lt;enumeration value="CF (CBC)"/>
 *               &lt;enumeration value="CF (CDP)"/>
 *               &lt;enumeration value="CF (DAD)"/>
 *               &lt;enumeration value="CF (QP)"/>
 *               &lt;enumeration value="CF (CIS)"/>
 *               &lt;enumeration value="CF (CAB)"/>
 *               &lt;enumeration value="CF (PET)"/>
 *               &lt;enumeration value="CONTR"/>
 *               &lt;enumeration value="VALID"/>
 *               &lt;enumeration value="EMET"/>
 *               &lt;enumeration value="RET"/>
 *               &lt;enumeration value="INFO"/>
 *               &lt;enumeration value="CLASS"/>
 *               &lt;enumeration value="AUT"/>
 *               &lt;enumeration value="SIGNAT"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SignatoryTask", propOrder = {
    "code"
})
public class SignatoryTask
    extends Task
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected String code;

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

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof SignatoryTask)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final SignatoryTask that = ((SignatoryTask) object);
        {
            String lhsCode;
            lhsCode = this.getCode();
            String rhsCode;
            rhsCode = that.getCode();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "code", lhsCode), LocatorUtils.property(thatLocator, "code", rhsCode), lhsCode, rhsCode)) {
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
        super.appendFields(locator, buffer, strategy);
        {
            String theCode;
            theCode = this.getCode();
            strategy.appendField(locator, this, "code", buffer, theCode);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = super.hashCode(locator, strategy);
        {
            String theCode;
            theCode = this.getCode();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "code", theCode), currentHashCode, theCode);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
