
package eu.europa.ec.budg.abac.budgetary_commitment_level2.v1;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import eu.europa.ec.budg.abac.associated_country.v1.AssociatedCountryType;
import eu.europa.ec.budg.abac.message.v1.MessageRequestType;


/**
 * <p>Clase Java para BudgetaryCommitmentLevel2ModifyAssociatedCountryRequestType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="BudgetaryCommitmentLevel2ModifyAssociatedCountryRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.ec.europa.eu/budg/abac/message/v1}MessageRequestType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="LocalKey" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}LocalKeyType"/&gt;
 *         &lt;element name="DocumentDetailNumber" type="{http://www.ec.europa.eu/budg/abac/local_abac_document_detail/v1}DocumentDetailNumberType"/&gt;
 *         &lt;element name="AssociatedCountry" type="{http://www.ec.europa.eu/budg/abac/associated_country/v1}AssociatedCountryType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BudgetaryCommitmentLevel2ModifyAssociatedCountryRequestType", propOrder = {
    "localKey",
    "documentDetailNumber",
    "associatedCountry"
})
public class BudgetaryCommitmentLevel2ModifyAssociatedCountryRequestType
    extends MessageRequestType
{

    @XmlElement(name = "LocalKey", required = true)
    protected String localKey;
    @XmlElement(name = "DocumentDetailNumber", required = true)
    protected BigInteger documentDetailNumber;
    @XmlElement(name = "AssociatedCountry", required = true)
    protected AssociatedCountryType associatedCountry;

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
     * Obtiene el valor de la propiedad associatedCountry.
     * 
     * @return
     *     possible object is
     *     {@link AssociatedCountryType }
     *     
     */
    public AssociatedCountryType getAssociatedCountry() {
        return associatedCountry;
    }

    /**
     * Define el valor de la propiedad associatedCountry.
     * 
     * @param value
     *     allowed object is
     *     {@link AssociatedCountryType }
     *     
     */
    public void setAssociatedCountry(AssociatedCountryType value) {
        this.associatedCountry = value;
    }

}
