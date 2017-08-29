
package abac.br.v1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para BusinessRuleResultType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="BusinessRuleResultType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="BusinessRuleCode" type="{http://www.ec.europa.eu/budg/abac/br/v1}BusinessRuleCodeType" minOccurs="0"/&gt;
 *         &lt;element name="BusinessRuleContextXpath" type="{http://www.ec.europa.eu/budg/abac/br/v1}BusinessRuleContextXpathType" minOccurs="0"/&gt;
 *         &lt;element name="BusinessRuleMessage" type="{http://www.ec.europa.eu/budg/abac/br/v1}BusinessRuleMessageType" minOccurs="0"/&gt;
 *         &lt;element name="BusinessRuleType" type="{http://www.ec.europa.eu/budg/abac/br/v1}BusinessRuleTypeType" minOccurs="0"/&gt;
 *         &lt;element name="DetailMessage" type="{http://www.ec.europa.eu/budg/abac/br/v1}DetailMessageType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BusinessRuleResultType", propOrder = {
    "businessRuleCode",
    "businessRuleContextXpath",
    "businessRuleMessage",
    "businessRuleType",
    "detailMessage"
})
public class BusinessRuleResultType {

    @XmlElement(name = "BusinessRuleCode")
    protected String businessRuleCode;
    @XmlElement(name = "BusinessRuleContextXpath")
    protected String businessRuleContextXpath;
    @XmlElement(name = "BusinessRuleMessage")
    protected String businessRuleMessage;
    @XmlElement(name = "BusinessRuleType")
    @XmlSchemaType(name = "string")
    protected BusinessRuleTypeType businessRuleType;
    @XmlElement(name = "DetailMessage")
    protected List<DetailMessageType> detailMessage;

    /**
     * Obtiene el valor de la propiedad businessRuleCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusinessRuleCode() {
        return businessRuleCode;
    }

    /**
     * Define el valor de la propiedad businessRuleCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusinessRuleCode(String value) {
        this.businessRuleCode = value;
    }

    /**
     * Obtiene el valor de la propiedad businessRuleContextXpath.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusinessRuleContextXpath() {
        return businessRuleContextXpath;
    }

    /**
     * Define el valor de la propiedad businessRuleContextXpath.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusinessRuleContextXpath(String value) {
        this.businessRuleContextXpath = value;
    }

    /**
     * Obtiene el valor de la propiedad businessRuleMessage.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusinessRuleMessage() {
        return businessRuleMessage;
    }

    /**
     * Define el valor de la propiedad businessRuleMessage.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusinessRuleMessage(String value) {
        this.businessRuleMessage = value;
    }

    /**
     * Obtiene el valor de la propiedad businessRuleType.
     * 
     * @return
     *     possible object is
     *     {@link BusinessRuleTypeType }
     *     
     */
    public BusinessRuleTypeType getBusinessRuleType() {
        return businessRuleType;
    }

    /**
     * Define el valor de la propiedad businessRuleType.
     * 
     * @param value
     *     allowed object is
     *     {@link BusinessRuleTypeType }
     *     
     */
    public void setBusinessRuleType(BusinessRuleTypeType value) {
        this.businessRuleType = value;
    }

    /**
     * Gets the value of the detailMessage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the detailMessage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDetailMessage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DetailMessageType }
     * 
     * 
     */
    public List<DetailMessageType> getDetailMessage() {
        if (detailMessage == null) {
            detailMessage = new ArrayList<DetailMessageType>();
        }
        return this.detailMessage;
    }

}
