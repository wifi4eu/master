
package wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.suspension.v1;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para SuspensionPeriodType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="SuspensionPeriodType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ActionReason" type="{http://www.ec.europa.eu/budg/abac/suspension/v1}ActionReasonType" minOccurs="0"/&gt;
 *         &lt;element name="ArchiveReference" type="{http://www.ec.europa.eu/budg/abac/suspension/v1}ArchiveReferenceType" minOccurs="0"/&gt;
 *         &lt;element name="CancellationReason" type="{http://www.ec.europa.eu/budg/abac/suspension/v1}CancellationReasonType" minOccurs="0"/&gt;
 *         &lt;element name="CancelledFlag" type="{http://www.ec.europa.eu/budg/abac/suspension/v1}CancelledFlagType"/&gt;
 *         &lt;element name="EndDate" type="{http://www.ec.europa.eu/budg/abac/suspension/v1}EndDateType" minOccurs="0"/&gt;
 *         &lt;element name="LineNumber" type="{http://www.ec.europa.eu/budg/abac/suspension/v1}LineNumber"/&gt;
 *         &lt;element name="StartDate" type="{http://www.ec.europa.eu/budg/abac/suspension/v1}StartDateType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SuspensionPeriodType", propOrder = {
    "actionReason",
    "archiveReference",
    "cancellationReason",
    "cancelledFlag",
    "endDate",
    "lineNumber",
    "startDate"
})
@XmlSeeAlso({
    PaymentSuspensionPeriodType.class,
    ReportApprovalSuspensionPeriodType.class
})
public abstract class SuspensionPeriodType {

    @XmlElement(name = "ActionReason")
    protected String actionReason;
    @XmlElement(name = "ArchiveReference")
    protected String archiveReference;
    @XmlElement(name = "CancellationReason")
    protected String cancellationReason;
    @XmlElement(name = "CancelledFlag")
    protected boolean cancelledFlag;
    @XmlElement(name = "EndDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar endDate;
    @XmlElement(name = "LineNumber", required = true)
    protected BigInteger lineNumber;
    @XmlElement(name = "StartDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar startDate;

    /**
     * Obtiene el valor de la propiedad actionReason.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActionReason() {
        return actionReason;
    }

    /**
     * Define el valor de la propiedad actionReason.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActionReason(String value) {
        this.actionReason = value;
    }

    /**
     * Obtiene el valor de la propiedad archiveReference.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArchiveReference() {
        return archiveReference;
    }

    /**
     * Define el valor de la propiedad archiveReference.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArchiveReference(String value) {
        this.archiveReference = value;
    }

    /**
     * Obtiene el valor de la propiedad cancellationReason.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCancellationReason() {
        return cancellationReason;
    }

    /**
     * Define el valor de la propiedad cancellationReason.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCancellationReason(String value) {
        this.cancellationReason = value;
    }

    /**
     * Obtiene el valor de la propiedad cancelledFlag.
     * 
     */
    public boolean isCancelledFlag() {
        return cancelledFlag;
    }

    /**
     * Define el valor de la propiedad cancelledFlag.
     * 
     */
    public void setCancelledFlag(boolean value) {
        this.cancelledFlag = value;
    }

    /**
     * Obtiene el valor de la propiedad endDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEndDate() {
        return endDate;
    }

    /**
     * Define el valor de la propiedad endDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEndDate(XMLGregorianCalendar value) {
        this.endDate = value;
    }

    /**
     * Obtiene el valor de la propiedad lineNumber.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getLineNumber() {
        return lineNumber;
    }

    /**
     * Define el valor de la propiedad lineNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setLineNumber(BigInteger value) {
        this.lineNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad startDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStartDate() {
        return startDate;
    }

    /**
     * Define el valor de la propiedad startDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStartDate(XMLGregorianCalendar value) {
        this.startDate = value;
    }

}
