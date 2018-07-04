
package eu.europa.ec.research.fp.model.legalentity.v11;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FactType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="FactType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="BankAccountFact"/>
 *     &lt;enumeration value="CertificationOnCostMethodologyFact"/>
 *     &lt;enumeration value="CIPLegalEntityFact"/>
 *     &lt;enumeration value="CIPRatiosFact"/>
 *     &lt;enumeration value="ContactFact"/>
 *     &lt;enumeration value="CoreFact"/>
 *     &lt;enumeration value="EACOrganisationTypeFact"/>
 *     &lt;enumeration value="ErasmusECHEAccreditationFact"/>
 *     &lt;enumeration value="ExtraCommunicationFact"/>
 *     &lt;enumeration value="ExtraDescriptionOfCoreActivitiesFact"/>
 *     &lt;enumeration value="ExtraNaceFact"/>
 *     &lt;enumeration value="FinancialDataFact"/>
 *     &lt;enumeration value="FP6LegacyFact"/>
 *     &lt;enumeration value="FP7EducationFact"/>
 *     &lt;enumeration value="FP7IBBAExemptionFact"/>
 *     &lt;enumeration value="FP7ICMFact"/>
 *     &lt;enumeration value="FP7InternationalOrganisationFact"/>
 *     &lt;enumeration value="FP7LegalEntityFact"/>
 *     &lt;enumeration value="FP7LegalPersonalityFact"/>
 *     &lt;enumeration value="FP7NonProfitFact"/>
 *     &lt;enumeration value="FP7RatiosFact"/>
 *     &lt;enumeration value="FP7ResearchOrganisationFact"/>
 *     &lt;enumeration value="NonBankruptcyDeclarationFact"/>
 *     &lt;enumeration value="SMEFact"/>
 *     &lt;enumeration value="SMESelfAssessmentFact"/>
 *     &lt;enumeration value="CivilSocietyFact"/>
 *     &lt;enumeration value="LargeInfrastructureFact"/>
 *     &lt;enumeration value="OrgWithOperatingGrantsFact"/>
 *     &lt;enumeration value="StateWarrantyFact"/>
 *     &lt;enumeration value="StateWarrantyH2020Fact"/>
 *     &lt;enumeration value="ExtendedMandateFact"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "FactType")
@XmlEnum
public enum FactType {

    @XmlEnumValue("BankAccountFact")
    BANK_ACCOUNT_FACT("BankAccountFact"),
    @XmlEnumValue("CertificationOnCostMethodologyFact")
    CERTIFICATION_ON_COST_METHODOLOGY_FACT("CertificationOnCostMethodologyFact"),
    @XmlEnumValue("CIPLegalEntityFact")
    CIP_LEGAL_ENTITY_FACT("CIPLegalEntityFact"),
    @XmlEnumValue("CIPRatiosFact")
    CIP_RATIOS_FACT("CIPRatiosFact"),
    @XmlEnumValue("ContactFact")
    CONTACT_FACT("ContactFact"),
    @XmlEnumValue("CoreFact")
    CORE_FACT("CoreFact"),
    @XmlEnumValue("EACOrganisationTypeFact")
    EAC_ORGANISATION_TYPE_FACT("EACOrganisationTypeFact"),
    @XmlEnumValue("ErasmusECHEAccreditationFact")
    ERASMUS_ECHE_ACCREDITATION_FACT("ErasmusECHEAccreditationFact"),
    @XmlEnumValue("ExtraCommunicationFact")
    EXTRA_COMMUNICATION_FACT("ExtraCommunicationFact"),
    @XmlEnumValue("ExtraDescriptionOfCoreActivitiesFact")
    EXTRA_DESCRIPTION_OF_CORE_ACTIVITIES_FACT("ExtraDescriptionOfCoreActivitiesFact"),
    @XmlEnumValue("ExtraNaceFact")
    EXTRA_NACE_FACT("ExtraNaceFact"),
    @XmlEnumValue("FinancialDataFact")
    FINANCIAL_DATA_FACT("FinancialDataFact"),
    @XmlEnumValue("FP6LegacyFact")
    FP_6_LEGACY_FACT("FP6LegacyFact"),
    @XmlEnumValue("FP7EducationFact")
    FP_7_EDUCATION_FACT("FP7EducationFact"),
    @XmlEnumValue("FP7IBBAExemptionFact")
    FP_7_IBBA_EXEMPTION_FACT("FP7IBBAExemptionFact"),
    @XmlEnumValue("FP7ICMFact")
    FP_7_ICM_FACT("FP7ICMFact"),
    @XmlEnumValue("FP7InternationalOrganisationFact")
    FP_7_INTERNATIONAL_ORGANISATION_FACT("FP7InternationalOrganisationFact"),
    @XmlEnumValue("FP7LegalEntityFact")
    FP_7_LEGAL_ENTITY_FACT("FP7LegalEntityFact"),
    @XmlEnumValue("FP7LegalPersonalityFact")
    FP_7_LEGAL_PERSONALITY_FACT("FP7LegalPersonalityFact"),
    @XmlEnumValue("FP7NonProfitFact")
    FP_7_NON_PROFIT_FACT("FP7NonProfitFact"),
    @XmlEnumValue("FP7RatiosFact")
    FP_7_RATIOS_FACT("FP7RatiosFact"),
    @XmlEnumValue("FP7ResearchOrganisationFact")
    FP_7_RESEARCH_ORGANISATION_FACT("FP7ResearchOrganisationFact"),
    @XmlEnumValue("NonBankruptcyDeclarationFact")
    NON_BANKRUPTCY_DECLARATION_FACT("NonBankruptcyDeclarationFact"),
    @XmlEnumValue("SMEFact")
    SME_FACT("SMEFact"),
    @XmlEnumValue("SMESelfAssessmentFact")
    SME_SELF_ASSESSMENT_FACT("SMESelfAssessmentFact"),
    @XmlEnumValue("CivilSocietyFact")
    CIVIL_SOCIETY_FACT("CivilSocietyFact"),
    @XmlEnumValue("LargeInfrastructureFact")
    LARGE_INFRASTRUCTURE_FACT("LargeInfrastructureFact"),
    @XmlEnumValue("OrgWithOperatingGrantsFact")
    ORG_WITH_OPERATING_GRANTS_FACT("OrgWithOperatingGrantsFact"),
    @XmlEnumValue("StateWarrantyFact")
    STATE_WARRANTY_FACT("StateWarrantyFact"),
    @XmlEnumValue("StateWarrantyH2020Fact")
    STATE_WARRANTY_H_2020_FACT("StateWarrantyH2020Fact"),
    @XmlEnumValue("ExtendedMandateFact")
    EXTENDED_MANDATE_FACT("ExtendedMandateFact");
    private final String value;

    FactType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static FactType fromValue(String v) {
        for (FactType c: FactType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
