
package eu.europa.ec.research.fp.model.legalentity.v11;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import generated.jagate.model.coderef.V3.CodeRefType;
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
 * <p>Java class for FP6LegacyFactType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FP6LegacyFactType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LegalFormCode" type="{http://ec.europa.eu/research/fp/model/code-ref/V3}CodeRefType" minOccurs="0"/>
 *         &lt;element name="CostModel" type="{http://ec.europa.eu/research/fp/model/code-ref/V3}CodeRefType" minOccurs="0"/>
 *         &lt;element name="LegalStatus" type="{http://ec.europa.eu/research/fp/model/code-ref/V3}CodeRefType" minOccurs="0"/>
 *         &lt;element name="FP6Status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FP6LegacyFactType", propOrder = {
    "legalFormCode",
    "costModel",
    "legalStatus",
    "fp6Status"
})
public class FP6LegacyFactType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "LegalFormCode")
    protected CodeRefType legalFormCode;
    @XmlElement(name = "CostModel")
    protected CodeRefType costModel;
    @XmlElement(name = "LegalStatus")
    protected CodeRefType legalStatus;
    @XmlElement(name = "FP6Status")
    protected String fp6Status;

    /**
     * Gets the value of the legalFormCode property.
     * 
     * @return
     *     possible object is
     *     {@link CodeRefType }
     *     
     */
    public CodeRefType getLegalFormCode() {
        return legalFormCode;
    }

    /**
     * Sets the value of the legalFormCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeRefType }
     *     
     */
    public void setLegalFormCode(CodeRefType value) {
        this.legalFormCode = value;
    }

    /**
     * Gets the value of the costModel property.
     * 
     * @return
     *     possible object is
     *     {@link CodeRefType }
     *     
     */
    public CodeRefType getCostModel() {
        return costModel;
    }

    /**
     * Sets the value of the costModel property.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeRefType }
     *     
     */
    public void setCostModel(CodeRefType value) {
        this.costModel = value;
    }

    /**
     * Gets the value of the legalStatus property.
     * 
     * @return
     *     possible object is
     *     {@link CodeRefType }
     *     
     */
    public CodeRefType getLegalStatus() {
        return legalStatus;
    }

    /**
     * Sets the value of the legalStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeRefType }
     *     
     */
    public void setLegalStatus(CodeRefType value) {
        this.legalStatus = value;
    }

    /**
     * Gets the value of the fp6Status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFP6Status() {
        return fp6Status;
    }

    /**
     * Sets the value of the fp6Status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFP6Status(String value) {
        this.fp6Status = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof FP6LegacyFactType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final FP6LegacyFactType that = ((FP6LegacyFactType) object);
        {
            CodeRefType lhsLegalFormCode;
            lhsLegalFormCode = this.getLegalFormCode();
            CodeRefType rhsLegalFormCode;
            rhsLegalFormCode = that.getLegalFormCode();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "legalFormCode", lhsLegalFormCode), LocatorUtils.property(thatLocator, "legalFormCode", rhsLegalFormCode), lhsLegalFormCode, rhsLegalFormCode)) {
                return false;
            }
        }
        {
            CodeRefType lhsCostModel;
            lhsCostModel = this.getCostModel();
            CodeRefType rhsCostModel;
            rhsCostModel = that.getCostModel();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "costModel", lhsCostModel), LocatorUtils.property(thatLocator, "costModel", rhsCostModel), lhsCostModel, rhsCostModel)) {
                return false;
            }
        }
        {
            CodeRefType lhsLegalStatus;
            lhsLegalStatus = this.getLegalStatus();
            CodeRefType rhsLegalStatus;
            rhsLegalStatus = that.getLegalStatus();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "legalStatus", lhsLegalStatus), LocatorUtils.property(thatLocator, "legalStatus", rhsLegalStatus), lhsLegalStatus, rhsLegalStatus)) {
                return false;
            }
        }
        {
            String lhsFP6Status;
            lhsFP6Status = this.getFP6Status();
            String rhsFP6Status;
            rhsFP6Status = that.getFP6Status();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "fp6Status", lhsFP6Status), LocatorUtils.property(thatLocator, "fp6Status", rhsFP6Status), lhsFP6Status, rhsFP6Status)) {
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
            CodeRefType theLegalFormCode;
            theLegalFormCode = this.getLegalFormCode();
            strategy.appendField(locator, this, "legalFormCode", buffer, theLegalFormCode);
        }
        {
            CodeRefType theCostModel;
            theCostModel = this.getCostModel();
            strategy.appendField(locator, this, "costModel", buffer, theCostModel);
        }
        {
            CodeRefType theLegalStatus;
            theLegalStatus = this.getLegalStatus();
            strategy.appendField(locator, this, "legalStatus", buffer, theLegalStatus);
        }
        {
            String theFP6Status;
            theFP6Status = this.getFP6Status();
            strategy.appendField(locator, this, "fp6Status", buffer, theFP6Status);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            CodeRefType theLegalFormCode;
            theLegalFormCode = this.getLegalFormCode();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "legalFormCode", theLegalFormCode), currentHashCode, theLegalFormCode);
        }
        {
            CodeRefType theCostModel;
            theCostModel = this.getCostModel();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "costModel", theCostModel), currentHashCode, theCostModel);
        }
        {
            CodeRefType theLegalStatus;
            theLegalStatus = this.getLegalStatus();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "legalStatus", theLegalStatus), currentHashCode, theLegalStatus);
        }
        {
            String theFP6Status;
            theFP6Status = this.getFP6Status();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fp6Status", theFP6Status), currentHashCode, theFP6Status);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
