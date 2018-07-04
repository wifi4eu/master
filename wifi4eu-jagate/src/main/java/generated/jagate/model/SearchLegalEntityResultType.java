
package generated.jagate.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import eu.europa.ec.rdg.jagate.ws.domain.legalentity.v6.FELStatusType;
import eu.europa.ec.research.fp.model.legalentity.v11.LegalEntityCoreFactType;
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
 * <p>Java class for SearchLegalEntityResultType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SearchLegalEntityResultType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LegalEntityCoreFact" type="{http://ec.europa.eu/research/fp/model/legalentity/V11}LegalEntityCoreFactType"/>
 *         &lt;element name="FELStatus" type="{http://ec.europa.eu/rdg/jagate/ws/domain/legalentity/v6}FELStatusType"/>
 *         &lt;element name="likenessPercentage" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SearchLegalEntityResultType", propOrder = {
    "legalEntityCoreFact",
    "felStatus",
    "likenessPercentage"
})
public class SearchLegalEntityResultType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "LegalEntityCoreFact", required = true)
    protected LegalEntityCoreFactType legalEntityCoreFact;
    @XmlElement(name = "FELStatus", required = true)
    protected FELStatusType felStatus;
    protected int likenessPercentage;

    /**
     * Gets the value of the legalEntityCoreFact property.
     * 
     * @return
     *     possible object is
     *     {@link LegalEntityCoreFactType }
     *     
     */
    public LegalEntityCoreFactType getLegalEntityCoreFact() {
        return legalEntityCoreFact;
    }

    /**
     * Sets the value of the legalEntityCoreFact property.
     * 
     * @param value
     *     allowed object is
     *     {@link LegalEntityCoreFactType }
     *     
     */
    public void setLegalEntityCoreFact(LegalEntityCoreFactType value) {
        this.legalEntityCoreFact = value;
    }

    /**
     * Gets the value of the felStatus property.
     * 
     * @return
     *     possible object is
     *     {@link FELStatusType }
     *     
     */
    public FELStatusType getFELStatus() {
        return felStatus;
    }

    /**
     * Sets the value of the felStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link FELStatusType }
     *     
     */
    public void setFELStatus(FELStatusType value) {
        this.felStatus = value;
    }

    /**
     * Gets the value of the likenessPercentage property.
     * 
     */
    public int getLikenessPercentage() {
        return likenessPercentage;
    }

    /**
     * Sets the value of the likenessPercentage property.
     * 
     */
    public void setLikenessPercentage(int value) {
        this.likenessPercentage = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof SearchLegalEntityResultType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final SearchLegalEntityResultType that = ((SearchLegalEntityResultType) object);
        {
            LegalEntityCoreFactType lhsLegalEntityCoreFact;
            lhsLegalEntityCoreFact = this.getLegalEntityCoreFact();
            LegalEntityCoreFactType rhsLegalEntityCoreFact;
            rhsLegalEntityCoreFact = that.getLegalEntityCoreFact();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "legalEntityCoreFact", lhsLegalEntityCoreFact), LocatorUtils.property(thatLocator, "legalEntityCoreFact", rhsLegalEntityCoreFact), lhsLegalEntityCoreFact, rhsLegalEntityCoreFact)) {
                return false;
            }
        }
        {
            FELStatusType lhsFELStatus;
            lhsFELStatus = this.getFELStatus();
            FELStatusType rhsFELStatus;
            rhsFELStatus = that.getFELStatus();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "felStatus", lhsFELStatus), LocatorUtils.property(thatLocator, "felStatus", rhsFELStatus), lhsFELStatus, rhsFELStatus)) {
                return false;
            }
        }
        {
            int lhsLikenessPercentage;
            lhsLikenessPercentage = (true?this.getLikenessPercentage(): 0);
            int rhsLikenessPercentage;
            rhsLikenessPercentage = (true?that.getLikenessPercentage(): 0);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "likenessPercentage", lhsLikenessPercentage), LocatorUtils.property(thatLocator, "likenessPercentage", rhsLikenessPercentage), lhsLikenessPercentage, rhsLikenessPercentage)) {
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
            LegalEntityCoreFactType theLegalEntityCoreFact;
            theLegalEntityCoreFact = this.getLegalEntityCoreFact();
            strategy.appendField(locator, this, "legalEntityCoreFact", buffer, theLegalEntityCoreFact);
        }
        {
            FELStatusType theFELStatus;
            theFELStatus = this.getFELStatus();
            strategy.appendField(locator, this, "felStatus", buffer, theFELStatus);
        }
        {
            int theLikenessPercentage;
            theLikenessPercentage = (true?this.getLikenessPercentage(): 0);
            strategy.appendField(locator, this, "likenessPercentage", buffer, theLikenessPercentage);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            LegalEntityCoreFactType theLegalEntityCoreFact;
            theLegalEntityCoreFact = this.getLegalEntityCoreFact();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "legalEntityCoreFact", theLegalEntityCoreFact), currentHashCode, theLegalEntityCoreFact);
        }
        {
            FELStatusType theFELStatus;
            theFELStatus = this.getFELStatus();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "felStatus", theFELStatus), currentHashCode, theFELStatus);
        }
        {
            int theLikenessPercentage;
            theLikenessPercentage = (true?this.getLikenessPercentage(): 0);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "likenessPercentage", theLikenessPercentage), currentHashCode, theLikenessPercentage);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
