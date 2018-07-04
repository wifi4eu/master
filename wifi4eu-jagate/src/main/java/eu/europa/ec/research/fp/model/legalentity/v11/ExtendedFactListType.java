
package eu.europa.ec.research.fp.model.legalentity.v11;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 * <p>Java class for ExtendedFactListType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExtendedFactListType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BankAccountFactList" type="{http://ec.europa.eu/research/fp/model/legalentity/V11}ExtendedBankAccountFactListType" minOccurs="0"/>
 *         &lt;element name="CertificationOnCostMethodologyFact" type="{http://ec.europa.eu/research/fp/model/legalentity/V11}ExtendedCertificationOnCostMethodologyFactType" minOccurs="0"/>
 *         &lt;element name="CIPLegalEntityFact" type="{http://ec.europa.eu/research/fp/model/legalentity/V11}ExtendedCIPLegalEntityFactType" minOccurs="0"/>
 *         &lt;element name="CIPRatiosFactList" type="{http://ec.europa.eu/research/fp/model/legalentity/V11}ExtendedCIPRatiosFactListType" minOccurs="0"/>
 *         &lt;element name="ContactFactList" type="{http://ec.europa.eu/research/fp/model/legalentity/V11}ExtendedContactFactListType" minOccurs="0"/>
 *         &lt;element name="CoreFact" type="{http://ec.europa.eu/research/fp/model/legalentity/V11}ExtendedCoreFactType" minOccurs="0"/>
 *         &lt;element name="EACOrganisationTypeFact" type="{http://ec.europa.eu/research/fp/model/legalentity/V11}ExtendedEACOrganisationTypeFactType" minOccurs="0"/>
 *         &lt;element name="ErasmusECHEAccreditationFactList" type="{http://ec.europa.eu/research/fp/model/legalentity/V11}ExtendedErasmusECHEAccreditationFactListType" minOccurs="0"/>
 *         &lt;element name="ExtraCommunicationFact" type="{http://ec.europa.eu/research/fp/model/legalentity/V11}ExtendedExtraCommunicationFactType" minOccurs="0"/>
 *         &lt;element name="ExtraDescriptionOfCoreActivitiesFact" type="{http://ec.europa.eu/research/fp/model/legalentity/V11}ExtendedExtraDescriptionOfCoreActivitiesFactType" minOccurs="0"/>
 *         &lt;element name="ExtraNaceFact" type="{http://ec.europa.eu/research/fp/model/legalentity/V11}ExtendedExtraNaceFactType" minOccurs="0"/>
 *         &lt;element name="FinancialDataFactList" type="{http://ec.europa.eu/research/fp/model/legalentity/V11}ExtendedFinancialDataFactListType" minOccurs="0"/>
 *         &lt;element name="FP6LegacyFact" type="{http://ec.europa.eu/research/fp/model/legalentity/V11}ExtendedFP6LegacyFactType" minOccurs="0"/>
 *         &lt;element name="FP7EducationFact" type="{http://ec.europa.eu/research/fp/model/legalentity/V11}ExtendedFP7EducationFactType" minOccurs="0"/>
 *         &lt;element name="FP7IBBAExemptionFact" type="{http://ec.europa.eu/research/fp/model/legalentity/V11}ExtendedFP7IBBAExemptionFactType" minOccurs="0"/>
 *         &lt;element name="FP7ICMFact" type="{http://ec.europa.eu/research/fp/model/legalentity/V11}ExtendedFP7ICMFactType" minOccurs="0"/>
 *         &lt;element name="FP7InternationalOrganisationFact" type="{http://ec.europa.eu/research/fp/model/legalentity/V11}ExtendedFP7InternationalOrganisationFactType" minOccurs="0"/>
 *         &lt;element name="FP7LegalEntityFact" type="{http://ec.europa.eu/research/fp/model/legalentity/V11}ExtendedFP7LegalEntityFactType" minOccurs="0"/>
 *         &lt;element name="FP7LegalPersonalityFact" type="{http://ec.europa.eu/research/fp/model/legalentity/V11}ExtendedFP7LegalPersonalityFactType" minOccurs="0"/>
 *         &lt;element name="FP7NonProfitFact" type="{http://ec.europa.eu/research/fp/model/legalentity/V11}ExtendedFP7NonProfitFactType" minOccurs="0"/>
 *         &lt;element name="FP7RatiosFactList" type="{http://ec.europa.eu/research/fp/model/legalentity/V11}ExtendedFP7RatiosFactListType" minOccurs="0"/>
 *         &lt;element name="FP7ResearchOrganisationFact" type="{http://ec.europa.eu/research/fp/model/legalentity/V11}ExtendedFP7ResearchOrganisationFactType" minOccurs="0"/>
 *         &lt;element name="NonBankruptcyDeclarationFactList" type="{http://ec.europa.eu/research/fp/model/legalentity/V11}ExtendedNonBankruptcyDeclarationFactListType" minOccurs="0"/>
 *         &lt;element name="SMEFactList" type="{http://ec.europa.eu/research/fp/model/legalentity/V11}ExtendedSMEFactListType" minOccurs="0"/>
 *         &lt;element name="SMESelfAssessmentFactList" type="{http://ec.europa.eu/research/fp/model/legalentity/V11}ExtendedSMESelfAssessmentFactListType" minOccurs="0"/>
 *         &lt;element name="StateWarrantyFact" type="{http://ec.europa.eu/research/fp/model/legalentity/V11}ExtendedStateWarrantyFactType" minOccurs="0"/>
 *         &lt;element name="StateWarrantyH2020Fact" type="{http://ec.europa.eu/research/fp/model/legalentity/V11}ExtendedStateWarrantyFactType" minOccurs="0"/>
 *         &lt;element name="CivilSocietyFact" type="{http://ec.europa.eu/research/fp/model/legalentity/V11}ExtendedCivilSocietyFactType" minOccurs="0"/>
 *         &lt;element name="LargeInfrastructureFact" type="{http://ec.europa.eu/research/fp/model/legalentity/V11}ExtendedLargeInfrastructureFactType" minOccurs="0"/>
 *         &lt;element name="OrgWithOperatingGrantsFact" type="{http://ec.europa.eu/research/fp/model/legalentity/V11}ExtendedOrgWithOperatingGrantsFactType" minOccurs="0"/>
 *         &lt;element name="ExtendedMandateFact" type="{http://ec.europa.eu/research/fp/model/legalentity/V11}ExtendedExtendedMandateFactType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExtendedFactListType", propOrder = {
    "bankAccountFactList",
    "certificationOnCostMethodologyFact",
    "cipLegalEntityFact",
    "cipRatiosFactList",
    "contactFactList",
    "coreFact",
    "eacOrganisationTypeFact",
    "erasmusECHEAccreditationFactList",
    "extraCommunicationFact",
    "extraDescriptionOfCoreActivitiesFact",
    "extraNaceFact",
    "financialDataFactList",
    "fp6LegacyFact",
    "fp7EducationFact",
    "fp7IBBAExemptionFact",
    "fp7ICMFact",
    "fp7InternationalOrganisationFact",
    "fp7LegalEntityFact",
    "fp7LegalPersonalityFact",
    "fp7NonProfitFact",
    "fp7RatiosFactList",
    "fp7ResearchOrganisationFact",
    "nonBankruptcyDeclarationFactList",
    "smeFactList",
    "smeSelfAssessmentFactList",
    "stateWarrantyFact",
    "stateWarrantyH2020Fact",
    "civilSocietyFact",
    "largeInfrastructureFact",
    "orgWithOperatingGrantsFact",
    "extendedMandateFact"
})
@XmlSeeAlso({
    LegalEntityType.class
})
public class ExtendedFactListType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "BankAccountFactList")
    protected ExtendedBankAccountFactListType bankAccountFactList;
    @XmlElement(name = "CertificationOnCostMethodologyFact")
    protected ExtendedCertificationOnCostMethodologyFactType certificationOnCostMethodologyFact;
    @XmlElement(name = "CIPLegalEntityFact")
    protected ExtendedCIPLegalEntityFactType cipLegalEntityFact;
    @XmlElement(name = "CIPRatiosFactList")
    protected ExtendedCIPRatiosFactListType cipRatiosFactList;
    @XmlElement(name = "ContactFactList")
    protected ExtendedContactFactListType contactFactList;
    @XmlElement(name = "CoreFact")
    protected ExtendedCoreFactType coreFact;
    @XmlElement(name = "EACOrganisationTypeFact")
    protected ExtendedEACOrganisationTypeFactType eacOrganisationTypeFact;
    @XmlElement(name = "ErasmusECHEAccreditationFactList")
    protected ExtendedErasmusECHEAccreditationFactListType erasmusECHEAccreditationFactList;
    @XmlElement(name = "ExtraCommunicationFact")
    protected ExtendedExtraCommunicationFactType extraCommunicationFact;
    @XmlElement(name = "ExtraDescriptionOfCoreActivitiesFact")
    protected ExtendedExtraDescriptionOfCoreActivitiesFactType extraDescriptionOfCoreActivitiesFact;
    @XmlElement(name = "ExtraNaceFact")
    protected ExtendedExtraNaceFactType extraNaceFact;
    @XmlElement(name = "FinancialDataFactList")
    protected ExtendedFinancialDataFactListType financialDataFactList;
    @XmlElement(name = "FP6LegacyFact")
    protected ExtendedFP6LegacyFactType fp6LegacyFact;
    @XmlElement(name = "FP7EducationFact")
    protected ExtendedFP7EducationFactType fp7EducationFact;
    @XmlElement(name = "FP7IBBAExemptionFact")
    protected ExtendedFP7IBBAExemptionFactType fp7IBBAExemptionFact;
    @XmlElement(name = "FP7ICMFact")
    protected ExtendedFP7ICMFactType fp7ICMFact;
    @XmlElement(name = "FP7InternationalOrganisationFact")
    protected ExtendedFP7InternationalOrganisationFactType fp7InternationalOrganisationFact;
    @XmlElement(name = "FP7LegalEntityFact")
    protected ExtendedFP7LegalEntityFactType fp7LegalEntityFact;
    @XmlElement(name = "FP7LegalPersonalityFact")
    protected ExtendedFP7LegalPersonalityFactType fp7LegalPersonalityFact;
    @XmlElement(name = "FP7NonProfitFact")
    protected ExtendedFP7NonProfitFactType fp7NonProfitFact;
    @XmlElement(name = "FP7RatiosFactList")
    protected ExtendedFP7RatiosFactListType fp7RatiosFactList;
    @XmlElement(name = "FP7ResearchOrganisationFact")
    protected ExtendedFP7ResearchOrganisationFactType fp7ResearchOrganisationFact;
    @XmlElement(name = "NonBankruptcyDeclarationFactList")
    protected ExtendedNonBankruptcyDeclarationFactListType nonBankruptcyDeclarationFactList;
    @XmlElement(name = "SMEFactList")
    protected ExtendedSMEFactListType smeFactList;
    @XmlElement(name = "SMESelfAssessmentFactList")
    protected ExtendedSMESelfAssessmentFactListType smeSelfAssessmentFactList;
    @XmlElement(name = "StateWarrantyFact")
    protected ExtendedStateWarrantyFactType stateWarrantyFact;
    @XmlElement(name = "StateWarrantyH2020Fact")
    protected ExtendedStateWarrantyFactType stateWarrantyH2020Fact;
    @XmlElement(name = "CivilSocietyFact")
    protected ExtendedCivilSocietyFactType civilSocietyFact;
    @XmlElement(name = "LargeInfrastructureFact")
    protected ExtendedLargeInfrastructureFactType largeInfrastructureFact;
    @XmlElement(name = "OrgWithOperatingGrantsFact")
    protected ExtendedOrgWithOperatingGrantsFactType orgWithOperatingGrantsFact;
    @XmlElement(name = "ExtendedMandateFact")
    protected ExtendedExtendedMandateFactType extendedMandateFact;

    /**
     * Gets the value of the bankAccountFactList property.
     * 
     * @return
     *     possible object is
     *     {@link ExtendedBankAccountFactListType }
     *     
     */
    public ExtendedBankAccountFactListType getBankAccountFactList() {
        return bankAccountFactList;
    }

    /**
     * Sets the value of the bankAccountFactList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtendedBankAccountFactListType }
     *     
     */
    public void setBankAccountFactList(ExtendedBankAccountFactListType value) {
        this.bankAccountFactList = value;
    }

    /**
     * Gets the value of the certificationOnCostMethodologyFact property.
     * 
     * @return
     *     possible object is
     *     {@link ExtendedCertificationOnCostMethodologyFactType }
     *     
     */
    public ExtendedCertificationOnCostMethodologyFactType getCertificationOnCostMethodologyFact() {
        return certificationOnCostMethodologyFact;
    }

    /**
     * Sets the value of the certificationOnCostMethodologyFact property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtendedCertificationOnCostMethodologyFactType }
     *     
     */
    public void setCertificationOnCostMethodologyFact(ExtendedCertificationOnCostMethodologyFactType value) {
        this.certificationOnCostMethodologyFact = value;
    }

    /**
     * Gets the value of the cipLegalEntityFact property.
     * 
     * @return
     *     possible object is
     *     {@link ExtendedCIPLegalEntityFactType }
     *     
     */
    public ExtendedCIPLegalEntityFactType getCIPLegalEntityFact() {
        return cipLegalEntityFact;
    }

    /**
     * Sets the value of the cipLegalEntityFact property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtendedCIPLegalEntityFactType }
     *     
     */
    public void setCIPLegalEntityFact(ExtendedCIPLegalEntityFactType value) {
        this.cipLegalEntityFact = value;
    }

    /**
     * Gets the value of the cipRatiosFactList property.
     * 
     * @return
     *     possible object is
     *     {@link ExtendedCIPRatiosFactListType }
     *     
     */
    public ExtendedCIPRatiosFactListType getCIPRatiosFactList() {
        return cipRatiosFactList;
    }

    /**
     * Sets the value of the cipRatiosFactList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtendedCIPRatiosFactListType }
     *     
     */
    public void setCIPRatiosFactList(ExtendedCIPRatiosFactListType value) {
        this.cipRatiosFactList = value;
    }

    /**
     * Gets the value of the contactFactList property.
     * 
     * @return
     *     possible object is
     *     {@link ExtendedContactFactListType }
     *     
     */
    public ExtendedContactFactListType getContactFactList() {
        return contactFactList;
    }

    /**
     * Sets the value of the contactFactList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtendedContactFactListType }
     *     
     */
    public void setContactFactList(ExtendedContactFactListType value) {
        this.contactFactList = value;
    }

    /**
     * Gets the value of the coreFact property.
     * 
     * @return
     *     possible object is
     *     {@link ExtendedCoreFactType }
     *     
     */
    public ExtendedCoreFactType getCoreFact() {
        return coreFact;
    }

    /**
     * Sets the value of the coreFact property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtendedCoreFactType }
     *     
     */
    public void setCoreFact(ExtendedCoreFactType value) {
        this.coreFact = value;
    }

    /**
     * Gets the value of the eacOrganisationTypeFact property.
     * 
     * @return
     *     possible object is
     *     {@link ExtendedEACOrganisationTypeFactType }
     *     
     */
    public ExtendedEACOrganisationTypeFactType getEACOrganisationTypeFact() {
        return eacOrganisationTypeFact;
    }

    /**
     * Sets the value of the eacOrganisationTypeFact property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtendedEACOrganisationTypeFactType }
     *     
     */
    public void setEACOrganisationTypeFact(ExtendedEACOrganisationTypeFactType value) {
        this.eacOrganisationTypeFact = value;
    }

    /**
     * Gets the value of the erasmusECHEAccreditationFactList property.
     * 
     * @return
     *     possible object is
     *     {@link ExtendedErasmusECHEAccreditationFactListType }
     *     
     */
    public ExtendedErasmusECHEAccreditationFactListType getErasmusECHEAccreditationFactList() {
        return erasmusECHEAccreditationFactList;
    }

    /**
     * Sets the value of the erasmusECHEAccreditationFactList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtendedErasmusECHEAccreditationFactListType }
     *     
     */
    public void setErasmusECHEAccreditationFactList(ExtendedErasmusECHEAccreditationFactListType value) {
        this.erasmusECHEAccreditationFactList = value;
    }

    /**
     * Gets the value of the extraCommunicationFact property.
     * 
     * @return
     *     possible object is
     *     {@link ExtendedExtraCommunicationFactType }
     *     
     */
    public ExtendedExtraCommunicationFactType getExtraCommunicationFact() {
        return extraCommunicationFact;
    }

    /**
     * Sets the value of the extraCommunicationFact property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtendedExtraCommunicationFactType }
     *     
     */
    public void setExtraCommunicationFact(ExtendedExtraCommunicationFactType value) {
        this.extraCommunicationFact = value;
    }

    /**
     * Gets the value of the extraDescriptionOfCoreActivitiesFact property.
     * 
     * @return
     *     possible object is
     *     {@link ExtendedExtraDescriptionOfCoreActivitiesFactType }
     *     
     */
    public ExtendedExtraDescriptionOfCoreActivitiesFactType getExtraDescriptionOfCoreActivitiesFact() {
        return extraDescriptionOfCoreActivitiesFact;
    }

    /**
     * Sets the value of the extraDescriptionOfCoreActivitiesFact property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtendedExtraDescriptionOfCoreActivitiesFactType }
     *     
     */
    public void setExtraDescriptionOfCoreActivitiesFact(ExtendedExtraDescriptionOfCoreActivitiesFactType value) {
        this.extraDescriptionOfCoreActivitiesFact = value;
    }

    /**
     * Gets the value of the extraNaceFact property.
     * 
     * @return
     *     possible object is
     *     {@link ExtendedExtraNaceFactType }
     *     
     */
    public ExtendedExtraNaceFactType getExtraNaceFact() {
        return extraNaceFact;
    }

    /**
     * Sets the value of the extraNaceFact property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtendedExtraNaceFactType }
     *     
     */
    public void setExtraNaceFact(ExtendedExtraNaceFactType value) {
        this.extraNaceFact = value;
    }

    /**
     * Gets the value of the financialDataFactList property.
     * 
     * @return
     *     possible object is
     *     {@link ExtendedFinancialDataFactListType }
     *     
     */
    public ExtendedFinancialDataFactListType getFinancialDataFactList() {
        return financialDataFactList;
    }

    /**
     * Sets the value of the financialDataFactList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtendedFinancialDataFactListType }
     *     
     */
    public void setFinancialDataFactList(ExtendedFinancialDataFactListType value) {
        this.financialDataFactList = value;
    }

    /**
     * Gets the value of the fp6LegacyFact property.
     * 
     * @return
     *     possible object is
     *     {@link ExtendedFP6LegacyFactType }
     *     
     */
    public ExtendedFP6LegacyFactType getFP6LegacyFact() {
        return fp6LegacyFact;
    }

    /**
     * Sets the value of the fp6LegacyFact property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtendedFP6LegacyFactType }
     *     
     */
    public void setFP6LegacyFact(ExtendedFP6LegacyFactType value) {
        this.fp6LegacyFact = value;
    }

    /**
     * Gets the value of the fp7EducationFact property.
     * 
     * @return
     *     possible object is
     *     {@link ExtendedFP7EducationFactType }
     *     
     */
    public ExtendedFP7EducationFactType getFP7EducationFact() {
        return fp7EducationFact;
    }

    /**
     * Sets the value of the fp7EducationFact property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtendedFP7EducationFactType }
     *     
     */
    public void setFP7EducationFact(ExtendedFP7EducationFactType value) {
        this.fp7EducationFact = value;
    }

    /**
     * Gets the value of the fp7IBBAExemptionFact property.
     * 
     * @return
     *     possible object is
     *     {@link ExtendedFP7IBBAExemptionFactType }
     *     
     */
    public ExtendedFP7IBBAExemptionFactType getFP7IBBAExemptionFact() {
        return fp7IBBAExemptionFact;
    }

    /**
     * Sets the value of the fp7IBBAExemptionFact property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtendedFP7IBBAExemptionFactType }
     *     
     */
    public void setFP7IBBAExemptionFact(ExtendedFP7IBBAExemptionFactType value) {
        this.fp7IBBAExemptionFact = value;
    }

    /**
     * Gets the value of the fp7ICMFact property.
     * 
     * @return
     *     possible object is
     *     {@link ExtendedFP7ICMFactType }
     *     
     */
    public ExtendedFP7ICMFactType getFP7ICMFact() {
        return fp7ICMFact;
    }

    /**
     * Sets the value of the fp7ICMFact property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtendedFP7ICMFactType }
     *     
     */
    public void setFP7ICMFact(ExtendedFP7ICMFactType value) {
        this.fp7ICMFact = value;
    }

    /**
     * Gets the value of the fp7InternationalOrganisationFact property.
     * 
     * @return
     *     possible object is
     *     {@link ExtendedFP7InternationalOrganisationFactType }
     *     
     */
    public ExtendedFP7InternationalOrganisationFactType getFP7InternationalOrganisationFact() {
        return fp7InternationalOrganisationFact;
    }

    /**
     * Sets the value of the fp7InternationalOrganisationFact property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtendedFP7InternationalOrganisationFactType }
     *     
     */
    public void setFP7InternationalOrganisationFact(ExtendedFP7InternationalOrganisationFactType value) {
        this.fp7InternationalOrganisationFact = value;
    }

    /**
     * Gets the value of the fp7LegalEntityFact property.
     * 
     * @return
     *     possible object is
     *     {@link ExtendedFP7LegalEntityFactType }
     *     
     */
    public ExtendedFP7LegalEntityFactType getFP7LegalEntityFact() {
        return fp7LegalEntityFact;
    }

    /**
     * Sets the value of the fp7LegalEntityFact property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtendedFP7LegalEntityFactType }
     *     
     */
    public void setFP7LegalEntityFact(ExtendedFP7LegalEntityFactType value) {
        this.fp7LegalEntityFact = value;
    }

    /**
     * Gets the value of the fp7LegalPersonalityFact property.
     * 
     * @return
     *     possible object is
     *     {@link ExtendedFP7LegalPersonalityFactType }
     *     
     */
    public ExtendedFP7LegalPersonalityFactType getFP7LegalPersonalityFact() {
        return fp7LegalPersonalityFact;
    }

    /**
     * Sets the value of the fp7LegalPersonalityFact property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtendedFP7LegalPersonalityFactType }
     *     
     */
    public void setFP7LegalPersonalityFact(ExtendedFP7LegalPersonalityFactType value) {
        this.fp7LegalPersonalityFact = value;
    }

    /**
     * Gets the value of the fp7NonProfitFact property.
     * 
     * @return
     *     possible object is
     *     {@link ExtendedFP7NonProfitFactType }
     *     
     */
    public ExtendedFP7NonProfitFactType getFP7NonProfitFact() {
        return fp7NonProfitFact;
    }

    /**
     * Sets the value of the fp7NonProfitFact property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtendedFP7NonProfitFactType }
     *     
     */
    public void setFP7NonProfitFact(ExtendedFP7NonProfitFactType value) {
        this.fp7NonProfitFact = value;
    }

    /**
     * Gets the value of the fp7RatiosFactList property.
     * 
     * @return
     *     possible object is
     *     {@link ExtendedFP7RatiosFactListType }
     *     
     */
    public ExtendedFP7RatiosFactListType getFP7RatiosFactList() {
        return fp7RatiosFactList;
    }

    /**
     * Sets the value of the fp7RatiosFactList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtendedFP7RatiosFactListType }
     *     
     */
    public void setFP7RatiosFactList(ExtendedFP7RatiosFactListType value) {
        this.fp7RatiosFactList = value;
    }

    /**
     * Gets the value of the fp7ResearchOrganisationFact property.
     * 
     * @return
     *     possible object is
     *     {@link ExtendedFP7ResearchOrganisationFactType }
     *     
     */
    public ExtendedFP7ResearchOrganisationFactType getFP7ResearchOrganisationFact() {
        return fp7ResearchOrganisationFact;
    }

    /**
     * Sets the value of the fp7ResearchOrganisationFact property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtendedFP7ResearchOrganisationFactType }
     *     
     */
    public void setFP7ResearchOrganisationFact(ExtendedFP7ResearchOrganisationFactType value) {
        this.fp7ResearchOrganisationFact = value;
    }

    /**
     * Gets the value of the nonBankruptcyDeclarationFactList property.
     * 
     * @return
     *     possible object is
     *     {@link ExtendedNonBankruptcyDeclarationFactListType }
     *     
     */
    public ExtendedNonBankruptcyDeclarationFactListType getNonBankruptcyDeclarationFactList() {
        return nonBankruptcyDeclarationFactList;
    }

    /**
     * Sets the value of the nonBankruptcyDeclarationFactList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtendedNonBankruptcyDeclarationFactListType }
     *     
     */
    public void setNonBankruptcyDeclarationFactList(ExtendedNonBankruptcyDeclarationFactListType value) {
        this.nonBankruptcyDeclarationFactList = value;
    }

    /**
     * Gets the value of the smeFactList property.
     * 
     * @return
     *     possible object is
     *     {@link ExtendedSMEFactListType }
     *     
     */
    public ExtendedSMEFactListType getSMEFactList() {
        return smeFactList;
    }

    /**
     * Sets the value of the smeFactList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtendedSMEFactListType }
     *     
     */
    public void setSMEFactList(ExtendedSMEFactListType value) {
        this.smeFactList = value;
    }

    /**
     * Gets the value of the smeSelfAssessmentFactList property.
     * 
     * @return
     *     possible object is
     *     {@link ExtendedSMESelfAssessmentFactListType }
     *     
     */
    public ExtendedSMESelfAssessmentFactListType getSMESelfAssessmentFactList() {
        return smeSelfAssessmentFactList;
    }

    /**
     * Sets the value of the smeSelfAssessmentFactList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtendedSMESelfAssessmentFactListType }
     *     
     */
    public void setSMESelfAssessmentFactList(ExtendedSMESelfAssessmentFactListType value) {
        this.smeSelfAssessmentFactList = value;
    }

    /**
     * Gets the value of the stateWarrantyFact property.
     * 
     * @return
     *     possible object is
     *     {@link ExtendedStateWarrantyFactType }
     *     
     */
    public ExtendedStateWarrantyFactType getStateWarrantyFact() {
        return stateWarrantyFact;
    }

    /**
     * Sets the value of the stateWarrantyFact property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtendedStateWarrantyFactType }
     *     
     */
    public void setStateWarrantyFact(ExtendedStateWarrantyFactType value) {
        this.stateWarrantyFact = value;
    }

    /**
     * Gets the value of the stateWarrantyH2020Fact property.
     * 
     * @return
     *     possible object is
     *     {@link ExtendedStateWarrantyFactType }
     *     
     */
    public ExtendedStateWarrantyFactType getStateWarrantyH2020Fact() {
        return stateWarrantyH2020Fact;
    }

    /**
     * Sets the value of the stateWarrantyH2020Fact property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtendedStateWarrantyFactType }
     *     
     */
    public void setStateWarrantyH2020Fact(ExtendedStateWarrantyFactType value) {
        this.stateWarrantyH2020Fact = value;
    }

    /**
     * Gets the value of the civilSocietyFact property.
     * 
     * @return
     *     possible object is
     *     {@link ExtendedCivilSocietyFactType }
     *     
     */
    public ExtendedCivilSocietyFactType getCivilSocietyFact() {
        return civilSocietyFact;
    }

    /**
     * Sets the value of the civilSocietyFact property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtendedCivilSocietyFactType }
     *     
     */
    public void setCivilSocietyFact(ExtendedCivilSocietyFactType value) {
        this.civilSocietyFact = value;
    }

    /**
     * Gets the value of the largeInfrastructureFact property.
     * 
     * @return
     *     possible object is
     *     {@link ExtendedLargeInfrastructureFactType }
     *     
     */
    public ExtendedLargeInfrastructureFactType getLargeInfrastructureFact() {
        return largeInfrastructureFact;
    }

    /**
     * Sets the value of the largeInfrastructureFact property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtendedLargeInfrastructureFactType }
     *     
     */
    public void setLargeInfrastructureFact(ExtendedLargeInfrastructureFactType value) {
        this.largeInfrastructureFact = value;
    }

    /**
     * Gets the value of the orgWithOperatingGrantsFact property.
     * 
     * @return
     *     possible object is
     *     {@link ExtendedOrgWithOperatingGrantsFactType }
     *     
     */
    public ExtendedOrgWithOperatingGrantsFactType getOrgWithOperatingGrantsFact() {
        return orgWithOperatingGrantsFact;
    }

    /**
     * Sets the value of the orgWithOperatingGrantsFact property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtendedOrgWithOperatingGrantsFactType }
     *     
     */
    public void setOrgWithOperatingGrantsFact(ExtendedOrgWithOperatingGrantsFactType value) {
        this.orgWithOperatingGrantsFact = value;
    }

    /**
     * Gets the value of the extendedMandateFact property.
     * 
     * @return
     *     possible object is
     *     {@link ExtendedExtendedMandateFactType }
     *     
     */
    public ExtendedExtendedMandateFactType getExtendedMandateFact() {
        return extendedMandateFact;
    }

    /**
     * Sets the value of the extendedMandateFact property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtendedExtendedMandateFactType }
     *     
     */
    public void setExtendedMandateFact(ExtendedExtendedMandateFactType value) {
        this.extendedMandateFact = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ExtendedFactListType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final ExtendedFactListType that = ((ExtendedFactListType) object);
        {
            ExtendedBankAccountFactListType lhsBankAccountFactList;
            lhsBankAccountFactList = this.getBankAccountFactList();
            ExtendedBankAccountFactListType rhsBankAccountFactList;
            rhsBankAccountFactList = that.getBankAccountFactList();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "bankAccountFactList", lhsBankAccountFactList), LocatorUtils.property(thatLocator, "bankAccountFactList", rhsBankAccountFactList), lhsBankAccountFactList, rhsBankAccountFactList)) {
                return false;
            }
        }
        {
            ExtendedCertificationOnCostMethodologyFactType lhsCertificationOnCostMethodologyFact;
            lhsCertificationOnCostMethodologyFact = this.getCertificationOnCostMethodologyFact();
            ExtendedCertificationOnCostMethodologyFactType rhsCertificationOnCostMethodologyFact;
            rhsCertificationOnCostMethodologyFact = that.getCertificationOnCostMethodologyFact();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "certificationOnCostMethodologyFact", lhsCertificationOnCostMethodologyFact), LocatorUtils.property(thatLocator, "certificationOnCostMethodologyFact", rhsCertificationOnCostMethodologyFact), lhsCertificationOnCostMethodologyFact, rhsCertificationOnCostMethodologyFact)) {
                return false;
            }
        }
        {
            ExtendedCIPLegalEntityFactType lhsCIPLegalEntityFact;
            lhsCIPLegalEntityFact = this.getCIPLegalEntityFact();
            ExtendedCIPLegalEntityFactType rhsCIPLegalEntityFact;
            rhsCIPLegalEntityFact = that.getCIPLegalEntityFact();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "cipLegalEntityFact", lhsCIPLegalEntityFact), LocatorUtils.property(thatLocator, "cipLegalEntityFact", rhsCIPLegalEntityFact), lhsCIPLegalEntityFact, rhsCIPLegalEntityFact)) {
                return false;
            }
        }
        {
            ExtendedCIPRatiosFactListType lhsCIPRatiosFactList;
            lhsCIPRatiosFactList = this.getCIPRatiosFactList();
            ExtendedCIPRatiosFactListType rhsCIPRatiosFactList;
            rhsCIPRatiosFactList = that.getCIPRatiosFactList();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "cipRatiosFactList", lhsCIPRatiosFactList), LocatorUtils.property(thatLocator, "cipRatiosFactList", rhsCIPRatiosFactList), lhsCIPRatiosFactList, rhsCIPRatiosFactList)) {
                return false;
            }
        }
        {
            ExtendedContactFactListType lhsContactFactList;
            lhsContactFactList = this.getContactFactList();
            ExtendedContactFactListType rhsContactFactList;
            rhsContactFactList = that.getContactFactList();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "contactFactList", lhsContactFactList), LocatorUtils.property(thatLocator, "contactFactList", rhsContactFactList), lhsContactFactList, rhsContactFactList)) {
                return false;
            }
        }
        {
            ExtendedCoreFactType lhsCoreFact;
            lhsCoreFact = this.getCoreFact();
            ExtendedCoreFactType rhsCoreFact;
            rhsCoreFact = that.getCoreFact();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "coreFact", lhsCoreFact), LocatorUtils.property(thatLocator, "coreFact", rhsCoreFact), lhsCoreFact, rhsCoreFact)) {
                return false;
            }
        }
        {
            ExtendedEACOrganisationTypeFactType lhsEACOrganisationTypeFact;
            lhsEACOrganisationTypeFact = this.getEACOrganisationTypeFact();
            ExtendedEACOrganisationTypeFactType rhsEACOrganisationTypeFact;
            rhsEACOrganisationTypeFact = that.getEACOrganisationTypeFact();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "eacOrganisationTypeFact", lhsEACOrganisationTypeFact), LocatorUtils.property(thatLocator, "eacOrganisationTypeFact", rhsEACOrganisationTypeFact), lhsEACOrganisationTypeFact, rhsEACOrganisationTypeFact)) {
                return false;
            }
        }
        {
            ExtendedErasmusECHEAccreditationFactListType lhsErasmusECHEAccreditationFactList;
            lhsErasmusECHEAccreditationFactList = this.getErasmusECHEAccreditationFactList();
            ExtendedErasmusECHEAccreditationFactListType rhsErasmusECHEAccreditationFactList;
            rhsErasmusECHEAccreditationFactList = that.getErasmusECHEAccreditationFactList();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "erasmusECHEAccreditationFactList", lhsErasmusECHEAccreditationFactList), LocatorUtils.property(thatLocator, "erasmusECHEAccreditationFactList", rhsErasmusECHEAccreditationFactList), lhsErasmusECHEAccreditationFactList, rhsErasmusECHEAccreditationFactList)) {
                return false;
            }
        }
        {
            ExtendedExtraCommunicationFactType lhsExtraCommunicationFact;
            lhsExtraCommunicationFact = this.getExtraCommunicationFact();
            ExtendedExtraCommunicationFactType rhsExtraCommunicationFact;
            rhsExtraCommunicationFact = that.getExtraCommunicationFact();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "extraCommunicationFact", lhsExtraCommunicationFact), LocatorUtils.property(thatLocator, "extraCommunicationFact", rhsExtraCommunicationFact), lhsExtraCommunicationFact, rhsExtraCommunicationFact)) {
                return false;
            }
        }
        {
            ExtendedExtraDescriptionOfCoreActivitiesFactType lhsExtraDescriptionOfCoreActivitiesFact;
            lhsExtraDescriptionOfCoreActivitiesFact = this.getExtraDescriptionOfCoreActivitiesFact();
            ExtendedExtraDescriptionOfCoreActivitiesFactType rhsExtraDescriptionOfCoreActivitiesFact;
            rhsExtraDescriptionOfCoreActivitiesFact = that.getExtraDescriptionOfCoreActivitiesFact();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "extraDescriptionOfCoreActivitiesFact", lhsExtraDescriptionOfCoreActivitiesFact), LocatorUtils.property(thatLocator, "extraDescriptionOfCoreActivitiesFact", rhsExtraDescriptionOfCoreActivitiesFact), lhsExtraDescriptionOfCoreActivitiesFact, rhsExtraDescriptionOfCoreActivitiesFact)) {
                return false;
            }
        }
        {
            ExtendedExtraNaceFactType lhsExtraNaceFact;
            lhsExtraNaceFact = this.getExtraNaceFact();
            ExtendedExtraNaceFactType rhsExtraNaceFact;
            rhsExtraNaceFact = that.getExtraNaceFact();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "extraNaceFact", lhsExtraNaceFact), LocatorUtils.property(thatLocator, "extraNaceFact", rhsExtraNaceFact), lhsExtraNaceFact, rhsExtraNaceFact)) {
                return false;
            }
        }
        {
            ExtendedFinancialDataFactListType lhsFinancialDataFactList;
            lhsFinancialDataFactList = this.getFinancialDataFactList();
            ExtendedFinancialDataFactListType rhsFinancialDataFactList;
            rhsFinancialDataFactList = that.getFinancialDataFactList();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "financialDataFactList", lhsFinancialDataFactList), LocatorUtils.property(thatLocator, "financialDataFactList", rhsFinancialDataFactList), lhsFinancialDataFactList, rhsFinancialDataFactList)) {
                return false;
            }
        }
        {
            ExtendedFP6LegacyFactType lhsFP6LegacyFact;
            lhsFP6LegacyFact = this.getFP6LegacyFact();
            ExtendedFP6LegacyFactType rhsFP6LegacyFact;
            rhsFP6LegacyFact = that.getFP6LegacyFact();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "fp6LegacyFact", lhsFP6LegacyFact), LocatorUtils.property(thatLocator, "fp6LegacyFact", rhsFP6LegacyFact), lhsFP6LegacyFact, rhsFP6LegacyFact)) {
                return false;
            }
        }
        {
            ExtendedFP7EducationFactType lhsFP7EducationFact;
            lhsFP7EducationFact = this.getFP7EducationFact();
            ExtendedFP7EducationFactType rhsFP7EducationFact;
            rhsFP7EducationFact = that.getFP7EducationFact();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "fp7EducationFact", lhsFP7EducationFact), LocatorUtils.property(thatLocator, "fp7EducationFact", rhsFP7EducationFact), lhsFP7EducationFact, rhsFP7EducationFact)) {
                return false;
            }
        }
        {
            ExtendedFP7IBBAExemptionFactType lhsFP7IBBAExemptionFact;
            lhsFP7IBBAExemptionFact = this.getFP7IBBAExemptionFact();
            ExtendedFP7IBBAExemptionFactType rhsFP7IBBAExemptionFact;
            rhsFP7IBBAExemptionFact = that.getFP7IBBAExemptionFact();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "fp7IBBAExemptionFact", lhsFP7IBBAExemptionFact), LocatorUtils.property(thatLocator, "fp7IBBAExemptionFact", rhsFP7IBBAExemptionFact), lhsFP7IBBAExemptionFact, rhsFP7IBBAExemptionFact)) {
                return false;
            }
        }
        {
            ExtendedFP7ICMFactType lhsFP7ICMFact;
            lhsFP7ICMFact = this.getFP7ICMFact();
            ExtendedFP7ICMFactType rhsFP7ICMFact;
            rhsFP7ICMFact = that.getFP7ICMFact();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "fp7ICMFact", lhsFP7ICMFact), LocatorUtils.property(thatLocator, "fp7ICMFact", rhsFP7ICMFact), lhsFP7ICMFact, rhsFP7ICMFact)) {
                return false;
            }
        }
        {
            ExtendedFP7InternationalOrganisationFactType lhsFP7InternationalOrganisationFact;
            lhsFP7InternationalOrganisationFact = this.getFP7InternationalOrganisationFact();
            ExtendedFP7InternationalOrganisationFactType rhsFP7InternationalOrganisationFact;
            rhsFP7InternationalOrganisationFact = that.getFP7InternationalOrganisationFact();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "fp7InternationalOrganisationFact", lhsFP7InternationalOrganisationFact), LocatorUtils.property(thatLocator, "fp7InternationalOrganisationFact", rhsFP7InternationalOrganisationFact), lhsFP7InternationalOrganisationFact, rhsFP7InternationalOrganisationFact)) {
                return false;
            }
        }
        {
            ExtendedFP7LegalEntityFactType lhsFP7LegalEntityFact;
            lhsFP7LegalEntityFact = this.getFP7LegalEntityFact();
            ExtendedFP7LegalEntityFactType rhsFP7LegalEntityFact;
            rhsFP7LegalEntityFact = that.getFP7LegalEntityFact();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "fp7LegalEntityFact", lhsFP7LegalEntityFact), LocatorUtils.property(thatLocator, "fp7LegalEntityFact", rhsFP7LegalEntityFact), lhsFP7LegalEntityFact, rhsFP7LegalEntityFact)) {
                return false;
            }
        }
        {
            ExtendedFP7LegalPersonalityFactType lhsFP7LegalPersonalityFact;
            lhsFP7LegalPersonalityFact = this.getFP7LegalPersonalityFact();
            ExtendedFP7LegalPersonalityFactType rhsFP7LegalPersonalityFact;
            rhsFP7LegalPersonalityFact = that.getFP7LegalPersonalityFact();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "fp7LegalPersonalityFact", lhsFP7LegalPersonalityFact), LocatorUtils.property(thatLocator, "fp7LegalPersonalityFact", rhsFP7LegalPersonalityFact), lhsFP7LegalPersonalityFact, rhsFP7LegalPersonalityFact)) {
                return false;
            }
        }
        {
            ExtendedFP7NonProfitFactType lhsFP7NonProfitFact;
            lhsFP7NonProfitFact = this.getFP7NonProfitFact();
            ExtendedFP7NonProfitFactType rhsFP7NonProfitFact;
            rhsFP7NonProfitFact = that.getFP7NonProfitFact();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "fp7NonProfitFact", lhsFP7NonProfitFact), LocatorUtils.property(thatLocator, "fp7NonProfitFact", rhsFP7NonProfitFact), lhsFP7NonProfitFact, rhsFP7NonProfitFact)) {
                return false;
            }
        }
        {
            ExtendedFP7RatiosFactListType lhsFP7RatiosFactList;
            lhsFP7RatiosFactList = this.getFP7RatiosFactList();
            ExtendedFP7RatiosFactListType rhsFP7RatiosFactList;
            rhsFP7RatiosFactList = that.getFP7RatiosFactList();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "fp7RatiosFactList", lhsFP7RatiosFactList), LocatorUtils.property(thatLocator, "fp7RatiosFactList", rhsFP7RatiosFactList), lhsFP7RatiosFactList, rhsFP7RatiosFactList)) {
                return false;
            }
        }
        {
            ExtendedFP7ResearchOrganisationFactType lhsFP7ResearchOrganisationFact;
            lhsFP7ResearchOrganisationFact = this.getFP7ResearchOrganisationFact();
            ExtendedFP7ResearchOrganisationFactType rhsFP7ResearchOrganisationFact;
            rhsFP7ResearchOrganisationFact = that.getFP7ResearchOrganisationFact();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "fp7ResearchOrganisationFact", lhsFP7ResearchOrganisationFact), LocatorUtils.property(thatLocator, "fp7ResearchOrganisationFact", rhsFP7ResearchOrganisationFact), lhsFP7ResearchOrganisationFact, rhsFP7ResearchOrganisationFact)) {
                return false;
            }
        }
        {
            ExtendedNonBankruptcyDeclarationFactListType lhsNonBankruptcyDeclarationFactList;
            lhsNonBankruptcyDeclarationFactList = this.getNonBankruptcyDeclarationFactList();
            ExtendedNonBankruptcyDeclarationFactListType rhsNonBankruptcyDeclarationFactList;
            rhsNonBankruptcyDeclarationFactList = that.getNonBankruptcyDeclarationFactList();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "nonBankruptcyDeclarationFactList", lhsNonBankruptcyDeclarationFactList), LocatorUtils.property(thatLocator, "nonBankruptcyDeclarationFactList", rhsNonBankruptcyDeclarationFactList), lhsNonBankruptcyDeclarationFactList, rhsNonBankruptcyDeclarationFactList)) {
                return false;
            }
        }
        {
            ExtendedSMEFactListType lhsSMEFactList;
            lhsSMEFactList = this.getSMEFactList();
            ExtendedSMEFactListType rhsSMEFactList;
            rhsSMEFactList = that.getSMEFactList();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "smeFactList", lhsSMEFactList), LocatorUtils.property(thatLocator, "smeFactList", rhsSMEFactList), lhsSMEFactList, rhsSMEFactList)) {
                return false;
            }
        }
        {
            ExtendedSMESelfAssessmentFactListType lhsSMESelfAssessmentFactList;
            lhsSMESelfAssessmentFactList = this.getSMESelfAssessmentFactList();
            ExtendedSMESelfAssessmentFactListType rhsSMESelfAssessmentFactList;
            rhsSMESelfAssessmentFactList = that.getSMESelfAssessmentFactList();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "smeSelfAssessmentFactList", lhsSMESelfAssessmentFactList), LocatorUtils.property(thatLocator, "smeSelfAssessmentFactList", rhsSMESelfAssessmentFactList), lhsSMESelfAssessmentFactList, rhsSMESelfAssessmentFactList)) {
                return false;
            }
        }
        {
            ExtendedStateWarrantyFactType lhsStateWarrantyFact;
            lhsStateWarrantyFact = this.getStateWarrantyFact();
            ExtendedStateWarrantyFactType rhsStateWarrantyFact;
            rhsStateWarrantyFact = that.getStateWarrantyFact();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "stateWarrantyFact", lhsStateWarrantyFact), LocatorUtils.property(thatLocator, "stateWarrantyFact", rhsStateWarrantyFact), lhsStateWarrantyFact, rhsStateWarrantyFact)) {
                return false;
            }
        }
        {
            ExtendedStateWarrantyFactType lhsStateWarrantyH2020Fact;
            lhsStateWarrantyH2020Fact = this.getStateWarrantyH2020Fact();
            ExtendedStateWarrantyFactType rhsStateWarrantyH2020Fact;
            rhsStateWarrantyH2020Fact = that.getStateWarrantyH2020Fact();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "stateWarrantyH2020Fact", lhsStateWarrantyH2020Fact), LocatorUtils.property(thatLocator, "stateWarrantyH2020Fact", rhsStateWarrantyH2020Fact), lhsStateWarrantyH2020Fact, rhsStateWarrantyH2020Fact)) {
                return false;
            }
        }
        {
            ExtendedCivilSocietyFactType lhsCivilSocietyFact;
            lhsCivilSocietyFact = this.getCivilSocietyFact();
            ExtendedCivilSocietyFactType rhsCivilSocietyFact;
            rhsCivilSocietyFact = that.getCivilSocietyFact();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "civilSocietyFact", lhsCivilSocietyFact), LocatorUtils.property(thatLocator, "civilSocietyFact", rhsCivilSocietyFact), lhsCivilSocietyFact, rhsCivilSocietyFact)) {
                return false;
            }
        }
        {
            ExtendedLargeInfrastructureFactType lhsLargeInfrastructureFact;
            lhsLargeInfrastructureFact = this.getLargeInfrastructureFact();
            ExtendedLargeInfrastructureFactType rhsLargeInfrastructureFact;
            rhsLargeInfrastructureFact = that.getLargeInfrastructureFact();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "largeInfrastructureFact", lhsLargeInfrastructureFact), LocatorUtils.property(thatLocator, "largeInfrastructureFact", rhsLargeInfrastructureFact), lhsLargeInfrastructureFact, rhsLargeInfrastructureFact)) {
                return false;
            }
        }
        {
            ExtendedOrgWithOperatingGrantsFactType lhsOrgWithOperatingGrantsFact;
            lhsOrgWithOperatingGrantsFact = this.getOrgWithOperatingGrantsFact();
            ExtendedOrgWithOperatingGrantsFactType rhsOrgWithOperatingGrantsFact;
            rhsOrgWithOperatingGrantsFact = that.getOrgWithOperatingGrantsFact();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "orgWithOperatingGrantsFact", lhsOrgWithOperatingGrantsFact), LocatorUtils.property(thatLocator, "orgWithOperatingGrantsFact", rhsOrgWithOperatingGrantsFact), lhsOrgWithOperatingGrantsFact, rhsOrgWithOperatingGrantsFact)) {
                return false;
            }
        }
        {
            ExtendedExtendedMandateFactType lhsExtendedMandateFact;
            lhsExtendedMandateFact = this.getExtendedMandateFact();
            ExtendedExtendedMandateFactType rhsExtendedMandateFact;
            rhsExtendedMandateFact = that.getExtendedMandateFact();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "extendedMandateFact", lhsExtendedMandateFact), LocatorUtils.property(thatLocator, "extendedMandateFact", rhsExtendedMandateFact), lhsExtendedMandateFact, rhsExtendedMandateFact)) {
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
            ExtendedBankAccountFactListType theBankAccountFactList;
            theBankAccountFactList = this.getBankAccountFactList();
            strategy.appendField(locator, this, "bankAccountFactList", buffer, theBankAccountFactList);
        }
        {
            ExtendedCertificationOnCostMethodologyFactType theCertificationOnCostMethodologyFact;
            theCertificationOnCostMethodologyFact = this.getCertificationOnCostMethodologyFact();
            strategy.appendField(locator, this, "certificationOnCostMethodologyFact", buffer, theCertificationOnCostMethodologyFact);
        }
        {
            ExtendedCIPLegalEntityFactType theCIPLegalEntityFact;
            theCIPLegalEntityFact = this.getCIPLegalEntityFact();
            strategy.appendField(locator, this, "cipLegalEntityFact", buffer, theCIPLegalEntityFact);
        }
        {
            ExtendedCIPRatiosFactListType theCIPRatiosFactList;
            theCIPRatiosFactList = this.getCIPRatiosFactList();
            strategy.appendField(locator, this, "cipRatiosFactList", buffer, theCIPRatiosFactList);
        }
        {
            ExtendedContactFactListType theContactFactList;
            theContactFactList = this.getContactFactList();
            strategy.appendField(locator, this, "contactFactList", buffer, theContactFactList);
        }
        {
            ExtendedCoreFactType theCoreFact;
            theCoreFact = this.getCoreFact();
            strategy.appendField(locator, this, "coreFact", buffer, theCoreFact);
        }
        {
            ExtendedEACOrganisationTypeFactType theEACOrganisationTypeFact;
            theEACOrganisationTypeFact = this.getEACOrganisationTypeFact();
            strategy.appendField(locator, this, "eacOrganisationTypeFact", buffer, theEACOrganisationTypeFact);
        }
        {
            ExtendedErasmusECHEAccreditationFactListType theErasmusECHEAccreditationFactList;
            theErasmusECHEAccreditationFactList = this.getErasmusECHEAccreditationFactList();
            strategy.appendField(locator, this, "erasmusECHEAccreditationFactList", buffer, theErasmusECHEAccreditationFactList);
        }
        {
            ExtendedExtraCommunicationFactType theExtraCommunicationFact;
            theExtraCommunicationFact = this.getExtraCommunicationFact();
            strategy.appendField(locator, this, "extraCommunicationFact", buffer, theExtraCommunicationFact);
        }
        {
            ExtendedExtraDescriptionOfCoreActivitiesFactType theExtraDescriptionOfCoreActivitiesFact;
            theExtraDescriptionOfCoreActivitiesFact = this.getExtraDescriptionOfCoreActivitiesFact();
            strategy.appendField(locator, this, "extraDescriptionOfCoreActivitiesFact", buffer, theExtraDescriptionOfCoreActivitiesFact);
        }
        {
            ExtendedExtraNaceFactType theExtraNaceFact;
            theExtraNaceFact = this.getExtraNaceFact();
            strategy.appendField(locator, this, "extraNaceFact", buffer, theExtraNaceFact);
        }
        {
            ExtendedFinancialDataFactListType theFinancialDataFactList;
            theFinancialDataFactList = this.getFinancialDataFactList();
            strategy.appendField(locator, this, "financialDataFactList", buffer, theFinancialDataFactList);
        }
        {
            ExtendedFP6LegacyFactType theFP6LegacyFact;
            theFP6LegacyFact = this.getFP6LegacyFact();
            strategy.appendField(locator, this, "fp6LegacyFact", buffer, theFP6LegacyFact);
        }
        {
            ExtendedFP7EducationFactType theFP7EducationFact;
            theFP7EducationFact = this.getFP7EducationFact();
            strategy.appendField(locator, this, "fp7EducationFact", buffer, theFP7EducationFact);
        }
        {
            ExtendedFP7IBBAExemptionFactType theFP7IBBAExemptionFact;
            theFP7IBBAExemptionFact = this.getFP7IBBAExemptionFact();
            strategy.appendField(locator, this, "fp7IBBAExemptionFact", buffer, theFP7IBBAExemptionFact);
        }
        {
            ExtendedFP7ICMFactType theFP7ICMFact;
            theFP7ICMFact = this.getFP7ICMFact();
            strategy.appendField(locator, this, "fp7ICMFact", buffer, theFP7ICMFact);
        }
        {
            ExtendedFP7InternationalOrganisationFactType theFP7InternationalOrganisationFact;
            theFP7InternationalOrganisationFact = this.getFP7InternationalOrganisationFact();
            strategy.appendField(locator, this, "fp7InternationalOrganisationFact", buffer, theFP7InternationalOrganisationFact);
        }
        {
            ExtendedFP7LegalEntityFactType theFP7LegalEntityFact;
            theFP7LegalEntityFact = this.getFP7LegalEntityFact();
            strategy.appendField(locator, this, "fp7LegalEntityFact", buffer, theFP7LegalEntityFact);
        }
        {
            ExtendedFP7LegalPersonalityFactType theFP7LegalPersonalityFact;
            theFP7LegalPersonalityFact = this.getFP7LegalPersonalityFact();
            strategy.appendField(locator, this, "fp7LegalPersonalityFact", buffer, theFP7LegalPersonalityFact);
        }
        {
            ExtendedFP7NonProfitFactType theFP7NonProfitFact;
            theFP7NonProfitFact = this.getFP7NonProfitFact();
            strategy.appendField(locator, this, "fp7NonProfitFact", buffer, theFP7NonProfitFact);
        }
        {
            ExtendedFP7RatiosFactListType theFP7RatiosFactList;
            theFP7RatiosFactList = this.getFP7RatiosFactList();
            strategy.appendField(locator, this, "fp7RatiosFactList", buffer, theFP7RatiosFactList);
        }
        {
            ExtendedFP7ResearchOrganisationFactType theFP7ResearchOrganisationFact;
            theFP7ResearchOrganisationFact = this.getFP7ResearchOrganisationFact();
            strategy.appendField(locator, this, "fp7ResearchOrganisationFact", buffer, theFP7ResearchOrganisationFact);
        }
        {
            ExtendedNonBankruptcyDeclarationFactListType theNonBankruptcyDeclarationFactList;
            theNonBankruptcyDeclarationFactList = this.getNonBankruptcyDeclarationFactList();
            strategy.appendField(locator, this, "nonBankruptcyDeclarationFactList", buffer, theNonBankruptcyDeclarationFactList);
        }
        {
            ExtendedSMEFactListType theSMEFactList;
            theSMEFactList = this.getSMEFactList();
            strategy.appendField(locator, this, "smeFactList", buffer, theSMEFactList);
        }
        {
            ExtendedSMESelfAssessmentFactListType theSMESelfAssessmentFactList;
            theSMESelfAssessmentFactList = this.getSMESelfAssessmentFactList();
            strategy.appendField(locator, this, "smeSelfAssessmentFactList", buffer, theSMESelfAssessmentFactList);
        }
        {
            ExtendedStateWarrantyFactType theStateWarrantyFact;
            theStateWarrantyFact = this.getStateWarrantyFact();
            strategy.appendField(locator, this, "stateWarrantyFact", buffer, theStateWarrantyFact);
        }
        {
            ExtendedStateWarrantyFactType theStateWarrantyH2020Fact;
            theStateWarrantyH2020Fact = this.getStateWarrantyH2020Fact();
            strategy.appendField(locator, this, "stateWarrantyH2020Fact", buffer, theStateWarrantyH2020Fact);
        }
        {
            ExtendedCivilSocietyFactType theCivilSocietyFact;
            theCivilSocietyFact = this.getCivilSocietyFact();
            strategy.appendField(locator, this, "civilSocietyFact", buffer, theCivilSocietyFact);
        }
        {
            ExtendedLargeInfrastructureFactType theLargeInfrastructureFact;
            theLargeInfrastructureFact = this.getLargeInfrastructureFact();
            strategy.appendField(locator, this, "largeInfrastructureFact", buffer, theLargeInfrastructureFact);
        }
        {
            ExtendedOrgWithOperatingGrantsFactType theOrgWithOperatingGrantsFact;
            theOrgWithOperatingGrantsFact = this.getOrgWithOperatingGrantsFact();
            strategy.appendField(locator, this, "orgWithOperatingGrantsFact", buffer, theOrgWithOperatingGrantsFact);
        }
        {
            ExtendedExtendedMandateFactType theExtendedMandateFact;
            theExtendedMandateFact = this.getExtendedMandateFact();
            strategy.appendField(locator, this, "extendedMandateFact", buffer, theExtendedMandateFact);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            ExtendedBankAccountFactListType theBankAccountFactList;
            theBankAccountFactList = this.getBankAccountFactList();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "bankAccountFactList", theBankAccountFactList), currentHashCode, theBankAccountFactList);
        }
        {
            ExtendedCertificationOnCostMethodologyFactType theCertificationOnCostMethodologyFact;
            theCertificationOnCostMethodologyFact = this.getCertificationOnCostMethodologyFact();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "certificationOnCostMethodologyFact", theCertificationOnCostMethodologyFact), currentHashCode, theCertificationOnCostMethodologyFact);
        }
        {
            ExtendedCIPLegalEntityFactType theCIPLegalEntityFact;
            theCIPLegalEntityFact = this.getCIPLegalEntityFact();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "cipLegalEntityFact", theCIPLegalEntityFact), currentHashCode, theCIPLegalEntityFact);
        }
        {
            ExtendedCIPRatiosFactListType theCIPRatiosFactList;
            theCIPRatiosFactList = this.getCIPRatiosFactList();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "cipRatiosFactList", theCIPRatiosFactList), currentHashCode, theCIPRatiosFactList);
        }
        {
            ExtendedContactFactListType theContactFactList;
            theContactFactList = this.getContactFactList();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "contactFactList", theContactFactList), currentHashCode, theContactFactList);
        }
        {
            ExtendedCoreFactType theCoreFact;
            theCoreFact = this.getCoreFact();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "coreFact", theCoreFact), currentHashCode, theCoreFact);
        }
        {
            ExtendedEACOrganisationTypeFactType theEACOrganisationTypeFact;
            theEACOrganisationTypeFact = this.getEACOrganisationTypeFact();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "eacOrganisationTypeFact", theEACOrganisationTypeFact), currentHashCode, theEACOrganisationTypeFact);
        }
        {
            ExtendedErasmusECHEAccreditationFactListType theErasmusECHEAccreditationFactList;
            theErasmusECHEAccreditationFactList = this.getErasmusECHEAccreditationFactList();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "erasmusECHEAccreditationFactList", theErasmusECHEAccreditationFactList), currentHashCode, theErasmusECHEAccreditationFactList);
        }
        {
            ExtendedExtraCommunicationFactType theExtraCommunicationFact;
            theExtraCommunicationFact = this.getExtraCommunicationFact();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "extraCommunicationFact", theExtraCommunicationFact), currentHashCode, theExtraCommunicationFact);
        }
        {
            ExtendedExtraDescriptionOfCoreActivitiesFactType theExtraDescriptionOfCoreActivitiesFact;
            theExtraDescriptionOfCoreActivitiesFact = this.getExtraDescriptionOfCoreActivitiesFact();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "extraDescriptionOfCoreActivitiesFact", theExtraDescriptionOfCoreActivitiesFact), currentHashCode, theExtraDescriptionOfCoreActivitiesFact);
        }
        {
            ExtendedExtraNaceFactType theExtraNaceFact;
            theExtraNaceFact = this.getExtraNaceFact();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "extraNaceFact", theExtraNaceFact), currentHashCode, theExtraNaceFact);
        }
        {
            ExtendedFinancialDataFactListType theFinancialDataFactList;
            theFinancialDataFactList = this.getFinancialDataFactList();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "financialDataFactList", theFinancialDataFactList), currentHashCode, theFinancialDataFactList);
        }
        {
            ExtendedFP6LegacyFactType theFP6LegacyFact;
            theFP6LegacyFact = this.getFP6LegacyFact();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fp6LegacyFact", theFP6LegacyFact), currentHashCode, theFP6LegacyFact);
        }
        {
            ExtendedFP7EducationFactType theFP7EducationFact;
            theFP7EducationFact = this.getFP7EducationFact();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fp7EducationFact", theFP7EducationFact), currentHashCode, theFP7EducationFact);
        }
        {
            ExtendedFP7IBBAExemptionFactType theFP7IBBAExemptionFact;
            theFP7IBBAExemptionFact = this.getFP7IBBAExemptionFact();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fp7IBBAExemptionFact", theFP7IBBAExemptionFact), currentHashCode, theFP7IBBAExemptionFact);
        }
        {
            ExtendedFP7ICMFactType theFP7ICMFact;
            theFP7ICMFact = this.getFP7ICMFact();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fp7ICMFact", theFP7ICMFact), currentHashCode, theFP7ICMFact);
        }
        {
            ExtendedFP7InternationalOrganisationFactType theFP7InternationalOrganisationFact;
            theFP7InternationalOrganisationFact = this.getFP7InternationalOrganisationFact();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fp7InternationalOrganisationFact", theFP7InternationalOrganisationFact), currentHashCode, theFP7InternationalOrganisationFact);
        }
        {
            ExtendedFP7LegalEntityFactType theFP7LegalEntityFact;
            theFP7LegalEntityFact = this.getFP7LegalEntityFact();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fp7LegalEntityFact", theFP7LegalEntityFact), currentHashCode, theFP7LegalEntityFact);
        }
        {
            ExtendedFP7LegalPersonalityFactType theFP7LegalPersonalityFact;
            theFP7LegalPersonalityFact = this.getFP7LegalPersonalityFact();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fp7LegalPersonalityFact", theFP7LegalPersonalityFact), currentHashCode, theFP7LegalPersonalityFact);
        }
        {
            ExtendedFP7NonProfitFactType theFP7NonProfitFact;
            theFP7NonProfitFact = this.getFP7NonProfitFact();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fp7NonProfitFact", theFP7NonProfitFact), currentHashCode, theFP7NonProfitFact);
        }
        {
            ExtendedFP7RatiosFactListType theFP7RatiosFactList;
            theFP7RatiosFactList = this.getFP7RatiosFactList();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fp7RatiosFactList", theFP7RatiosFactList), currentHashCode, theFP7RatiosFactList);
        }
        {
            ExtendedFP7ResearchOrganisationFactType theFP7ResearchOrganisationFact;
            theFP7ResearchOrganisationFact = this.getFP7ResearchOrganisationFact();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fp7ResearchOrganisationFact", theFP7ResearchOrganisationFact), currentHashCode, theFP7ResearchOrganisationFact);
        }
        {
            ExtendedNonBankruptcyDeclarationFactListType theNonBankruptcyDeclarationFactList;
            theNonBankruptcyDeclarationFactList = this.getNonBankruptcyDeclarationFactList();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "nonBankruptcyDeclarationFactList", theNonBankruptcyDeclarationFactList), currentHashCode, theNonBankruptcyDeclarationFactList);
        }
        {
            ExtendedSMEFactListType theSMEFactList;
            theSMEFactList = this.getSMEFactList();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "smeFactList", theSMEFactList), currentHashCode, theSMEFactList);
        }
        {
            ExtendedSMESelfAssessmentFactListType theSMESelfAssessmentFactList;
            theSMESelfAssessmentFactList = this.getSMESelfAssessmentFactList();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "smeSelfAssessmentFactList", theSMESelfAssessmentFactList), currentHashCode, theSMESelfAssessmentFactList);
        }
        {
            ExtendedStateWarrantyFactType theStateWarrantyFact;
            theStateWarrantyFact = this.getStateWarrantyFact();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "stateWarrantyFact", theStateWarrantyFact), currentHashCode, theStateWarrantyFact);
        }
        {
            ExtendedStateWarrantyFactType theStateWarrantyH2020Fact;
            theStateWarrantyH2020Fact = this.getStateWarrantyH2020Fact();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "stateWarrantyH2020Fact", theStateWarrantyH2020Fact), currentHashCode, theStateWarrantyH2020Fact);
        }
        {
            ExtendedCivilSocietyFactType theCivilSocietyFact;
            theCivilSocietyFact = this.getCivilSocietyFact();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "civilSocietyFact", theCivilSocietyFact), currentHashCode, theCivilSocietyFact);
        }
        {
            ExtendedLargeInfrastructureFactType theLargeInfrastructureFact;
            theLargeInfrastructureFact = this.getLargeInfrastructureFact();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "largeInfrastructureFact", theLargeInfrastructureFact), currentHashCode, theLargeInfrastructureFact);
        }
        {
            ExtendedOrgWithOperatingGrantsFactType theOrgWithOperatingGrantsFact;
            theOrgWithOperatingGrantsFact = this.getOrgWithOperatingGrantsFact();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "orgWithOperatingGrantsFact", theOrgWithOperatingGrantsFact), currentHashCode, theOrgWithOperatingGrantsFact);
        }
        {
            ExtendedExtendedMandateFactType theExtendedMandateFact;
            theExtendedMandateFact = this.getExtendedMandateFact();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "extendedMandateFact", theExtendedMandateFact), currentHashCode, theExtendedMandateFact);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
