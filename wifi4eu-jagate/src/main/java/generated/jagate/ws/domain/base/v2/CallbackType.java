
package generated.jagate.ws.domain.base.v2;

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
 * <p>Java class for CallbackType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CallbackType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="JmsCallbackSpec" type="{http://ec.europa.eu/rdg/jagate/ws/domain/base/v2}JmsCallbackSpecType"/>
 *         &lt;element name="EjbCallbackSpec" type="{http://ec.europa.eu/rdg/jagate/ws/domain/base/v2}EjbCallbackSpecType"/>
 *         &lt;element name="WebserviceCallbackSpec" type="{http://ec.europa.eu/rdg/jagate/ws/domain/base/v2}WebServiceCallbackSpecType"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CallbackType", propOrder = {
    "jmsCallbackSpec",
    "ejbCallbackSpec",
    "webserviceCallbackSpec"
})
public class CallbackType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "JmsCallbackSpec")
    protected JmsCallbackSpecType jmsCallbackSpec;
    @XmlElement(name = "EjbCallbackSpec")
    protected EjbCallbackSpecType ejbCallbackSpec;
    @XmlElement(name = "WebserviceCallbackSpec")
    protected WebServiceCallbackSpecType webserviceCallbackSpec;

    /**
     * Gets the value of the jmsCallbackSpec property.
     * 
     * @return
     *     possible object is
     *     {@link JmsCallbackSpecType }
     *     
     */
    public JmsCallbackSpecType getJmsCallbackSpec() {
        return jmsCallbackSpec;
    }

    /**
     * Sets the value of the jmsCallbackSpec property.
     * 
     * @param value
     *     allowed object is
     *     {@link JmsCallbackSpecType }
     *     
     */
    public void setJmsCallbackSpec(JmsCallbackSpecType value) {
        this.jmsCallbackSpec = value;
    }

    /**
     * Gets the value of the ejbCallbackSpec property.
     * 
     * @return
     *     possible object is
     *     {@link EjbCallbackSpecType }
     *     
     */
    public EjbCallbackSpecType getEjbCallbackSpec() {
        return ejbCallbackSpec;
    }

    /**
     * Sets the value of the ejbCallbackSpec property.
     * 
     * @param value
     *     allowed object is
     *     {@link EjbCallbackSpecType }
     *     
     */
    public void setEjbCallbackSpec(EjbCallbackSpecType value) {
        this.ejbCallbackSpec = value;
    }

    /**
     * Gets the value of the webserviceCallbackSpec property.
     * 
     * @return
     *     possible object is
     *     {@link WebServiceCallbackSpecType }
     *     
     */
    public WebServiceCallbackSpecType getWebserviceCallbackSpec() {
        return webserviceCallbackSpec;
    }

    /**
     * Sets the value of the webserviceCallbackSpec property.
     * 
     * @param value
     *     allowed object is
     *     {@link WebServiceCallbackSpecType }
     *     
     */
    public void setWebserviceCallbackSpec(WebServiceCallbackSpecType value) {
        this.webserviceCallbackSpec = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof CallbackType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final CallbackType that = ((CallbackType) object);
        {
            JmsCallbackSpecType lhsJmsCallbackSpec;
            lhsJmsCallbackSpec = this.getJmsCallbackSpec();
            JmsCallbackSpecType rhsJmsCallbackSpec;
            rhsJmsCallbackSpec = that.getJmsCallbackSpec();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "jmsCallbackSpec", lhsJmsCallbackSpec), LocatorUtils.property(thatLocator, "jmsCallbackSpec", rhsJmsCallbackSpec), lhsJmsCallbackSpec, rhsJmsCallbackSpec)) {
                return false;
            }
        }
        {
            EjbCallbackSpecType lhsEjbCallbackSpec;
            lhsEjbCallbackSpec = this.getEjbCallbackSpec();
            EjbCallbackSpecType rhsEjbCallbackSpec;
            rhsEjbCallbackSpec = that.getEjbCallbackSpec();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "ejbCallbackSpec", lhsEjbCallbackSpec), LocatorUtils.property(thatLocator, "ejbCallbackSpec", rhsEjbCallbackSpec), lhsEjbCallbackSpec, rhsEjbCallbackSpec)) {
                return false;
            }
        }
        {
            WebServiceCallbackSpecType lhsWebserviceCallbackSpec;
            lhsWebserviceCallbackSpec = this.getWebserviceCallbackSpec();
            WebServiceCallbackSpecType rhsWebserviceCallbackSpec;
            rhsWebserviceCallbackSpec = that.getWebserviceCallbackSpec();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "webserviceCallbackSpec", lhsWebserviceCallbackSpec), LocatorUtils.property(thatLocator, "webserviceCallbackSpec", rhsWebserviceCallbackSpec), lhsWebserviceCallbackSpec, rhsWebserviceCallbackSpec)) {
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
            JmsCallbackSpecType theJmsCallbackSpec;
            theJmsCallbackSpec = this.getJmsCallbackSpec();
            strategy.appendField(locator, this, "jmsCallbackSpec", buffer, theJmsCallbackSpec);
        }
        {
            EjbCallbackSpecType theEjbCallbackSpec;
            theEjbCallbackSpec = this.getEjbCallbackSpec();
            strategy.appendField(locator, this, "ejbCallbackSpec", buffer, theEjbCallbackSpec);
        }
        {
            WebServiceCallbackSpecType theWebserviceCallbackSpec;
            theWebserviceCallbackSpec = this.getWebserviceCallbackSpec();
            strategy.appendField(locator, this, "webserviceCallbackSpec", buffer, theWebserviceCallbackSpec);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            JmsCallbackSpecType theJmsCallbackSpec;
            theJmsCallbackSpec = this.getJmsCallbackSpec();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "jmsCallbackSpec", theJmsCallbackSpec), currentHashCode, theJmsCallbackSpec);
        }
        {
            EjbCallbackSpecType theEjbCallbackSpec;
            theEjbCallbackSpec = this.getEjbCallbackSpec();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "ejbCallbackSpec", theEjbCallbackSpec), currentHashCode, theEjbCallbackSpec);
        }
        {
            WebServiceCallbackSpecType theWebserviceCallbackSpec;
            theWebserviceCallbackSpec = this.getWebserviceCallbackSpec();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "webserviceCallbackSpec", theWebserviceCallbackSpec), currentHashCode, theWebserviceCallbackSpec);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
