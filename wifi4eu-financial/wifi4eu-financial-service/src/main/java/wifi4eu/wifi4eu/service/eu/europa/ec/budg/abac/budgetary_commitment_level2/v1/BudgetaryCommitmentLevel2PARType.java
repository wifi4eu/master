
package wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.budgetary_commitment_level2.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para BudgetaryCommitmentLevel2PARType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="BudgetaryCommitmentLevel2PARType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Justification" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}RemarksType" minOccurs="0"/&gt;
 *         &lt;element name="PARCode" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}PARCodeType" minOccurs="0"/&gt;
 *         &lt;element name="ResponsibleService" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}RemarksType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BudgetaryCommitmentLevel2PARType", propOrder = {
    "justification",
    "parCode",
    "responsibleService"
})
public class BudgetaryCommitmentLevel2PARType {

    @XmlElement(name = "Justification")
    protected String justification;
    @XmlElement(name = "PARCode")
    protected String parCode;
    @XmlElement(name = "ResponsibleService")
    protected String responsibleService;

    /**
     * Obtiene el valor de la propiedad justification.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJustification() {
        return justification;
    }

    /**
     * Define el valor de la propiedad justification.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJustification(String value) {
        this.justification = value;
    }

    /**
     * Obtiene el valor de la propiedad parCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPARCode() {
        return parCode;
    }

    /**
     * Define el valor de la propiedad parCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPARCode(String value) {
        this.parCode = value;
    }

    /**
     * Obtiene el valor de la propiedad responsibleService.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponsibleService() {
        return responsibleService;
    }

    /**
     * Define el valor de la propiedad responsibleService.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponsibleService(String value) {
        this.responsibleService = value;
    }

}
