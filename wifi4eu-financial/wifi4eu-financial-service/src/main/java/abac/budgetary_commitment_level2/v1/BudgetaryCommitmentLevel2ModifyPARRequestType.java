
package abac.budgetary_commitment_level2.v1;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import abac.message.v1.MessageRequestType;


/**
 * <p>Clase Java para BudgetaryCommitmentLevel2ModifyPARRequestType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="BudgetaryCommitmentLevel2ModifyPARRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.ec.europa.eu/budg/abac/message/v1}MessageRequestType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="LocalKey" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}LocalKeyType"/&gt;
 *         &lt;element name="DocumentDetailNumber" type="{http://www.ec.europa.eu/budg/abac/local_abac_document_detail/v1}DocumentDetailNumberType" minOccurs="0"/&gt;
 *         &lt;element name="CurrentBudgetYear" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}CurrentBudgetYearType" minOccurs="0"/&gt;
 *         &lt;element name="BudgetaryCommitmentLevel2PAR" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}BudgetaryCommitmentLevel2PARType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BudgetaryCommitmentLevel2ModifyPARRequestType", propOrder = {
    "localKey",
    "documentDetailNumber",
    "currentBudgetYear",
    "budgetaryCommitmentLevel2PAR"
})
public class BudgetaryCommitmentLevel2ModifyPARRequestType
    extends MessageRequestType
{

    @XmlElement(name = "LocalKey", required = true)
    protected String localKey;
    @XmlElement(name = "DocumentDetailNumber")
    protected BigInteger documentDetailNumber;
    @XmlElement(name = "CurrentBudgetYear")
    protected String currentBudgetYear;
    @XmlElement(name = "BudgetaryCommitmentLevel2PAR", required = true)
    protected BudgetaryCommitmentLevel2PARType budgetaryCommitmentLevel2PAR;

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
     * Obtiene el valor de la propiedad budgetaryCommitmentLevel2PAR.
     * 
     * @return
     *     possible object is
     *     {@link BudgetaryCommitmentLevel2PARType }
     *     
     */
    public BudgetaryCommitmentLevel2PARType getBudgetaryCommitmentLevel2PAR() {
        return budgetaryCommitmentLevel2PAR;
    }

    /**
     * Define el valor de la propiedad budgetaryCommitmentLevel2PAR.
     * 
     * @param value
     *     allowed object is
     *     {@link BudgetaryCommitmentLevel2PARType }
     *     
     */
    public void setBudgetaryCommitmentLevel2PAR(BudgetaryCommitmentLevel2PARType value) {
        this.budgetaryCommitmentLevel2PAR = value;
    }

}
