
package generated.jagate.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import eu.europa.ec.rdg.jagate.ws.domain.legalentity.v6.LEScannedDocumentList;
import eu.europa.ec.rdg.jagate.ws.domain.legalentity.v6.NaturalBodyExMemberOfPersonnel;
import eu.europa.ec.rdg.jagate.ws.domain.legalentity.v6.NaturalBodyMemberOfPersonnelExcluded;
import eu.europa.ec.rdg.jagate.ws.domain.legalentity.v6.PrivateLawBody;
import eu.europa.ec.rdg.jagate.ws.domain.legalentity.v6.PublicLawBody;
import generated.jagate.ws.domain.base.v2.AresDocumentList;
import generated.jagate.ws.domain.visa.v1.BasicVisa;
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
 * <p>Java class for CreateLegalEntityRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CreateLegalEntityRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="naturalBodyMemberOfPersonnelExcluded" type="{http://ec.europa.eu/rdg/jagate/ws/domain/legalentity/v6}NaturalBodyMemberOfPersonnelExcluded"/>
 *           &lt;element name="naturalBodyExMemberOfPersonnel" type="{http://ec.europa.eu/rdg/jagate/ws/domain/legalentity/v6}NaturalBodyExMemberOfPersonnel"/>
 *           &lt;element name="publicLawBody" type="{http://ec.europa.eu/rdg/jagate/ws/domain/legalentity/v6}PublicLawBody"/>
 *           &lt;element name="privateLawBody" type="{http://ec.europa.eu/rdg/jagate/ws/domain/legalentity/v6}PrivateLawBody"/>
 *         &lt;/choice>
 *         &lt;choice>
 *           &lt;element name="aresDocumentList" type="{http://ec.europa.eu/rdg/jagate/ws/domain/base/v2}AresDocumentList"/>
 *           &lt;element name="scannedDocumentList" type="{http://ec.europa.eu/rdg/jagate/ws/domain/legalentity/v6}LEScannedDocumentList"/>
 *         &lt;/choice>
 *         &lt;element name="visa" type="{http://ec.europa.eu/rdg/jagate/ws/domain/visa/v1}BasicVisa"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateLegalEntityRequestType", propOrder = {
    "naturalBodyMemberOfPersonnelExcluded",
    "naturalBodyExMemberOfPersonnel",
    "publicLawBody",
    "privateLawBody",
    "aresDocumentList",
    "scannedDocumentList",
    "visa"
})
public class CreateLegalEntityRequestType
    implements Equals, HashCode, ToString
{

    protected NaturalBodyMemberOfPersonnelExcluded naturalBodyMemberOfPersonnelExcluded;
    protected NaturalBodyExMemberOfPersonnel naturalBodyExMemberOfPersonnel;
    protected PublicLawBody publicLawBody;
    protected PrivateLawBody privateLawBody;
    protected AresDocumentList aresDocumentList;
    protected LEScannedDocumentList scannedDocumentList;
    @XmlElement(required = true)
    protected BasicVisa visa;

    /**
     * Gets the value of the naturalBodyMemberOfPersonnelExcluded property.
     * 
     * @return
     *     possible object is
     *     {@link NaturalBodyMemberOfPersonnelExcluded }
     *     
     */
    public NaturalBodyMemberOfPersonnelExcluded getNaturalBodyMemberOfPersonnelExcluded() {
        return naturalBodyMemberOfPersonnelExcluded;
    }

    /**
     * Sets the value of the naturalBodyMemberOfPersonnelExcluded property.
     * 
     * @param value
     *     allowed object is
     *     {@link NaturalBodyMemberOfPersonnelExcluded }
     *     
     */
    public void setNaturalBodyMemberOfPersonnelExcluded(NaturalBodyMemberOfPersonnelExcluded value) {
        this.naturalBodyMemberOfPersonnelExcluded = value;
    }

    /**
     * Gets the value of the naturalBodyExMemberOfPersonnel property.
     * 
     * @return
     *     possible object is
     *     {@link NaturalBodyExMemberOfPersonnel }
     *     
     */
    public NaturalBodyExMemberOfPersonnel getNaturalBodyExMemberOfPersonnel() {
        return naturalBodyExMemberOfPersonnel;
    }

    /**
     * Sets the value of the naturalBodyExMemberOfPersonnel property.
     * 
     * @param value
     *     allowed object is
     *     {@link NaturalBodyExMemberOfPersonnel }
     *     
     */
    public void setNaturalBodyExMemberOfPersonnel(NaturalBodyExMemberOfPersonnel value) {
        this.naturalBodyExMemberOfPersonnel = value;
    }

    /**
     * Gets the value of the publicLawBody property.
     * 
     * @return
     *     possible object is
     *     {@link PublicLawBody }
     *     
     */
    public PublicLawBody getPublicLawBody() {
        return publicLawBody;
    }

    /**
     * Sets the value of the publicLawBody property.
     * 
     * @param value
     *     allowed object is
     *     {@link PublicLawBody }
     *     
     */
    public void setPublicLawBody(PublicLawBody value) {
        this.publicLawBody = value;
    }

    /**
     * Gets the value of the privateLawBody property.
     * 
     * @return
     *     possible object is
     *     {@link PrivateLawBody }
     *     
     */
    public PrivateLawBody getPrivateLawBody() {
        return privateLawBody;
    }

    /**
     * Sets the value of the privateLawBody property.
     * 
     * @param value
     *     allowed object is
     *     {@link PrivateLawBody }
     *     
     */
    public void setPrivateLawBody(PrivateLawBody value) {
        this.privateLawBody = value;
    }

    /**
     * Gets the value of the aresDocumentList property.
     * 
     * @return
     *     possible object is
     *     {@link AresDocumentList }
     *     
     */
    public AresDocumentList getAresDocumentList() {
        return aresDocumentList;
    }

    /**
     * Sets the value of the aresDocumentList property.
     * 
     * @param value
     *     allowed object is
     *     {@link AresDocumentList }
     *     
     */
    public void setAresDocumentList(AresDocumentList value) {
        this.aresDocumentList = value;
    }

    /**
     * Gets the value of the scannedDocumentList property.
     * 
     * @return
     *     possible object is
     *     {@link LEScannedDocumentList }
     *     
     */
    public LEScannedDocumentList getScannedDocumentList() {
        return scannedDocumentList;
    }

    /**
     * Sets the value of the scannedDocumentList property.
     * 
     * @param value
     *     allowed object is
     *     {@link LEScannedDocumentList }
     *     
     */
    public void setScannedDocumentList(LEScannedDocumentList value) {
        this.scannedDocumentList = value;
    }

    /**
     * Gets the value of the visa property.
     * 
     * @return
     *     possible object is
     *     {@link BasicVisa }
     *     
     */
    public BasicVisa getVisa() {
        return visa;
    }

    /**
     * Sets the value of the visa property.
     * 
     * @param value
     *     allowed object is
     *     {@link BasicVisa }
     *     
     */
    public void setVisa(BasicVisa value) {
        this.visa = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof CreateLegalEntityRequestType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final CreateLegalEntityRequestType that = ((CreateLegalEntityRequestType) object);
        {
            NaturalBodyMemberOfPersonnelExcluded lhsNaturalBodyMemberOfPersonnelExcluded;
            lhsNaturalBodyMemberOfPersonnelExcluded = this.getNaturalBodyMemberOfPersonnelExcluded();
            NaturalBodyMemberOfPersonnelExcluded rhsNaturalBodyMemberOfPersonnelExcluded;
            rhsNaturalBodyMemberOfPersonnelExcluded = that.getNaturalBodyMemberOfPersonnelExcluded();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "naturalBodyMemberOfPersonnelExcluded", lhsNaturalBodyMemberOfPersonnelExcluded), LocatorUtils.property(thatLocator, "naturalBodyMemberOfPersonnelExcluded", rhsNaturalBodyMemberOfPersonnelExcluded), lhsNaturalBodyMemberOfPersonnelExcluded, rhsNaturalBodyMemberOfPersonnelExcluded)) {
                return false;
            }
        }
        {
            NaturalBodyExMemberOfPersonnel lhsNaturalBodyExMemberOfPersonnel;
            lhsNaturalBodyExMemberOfPersonnel = this.getNaturalBodyExMemberOfPersonnel();
            NaturalBodyExMemberOfPersonnel rhsNaturalBodyExMemberOfPersonnel;
            rhsNaturalBodyExMemberOfPersonnel = that.getNaturalBodyExMemberOfPersonnel();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "naturalBodyExMemberOfPersonnel", lhsNaturalBodyExMemberOfPersonnel), LocatorUtils.property(thatLocator, "naturalBodyExMemberOfPersonnel", rhsNaturalBodyExMemberOfPersonnel), lhsNaturalBodyExMemberOfPersonnel, rhsNaturalBodyExMemberOfPersonnel)) {
                return false;
            }
        }
        {
            PublicLawBody lhsPublicLawBody;
            lhsPublicLawBody = this.getPublicLawBody();
            PublicLawBody rhsPublicLawBody;
            rhsPublicLawBody = that.getPublicLawBody();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "publicLawBody", lhsPublicLawBody), LocatorUtils.property(thatLocator, "publicLawBody", rhsPublicLawBody), lhsPublicLawBody, rhsPublicLawBody)) {
                return false;
            }
        }
        {
            PrivateLawBody lhsPrivateLawBody;
            lhsPrivateLawBody = this.getPrivateLawBody();
            PrivateLawBody rhsPrivateLawBody;
            rhsPrivateLawBody = that.getPrivateLawBody();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "privateLawBody", lhsPrivateLawBody), LocatorUtils.property(thatLocator, "privateLawBody", rhsPrivateLawBody), lhsPrivateLawBody, rhsPrivateLawBody)) {
                return false;
            }
        }
        {
            AresDocumentList lhsAresDocumentList;
            lhsAresDocumentList = this.getAresDocumentList();
            AresDocumentList rhsAresDocumentList;
            rhsAresDocumentList = that.getAresDocumentList();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "aresDocumentList", lhsAresDocumentList), LocatorUtils.property(thatLocator, "aresDocumentList", rhsAresDocumentList), lhsAresDocumentList, rhsAresDocumentList)) {
                return false;
            }
        }
        {
            LEScannedDocumentList lhsScannedDocumentList;
            lhsScannedDocumentList = this.getScannedDocumentList();
            LEScannedDocumentList rhsScannedDocumentList;
            rhsScannedDocumentList = that.getScannedDocumentList();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "scannedDocumentList", lhsScannedDocumentList), LocatorUtils.property(thatLocator, "scannedDocumentList", rhsScannedDocumentList), lhsScannedDocumentList, rhsScannedDocumentList)) {
                return false;
            }
        }
        {
            BasicVisa lhsVisa;
            lhsVisa = this.getVisa();
            BasicVisa rhsVisa;
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
            NaturalBodyMemberOfPersonnelExcluded theNaturalBodyMemberOfPersonnelExcluded;
            theNaturalBodyMemberOfPersonnelExcluded = this.getNaturalBodyMemberOfPersonnelExcluded();
            strategy.appendField(locator, this, "naturalBodyMemberOfPersonnelExcluded", buffer, theNaturalBodyMemberOfPersonnelExcluded);
        }
        {
            NaturalBodyExMemberOfPersonnel theNaturalBodyExMemberOfPersonnel;
            theNaturalBodyExMemberOfPersonnel = this.getNaturalBodyExMemberOfPersonnel();
            strategy.appendField(locator, this, "naturalBodyExMemberOfPersonnel", buffer, theNaturalBodyExMemberOfPersonnel);
        }
        {
            PublicLawBody thePublicLawBody;
            thePublicLawBody = this.getPublicLawBody();
            strategy.appendField(locator, this, "publicLawBody", buffer, thePublicLawBody);
        }
        {
            PrivateLawBody thePrivateLawBody;
            thePrivateLawBody = this.getPrivateLawBody();
            strategy.appendField(locator, this, "privateLawBody", buffer, thePrivateLawBody);
        }
        {
            AresDocumentList theAresDocumentList;
            theAresDocumentList = this.getAresDocumentList();
            strategy.appendField(locator, this, "aresDocumentList", buffer, theAresDocumentList);
        }
        {
            LEScannedDocumentList theScannedDocumentList;
            theScannedDocumentList = this.getScannedDocumentList();
            strategy.appendField(locator, this, "scannedDocumentList", buffer, theScannedDocumentList);
        }
        {
            BasicVisa theVisa;
            theVisa = this.getVisa();
            strategy.appendField(locator, this, "visa", buffer, theVisa);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            NaturalBodyMemberOfPersonnelExcluded theNaturalBodyMemberOfPersonnelExcluded;
            theNaturalBodyMemberOfPersonnelExcluded = this.getNaturalBodyMemberOfPersonnelExcluded();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "naturalBodyMemberOfPersonnelExcluded", theNaturalBodyMemberOfPersonnelExcluded), currentHashCode, theNaturalBodyMemberOfPersonnelExcluded);
        }
        {
            NaturalBodyExMemberOfPersonnel theNaturalBodyExMemberOfPersonnel;
            theNaturalBodyExMemberOfPersonnel = this.getNaturalBodyExMemberOfPersonnel();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "naturalBodyExMemberOfPersonnel", theNaturalBodyExMemberOfPersonnel), currentHashCode, theNaturalBodyExMemberOfPersonnel);
        }
        {
            PublicLawBody thePublicLawBody;
            thePublicLawBody = this.getPublicLawBody();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "publicLawBody", thePublicLawBody), currentHashCode, thePublicLawBody);
        }
        {
            PrivateLawBody thePrivateLawBody;
            thePrivateLawBody = this.getPrivateLawBody();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "privateLawBody", thePrivateLawBody), currentHashCode, thePrivateLawBody);
        }
        {
            AresDocumentList theAresDocumentList;
            theAresDocumentList = this.getAresDocumentList();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "aresDocumentList", theAresDocumentList), currentHashCode, theAresDocumentList);
        }
        {
            LEScannedDocumentList theScannedDocumentList;
            theScannedDocumentList = this.getScannedDocumentList();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "scannedDocumentList", theScannedDocumentList), currentHashCode, theScannedDocumentList);
        }
        {
            BasicVisa theVisa;
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
