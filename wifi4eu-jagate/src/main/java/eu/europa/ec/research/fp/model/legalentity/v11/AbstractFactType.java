
package eu.europa.ec.research.fp.model.legalentity.v11;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
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
 * <p>Java class for AbstractFactType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AbstractFactType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WorkFlowStatus" type="{http://ec.europa.eu/research/fp/model/legalentity-ref/V3}WorkFlowStatusType" minOccurs="0"/>
 *         &lt;element name="DataStatus" type="{http://ec.europa.eu/research/fp/model/legalentity-ref/V3}ResponseDataQualityType" minOccurs="0"/>
 *         &lt;element name="EffectiveDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractFactType", propOrder = {
    "workFlowStatus",
    "dataStatus",
    "effectiveDate"
})
@XmlSeeAlso({
    ExtendedFP7IBBAExemptionFactType.class,
    ExtendedFP7ICMFactType.class,
    ExtendedCivilSocietyFactType.class,
    ExtendedFinancialDataFactType.class,
    ExtendedEACOrganisationTypeFactType.class,
    ExtendedExtraNaceFactType.class,
    ExtendedOrgWithOperatingGrantsFactType.class,
    ExtendedLargeInfrastructureFactType.class,
    ExtendedBankAccountFactType.class,
    ExtendedRatiosFactType.class,
    ExtendedFP7LegalEntityFactType.class,
    ExtendedStateWarrantyFactType.class,
    ExtendedCoreFactType.class,
    ExtendedExtraDescriptionOfCoreActivitiesFactType.class,
    ExtendedFP7EducationFactType.class,
    ExtendedFP7ResearchOrganisationFactType.class,
    ExtendedExtraCommunicationFactType.class,
    ExtendedFP7NonProfitFactType.class,
    ExtendedContactFactType.class,
    ExtendedCIPLegalEntityFactType.class,
    ExtendedExtendedMandateFactType.class,
    ExtendedErasmusECHEAccreditationFactType.class,
    ExtendedSMEFactType.class,
    ExtendedFP7LegalPersonalityFactType.class,
    ExtendedCertificationOnCostMethodologyFactType.class,
    ExtendedSMESelfAssessmentFactType.class,
    ExtendedFP7InternationalOrganisationFactType.class,
    ExtendedFP6LegacyFactType.class,
    ExtendedNonBankruptcyDeclarationFactType.class
})
public class AbstractFactType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "WorkFlowStatus", defaultValue = "NONE")
    protected String workFlowStatus;
    @XmlElement(name = "DataStatus", defaultValue = "DECLARED")
    protected String dataStatus;
    @XmlElement(name = "EffectiveDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar effectiveDate;

    /**
     * Gets the value of the workFlowStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkFlowStatus() {
        return workFlowStatus;
    }

    /**
     * Sets the value of the workFlowStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkFlowStatus(String value) {
        this.workFlowStatus = value;
    }

    /**
     * Gets the value of the dataStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataStatus() {
        return dataStatus;
    }

    /**
     * Sets the value of the dataStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataStatus(String value) {
        this.dataStatus = value;
    }

    /**
     * Gets the value of the effectiveDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEffectiveDate() {
        return effectiveDate;
    }

    /**
     * Sets the value of the effectiveDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEffectiveDate(XMLGregorianCalendar value) {
        this.effectiveDate = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof AbstractFactType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final AbstractFactType that = ((AbstractFactType) object);
        {
            String lhsWorkFlowStatus;
            lhsWorkFlowStatus = this.getWorkFlowStatus();
            String rhsWorkFlowStatus;
            rhsWorkFlowStatus = that.getWorkFlowStatus();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "workFlowStatus", lhsWorkFlowStatus), LocatorUtils.property(thatLocator, "workFlowStatus", rhsWorkFlowStatus), lhsWorkFlowStatus, rhsWorkFlowStatus)) {
                return false;
            }
        }
        {
            String lhsDataStatus;
            lhsDataStatus = this.getDataStatus();
            String rhsDataStatus;
            rhsDataStatus = that.getDataStatus();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "dataStatus", lhsDataStatus), LocatorUtils.property(thatLocator, "dataStatus", rhsDataStatus), lhsDataStatus, rhsDataStatus)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsEffectiveDate;
            lhsEffectiveDate = this.getEffectiveDate();
            XMLGregorianCalendar rhsEffectiveDate;
            rhsEffectiveDate = that.getEffectiveDate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "effectiveDate", lhsEffectiveDate), LocatorUtils.property(thatLocator, "effectiveDate", rhsEffectiveDate), lhsEffectiveDate, rhsEffectiveDate)) {
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
            String theWorkFlowStatus;
            theWorkFlowStatus = this.getWorkFlowStatus();
            strategy.appendField(locator, this, "workFlowStatus", buffer, theWorkFlowStatus);
        }
        {
            String theDataStatus;
            theDataStatus = this.getDataStatus();
            strategy.appendField(locator, this, "dataStatus", buffer, theDataStatus);
        }
        {
            XMLGregorianCalendar theEffectiveDate;
            theEffectiveDate = this.getEffectiveDate();
            strategy.appendField(locator, this, "effectiveDate", buffer, theEffectiveDate);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String theWorkFlowStatus;
            theWorkFlowStatus = this.getWorkFlowStatus();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "workFlowStatus", theWorkFlowStatus), currentHashCode, theWorkFlowStatus);
        }
        {
            String theDataStatus;
            theDataStatus = this.getDataStatus();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "dataStatus", theDataStatus), currentHashCode, theDataStatus);
        }
        {
            XMLGregorianCalendar theEffectiveDate;
            theEffectiveDate = this.getEffectiveDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "effectiveDate", theEffectiveDate), currentHashCode, theEffectiveDate);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
