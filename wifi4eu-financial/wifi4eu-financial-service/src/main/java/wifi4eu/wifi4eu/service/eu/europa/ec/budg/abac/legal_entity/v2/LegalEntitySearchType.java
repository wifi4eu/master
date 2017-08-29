
package wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.legal_entity.v2;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

import wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.complex_type.v1.AuditInfoType;


/**
 * <p>Clase Java para LegalEntitySearchType complex type.
 * <p>
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;complexType name="LegalEntitySearchType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AbacKey" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}LocalKeyType"/&gt;
 *         &lt;element name="CentralStatus" type="{http://www.ec.europa.eu/budg/abac/third_party/v1}BlockingCodeType" minOccurs="0"/&gt;
 *         &lt;element name="EWS" type="{http://www.ec.europa.eu/budg/abac/legal_entity/v2}EwsFlagType" minOccurs="0"/&gt;
 *         &lt;element name="LegalTypeCode" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}CodeType"/&gt;
 *         &lt;element name="OfficialName" type="{http://www.ec.europa.eu/budg/abac/legal_entity/simple_type/v1}OfficialNameType" minOccurs="0"/&gt;
 *         &lt;element name="FullOfficialName" type="{http://www.ec.europa.eu/budg/abac/legal_entity/simple_type/v1}FullOfficialNameType" minOccurs="0"/&gt;
 *         &lt;element name="CurrentWorkflowStatus" type="{http://www.ec.europa.eu/budg/abac/workflow_object/v1}WorkflowStatusType" minOccurs="0"/&gt;
 *         &lt;element name="CurrentWorkflowLevel" type="{http://www.ec.europa.eu/budg/abac/workflow_object/v1}WorkflowLevelType" minOccurs="0"/&gt;
 *         &lt;element name="AccountGroupCode" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}CodeType" minOccurs="0"/&gt;
 *         &lt;element name="AuditInfo" type="{http://www.ec.europa.eu/budg/abac/complex_type/v1}AuditInfoType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LegalEntitySearchType", propOrder = {
        "abacKey",
        "centralStatus",
        "ews",
        "legalTypeCode",
        "officialName",
        "fullOfficialName",
        "currentWorkflowStatus",
        "currentWorkflowLevel",
        "accountGroupCode",
        "auditInfo"
})
@XmlSeeAlso({
        TechnicalLegalEntitySearchType.class,
        NaturalPersonSearchType.class,
        PublicPrivateLawBodySearchType.class
})
public abstract class LegalEntitySearchType {

    @XmlElement(name = "AbacKey", required = true)
    protected String abacKey;
    @XmlElement(name = "CentralStatus")
    protected String centralStatus;
    @XmlElement(name = "EWS")
    protected Boolean ews;
    @XmlElement(name = "LegalTypeCode", required = true)
    protected String legalTypeCode;
    @XmlElement(name = "OfficialName")
    protected String officialName;
    @XmlElement(name = "FullOfficialName")
    protected String fullOfficialName;
    @XmlElement(name = "CurrentWorkflowStatus")
    protected String currentWorkflowStatus;
    @XmlElement(name = "CurrentWorkflowLevel")
    protected BigInteger currentWorkflowLevel;
    @XmlElement(name = "AccountGroupCode")
    protected String accountGroupCode;
    @XmlElement(name = "AuditInfo")
    protected AuditInfoType auditInfo;

    /**
     * Obtiene el valor de la propiedad abacKey.
     *
     * @return possible object is
     * {@link String }
     */
    public String getAbacKey() {
        return abacKey;
    }

    /**
     * Define el valor de la propiedad abacKey.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAbacKey(String value) {
        this.abacKey = value;
    }

    /**
     * Obtiene el valor de la propiedad centralStatus.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCentralStatus() {
        return centralStatus;
    }

    /**
     * Define el valor de la propiedad centralStatus.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCentralStatus(String value) {
        this.centralStatus = value;
    }

    /**
     * Obtiene el valor de la propiedad ews.
     *
     * @return possible object is
     * {@link Boolean }
     */
    public Boolean isEWS() {
        return ews;
    }

    /**
     * Define el valor de la propiedad ews.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setEWS(Boolean value) {
        this.ews = value;
    }

    /**
     * Obtiene el valor de la propiedad legalTypeCode.
     *
     * @return possible object is
     * {@link String }
     */
    public String getLegalTypeCode() {
        return legalTypeCode;
    }

    /**
     * Define el valor de la propiedad legalTypeCode.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setLegalTypeCode(String value) {
        this.legalTypeCode = value;
    }

    /**
     * Obtiene el valor de la propiedad officialName.
     *
     * @return possible object is
     * {@link String }
     */
    public String getOfficialName() {
        return officialName;
    }

    /**
     * Define el valor de la propiedad officialName.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setOfficialName(String value) {
        this.officialName = value;
    }

    /**
     * Obtiene el valor de la propiedad fullOfficialName.
     *
     * @return possible object is
     * {@link String }
     */
    public String getFullOfficialName() {
        return fullOfficialName;
    }

    /**
     * Define el valor de la propiedad fullOfficialName.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setFullOfficialName(String value) {
        this.fullOfficialName = value;
    }

    /**
     * Obtiene el valor de la propiedad currentWorkflowStatus.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCurrentWorkflowStatus() {
        return currentWorkflowStatus;
    }

    /**
     * Define el valor de la propiedad currentWorkflowStatus.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCurrentWorkflowStatus(String value) {
        this.currentWorkflowStatus = value;
    }

    /**
     * Obtiene el valor de la propiedad currentWorkflowLevel.
     *
     * @return possible object is
     * {@link BigInteger }
     */
    public BigInteger getCurrentWorkflowLevel() {
        return currentWorkflowLevel;
    }

    /**
     * Define el valor de la propiedad currentWorkflowLevel.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setCurrentWorkflowLevel(BigInteger value) {
        this.currentWorkflowLevel = value;
    }

    /**
     * Obtiene el valor de la propiedad accountGroupCode.
     *
     * @return possible object is
     * {@link String }
     */
    public String getAccountGroupCode() {
        return accountGroupCode;
    }

    /**
     * Define el valor de la propiedad accountGroupCode.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAccountGroupCode(String value) {
        this.accountGroupCode = value;
    }

    /**
     * Obtiene el valor de la propiedad auditInfo.
     *
     * @return possible object is
     * {@link AuditInfoType }
     */
    public AuditInfoType getAuditInfo() {
        return auditInfo;
    }

    /**
     * Define el valor de la propiedad auditInfo.
     *
     * @param value allowed object is
     *              {@link AuditInfoType }
     */
    public void setAuditInfo(AuditInfoType value) {
        this.auditInfo = value;
    }

}
