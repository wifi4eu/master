
package wifi4eu.wifi4eu.service.exportImport.messageCall.bc;

import eu.europa.ec.budg.abac.message.v1.MessageRequestType;
import eu.europa.ec.budg.abac.wbs.v1.WbsType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigInteger;


/**
 * <p>Clase Java para BudgetaryCommitmentLevel2CreateWbsRequestType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="BudgetaryCommitmentLevel2CreateWbsRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.ec.europa.eu/budg/abac/message/v1}MessageRequestType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="LocalKey" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}LocalKeyType"/&gt;
 *         &lt;element name="DocumentDetailNumber" type="{http://www.ec.europa.eu/budg/abac/local_abac_document_detail/v1}DocumentDetailNumberType"/&gt;
 *         &lt;element name="Wbs" type="{http://www.ec.europa.eu/budg/abac/wbs/v1}WbsType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BudgetaryCommitmentLevel2CreateWbsRequestType", propOrder = {
    "localKey",
    "documentDetailNumber",
    "wbs"
})
public class BudgetaryCommitmentLevel2CreateWbsRequestType
    extends MessageRequestType
{

    @XmlElement(name = "LocalKey", required = true)
    protected String localKey;
    @XmlElement(name = "DocumentDetailNumber", required = true)
    protected BigInteger documentDetailNumber;
    @XmlElement(name = "Wbs", required = true)
    protected WbsType wbs;

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
     * Obtiene el valor de la propiedad wbs.
     * 
     * @return
     *     possible object is
     *     {@link WbsType }
     *     
     */
    public WbsType getWbs() {
        return wbs;
    }

    /**
     * Define el valor de la propiedad wbs.
     * 
     * @param value
     *     allowed object is
     *     {@link WbsType }
     *     
     */
    public void setWbs(WbsType value) {
        this.wbs = value;
    }

}
