
package abac.budgetary_commitment_level2.v1;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para BudgetaryCommitmentLevel2PositionWritableType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="BudgetaryCommitmentLevel2PositionWritableType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AccountReference" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}AccountReferenceType" minOccurs="0"/&gt;
 *         &lt;element name="AppropriationLocalKey" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}LocalKeyType" minOccurs="0"/&gt;
 *         &lt;element name="BudgetaryCommitmentL1PositionLocalKey" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}LocalKeyType" minOccurs="0"/&gt;
 *         &lt;element name="CarryForwardFlag" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}IndicatorType" minOccurs="0"/&gt;
 *         &lt;element name="DgName" type="{http://www.ec.europa.eu/budg/abac/dg/v1}NameType" minOccurs="0"/&gt;
 *         &lt;element name="DocumentDetailNumber" type="{http://www.ec.europa.eu/budg/abac/local_abac_document_detail/v1}DocumentDetailNumberType" minOccurs="0"/&gt;
 *         &lt;element name="EntryInCurrencyAmount" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}AmountType" minOccurs="0"/&gt;
 *         &lt;element name="ExpenseTypeCode" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}ExpenseTypeCodeType"/&gt;
 *         &lt;element name="PolicyAreaCode" type="{http://www.ec.europa.eu/budg/abac/policy_area/v1}CodeType" minOccurs="0"/&gt;
 *         &lt;element name="ProgramCode" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}ProgramCodeType"/&gt;
 *         &lt;element name="ProgramRemarks" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}ProgramRemarksType" minOccurs="0"/&gt;
 *         &lt;element name="Remarks" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}RemarksType" minOccurs="0"/&gt;
 *         &lt;element name="SpecificIncreaseTypeCode" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}SpecificIncreaseTypeCodeType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BudgetaryCommitmentLevel2PositionWritableType", propOrder = {
    "accountReference",
    "appropriationLocalKey",
    "budgetaryCommitmentL1PositionLocalKey",
    "carryForwardFlag",
    "dgName",
    "documentDetailNumber",
    "entryInCurrencyAmount",
    "expenseTypeCode",
    "policyAreaCode",
    "programCode",
    "programRemarks",
    "remarks",
    "specificIncreaseTypeCode"
})
@XmlSeeAlso({
    BudgetaryCommitmentLevel2PositionCreateType.class
})
public class BudgetaryCommitmentLevel2PositionWritableType {

    @XmlElement(name = "AccountReference")
    protected String accountReference;
    @XmlElement(name = "AppropriationLocalKey")
    protected String appropriationLocalKey;
    @XmlElement(name = "BudgetaryCommitmentL1PositionLocalKey")
    protected String budgetaryCommitmentL1PositionLocalKey;
    @XmlElement(name = "CarryForwardFlag")
    protected Boolean carryForwardFlag;
    @XmlElement(name = "DgName")
    protected String dgName;
    @XmlElement(name = "DocumentDetailNumber")
    protected BigInteger documentDetailNumber;
    @XmlElement(name = "EntryInCurrencyAmount")
    protected BigDecimal entryInCurrencyAmount;
    @XmlElement(name = "ExpenseTypeCode", required = true)
    protected String expenseTypeCode;
    @XmlElement(name = "PolicyAreaCode")
    protected String policyAreaCode;
    @XmlElement(name = "ProgramCode", required = true)
    protected String programCode;
    @XmlElement(name = "ProgramRemarks")
    protected String programRemarks;
    @XmlElement(name = "Remarks")
    protected String remarks;
    @XmlElement(name = "SpecificIncreaseTypeCode")
    protected String specificIncreaseTypeCode;

    /**
     * Obtiene el valor de la propiedad accountReference.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountReference() {
        return accountReference;
    }

    /**
     * Define el valor de la propiedad accountReference.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountReference(String value) {
        this.accountReference = value;
    }

    /**
     * Obtiene el valor de la propiedad appropriationLocalKey.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppropriationLocalKey() {
        return appropriationLocalKey;
    }

    /**
     * Define el valor de la propiedad appropriationLocalKey.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppropriationLocalKey(String value) {
        this.appropriationLocalKey = value;
    }

    /**
     * Obtiene el valor de la propiedad budgetaryCommitmentL1PositionLocalKey.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBudgetaryCommitmentL1PositionLocalKey() {
        return budgetaryCommitmentL1PositionLocalKey;
    }

    /**
     * Define el valor de la propiedad budgetaryCommitmentL1PositionLocalKey.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBudgetaryCommitmentL1PositionLocalKey(String value) {
        this.budgetaryCommitmentL1PositionLocalKey = value;
    }

    /**
     * Obtiene el valor de la propiedad carryForwardFlag.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCarryForwardFlag() {
        return carryForwardFlag;
    }

    /**
     * Define el valor de la propiedad carryForwardFlag.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCarryForwardFlag(Boolean value) {
        this.carryForwardFlag = value;
    }

    /**
     * Obtiene el valor de la propiedad dgName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDgName() {
        return dgName;
    }

    /**
     * Define el valor de la propiedad dgName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDgName(String value) {
        this.dgName = value;
    }

    /**
     * Obtiene el valor de la propiedad documentDetailNumber.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDocumentDetailNumber() {
        return documentDetailNumber;
    }

    /**
     * Define el valor de la propiedad documentDetailNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDocumentDetailNumber(BigInteger value) {
        this.documentDetailNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad entryInCurrencyAmount.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getEntryInCurrencyAmount() {
        return entryInCurrencyAmount;
    }

    /**
     * Define el valor de la propiedad entryInCurrencyAmount.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setEntryInCurrencyAmount(BigDecimal value) {
        this.entryInCurrencyAmount = value;
    }

    /**
     * Obtiene el valor de la propiedad expenseTypeCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpenseTypeCode() {
        return expenseTypeCode;
    }

    /**
     * Define el valor de la propiedad expenseTypeCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpenseTypeCode(String value) {
        this.expenseTypeCode = value;
    }

    /**
     * Obtiene el valor de la propiedad policyAreaCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPolicyAreaCode() {
        return policyAreaCode;
    }

    /**
     * Define el valor de la propiedad policyAreaCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPolicyAreaCode(String value) {
        this.policyAreaCode = value;
    }

    /**
     * Obtiene el valor de la propiedad programCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProgramCode() {
        return programCode;
    }

    /**
     * Define el valor de la propiedad programCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProgramCode(String value) {
        this.programCode = value;
    }

    /**
     * Obtiene el valor de la propiedad programRemarks.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProgramRemarks() {
        return programRemarks;
    }

    /**
     * Define el valor de la propiedad programRemarks.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProgramRemarks(String value) {
        this.programRemarks = value;
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
     * Obtiene el valor de la propiedad specificIncreaseTypeCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecificIncreaseTypeCode() {
        return specificIncreaseTypeCode;
    }

    /**
     * Define el valor de la propiedad specificIncreaseTypeCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecificIncreaseTypeCode(String value) {
        this.specificIncreaseTypeCode = value;
    }

}
