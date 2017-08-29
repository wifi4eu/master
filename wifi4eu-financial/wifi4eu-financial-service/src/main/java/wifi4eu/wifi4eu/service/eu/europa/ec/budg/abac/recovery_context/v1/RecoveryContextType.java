
package wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.recovery_context.v1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para RecoveryContextType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="RecoveryContextType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.ec.europa.eu/budg/abac/recovery_context/v1}RecoveryContextWithoutErrorsType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ErrorIrregularityTypes" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="ErrorIrregularityType" type="{http://www.ec.europa.eu/budg/abac/recovery_context/v1}ErrorIrregularityTypeNoDescType" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RecoveryContextType", propOrder = {
    "errorIrregularityTypes"
})
public class RecoveryContextType
    extends RecoveryContextWithoutErrorsType
{

    @XmlElement(name = "ErrorIrregularityTypes")
    protected ErrorIrregularityTypes errorIrregularityTypes;

    /**
     * Obtiene el valor de la propiedad errorIrregularityTypes.
     * 
     * @return
     *     possible object is
     *     {@link ErrorIrregularityTypes }
     *     
     */
    public ErrorIrregularityTypes getErrorIrregularityTypes() {
        return errorIrregularityTypes;
    }

    /**
     * Define el valor de la propiedad errorIrregularityTypes.
     * 
     * @param value
     *     allowed object is
     *     {@link ErrorIrregularityTypes }
     *     
     */
    public void setErrorIrregularityTypes(ErrorIrregularityTypes value) {
        this.errorIrregularityTypes = value;
    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="ErrorIrregularityType" type="{http://www.ec.europa.eu/budg/abac/recovery_context/v1}ErrorIrregularityTypeNoDescType" maxOccurs="unbounded"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "errorIrregularityType"
    })
    public static class ErrorIrregularityTypes {

        @XmlElement(name = "ErrorIrregularityType", required = true)
        protected List<ErrorIrregularityTypeNoDescType> errorIrregularityType;

        /**
         * Gets the value of the errorIrregularityType property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the errorIrregularityType property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getErrorIrregularityType().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ErrorIrregularityTypeNoDescType }
         * 
         * 
         */
        public List<ErrorIrregularityTypeNoDescType> getErrorIrregularityType() {
            if (errorIrregularityType == null) {
                errorIrregularityType = new ArrayList<ErrorIrregularityTypeNoDescType>();
            }
            return this.errorIrregularityType;
        }

    }

}
