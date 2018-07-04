
package eu.europa.ec.rdg.jagate.ws.domain.legalentity.v6;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 * <p>Java class for FELStatusType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FELStatusType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Code" type="{http://ec.europa.eu/rdg/jagate/ws/domain/legalentity/v6}LegalEntityStatusCodeType"/>
 *         &lt;element name="RejectionInfo" type="{http://ec.europa.eu/rdg/jagate/ws/domain/legalentity/v6}RejectedFelInfoType" minOccurs="0"/>
 *         &lt;element name="BlockedInfo" type="{http://ec.europa.eu/rdg/jagate/ws/domain/legalentity/v6}BlockedFelInfoType" minOccurs="0"/>
 *         &lt;element name="FollowUpInfo" type="{http://ec.europa.eu/rdg/jagate/ws/domain/legalentity/v6}FollowUpFelInfoType" minOccurs="0"/>
 *         &lt;element name="EWS" type="{http://ec.europa.eu/rdg/jagate/ws/domain/legalentity/v6}EarlyWarningType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Identifier" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FELStatusType", propOrder = {
    "code",
    "rejectionInfo",
    "blockedInfo",
    "followUpInfo",
    "ews"
})
public class FELStatusType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "Code", required = true)
    protected LegalEntityStatusCodeType code;
    @XmlElement(name = "RejectionInfo")
    protected RejectedFelInfoType rejectionInfo;
    @XmlElement(name = "BlockedInfo")
    protected BlockedFelInfoType blockedInfo;
    @XmlElement(name = "FollowUpInfo")
    protected FollowUpFelInfoType followUpInfo;
    @XmlElement(name = "EWS")
    protected List<EarlyWarningType> ews;
    @XmlAttribute(name = "Identifier")
    protected String identifier;

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link LegalEntityStatusCodeType }
     *     
     */
    public LegalEntityStatusCodeType getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link LegalEntityStatusCodeType }
     *     
     */
    public void setCode(LegalEntityStatusCodeType value) {
        this.code = value;
    }

    /**
     * Gets the value of the rejectionInfo property.
     * 
     * @return
     *     possible object is
     *     {@link RejectedFelInfoType }
     *     
     */
    public RejectedFelInfoType getRejectionInfo() {
        return rejectionInfo;
    }

    /**
     * Sets the value of the rejectionInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link RejectedFelInfoType }
     *     
     */
    public void setRejectionInfo(RejectedFelInfoType value) {
        this.rejectionInfo = value;
    }

    /**
     * Gets the value of the blockedInfo property.
     * 
     * @return
     *     possible object is
     *     {@link BlockedFelInfoType }
     *     
     */
    public BlockedFelInfoType getBlockedInfo() {
        return blockedInfo;
    }

    /**
     * Sets the value of the blockedInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link BlockedFelInfoType }
     *     
     */
    public void setBlockedInfo(BlockedFelInfoType value) {
        this.blockedInfo = value;
    }

    /**
     * Gets the value of the followUpInfo property.
     * 
     * @return
     *     possible object is
     *     {@link FollowUpFelInfoType }
     *     
     */
    public FollowUpFelInfoType getFollowUpInfo() {
        return followUpInfo;
    }

    /**
     * Sets the value of the followUpInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link FollowUpFelInfoType }
     *     
     */
    public void setFollowUpInfo(FollowUpFelInfoType value) {
        this.followUpInfo = value;
    }

    /**
     * Gets the value of the ews property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ews property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEWS().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EarlyWarningType }
     * 
     * 
     */
    public List<EarlyWarningType> getEWS() {
        if (ews == null) {
            ews = new ArrayList<EarlyWarningType>();
        }
        return this.ews;
    }

    /**
     * Gets the value of the identifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * Sets the value of the identifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentifier(String value) {
        this.identifier = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof FELStatusType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final FELStatusType that = ((FELStatusType) object);
        {
            LegalEntityStatusCodeType lhsCode;
            lhsCode = this.getCode();
            LegalEntityStatusCodeType rhsCode;
            rhsCode = that.getCode();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "code", lhsCode), LocatorUtils.property(thatLocator, "code", rhsCode), lhsCode, rhsCode)) {
                return false;
            }
        }
        {
            RejectedFelInfoType lhsRejectionInfo;
            lhsRejectionInfo = this.getRejectionInfo();
            RejectedFelInfoType rhsRejectionInfo;
            rhsRejectionInfo = that.getRejectionInfo();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "rejectionInfo", lhsRejectionInfo), LocatorUtils.property(thatLocator, "rejectionInfo", rhsRejectionInfo), lhsRejectionInfo, rhsRejectionInfo)) {
                return false;
            }
        }
        {
            BlockedFelInfoType lhsBlockedInfo;
            lhsBlockedInfo = this.getBlockedInfo();
            BlockedFelInfoType rhsBlockedInfo;
            rhsBlockedInfo = that.getBlockedInfo();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "blockedInfo", lhsBlockedInfo), LocatorUtils.property(thatLocator, "blockedInfo", rhsBlockedInfo), lhsBlockedInfo, rhsBlockedInfo)) {
                return false;
            }
        }
        {
            FollowUpFelInfoType lhsFollowUpInfo;
            lhsFollowUpInfo = this.getFollowUpInfo();
            FollowUpFelInfoType rhsFollowUpInfo;
            rhsFollowUpInfo = that.getFollowUpInfo();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "followUpInfo", lhsFollowUpInfo), LocatorUtils.property(thatLocator, "followUpInfo", rhsFollowUpInfo), lhsFollowUpInfo, rhsFollowUpInfo)) {
                return false;
            }
        }
        {
            List<EarlyWarningType> lhsEWS;
            lhsEWS = (((this.ews!= null)&&(!this.ews.isEmpty()))?this.getEWS():null);
            List<EarlyWarningType> rhsEWS;
            rhsEWS = (((that.ews!= null)&&(!that.ews.isEmpty()))?that.getEWS():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "ews", lhsEWS), LocatorUtils.property(thatLocator, "ews", rhsEWS), lhsEWS, rhsEWS)) {
                return false;
            }
        }
        {
            String lhsIdentifier;
            lhsIdentifier = this.getIdentifier();
            String rhsIdentifier;
            rhsIdentifier = that.getIdentifier();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "identifier", lhsIdentifier), LocatorUtils.property(thatLocator, "identifier", rhsIdentifier), lhsIdentifier, rhsIdentifier)) {
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
            LegalEntityStatusCodeType theCode;
            theCode = this.getCode();
            strategy.appendField(locator, this, "code", buffer, theCode);
        }
        {
            RejectedFelInfoType theRejectionInfo;
            theRejectionInfo = this.getRejectionInfo();
            strategy.appendField(locator, this, "rejectionInfo", buffer, theRejectionInfo);
        }
        {
            BlockedFelInfoType theBlockedInfo;
            theBlockedInfo = this.getBlockedInfo();
            strategy.appendField(locator, this, "blockedInfo", buffer, theBlockedInfo);
        }
        {
            FollowUpFelInfoType theFollowUpInfo;
            theFollowUpInfo = this.getFollowUpInfo();
            strategy.appendField(locator, this, "followUpInfo", buffer, theFollowUpInfo);
        }
        {
            List<EarlyWarningType> theEWS;
            theEWS = (((this.ews!= null)&&(!this.ews.isEmpty()))?this.getEWS():null);
            strategy.appendField(locator, this, "ews", buffer, theEWS);
        }
        {
            String theIdentifier;
            theIdentifier = this.getIdentifier();
            strategy.appendField(locator, this, "identifier", buffer, theIdentifier);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            LegalEntityStatusCodeType theCode;
            theCode = this.getCode();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "code", theCode), currentHashCode, theCode);
        }
        {
            RejectedFelInfoType theRejectionInfo;
            theRejectionInfo = this.getRejectionInfo();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "rejectionInfo", theRejectionInfo), currentHashCode, theRejectionInfo);
        }
        {
            BlockedFelInfoType theBlockedInfo;
            theBlockedInfo = this.getBlockedInfo();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "blockedInfo", theBlockedInfo), currentHashCode, theBlockedInfo);
        }
        {
            FollowUpFelInfoType theFollowUpInfo;
            theFollowUpInfo = this.getFollowUpInfo();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "followUpInfo", theFollowUpInfo), currentHashCode, theFollowUpInfo);
        }
        {
            List<EarlyWarningType> theEWS;
            theEWS = (((this.ews!= null)&&(!this.ews.isEmpty()))?this.getEWS():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "ews", theEWS), currentHashCode, theEWS);
        }
        {
            String theIdentifier;
            theIdentifier = this.getIdentifier();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "identifier", theIdentifier), currentHashCode, theIdentifier);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
