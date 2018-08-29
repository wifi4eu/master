
package generated.hrs.ws.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
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
 * <p>Java class for CurrentEntityToAdd complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CurrentEntityToAdd">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="currentEntityId" type="{http://ec.europa.eu/sg/hrs/types}CurrentEntityId"/>
 *         &lt;element name="currentInternalEntitySearchExpression" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="currentExternalEntitySearchExpression" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CurrentEntityToAdd", propOrder = {
    "currentEntityId",
    "currentInternalEntitySearchExpression",
    "currentExternalEntitySearchExpression"
})
@XmlSeeAlso({
    RecipientToAdd.class
})
public class CurrentEntityToAdd
    implements Equals, HashCode, ToString
{

    protected String currentEntityId;
    protected String currentInternalEntitySearchExpression;
    protected String currentExternalEntitySearchExpression;

    /**
     * Gets the value of the currentEntityId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrentEntityId() {
        return currentEntityId;
    }

    /**
     * Sets the value of the currentEntityId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrentEntityId(String value) {
        this.currentEntityId = value;
    }

    /**
     * Gets the value of the currentInternalEntitySearchExpression property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrentInternalEntitySearchExpression() {
        return currentInternalEntitySearchExpression;
    }

    /**
     * Sets the value of the currentInternalEntitySearchExpression property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrentInternalEntitySearchExpression(String value) {
        this.currentInternalEntitySearchExpression = value;
    }

    /**
     * Gets the value of the currentExternalEntitySearchExpression property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrentExternalEntitySearchExpression() {
        return currentExternalEntitySearchExpression;
    }

    /**
     * Sets the value of the currentExternalEntitySearchExpression property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrentExternalEntitySearchExpression(String value) {
        this.currentExternalEntitySearchExpression = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof CurrentEntityToAdd)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final CurrentEntityToAdd that = ((CurrentEntityToAdd) object);
        {
            String lhsCurrentEntityId;
            lhsCurrentEntityId = this.getCurrentEntityId();
            String rhsCurrentEntityId;
            rhsCurrentEntityId = that.getCurrentEntityId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "currentEntityId", lhsCurrentEntityId), LocatorUtils.property(thatLocator, "currentEntityId", rhsCurrentEntityId), lhsCurrentEntityId, rhsCurrentEntityId)) {
                return false;
            }
        }
        {
            String lhsCurrentInternalEntitySearchExpression;
            lhsCurrentInternalEntitySearchExpression = this.getCurrentInternalEntitySearchExpression();
            String rhsCurrentInternalEntitySearchExpression;
            rhsCurrentInternalEntitySearchExpression = that.getCurrentInternalEntitySearchExpression();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "currentInternalEntitySearchExpression", lhsCurrentInternalEntitySearchExpression), LocatorUtils.property(thatLocator, "currentInternalEntitySearchExpression", rhsCurrentInternalEntitySearchExpression), lhsCurrentInternalEntitySearchExpression, rhsCurrentInternalEntitySearchExpression)) {
                return false;
            }
        }
        {
            String lhsCurrentExternalEntitySearchExpression;
            lhsCurrentExternalEntitySearchExpression = this.getCurrentExternalEntitySearchExpression();
            String rhsCurrentExternalEntitySearchExpression;
            rhsCurrentExternalEntitySearchExpression = that.getCurrentExternalEntitySearchExpression();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "currentExternalEntitySearchExpression", lhsCurrentExternalEntitySearchExpression), LocatorUtils.property(thatLocator, "currentExternalEntitySearchExpression", rhsCurrentExternalEntitySearchExpression), lhsCurrentExternalEntitySearchExpression, rhsCurrentExternalEntitySearchExpression)) {
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
            String theCurrentEntityId;
            theCurrentEntityId = this.getCurrentEntityId();
            strategy.appendField(locator, this, "currentEntityId", buffer, theCurrentEntityId);
        }
        {
            String theCurrentInternalEntitySearchExpression;
            theCurrentInternalEntitySearchExpression = this.getCurrentInternalEntitySearchExpression();
            strategy.appendField(locator, this, "currentInternalEntitySearchExpression", buffer, theCurrentInternalEntitySearchExpression);
        }
        {
            String theCurrentExternalEntitySearchExpression;
            theCurrentExternalEntitySearchExpression = this.getCurrentExternalEntitySearchExpression();
            strategy.appendField(locator, this, "currentExternalEntitySearchExpression", buffer, theCurrentExternalEntitySearchExpression);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String theCurrentEntityId;
            theCurrentEntityId = this.getCurrentEntityId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "currentEntityId", theCurrentEntityId), currentHashCode, theCurrentEntityId);
        }
        {
            String theCurrentInternalEntitySearchExpression;
            theCurrentInternalEntitySearchExpression = this.getCurrentInternalEntitySearchExpression();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "currentInternalEntitySearchExpression", theCurrentInternalEntitySearchExpression), currentHashCode, theCurrentInternalEntitySearchExpression);
        }
        {
            String theCurrentExternalEntitySearchExpression;
            theCurrentExternalEntitySearchExpression = this.getCurrentExternalEntitySearchExpression();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "currentExternalEntitySearchExpression", theCurrentExternalEntitySearchExpression), currentHashCode, theCurrentExternalEntitySearchExpression);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
