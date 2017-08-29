
package wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.budgetary_commitment_level2.v1;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.ares_document.v1.AresDocumentsType;
import wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.complex_type.v1.AuditInfoType;
import wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.contractor_reference.v1.ContractorReferencesType;
import wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.external_criteria.v1.ExternalCriteriasType;
import wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.organisation.v1.ResponsibleOrganisationType;
import wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.responsible_user.v1.ResponsibleUsersType;
import wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.scanned_document.v1.ScannedDocumentsType;
import wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.supporting_document.v1.SupportingDocumentFolderType;
import wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.workflow_object.v1.WorkflowInfoType;


/**
 * <p>Clase Java para BudgetaryCommitmentLevel2GetType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="BudgetaryCommitmentLevel2GetType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AnnualInstallmentFlag" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}IndicatorType" minOccurs="0"/&gt;
 *         &lt;element name="AnnualInstallmentJustification" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}AnnualInstallmentJustificationType" minOccurs="0"/&gt;
 *         &lt;element name="AuditInfo" type="{http://www.ec.europa.eu/budg/abac/complex_type/v1}AuditInfoType"/&gt;
 *         &lt;element name="BeneficiaryName" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}BeneficiaryNameType" minOccurs="0"/&gt;
 *         &lt;element name="BeneficiaryContact" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}BeneficiaryContactType" minOccurs="0"/&gt;
 *         &lt;element name="BeneficiaryStreet" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}BeneficiaryStreetType" minOccurs="0"/&gt;
 *         &lt;element name="BeneficiaryPostCode" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}BeneficiaryPostCodeType" minOccurs="0"/&gt;
 *         &lt;element name="BeneficiaryPostBox" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}BeneficiaryPostBoxType" minOccurs="0"/&gt;
 *         &lt;element name="BeneficiaryCity" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}BeneficiaryCityType" minOccurs="0"/&gt;
 *         &lt;element name="BeneficiaryCountryIso2Code" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}BeneficiaryCountryIso2CodeType" minOccurs="0"/&gt;
 *         &lt;element name="BeneficiaryCounty" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}BeneficiaryCountyType" minOccurs="0"/&gt;
 *         &lt;element name="BudgetManagementTypeCode" type="{http://www.ec.europa.eu/budg/abac/budget_management_type/v1}CodeType" minOccurs="0"/&gt;
 *         &lt;element name="ClassCode" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}ClassCodeType" minOccurs="0"/&gt;
 *         &lt;element name="CompletionFlag" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}IndicatorType" minOccurs="0"/&gt;
 *         &lt;element name="CompletionModReason" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}CompletionModReasonType" minOccurs="0"/&gt;
 *         &lt;element name="ConsumingL1ReasonJustCode" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}JustificationCodeType" minOccurs="0"/&gt;
 *         &lt;element name="ContractSignDate" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}DateType" minOccurs="0"/&gt;
 *         &lt;element name="ContractSignEntryUser" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}UserIdType" minOccurs="0"/&gt;
 *         &lt;element name="ContractSignEntryDate" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}DateType" minOccurs="0"/&gt;
 *         &lt;element name="CurrencyIso3Code" type="{http://www.ec.europa.eu/budg/abac/currency/v1}Iso3CodeType" minOccurs="0"/&gt;
 *         &lt;element name="CurrentBudgetYear" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}CurrentBudgetYearType" minOccurs="0"/&gt;
 *         &lt;element name="ExpenditureCategoryCode" type="{http://www.ec.europa.eu/budg/abac/expenditure_category/v1}CodeType" minOccurs="0"/&gt;
 *         &lt;element name="FdiDelimiterCode" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}FdiDelimiterCodeType" minOccurs="0"/&gt;
 *         &lt;element name="FileReference" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}FileReferenceType" minOccurs="0"/&gt;
 *         &lt;element name="FinancialRegulationGroupCode" type="{http://www.ec.europa.eu/budg/abac/financial_regulation/v1}FinancialRegulationGroupCodeType" minOccurs="0"/&gt;
 *         &lt;element name="Guarantees" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="GuaranteeLocalKey" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}LocalKeyType" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ImplementedByCode" type="{http://www.ec.europa.eu/budg/abac/implemented_by/v1}CodeType" minOccurs="0"/&gt;
 *         &lt;element name="Invoices" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="InvoiceLocalKey" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}LocalKeyType" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="JustificationCodeForNoFdcIlc" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}JustificationCodeType" minOccurs="0"/&gt;
 *         &lt;element name="JustificationCsd" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}JustificationCodeType" minOccurs="0"/&gt;
 *         &lt;element name="JustificationForContractSignedDateCode" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}JustificationCodeType" minOccurs="0"/&gt;
 *         &lt;element name="JustificationForMultiplePaymentClassCode" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}JustificationCodeType" minOccurs="0"/&gt;
 *         &lt;element name="JustificationForMultipleThirdpartyCode" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}JustificationCodeType" minOccurs="0"/&gt;
 *         &lt;element name="JustificationForNoThirdpartyCode" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}JustificationCodeType" minOccurs="0"/&gt;
 *         &lt;element name="JustificationNoContractorRefCode" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}JustificationCodeType" minOccurs="0"/&gt;
 *         &lt;element name="LegalCommitmentVersions" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="LegalCommitmentVersionLocalKey" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}LocalKeyType" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="LegalJustificationCode" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}JustificationCodeType" minOccurs="0"/&gt;
 *         &lt;element name="LocalKey" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}LocalKeyType"/&gt;
 *         &lt;element name="PaymentClassCode" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}PaymentClassCodeType" minOccurs="0"/&gt;
 *         &lt;element name="PaymentSchemes" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="PaymentScheme" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}PaymentSchemeType" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="PotentialAbnormalRAL" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="OldCommitment" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}OldCommitmentType" minOccurs="0"/&gt;
 *                   &lt;element name="SleepingCommitment" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}SleepingCommitmentType" minOccurs="0"/&gt;
 *                   &lt;element name="RAL" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}RALType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                   &lt;element name="Remarks" type="{http://www.ec.europa.eu/budg/abac/local_abac_document/v1}RemarksType" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="PrefinBalanceAnalysis" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}PrefinBalanceAnalysisType" minOccurs="0"/&gt;
 *         &lt;element name="PrefinGuaranteeAmount" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}AmountType" minOccurs="0"/&gt;
 *         &lt;element name="PrefinGuaranteeJustificationCode" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}JustificationCodeType" minOccurs="0"/&gt;
 *         &lt;element name="PrefinGuaranteeJustificationFinRegulCode" type="{http://www.ec.europa.eu/budg/abac/financial_regulation/v1}FinancialRegulationCodeType" minOccurs="0"/&gt;
 *         &lt;element name="Project" type="{http://www.ec.europa.eu/budg/abac/local_abac_document/v1}ProjectType" minOccurs="0"/&gt;
 *         &lt;element name="ProposedFdiDate" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}DateType" minOccurs="0"/&gt;
 *         &lt;element name="ReferenceTreatyCode" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}ReferenceTreatyCodeType" minOccurs="0"/&gt;
 *         &lt;element name="Remarks" type="{http://www.ec.europa.eu/budg/abac/local_abac_document/v1}RemarksType" minOccurs="0"/&gt;
 *         &lt;element name="ResponsibleOrganisation" type="{http://www.ec.europa.eu/budg/abac/organisation/v1}ResponsibleOrganisationType"/&gt;
 *         &lt;element name="StillToCoverInEuroAmount" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}AmountType" minOccurs="0"/&gt;
 *         &lt;element name="UpdateFdiReason" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}UpdateFdiReasonType" minOccurs="0"/&gt;
 *         &lt;element name="UserReference" type="{http://www.ec.europa.eu/budg/abac/local_abac_document/v1}UserReferenceType" minOccurs="0"/&gt;
 *         &lt;element name="WorkflowInfo" type="{http://www.ec.europa.eu/budg/abac/workflow_object/v1}WorkflowInfoType" minOccurs="0"/&gt;
 *         &lt;element name="AresDocuments" type="{http://www.ec.europa.eu/budg/abac/ares_document/v1}AresDocumentsType" minOccurs="0"/&gt;
 *         &lt;element name="BudgetCompanyCode" type="{http://www.ec.europa.eu/budg/abac/abac_object/v1}BudgetCompanyCodeType"/&gt;
 *         &lt;element name="ContractorReferences" type="{http://www.ec.europa.eu/budg/abac/contractor_reference/v1}ContractorReferencesType" minOccurs="0"/&gt;
 *         &lt;element name="ExternalCriterias" type="{http://www.ec.europa.eu/budg/abac/external_criteria/v1}ExternalCriteriasType" minOccurs="0"/&gt;
 *         &lt;element name="LocalSystemCode" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}LocalSystemCodeType"/&gt;
 *         &lt;group ref="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}PositionsOrEnvelopeLinkChoiceGroupGet" minOccurs="0"/&gt;
 *         &lt;element name="ResponsibleUsers" type="{http://www.ec.europa.eu/budg/abac/responsible_user/v1}ResponsibleUsersType" minOccurs="0"/&gt;
 *         &lt;element name="ScannedDocuments" type="{http://www.ec.europa.eu/budg/abac/scanned_document/v1}ScannedDocumentsType" minOccurs="0"/&gt;
 *         &lt;element name="SupportingDocumentFolder" type="{http://www.ec.europa.eu/budg/abac/supporting_document/v1}SupportingDocumentFolderType" minOccurs="0"/&gt;
 *         &lt;element name="CommitmentL2Consumptions" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}CommitmentL2ConsumptionsType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BudgetaryCommitmentLevel2GetType", propOrder = {
    "annualInstallmentFlag",
    "annualInstallmentJustification",
    "auditInfo",
    "beneficiaryName",
    "beneficiaryContact",
    "beneficiaryStreet",
    "beneficiaryPostCode",
    "beneficiaryPostBox",
    "beneficiaryCity",
    "beneficiaryCountryIso2Code",
    "beneficiaryCounty",
    "budgetManagementTypeCode",
    "classCode",
    "completionFlag",
    "completionModReason",
    "consumingL1ReasonJustCode",
    "contractSignDate",
    "contractSignEntryUser",
    "contractSignEntryDate",
    "currencyIso3Code",
    "currentBudgetYear",
    "expenditureCategoryCode",
    "fdiDelimiterCode",
    "fileReference",
    "financialRegulationGroupCode",
    "guarantees",
    "implementedByCode",
    "invoices",
    "justificationCodeForNoFdcIlc",
    "justificationCsd",
    "justificationForContractSignedDateCode",
    "justificationForMultiplePaymentClassCode",
    "justificationForMultipleThirdpartyCode",
    "justificationForNoThirdpartyCode",
    "justificationNoContractorRefCode",
    "legalCommitmentVersions",
    "legalJustificationCode",
    "localKey",
    "paymentClassCode",
    "paymentSchemes",
    "potentialAbnormalRAL",
    "prefinBalanceAnalysis",
    "prefinGuaranteeAmount",
    "prefinGuaranteeJustificationCode",
    "prefinGuaranteeJustificationFinRegulCode",
    "project",
    "proposedFdiDate",
    "referenceTreatyCode",
    "remarks",
    "responsibleOrganisation",
    "stillToCoverInEuroAmount",
    "updateFdiReason",
    "userReference",
    "workflowInfo",
    "aresDocuments",
    "budgetCompanyCode",
    "contractorReferences",
    "externalCriterias",
    "localSystemCode",
    "commitmentPositions",
    "envelopeLink",
    "responsibleUsers",
    "scannedDocuments",
    "supportingDocumentFolder",
    "commitmentL2Consumptions"
})
public class BudgetaryCommitmentLevel2GetType {

    @XmlElement(name = "AnnualInstallmentFlag")
    protected Boolean annualInstallmentFlag;
    @XmlElement(name = "AnnualInstallmentJustification")
    protected String annualInstallmentJustification;
    @XmlElement(name = "AuditInfo", required = true)
    protected AuditInfoType auditInfo;
    @XmlElement(name = "BeneficiaryName")
    protected String beneficiaryName;
    @XmlElement(name = "BeneficiaryContact")
    protected String beneficiaryContact;
    @XmlElement(name = "BeneficiaryStreet")
    protected String beneficiaryStreet;
    @XmlElement(name = "BeneficiaryPostCode")
    protected String beneficiaryPostCode;
    @XmlElement(name = "BeneficiaryPostBox")
    protected String beneficiaryPostBox;
    @XmlElement(name = "BeneficiaryCity")
    protected String beneficiaryCity;
    @XmlElement(name = "BeneficiaryCountryIso2Code")
    protected String beneficiaryCountryIso2Code;
    @XmlElement(name = "BeneficiaryCounty")
    protected String beneficiaryCounty;
    @XmlElement(name = "BudgetManagementTypeCode")
    protected String budgetManagementTypeCode;
    @XmlElement(name = "ClassCode")
    protected String classCode;
    @XmlElement(name = "CompletionFlag")
    protected Boolean completionFlag;
    @XmlElement(name = "CompletionModReason")
    protected String completionModReason;
    @XmlElement(name = "ConsumingL1ReasonJustCode")
    protected String consumingL1ReasonJustCode;
    @XmlElement(name = "ContractSignDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar contractSignDate;
    @XmlElement(name = "ContractSignEntryUser")
    protected String contractSignEntryUser;
    @XmlElement(name = "ContractSignEntryDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar contractSignEntryDate;
    @XmlElement(name = "CurrencyIso3Code")
    protected String currencyIso3Code;
    @XmlElement(name = "CurrentBudgetYear")
    protected String currentBudgetYear;
    @XmlElement(name = "ExpenditureCategoryCode")
    protected String expenditureCategoryCode;
    @XmlElement(name = "FdiDelimiterCode")
    protected String fdiDelimiterCode;
    @XmlElement(name = "FileReference")
    protected String fileReference;
    @XmlElement(name = "FinancialRegulationGroupCode")
    protected String financialRegulationGroupCode;
    @XmlElement(name = "Guarantees")
    protected Guarantees guarantees;
    @XmlElement(name = "ImplementedByCode")
    protected String implementedByCode;
    @XmlElement(name = "Invoices")
    protected Invoices invoices;
    @XmlElement(name = "JustificationCodeForNoFdcIlc")
    protected String justificationCodeForNoFdcIlc;
    @XmlElement(name = "JustificationCsd")
    protected String justificationCsd;
    @XmlElement(name = "JustificationForContractSignedDateCode")
    protected String justificationForContractSignedDateCode;
    @XmlElement(name = "JustificationForMultiplePaymentClassCode")
    protected String justificationForMultiplePaymentClassCode;
    @XmlElement(name = "JustificationForMultipleThirdpartyCode")
    protected String justificationForMultipleThirdpartyCode;
    @XmlElement(name = "JustificationForNoThirdpartyCode")
    protected String justificationForNoThirdpartyCode;
    @XmlElement(name = "JustificationNoContractorRefCode")
    protected String justificationNoContractorRefCode;
    @XmlElement(name = "LegalCommitmentVersions")
    protected LegalCommitmentVersions legalCommitmentVersions;
    @XmlElement(name = "LegalJustificationCode")
    protected String legalJustificationCode;
    @XmlElement(name = "LocalKey", required = true)
    protected String localKey;
    @XmlElement(name = "PaymentClassCode")
    protected String paymentClassCode;
    @XmlElement(name = "PaymentSchemes")
    protected PaymentSchemes paymentSchemes;
    @XmlElement(name = "PotentialAbnormalRAL")
    protected PotentialAbnormalRAL potentialAbnormalRAL;
    @XmlElement(name = "PrefinBalanceAnalysis")
    protected String prefinBalanceAnalysis;
    @XmlElement(name = "PrefinGuaranteeAmount")
    protected BigDecimal prefinGuaranteeAmount;
    @XmlElement(name = "PrefinGuaranteeJustificationCode")
    protected String prefinGuaranteeJustificationCode;
    @XmlElement(name = "PrefinGuaranteeJustificationFinRegulCode")
    protected String prefinGuaranteeJustificationFinRegulCode;
    @XmlElement(name = "Project")
    protected String project;
    @XmlElement(name = "ProposedFdiDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar proposedFdiDate;
    @XmlElement(name = "ReferenceTreatyCode")
    protected String referenceTreatyCode;
    @XmlElement(name = "Remarks")
    protected String remarks;
    @XmlElement(name = "ResponsibleOrganisation", required = true)
    protected ResponsibleOrganisationType responsibleOrganisation;
    @XmlElement(name = "StillToCoverInEuroAmount")
    protected BigDecimal stillToCoverInEuroAmount;
    @XmlElement(name = "UpdateFdiReason")
    protected String updateFdiReason;
    @XmlElement(name = "UserReference")
    protected String userReference;
    @XmlElement(name = "WorkflowInfo")
    protected WorkflowInfoType workflowInfo;
    @XmlElement(name = "AresDocuments")
    protected AresDocumentsType aresDocuments;
    @XmlElement(name = "BudgetCompanyCode", required = true)
    protected String budgetCompanyCode;
    @XmlElement(name = "ContractorReferences")
    protected ContractorReferencesType contractorReferences;
    @XmlElement(name = "ExternalCriterias")
    protected ExternalCriteriasType externalCriterias;
    @XmlElement(name = "LocalSystemCode", required = true)
    protected String localSystemCode;
    @XmlElement(name = "CommitmentPositions")
    protected CommitmentPositionsGetType commitmentPositions;
    @XmlElement(name = "EnvelopeLink")
    protected BudgetaryCommitmentLevel2EnvelopeLinkCreateType envelopeLink;
    @XmlElement(name = "ResponsibleUsers")
    protected ResponsibleUsersType responsibleUsers;
    @XmlElement(name = "ScannedDocuments")
    protected ScannedDocumentsType scannedDocuments;
    @XmlElement(name = "SupportingDocumentFolder")
    protected SupportingDocumentFolderType supportingDocumentFolder;
    @XmlElement(name = "CommitmentL2Consumptions")
    protected CommitmentL2ConsumptionsType commitmentL2Consumptions;

    /**
     * Obtiene el valor de la propiedad annualInstallmentFlag.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAnnualInstallmentFlag() {
        return annualInstallmentFlag;
    }

    /**
     * Define el valor de la propiedad annualInstallmentFlag.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAnnualInstallmentFlag(Boolean value) {
        this.annualInstallmentFlag = value;
    }

    /**
     * Obtiene el valor de la propiedad annualInstallmentJustification.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnnualInstallmentJustification() {
        return annualInstallmentJustification;
    }

    /**
     * Define el valor de la propiedad annualInstallmentJustification.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnnualInstallmentJustification(String value) {
        this.annualInstallmentJustification = value;
    }

    /**
     * Obtiene el valor de la propiedad auditInfo.
     * 
     * @return
     *     possible object is
     *     {@link AuditInfoType }
     *     
     */
    public AuditInfoType getAuditInfo() {
        return auditInfo;
    }

    /**
     * Define el valor de la propiedad auditInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link AuditInfoType }
     *     
     */
    public void setAuditInfo(AuditInfoType value) {
        this.auditInfo = value;
    }

    /**
     * Obtiene el valor de la propiedad beneficiaryName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeneficiaryName() {
        return beneficiaryName;
    }

    /**
     * Define el valor de la propiedad beneficiaryName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeneficiaryName(String value) {
        this.beneficiaryName = value;
    }

    /**
     * Obtiene el valor de la propiedad beneficiaryContact.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeneficiaryContact() {
        return beneficiaryContact;
    }

    /**
     * Define el valor de la propiedad beneficiaryContact.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeneficiaryContact(String value) {
        this.beneficiaryContact = value;
    }

    /**
     * Obtiene el valor de la propiedad beneficiaryStreet.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeneficiaryStreet() {
        return beneficiaryStreet;
    }

    /**
     * Define el valor de la propiedad beneficiaryStreet.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeneficiaryStreet(String value) {
        this.beneficiaryStreet = value;
    }

    /**
     * Obtiene el valor de la propiedad beneficiaryPostCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeneficiaryPostCode() {
        return beneficiaryPostCode;
    }

    /**
     * Define el valor de la propiedad beneficiaryPostCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeneficiaryPostCode(String value) {
        this.beneficiaryPostCode = value;
    }

    /**
     * Obtiene el valor de la propiedad beneficiaryPostBox.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeneficiaryPostBox() {
        return beneficiaryPostBox;
    }

    /**
     * Define el valor de la propiedad beneficiaryPostBox.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeneficiaryPostBox(String value) {
        this.beneficiaryPostBox = value;
    }

    /**
     * Obtiene el valor de la propiedad beneficiaryCity.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeneficiaryCity() {
        return beneficiaryCity;
    }

    /**
     * Define el valor de la propiedad beneficiaryCity.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeneficiaryCity(String value) {
        this.beneficiaryCity = value;
    }

    /**
     * Obtiene el valor de la propiedad beneficiaryCountryIso2Code.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeneficiaryCountryIso2Code() {
        return beneficiaryCountryIso2Code;
    }

    /**
     * Define el valor de la propiedad beneficiaryCountryIso2Code.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeneficiaryCountryIso2Code(String value) {
        this.beneficiaryCountryIso2Code = value;
    }

    /**
     * Obtiene el valor de la propiedad beneficiaryCounty.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeneficiaryCounty() {
        return beneficiaryCounty;
    }

    /**
     * Define el valor de la propiedad beneficiaryCounty.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeneficiaryCounty(String value) {
        this.beneficiaryCounty = value;
    }

    /**
     * Obtiene el valor de la propiedad budgetManagementTypeCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBudgetManagementTypeCode() {
        return budgetManagementTypeCode;
    }

    /**
     * Define el valor de la propiedad budgetManagementTypeCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBudgetManagementTypeCode(String value) {
        this.budgetManagementTypeCode = value;
    }

    /**
     * Obtiene el valor de la propiedad classCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClassCode() {
        return classCode;
    }

    /**
     * Define el valor de la propiedad classCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClassCode(String value) {
        this.classCode = value;
    }

    /**
     * Obtiene el valor de la propiedad completionFlag.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCompletionFlag() {
        return completionFlag;
    }

    /**
     * Define el valor de la propiedad completionFlag.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCompletionFlag(Boolean value) {
        this.completionFlag = value;
    }

    /**
     * Obtiene el valor de la propiedad completionModReason.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompletionModReason() {
        return completionModReason;
    }

    /**
     * Define el valor de la propiedad completionModReason.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompletionModReason(String value) {
        this.completionModReason = value;
    }

    /**
     * Obtiene el valor de la propiedad consumingL1ReasonJustCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConsumingL1ReasonJustCode() {
        return consumingL1ReasonJustCode;
    }

    /**
     * Define el valor de la propiedad consumingL1ReasonJustCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConsumingL1ReasonJustCode(String value) {
        this.consumingL1ReasonJustCode = value;
    }

    /**
     * Obtiene el valor de la propiedad contractSignDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getContractSignDate() {
        return contractSignDate;
    }

    /**
     * Define el valor de la propiedad contractSignDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setContractSignDate(XMLGregorianCalendar value) {
        this.contractSignDate = value;
    }

    /**
     * Obtiene el valor de la propiedad contractSignEntryUser.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContractSignEntryUser() {
        return contractSignEntryUser;
    }

    /**
     * Define el valor de la propiedad contractSignEntryUser.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContractSignEntryUser(String value) {
        this.contractSignEntryUser = value;
    }

    /**
     * Obtiene el valor de la propiedad contractSignEntryDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getContractSignEntryDate() {
        return contractSignEntryDate;
    }

    /**
     * Define el valor de la propiedad contractSignEntryDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setContractSignEntryDate(XMLGregorianCalendar value) {
        this.contractSignEntryDate = value;
    }

    /**
     * Obtiene el valor de la propiedad currencyIso3Code.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrencyIso3Code() {
        return currencyIso3Code;
    }

    /**
     * Define el valor de la propiedad currencyIso3Code.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrencyIso3Code(String value) {
        this.currencyIso3Code = value;
    }

    /**
     * Obtiene el valor de la propiedad currentBudgetYear.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrentBudgetYear() {
        return currentBudgetYear;
    }

    /**
     * Define el valor de la propiedad currentBudgetYear.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrentBudgetYear(String value) {
        this.currentBudgetYear = value;
    }

    /**
     * Obtiene el valor de la propiedad expenditureCategoryCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpenditureCategoryCode() {
        return expenditureCategoryCode;
    }

    /**
     * Define el valor de la propiedad expenditureCategoryCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpenditureCategoryCode(String value) {
        this.expenditureCategoryCode = value;
    }

    /**
     * Obtiene el valor de la propiedad fdiDelimiterCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFdiDelimiterCode() {
        return fdiDelimiterCode;
    }

    /**
     * Define el valor de la propiedad fdiDelimiterCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFdiDelimiterCode(String value) {
        this.fdiDelimiterCode = value;
    }

    /**
     * Obtiene el valor de la propiedad fileReference.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileReference() {
        return fileReference;
    }

    /**
     * Define el valor de la propiedad fileReference.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileReference(String value) {
        this.fileReference = value;
    }

    /**
     * Obtiene el valor de la propiedad financialRegulationGroupCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFinancialRegulationGroupCode() {
        return financialRegulationGroupCode;
    }

    /**
     * Define el valor de la propiedad financialRegulationGroupCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFinancialRegulationGroupCode(String value) {
        this.financialRegulationGroupCode = value;
    }

    /**
     * Obtiene el valor de la propiedad guarantees.
     * 
     * @return
     *     possible object is
     *     {@link Guarantees }
     *     
     */
    public Guarantees getGuarantees() {
        return guarantees;
    }

    /**
     * Define el valor de la propiedad guarantees.
     * 
     * @param value
     *     allowed object is
     *     {@link Guarantees }
     *     
     */
    public void setGuarantees(Guarantees value) {
        this.guarantees = value;
    }

    /**
     * Obtiene el valor de la propiedad implementedByCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImplementedByCode() {
        return implementedByCode;
    }

    /**
     * Define el valor de la propiedad implementedByCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImplementedByCode(String value) {
        this.implementedByCode = value;
    }

    /**
     * Obtiene el valor de la propiedad invoices.
     * 
     * @return
     *     possible object is
     *     {@link Invoices }
     *     
     */
    public Invoices getInvoices() {
        return invoices;
    }

    /**
     * Define el valor de la propiedad invoices.
     * 
     * @param value
     *     allowed object is
     *     {@link Invoices }
     *     
     */
    public void setInvoices(Invoices value) {
        this.invoices = value;
    }

    /**
     * Obtiene el valor de la propiedad justificationCodeForNoFdcIlc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJustificationCodeForNoFdcIlc() {
        return justificationCodeForNoFdcIlc;
    }

    /**
     * Define el valor de la propiedad justificationCodeForNoFdcIlc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJustificationCodeForNoFdcIlc(String value) {
        this.justificationCodeForNoFdcIlc = value;
    }

    /**
     * Obtiene el valor de la propiedad justificationCsd.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJustificationCsd() {
        return justificationCsd;
    }

    /**
     * Define el valor de la propiedad justificationCsd.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJustificationCsd(String value) {
        this.justificationCsd = value;
    }

    /**
     * Obtiene el valor de la propiedad justificationForContractSignedDateCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJustificationForContractSignedDateCode() {
        return justificationForContractSignedDateCode;
    }

    /**
     * Define el valor de la propiedad justificationForContractSignedDateCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJustificationForContractSignedDateCode(String value) {
        this.justificationForContractSignedDateCode = value;
    }

    /**
     * Obtiene el valor de la propiedad justificationForMultiplePaymentClassCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJustificationForMultiplePaymentClassCode() {
        return justificationForMultiplePaymentClassCode;
    }

    /**
     * Define el valor de la propiedad justificationForMultiplePaymentClassCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJustificationForMultiplePaymentClassCode(String value) {
        this.justificationForMultiplePaymentClassCode = value;
    }

    /**
     * Obtiene el valor de la propiedad justificationForMultipleThirdpartyCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJustificationForMultipleThirdpartyCode() {
        return justificationForMultipleThirdpartyCode;
    }

    /**
     * Define el valor de la propiedad justificationForMultipleThirdpartyCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJustificationForMultipleThirdpartyCode(String value) {
        this.justificationForMultipleThirdpartyCode = value;
    }

    /**
     * Obtiene el valor de la propiedad justificationForNoThirdpartyCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJustificationForNoThirdpartyCode() {
        return justificationForNoThirdpartyCode;
    }

    /**
     * Define el valor de la propiedad justificationForNoThirdpartyCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJustificationForNoThirdpartyCode(String value) {
        this.justificationForNoThirdpartyCode = value;
    }

    /**
     * Obtiene el valor de la propiedad justificationNoContractorRefCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJustificationNoContractorRefCode() {
        return justificationNoContractorRefCode;
    }

    /**
     * Define el valor de la propiedad justificationNoContractorRefCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJustificationNoContractorRefCode(String value) {
        this.justificationNoContractorRefCode = value;
    }

    /**
     * Obtiene el valor de la propiedad legalCommitmentVersions.
     * 
     * @return
     *     possible object is
     *     {@link LegalCommitmentVersions }
     *     
     */
    public LegalCommitmentVersions getLegalCommitmentVersions() {
        return legalCommitmentVersions;
    }

    /**
     * Define el valor de la propiedad legalCommitmentVersions.
     * 
     * @param value
     *     allowed object is
     *     {@link LegalCommitmentVersions }
     *     
     */
    public void setLegalCommitmentVersions(LegalCommitmentVersions value) {
        this.legalCommitmentVersions = value;
    }

    /**
     * Obtiene el valor de la propiedad legalJustificationCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLegalJustificationCode() {
        return legalJustificationCode;
    }

    /**
     * Define el valor de la propiedad legalJustificationCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLegalJustificationCode(String value) {
        this.legalJustificationCode = value;
    }

    /**
     * Obtiene el valor de la propiedad localKey.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocalKey() {
        return localKey;
    }

    /**
     * Define el valor de la propiedad localKey.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocalKey(String value) {
        this.localKey = value;
    }

    /**
     * Obtiene el valor de la propiedad paymentClassCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentClassCode() {
        return paymentClassCode;
    }

    /**
     * Define el valor de la propiedad paymentClassCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentClassCode(String value) {
        this.paymentClassCode = value;
    }

    /**
     * Obtiene el valor de la propiedad paymentSchemes.
     * 
     * @return
     *     possible object is
     *     {@link PaymentSchemes }
     *     
     */
    public PaymentSchemes getPaymentSchemes() {
        return paymentSchemes;
    }

    /**
     * Define el valor de la propiedad paymentSchemes.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentSchemes }
     *     
     */
    public void setPaymentSchemes(PaymentSchemes value) {
        this.paymentSchemes = value;
    }

    /**
     * Obtiene el valor de la propiedad potentialAbnormalRAL.
     * 
     * @return
     *     possible object is
     *     {@link PotentialAbnormalRAL }
     *     
     */
    public PotentialAbnormalRAL getPotentialAbnormalRAL() {
        return potentialAbnormalRAL;
    }

    /**
     * Define el valor de la propiedad potentialAbnormalRAL.
     * 
     * @param value
     *     allowed object is
     *     {@link PotentialAbnormalRAL }
     *     
     */
    public void setPotentialAbnormalRAL(PotentialAbnormalRAL value) {
        this.potentialAbnormalRAL = value;
    }

    /**
     * Obtiene el valor de la propiedad prefinBalanceAnalysis.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrefinBalanceAnalysis() {
        return prefinBalanceAnalysis;
    }

    /**
     * Define el valor de la propiedad prefinBalanceAnalysis.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrefinBalanceAnalysis(String value) {
        this.prefinBalanceAnalysis = value;
    }

    /**
     * Obtiene el valor de la propiedad prefinGuaranteeAmount.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPrefinGuaranteeAmount() {
        return prefinGuaranteeAmount;
    }

    /**
     * Define el valor de la propiedad prefinGuaranteeAmount.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPrefinGuaranteeAmount(BigDecimal value) {
        this.prefinGuaranteeAmount = value;
    }

    /**
     * Obtiene el valor de la propiedad prefinGuaranteeJustificationCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrefinGuaranteeJustificationCode() {
        return prefinGuaranteeJustificationCode;
    }

    /**
     * Define el valor de la propiedad prefinGuaranteeJustificationCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrefinGuaranteeJustificationCode(String value) {
        this.prefinGuaranteeJustificationCode = value;
    }

    /**
     * Obtiene el valor de la propiedad prefinGuaranteeJustificationFinRegulCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrefinGuaranteeJustificationFinRegulCode() {
        return prefinGuaranteeJustificationFinRegulCode;
    }

    /**
     * Define el valor de la propiedad prefinGuaranteeJustificationFinRegulCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrefinGuaranteeJustificationFinRegulCode(String value) {
        this.prefinGuaranteeJustificationFinRegulCode = value;
    }

    /**
     * Obtiene el valor de la propiedad project.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProject() {
        return project;
    }

    /**
     * Define el valor de la propiedad project.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProject(String value) {
        this.project = value;
    }

    /**
     * Obtiene el valor de la propiedad proposedFdiDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getProposedFdiDate() {
        return proposedFdiDate;
    }

    /**
     * Define el valor de la propiedad proposedFdiDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setProposedFdiDate(XMLGregorianCalendar value) {
        this.proposedFdiDate = value;
    }

    /**
     * Obtiene el valor de la propiedad referenceTreatyCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferenceTreatyCode() {
        return referenceTreatyCode;
    }

    /**
     * Define el valor de la propiedad referenceTreatyCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferenceTreatyCode(String value) {
        this.referenceTreatyCode = value;
    }

    /**
     * Obtiene el valor de la propiedad remarks.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * Define el valor de la propiedad remarks.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemarks(String value) {
        this.remarks = value;
    }

    /**
     * Obtiene el valor de la propiedad responsibleOrganisation.
     * 
     * @return
     *     possible object is
     *     {@link ResponsibleOrganisationType }
     *     
     */
    public ResponsibleOrganisationType getResponsibleOrganisation() {
        return responsibleOrganisation;
    }

    /**
     * Define el valor de la propiedad responsibleOrganisation.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponsibleOrganisationType }
     *     
     */
    public void setResponsibleOrganisation(ResponsibleOrganisationType value) {
        this.responsibleOrganisation = value;
    }

    /**
     * Obtiene el valor de la propiedad stillToCoverInEuroAmount.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getStillToCoverInEuroAmount() {
        return stillToCoverInEuroAmount;
    }

    /**
     * Define el valor de la propiedad stillToCoverInEuroAmount.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setStillToCoverInEuroAmount(BigDecimal value) {
        this.stillToCoverInEuroAmount = value;
    }

    /**
     * Obtiene el valor de la propiedad updateFdiReason.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUpdateFdiReason() {
        return updateFdiReason;
    }

    /**
     * Define el valor de la propiedad updateFdiReason.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUpdateFdiReason(String value) {
        this.updateFdiReason = value;
    }

    /**
     * Obtiene el valor de la propiedad userReference.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserReference() {
        return userReference;
    }

    /**
     * Define el valor de la propiedad userReference.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserReference(String value) {
        this.userReference = value;
    }

    /**
     * Obtiene el valor de la propiedad workflowInfo.
     * 
     * @return
     *     possible object is
     *     {@link WorkflowInfoType }
     *     
     */
    public WorkflowInfoType getWorkflowInfo() {
        return workflowInfo;
    }

    /**
     * Define el valor de la propiedad workflowInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link WorkflowInfoType }
     *     
     */
    public void setWorkflowInfo(WorkflowInfoType value) {
        this.workflowInfo = value;
    }

    /**
     * Obtiene el valor de la propiedad aresDocuments.
     * 
     * @return
     *     possible object is
     *     {@link AresDocumentsType }
     *     
     */
    public AresDocumentsType getAresDocuments() {
        return aresDocuments;
    }

    /**
     * Define el valor de la propiedad aresDocuments.
     * 
     * @param value
     *     allowed object is
     *     {@link AresDocumentsType }
     *     
     */
    public void setAresDocuments(AresDocumentsType value) {
        this.aresDocuments = value;
    }

    /**
     * Obtiene el valor de la propiedad budgetCompanyCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBudgetCompanyCode() {
        return budgetCompanyCode;
    }

    /**
     * Define el valor de la propiedad budgetCompanyCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBudgetCompanyCode(String value) {
        this.budgetCompanyCode = value;
    }

    /**
     * Obtiene el valor de la propiedad contractorReferences.
     * 
     * @return
     *     possible object is
     *     {@link ContractorReferencesType }
     *     
     */
    public ContractorReferencesType getContractorReferences() {
        return contractorReferences;
    }

    /**
     * Define el valor de la propiedad contractorReferences.
     * 
     * @param value
     *     allowed object is
     *     {@link ContractorReferencesType }
     *     
     */
    public void setContractorReferences(ContractorReferencesType value) {
        this.contractorReferences = value;
    }

    /**
     * Obtiene el valor de la propiedad externalCriterias.
     * 
     * @return
     *     possible object is
     *     {@link ExternalCriteriasType }
     *     
     */
    public ExternalCriteriasType getExternalCriterias() {
        return externalCriterias;
    }

    /**
     * Define el valor de la propiedad externalCriterias.
     * 
     * @param value
     *     allowed object is
     *     {@link ExternalCriteriasType }
     *     
     */
    public void setExternalCriterias(ExternalCriteriasType value) {
        this.externalCriterias = value;
    }

    /**
     * Obtiene el valor de la propiedad localSystemCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocalSystemCode() {
        return localSystemCode;
    }

    /**
     * Define el valor de la propiedad localSystemCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocalSystemCode(String value) {
        this.localSystemCode = value;
    }

    /**
     * Obtiene el valor de la propiedad commitmentPositions.
     * 
     * @return
     *     possible object is
     *     {@link CommitmentPositionsGetType }
     *     
     */
    public CommitmentPositionsGetType getCommitmentPositions() {
        return commitmentPositions;
    }

    /**
     * Define el valor de la propiedad commitmentPositions.
     * 
     * @param value
     *     allowed object is
     *     {@link CommitmentPositionsGetType }
     *     
     */
    public void setCommitmentPositions(CommitmentPositionsGetType value) {
        this.commitmentPositions = value;
    }

    /**
     * Obtiene el valor de la propiedad envelopeLink.
     * 
     * @return
     *     possible object is
     *     {@link BudgetaryCommitmentLevel2EnvelopeLinkCreateType }
     *     
     */
    public BudgetaryCommitmentLevel2EnvelopeLinkCreateType getEnvelopeLink() {
        return envelopeLink;
    }

    /**
     * Define el valor de la propiedad envelopeLink.
     * 
     * @param value
     *     allowed object is
     *     {@link BudgetaryCommitmentLevel2EnvelopeLinkCreateType }
     *     
     */
    public void setEnvelopeLink(BudgetaryCommitmentLevel2EnvelopeLinkCreateType value) {
        this.envelopeLink = value;
    }

    /**
     * Obtiene el valor de la propiedad responsibleUsers.
     * 
     * @return
     *     possible object is
     *     {@link ResponsibleUsersType }
     *     
     */
    public ResponsibleUsersType getResponsibleUsers() {
        return responsibleUsers;
    }

    /**
     * Define el valor de la propiedad responsibleUsers.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponsibleUsersType }
     *     
     */
    public void setResponsibleUsers(ResponsibleUsersType value) {
        this.responsibleUsers = value;
    }

    /**
     * Obtiene el valor de la propiedad scannedDocuments.
     * 
     * @return
     *     possible object is
     *     {@link ScannedDocumentsType }
     *     
     */
    public ScannedDocumentsType getScannedDocuments() {
        return scannedDocuments;
    }

    /**
     * Define el valor de la propiedad scannedDocuments.
     * 
     * @param value
     *     allowed object is
     *     {@link ScannedDocumentsType }
     *     
     */
    public void setScannedDocuments(ScannedDocumentsType value) {
        this.scannedDocuments = value;
    }

    /**
     * Obtiene el valor de la propiedad supportingDocumentFolder.
     * 
     * @return
     *     possible object is
     *     {@link SupportingDocumentFolderType }
     *     
     */
    public SupportingDocumentFolderType getSupportingDocumentFolder() {
        return supportingDocumentFolder;
    }

    /**
     * Define el valor de la propiedad supportingDocumentFolder.
     * 
     * @param value
     *     allowed object is
     *     {@link SupportingDocumentFolderType }
     *     
     */
    public void setSupportingDocumentFolder(SupportingDocumentFolderType value) {
        this.supportingDocumentFolder = value;
    }

    /**
     * Obtiene el valor de la propiedad commitmentL2Consumptions.
     * 
     * @return
     *     possible object is
     *     {@link CommitmentL2ConsumptionsType }
     *     
     */
    public CommitmentL2ConsumptionsType getCommitmentL2Consumptions() {
        return commitmentL2Consumptions;
    }

    /**
     * Define el valor de la propiedad commitmentL2Consumptions.
     * 
     * @param value
     *     allowed object is
     *     {@link CommitmentL2ConsumptionsType }
     *     
     */
    public void setCommitmentL2Consumptions(CommitmentL2ConsumptionsType value) {
        this.commitmentL2Consumptions = value;
    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="GuaranteeLocalKey" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}LocalKeyType" maxOccurs="unbounded"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "guaranteeLocalKey"
    })
    public static class Guarantees {

        @XmlElement(name = "GuaranteeLocalKey", required = true)
        protected List<String> guaranteeLocalKey;

        /**
         * Gets the value of the guaranteeLocalKey property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the guaranteeLocalKey property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getGuaranteeLocalKey().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getGuaranteeLocalKey() {
            if (guaranteeLocalKey == null) {
                guaranteeLocalKey = new ArrayList<String>();
            }
            return this.guaranteeLocalKey;
        }

    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="InvoiceLocalKey" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}LocalKeyType" maxOccurs="unbounded"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "invoiceLocalKey"
    })
    public static class Invoices {

        @XmlElement(name = "InvoiceLocalKey", required = true)
        protected List<String> invoiceLocalKey;

        /**
         * Gets the value of the invoiceLocalKey property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the invoiceLocalKey property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getInvoiceLocalKey().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getInvoiceLocalKey() {
            if (invoiceLocalKey == null) {
                invoiceLocalKey = new ArrayList<String>();
            }
            return this.invoiceLocalKey;
        }

    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="LegalCommitmentVersionLocalKey" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}LocalKeyType" maxOccurs="unbounded"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "legalCommitmentVersionLocalKey"
    })
    public static class LegalCommitmentVersions {

        @XmlElement(name = "LegalCommitmentVersionLocalKey", required = true)
        protected List<String> legalCommitmentVersionLocalKey;

        /**
         * Gets the value of the legalCommitmentVersionLocalKey property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the legalCommitmentVersionLocalKey property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getLegalCommitmentVersionLocalKey().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getLegalCommitmentVersionLocalKey() {
            if (legalCommitmentVersionLocalKey == null) {
                legalCommitmentVersionLocalKey = new ArrayList<String>();
            }
            return this.legalCommitmentVersionLocalKey;
        }

    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="PaymentScheme" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}PaymentSchemeType" maxOccurs="unbounded"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "paymentScheme"
    })
    public static class PaymentSchemes {

        @XmlElement(name = "PaymentScheme", required = true)
        protected List<PaymentSchemeType> paymentScheme;

        /**
         * Gets the value of the paymentScheme property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the paymentScheme property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPaymentScheme().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link PaymentSchemeType }
         * 
         * 
         */
        public List<PaymentSchemeType> getPaymentScheme() {
            if (paymentScheme == null) {
                paymentScheme = new ArrayList<PaymentSchemeType>();
            }
            return this.paymentScheme;
        }

    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="OldCommitment" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}OldCommitmentType" minOccurs="0"/&gt;
     *         &lt;element name="SleepingCommitment" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}SleepingCommitmentType" minOccurs="0"/&gt;
     *         &lt;element name="RAL" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}RALType" maxOccurs="unbounded" minOccurs="0"/&gt;
     *         &lt;element name="Remarks" type="{http://www.ec.europa.eu/budg/abac/local_abac_document/v1}RemarksType" minOccurs="0"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "oldCommitment",
        "sleepingCommitment",
        "ral",
        "remarks"
    })
    public static class PotentialAbnormalRAL {

        @XmlElement(name = "OldCommitment")
        protected Boolean oldCommitment;
        @XmlElement(name = "SleepingCommitment")
        protected Boolean sleepingCommitment;
        @XmlElement(name = "RAL")
        protected List<RALType> ral;
        @XmlElement(name = "Remarks")
        protected String remarks;

        /**
         * Obtiene el valor de la propiedad oldCommitment.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isOldCommitment() {
            return oldCommitment;
        }

        /**
         * Define el valor de la propiedad oldCommitment.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setOldCommitment(Boolean value) {
            this.oldCommitment = value;
        }

        /**
         * Obtiene el valor de la propiedad sleepingCommitment.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isSleepingCommitment() {
            return sleepingCommitment;
        }

        /**
         * Define el valor de la propiedad sleepingCommitment.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setSleepingCommitment(Boolean value) {
            this.sleepingCommitment = value;
        }

        /**
         * Gets the value of the ral property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the ral property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getRAL().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link RALType }
         * 
         * 
         */
        public List<RALType> getRAL() {
            if (ral == null) {
                ral = new ArrayList<RALType>();
            }
            return this.ral;
        }

        /**
         * Obtiene el valor de la propiedad remarks.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRemarks() {
            return remarks;
        }

        /**
         * Define el valor de la propiedad remarks.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRemarks(String value) {
            this.remarks = value;
        }

    }

}
