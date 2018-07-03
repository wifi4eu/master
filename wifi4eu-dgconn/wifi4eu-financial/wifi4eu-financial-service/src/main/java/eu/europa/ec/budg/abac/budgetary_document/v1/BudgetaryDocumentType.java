
package eu.europa.ec.budg.abac.budgetary_document.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import eu.europa.ec.budg.abac.local_abac_document.v1.LocalAbacDocumentType;


/**
 * <p>Clase Java para BudgetaryDocumentType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="BudgetaryDocumentType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.ec.europa.eu/budg/abac/local_abac_document/v1}LocalAbacDocumentType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CurrentBookYear" type="{http://www.ec.europa.eu/budg/abac/budgetary_document/v1}CurrentBookYearType" minOccurs="0"/&gt;
 *         &lt;element name="OriginBookYear" type="{http://www.ec.europa.eu/budg/abac/budgetary_document/v1}OriginBookYearType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BudgetaryDocumentType", propOrder = {
    "currentBookYear",
    "originBookYear"
})
public abstract class BudgetaryDocumentType
    extends LocalAbacDocumentType
{

    @XmlElement(name = "CurrentBookYear")
    protected String currentBookYear;
    @XmlElement(name = "OriginBookYear")
    protected String originBookYear;

    /**
     * Obtiene el valor de la propiedad currentBookYear.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrentBookYear() {
        return currentBookYear;
    }

    /**
     * Define el valor de la propiedad currentBookYear.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrentBookYear(String value) {
        this.currentBookYear = value;
    }

    /**
     * Obtiene el valor de la propiedad originBookYear.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginBookYear() {
        return originBookYear;
    }

    /**
     * Define el valor de la propiedad originBookYear.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginBookYear(String value) {
        this.originBookYear = value;
    }

}
