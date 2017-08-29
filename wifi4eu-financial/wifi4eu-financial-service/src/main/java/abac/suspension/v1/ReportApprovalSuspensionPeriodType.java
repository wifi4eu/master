
package abac.suspension.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ReportApprovalSuspensionPeriodType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ReportApprovalSuspensionPeriodType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.ec.europa.eu/budg/abac/suspension/v1}SuspensionPeriodType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ReportApprovalSuspensionReasonCode" type="{http://www.ec.europa.eu/budg/abac/suspension_reason/v1}CodeType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReportApprovalSuspensionPeriodType", propOrder = {
    "reportApprovalSuspensionReasonCode"
})
public class ReportApprovalSuspensionPeriodType
    extends SuspensionPeriodType
{

    @XmlElement(name = "ReportApprovalSuspensionReasonCode", required = true)
    protected String reportApprovalSuspensionReasonCode;

    /**
     * Obtiene el valor de la propiedad reportApprovalSuspensionReasonCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportApprovalSuspensionReasonCode() {
        return reportApprovalSuspensionReasonCode;
    }

    /**
     * Define el valor de la propiedad reportApprovalSuspensionReasonCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportApprovalSuspensionReasonCode(String value) {
        this.reportApprovalSuspensionReasonCode = value;
    }

}
