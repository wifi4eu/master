
package abac.suspension.v1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para SuspensionPeriodsType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="SuspensionPeriodsType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice maxOccurs="unbounded"&gt;
 *         &lt;element name="PaymentSuspensionPeriod" type="{http://www.ec.europa.eu/budg/abac/suspension/v1}PaymentSuspensionPeriodType" maxOccurs="unbounded"/&gt;
 *         &lt;element name="ReportApprovalSuspensionPeriod" type="{http://www.ec.europa.eu/budg/abac/suspension/v1}ReportApprovalSuspensionPeriodType" maxOccurs="unbounded"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SuspensionPeriodsType", propOrder = {
    "paymentSuspensionPeriodOrReportApprovalSuspensionPeriod"
})
public class SuspensionPeriodsType {

    @XmlElements({
        @XmlElement(name = "PaymentSuspensionPeriod", type = PaymentSuspensionPeriodType.class),
        @XmlElement(name = "ReportApprovalSuspensionPeriod", type = ReportApprovalSuspensionPeriodType.class)
    })
    protected List<SuspensionPeriodType> paymentSuspensionPeriodOrReportApprovalSuspensionPeriod;

    /**
     * Gets the value of the paymentSuspensionPeriodOrReportApprovalSuspensionPeriod property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the paymentSuspensionPeriodOrReportApprovalSuspensionPeriod property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPaymentSuspensionPeriodOrReportApprovalSuspensionPeriod().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PaymentSuspensionPeriodType }
     * {@link ReportApprovalSuspensionPeriodType }
     * 
     * 
     */
    public List<SuspensionPeriodType> getPaymentSuspensionPeriodOrReportApprovalSuspensionPeriod() {
        if (paymentSuspensionPeriodOrReportApprovalSuspensionPeriod == null) {
            paymentSuspensionPeriodOrReportApprovalSuspensionPeriod = new ArrayList<SuspensionPeriodType>();
        }
        return this.paymentSuspensionPeriodOrReportApprovalSuspensionPeriod;
    }

}
