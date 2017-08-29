
package wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.posting_criteria.v1;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.complex_type.v1.PeriodType;


/**
 * <p>Clase Java para PostingCriteriaCodeType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="PostingCriteriaCodeType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Abbreviation" type="{http://www.ec.europa.eu/budg/abac/posting_criteria/v1}AbbreviationType" minOccurs="0"/&gt;
 *         &lt;element name="Code" type="{http://www.ec.europa.eu/budg/abac/posting_criteria/v1}CodeType"/&gt;
 *         &lt;element name="Description" type="{http://www.ec.europa.eu/budg/abac/posting_criteria/v1}DescriptionType" minOccurs="0"/&gt;
 *         &lt;element name="Level" type="{http://www.ec.europa.eu/budg/abac/posting_criteria/v1}LevelType"/&gt;
 *         &lt;element name="LocalKey" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}LocalKeyType"/&gt;
 *         &lt;element name="LocalSystemCode" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}LocalSystemCodeType"/&gt;
 *         &lt;element name="ParentCode" type="{http://www.ec.europa.eu/budg/abac/posting_criteria/v1}CodeType" minOccurs="0"/&gt;
 *         &lt;element name="TypeCode" type="{http://www.ec.europa.eu/budg/abac/posting_criteria/v1}CodeType"/&gt;
 *         &lt;element name="ValidFlag" type="{http://www.ec.europa.eu/budg/abac/posting_criteria/v1}ValidFlagType"/&gt;
 *         &lt;element name="ValidityPeriod" type="{http://www.ec.europa.eu/budg/abac/complex_type/v1}PeriodType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PostingCriteriaCodeType", propOrder = {
    "abbreviation",
    "code",
    "description",
    "level",
    "localKey",
    "localSystemCode",
    "parentCode",
    "typeCode",
    "validFlag",
    "validityPeriod"
})
public class PostingCriteriaCodeType {

    @XmlElement(name = "Abbreviation")
    protected String abbreviation;
    @XmlElement(name = "Code", required = true)
    protected String code;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "Level", required = true)
    protected BigInteger level;
    @XmlElement(name = "LocalKey", required = true)
    protected String localKey;
    @XmlElement(name = "LocalSystemCode", required = true)
    protected String localSystemCode;
    @XmlElement(name = "ParentCode")
    protected String parentCode;
    @XmlElement(name = "TypeCode", required = true)
    protected String typeCode;
    @XmlElement(name = "ValidFlag")
    protected boolean validFlag;
    @XmlElement(name = "ValidityPeriod")
    protected PeriodType validityPeriod;

    /**
     * Obtiene el valor de la propiedad abbreviation.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAbbreviation() {
        return abbreviation;
    }

    /**
     * Define el valor de la propiedad abbreviation.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAbbreviation(String value) {
        this.abbreviation = value;
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
     * Obtiene el valor de la propiedad description.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Define el valor de la propiedad description.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Obtiene el valor de la propiedad level.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getLevel() {
        return level;
    }

    /**
     * Define el valor de la propiedad level.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setLevel(BigInteger value) {
        this.level = value;
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
     * Obtiene el valor de la propiedad parentCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParentCode() {
        return parentCode;
    }

    /**
     * Define el valor de la propiedad parentCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParentCode(String value) {
        this.parentCode = value;
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

    /**
     * Obtiene el valor de la propiedad validFlag.
     * 
     */
    public boolean isValidFlag() {
        return validFlag;
    }

    /**
     * Define el valor de la propiedad validFlag.
     * 
     */
    public void setValidFlag(boolean value) {
        this.validFlag = value;
    }

    /**
     * Obtiene el valor de la propiedad validityPeriod.
     * 
     * @return
     *     possible object is
     *     {@link PeriodType }
     *     
     */
    public PeriodType getValidityPeriod() {
        return validityPeriod;
    }

    /**
     * Define el valor de la propiedad validityPeriod.
     * 
     * @param value
     *     allowed object is
     *     {@link PeriodType }
     *     
     */
    public void setValidityPeriod(PeriodType value) {
        this.validityPeriod = value;
    }

}
