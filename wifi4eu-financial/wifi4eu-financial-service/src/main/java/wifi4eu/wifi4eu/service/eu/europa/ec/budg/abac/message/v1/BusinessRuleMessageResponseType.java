
package wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.message.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.br.v1.BusinessRuleResultListType;


/**
 * <p>Clase Java para BusinessRuleMessageResponseType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="BusinessRuleMessageResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.ec.europa.eu/budg/abac/message/v1}MessageResponseType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="BusinessRuleRejectionList" type="{http://www.ec.europa.eu/budg/abac/br/v1}BusinessRuleResultListType" minOccurs="0"/&gt;
 *         &lt;element name="BusinessRuleRejectionReturnCode" type="{http://www.ec.europa.eu/budg/abac/message/v1}BusinessRuleRejectionReturnCodeType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BusinessRuleMessageResponseType", propOrder = {
    "businessRuleRejectionList",
    "businessRuleRejectionReturnCode"
})
@XmlSeeAlso({
    ConcurrentAccessMessageResponseType.class,
    SAPMessageResponseType.class
})
public class BusinessRuleMessageResponseType
    extends MessageResponseType
{

    @XmlElement(name = "BusinessRuleRejectionList")
    protected BusinessRuleResultListType businessRuleRejectionList;
    @XmlElement(name = "BusinessRuleRejectionReturnCode")
    protected String businessRuleRejectionReturnCode;

    /**
     * Obtiene el valor de la propiedad businessRuleRejectionList.
     * 
     * @return
     *     possible object is
     *     {@link BusinessRuleResultListType }
     *     
     */
    public BusinessRuleResultListType getBusinessRuleRejectionList() {
        return businessRuleRejectionList;
    }

    /**
     * Define el valor de la propiedad businessRuleRejectionList.
     * 
     * @param value
     *     allowed object is
     *     {@link BusinessRuleResultListType }
     *     
     */
    public void setBusinessRuleRejectionList(BusinessRuleResultListType value) {
        this.businessRuleRejectionList = value;
    }

    /**
     * Obtiene el valor de la propiedad businessRuleRejectionReturnCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusinessRuleRejectionReturnCode() {
        return businessRuleRejectionReturnCode;
    }

    /**
     * Define el valor de la propiedad businessRuleRejectionReturnCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusinessRuleRejectionReturnCode(String value) {
        this.businessRuleRejectionReturnCode = value;
    }

}
