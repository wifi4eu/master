
package generated.jagate.ws.domain.visa.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import eu.europa.ec.rdg.jagate.ws.domain.transaction.v1.TransactionSubtype;
import generated.jagate.ws.domain.constants.v1.JagateClient;
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
 * <p>Java class for GiveVisaRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GiveVisaRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="localObjectForeigId" type="{http://ec.europa.eu/rdg/jagate/ws/domain/base/v2}NonEmptyString"/>
 *         &lt;element name="transactionType" type="{http://ec.europa.eu/rdg/jagate/ws/domain/transaction/v1}TransactionSubtype"/>
 *         &lt;element name="requestingClient" type="{http://ec.europa.eu/rdg/jagate/ws/domain/constants/v1}JagateClient"/>
 *         &lt;element name="visa" type="{http://ec.europa.eu/rdg/jagate/ws/domain/visa/v1}Visa"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GiveVisaRequestType", propOrder = {
    "localObjectForeigId",
    "transactionType",
    "requestingClient",
    "visa"
})
public class GiveVisaRequestType
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected String localObjectForeigId;
    @XmlElement(required = true)
    protected TransactionSubtype transactionType;
    @XmlElement(required = true)
    protected JagateClient requestingClient;
    @XmlElement(required = true)
    protected Visa visa;

    /**
     * Gets the value of the localObjectForeigId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocalObjectForeigId() {
        return localObjectForeigId;
    }

    /**
     * Sets the value of the localObjectForeigId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocalObjectForeigId(String value) {
        this.localObjectForeigId = value;
    }

    /**
     * Gets the value of the transactionType property.
     * 
     * @return
     *     possible object is
     *     {@link TransactionSubtype }
     *     
     */
    public TransactionSubtype getTransactionType() {
        return transactionType;
    }

    /**
     * Sets the value of the transactionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionSubtype }
     *     
     */
    public void setTransactionType(TransactionSubtype value) {
        this.transactionType = value;
    }

    /**
     * Gets the value of the requestingClient property.
     * 
     * @return
     *     possible object is
     *     {@link JagateClient }
     *     
     */
    public JagateClient getRequestingClient() {
        return requestingClient;
    }

    /**
     * Sets the value of the requestingClient property.
     * 
     * @param value
     *     allowed object is
     *     {@link JagateClient }
     *     
     */
    public void setRequestingClient(JagateClient value) {
        this.requestingClient = value;
    }

    /**
     * Gets the value of the visa property.
     * 
     * @return
     *     possible object is
     *     {@link Visa }
     *     
     */
    public Visa getVisa() {
        return visa;
    }

    /**
     * Sets the value of the visa property.
     * 
     * @param value
     *     allowed object is
     *     {@link Visa }
     *     
     */
    public void setVisa(Visa value) {
        this.visa = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof GiveVisaRequestType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final GiveVisaRequestType that = ((GiveVisaRequestType) object);
        {
            String lhsLocalObjectForeigId;
            lhsLocalObjectForeigId = this.getLocalObjectForeigId();
            String rhsLocalObjectForeigId;
            rhsLocalObjectForeigId = that.getLocalObjectForeigId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "localObjectForeigId", lhsLocalObjectForeigId), LocatorUtils.property(thatLocator, "localObjectForeigId", rhsLocalObjectForeigId), lhsLocalObjectForeigId, rhsLocalObjectForeigId)) {
                return false;
            }
        }
        {
            TransactionSubtype lhsTransactionType;
            lhsTransactionType = this.getTransactionType();
            TransactionSubtype rhsTransactionType;
            rhsTransactionType = that.getTransactionType();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "transactionType", lhsTransactionType), LocatorUtils.property(thatLocator, "transactionType", rhsTransactionType), lhsTransactionType, rhsTransactionType)) {
                return false;
            }
        }
        {
            JagateClient lhsRequestingClient;
            lhsRequestingClient = this.getRequestingClient();
            JagateClient rhsRequestingClient;
            rhsRequestingClient = that.getRequestingClient();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "requestingClient", lhsRequestingClient), LocatorUtils.property(thatLocator, "requestingClient", rhsRequestingClient), lhsRequestingClient, rhsRequestingClient)) {
                return false;
            }
        }
        {
            Visa lhsVisa;
            lhsVisa = this.getVisa();
            Visa rhsVisa;
            rhsVisa = that.getVisa();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "visa", lhsVisa), LocatorUtils.property(thatLocator, "visa", rhsVisa), lhsVisa, rhsVisa)) {
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
            String theLocalObjectForeigId;
            theLocalObjectForeigId = this.getLocalObjectForeigId();
            strategy.appendField(locator, this, "localObjectForeigId", buffer, theLocalObjectForeigId);
        }
        {
            TransactionSubtype theTransactionType;
            theTransactionType = this.getTransactionType();
            strategy.appendField(locator, this, "transactionType", buffer, theTransactionType);
        }
        {
            JagateClient theRequestingClient;
            theRequestingClient = this.getRequestingClient();
            strategy.appendField(locator, this, "requestingClient", buffer, theRequestingClient);
        }
        {
            Visa theVisa;
            theVisa = this.getVisa();
            strategy.appendField(locator, this, "visa", buffer, theVisa);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String theLocalObjectForeigId;
            theLocalObjectForeigId = this.getLocalObjectForeigId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "localObjectForeigId", theLocalObjectForeigId), currentHashCode, theLocalObjectForeigId);
        }
        {
            TransactionSubtype theTransactionType;
            theTransactionType = this.getTransactionType();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "transactionType", theTransactionType), currentHashCode, theTransactionType);
        }
        {
            JagateClient theRequestingClient;
            theRequestingClient = this.getRequestingClient();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "requestingClient", theRequestingClient), currentHashCode, theRequestingClient);
        }
        {
            Visa theVisa;
            theVisa = this.getVisa();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "visa", theVisa), currentHashCode, theVisa);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
