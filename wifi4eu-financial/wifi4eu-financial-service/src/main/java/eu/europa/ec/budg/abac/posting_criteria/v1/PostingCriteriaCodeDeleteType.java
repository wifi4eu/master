
package eu.europa.ec.budg.abac.posting_criteria.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para PostingCriteriaCodeDeleteType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="PostingCriteriaCodeDeleteType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="LocalSystemCode" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}LocalSystemCodeType"/&gt;
 *         &lt;element name="Code" type="{http://www.ec.europa.eu/budg/abac/posting_criteria/v1}CodeType"/&gt;
 *         &lt;element name="TypeCode" type="{http://www.ec.europa.eu/budg/abac/posting_criteria/v1}CodeType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PostingCriteriaCodeDeleteType", propOrder = {
    "localSystemCode",
    "code",
    "typeCode"
})
public class PostingCriteriaCodeDeleteType {

    @XmlElement(name = "LocalSystemCode", required = true)
    protected String localSystemCode;
    @XmlElement(name = "Code", required = true)
    protected String code;
    @XmlElement(name = "TypeCode", required = true)
    protected String typeCode;

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
     * Obtiene el valor de la propiedad code.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Define el valor de la propiedad code.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Obtiene el valor de la propiedad typeCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeCode() {
        return typeCode;
    }

    /**
     * Define el valor de la propiedad typeCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeCode(String value) {
        this.typeCode = value;
    }

}
