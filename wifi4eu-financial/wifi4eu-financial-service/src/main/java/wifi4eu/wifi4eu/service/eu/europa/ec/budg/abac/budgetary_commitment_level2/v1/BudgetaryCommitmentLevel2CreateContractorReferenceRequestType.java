
package wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.budgetary_commitment_level2.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.contractor_reference.v1.HistoricalContractorReferenceType;
import wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.contractor_reference.v1.PrimaryContractorReferenceType;
import wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.contractor_reference.v1.SecondaryContractorReferenceType;
import wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.message.v1.MessageRequestType;


/**
 * <p>Clase Java para BudgetaryCommitmentLevel2CreateContractorReferenceRequestType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="BudgetaryCommitmentLevel2CreateContractorReferenceRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.ec.europa.eu/budg/abac/message/v1}MessageRequestType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="LocalKey" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}LocalKeyType"/&gt;
 *         &lt;group ref="{http://www.ec.europa.eu/budg/abac/contractor_reference/v1}ContractorReferenceChoiceGroup"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BudgetaryCommitmentLevel2CreateContractorReferenceRequestType", propOrder = {
    "localKey",
    "primaryContractorReference",
    "secondaryContractorReference",
    "historicalContractorReference"
})
public class BudgetaryCommitmentLevel2CreateContractorReferenceRequestType
    extends MessageRequestType
{

    @XmlElement(name = "LocalKey", required = true)
    protected String localKey;
    @XmlElement(name = "PrimaryContractorReference", namespace = "http://www.ec.europa.eu/budg/abac/contractor_reference/v1")
    protected PrimaryContractorReferenceType primaryContractorReference;
    @XmlElement(name = "SecondaryContractorReference", namespace = "http://www.ec.europa.eu/budg/abac/contractor_reference/v1")
    protected SecondaryContractorReferenceType secondaryContractorReference;
    @XmlElement(name = "HistoricalContractorReference", namespace = "http://www.ec.europa.eu/budg/abac/contractor_reference/v1")
    protected HistoricalContractorReferenceType historicalContractorReference;

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
     * Obtiene el valor de la propiedad primaryContractorReference.
     * 
     * @return
     *     possible object is
     *     {@link PrimaryContractorReferenceType }
     *     
     */
    public PrimaryContractorReferenceType getPrimaryContractorReference() {
        return primaryContractorReference;
    }

    /**
     * Define el valor de la propiedad primaryContractorReference.
     * 
     * @param value
     *     allowed object is
     *     {@link PrimaryContractorReferenceType }
     *     
     */
    public void setPrimaryContractorReference(PrimaryContractorReferenceType value) {
        this.primaryContractorReference = value;
    }

    /**
     * Obtiene el valor de la propiedad secondaryContractorReference.
     * 
     * @return
     *     possible object is
     *     {@link SecondaryContractorReferenceType }
     *     
     */
    public SecondaryContractorReferenceType getSecondaryContractorReference() {
        return secondaryContractorReference;
    }

    /**
     * Define el valor de la propiedad secondaryContractorReference.
     * 
     * @param value
     *     allowed object is
     *     {@link SecondaryContractorReferenceType }
     *     
     */
    public void setSecondaryContractorReference(SecondaryContractorReferenceType value) {
        this.secondaryContractorReference = value;
    }

    /**
     * Obtiene el valor de la propiedad historicalContractorReference.
     * 
     * @return
     *     possible object is
     *     {@link HistoricalContractorReferenceType }
     *     
     */
    public HistoricalContractorReferenceType getHistoricalContractorReference() {
        return historicalContractorReference;
    }

    /**
     * Define el valor de la propiedad historicalContractorReference.
     * 
     * @param value
     *     allowed object is
     *     {@link HistoricalContractorReferenceType }
     *     
     */
    public void setHistoricalContractorReference(HistoricalContractorReferenceType value) {
        this.historicalContractorReference = value;
    }

}
