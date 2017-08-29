
package abac.legal_entity.v2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import abac.message.v1.MessageResponseType;


/**
 * <p>Clase Java para LegalEntityCheckDuplicateResponseType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="LegalEntityCheckDuplicateResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.ec.europa.eu/budg/abac/message/v1}MessageResponseType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ReliabilityPercentage" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="Result" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="SimilarityPercentage" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *                   &lt;group ref="{http://www.ec.europa.eu/budg/abac/legal_entity/v2}LegalEntitySearchChoiceGroup"/&gt;
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
@XmlType(name = "LegalEntityCheckDuplicateResponseType", propOrder = {
    "reliabilityPercentage",
    "result"
})
public class LegalEntityCheckDuplicateResponseType
    extends MessageResponseType
{

    @XmlElement(name = "ReliabilityPercentage")
    protected double reliabilityPercentage;
    @XmlElement(name = "Result")
    protected List<Result> result;

    /**
     * Obtiene el valor de la propiedad reliabilityPercentage.
     * 
     */
    public double getReliabilityPercentage() {
        return reliabilityPercentage;
    }

    /**
     * Define el valor de la propiedad reliabilityPercentage.
     * 
     */
    public void setReliabilityPercentage(double value) {
        this.reliabilityPercentage = value;
    }

    /**
     * Gets the value of the result property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the result property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Result }
     * 
     * 
     */
    public List<Result> getResult() {
        if (result == null) {
            result = new ArrayList<Result>();
        }
        return this.result;
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
     *         &lt;element name="SimilarityPercentage" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
     *         &lt;group ref="{http://www.ec.europa.eu/budg/abac/legal_entity/v2}LegalEntitySearchChoiceGroup"/&gt;
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
        "similarityPercentage",
        "privatePersonSearch",
        "staffMemberSearch",
        "exStaffMemberSearch",
        "europeanParliamentMemberSearch",
        "publicLawBodySearch",
        "privateLawBodySearch",
        "technicalLegalEntitySearch"
    })
    public static class Result {

        @XmlElement(name = "SimilarityPercentage")
        protected double similarityPercentage;
        @XmlElement(name = "PrivatePersonSearch")
        protected PrivatePersonSearchType privatePersonSearch;
        @XmlElement(name = "StaffMemberSearch")
        protected StaffMemberSearchType staffMemberSearch;
        @XmlElement(name = "ExStaffMemberSearch")
        protected ExStaffMemberSearchType exStaffMemberSearch;
        @XmlElement(name = "EuropeanParliamentMemberSearch")
        protected EuropeanParliamentMemberSearchType europeanParliamentMemberSearch;
        @XmlElement(name = "PublicLawBodySearch")
        protected PublicLawBodySearchType publicLawBodySearch;
        @XmlElement(name = "PrivateLawBodySearch")
        protected PrivateLawBodySearchType privateLawBodySearch;
        @XmlElement(name = "TechnicalLegalEntitySearch")
        protected TechnicalLegalEntitySearchType technicalLegalEntitySearch;

        /**
         * Obtiene el valor de la propiedad similarityPercentage.
         * 
         */
        public double getSimilarityPercentage() {
            return similarityPercentage;
        }

        /**
         * Define el valor de la propiedad similarityPercentage.
         * 
         */
        public void setSimilarityPercentage(double value) {
            this.similarityPercentage = value;
        }

        /**
         * Obtiene el valor de la propiedad privatePersonSearch.
         * 
         * @return
         *     possible object is
         *     {@link PrivatePersonSearchType }
         *     
         */
        public PrivatePersonSearchType getPrivatePersonSearch() {
            return privatePersonSearch;
        }

        /**
         * Define el valor de la propiedad privatePersonSearch.
         * 
         * @param value
         *     allowed object is
         *     {@link PrivatePersonSearchType }
         *     
         */
        public void setPrivatePersonSearch(PrivatePersonSearchType value) {
            this.privatePersonSearch = value;
        }

        /**
         * Obtiene el valor de la propiedad staffMemberSearch.
         * 
         * @return
         *     possible object is
         *     {@link StaffMemberSearchType }
         *     
         */
        public StaffMemberSearchType getStaffMemberSearch() {
            return staffMemberSearch;
        }

        /**
         * Define el valor de la propiedad staffMemberSearch.
         * 
         * @param value
         *     allowed object is
         *     {@link StaffMemberSearchType }
         *     
         */
        public void setStaffMemberSearch(StaffMemberSearchType value) {
            this.staffMemberSearch = value;
        }

        /**
         * Obtiene el valor de la propiedad exStaffMemberSearch.
         * 
         * @return
         *     possible object is
         *     {@link ExStaffMemberSearchType }
         *     
         */
        public ExStaffMemberSearchType getExStaffMemberSearch() {
            return exStaffMemberSearch;
        }

        /**
         * Define el valor de la propiedad exStaffMemberSearch.
         * 
         * @param value
         *     allowed object is
         *     {@link ExStaffMemberSearchType }
         *     
         */
        public void setExStaffMemberSearch(ExStaffMemberSearchType value) {
            this.exStaffMemberSearch = value;
        }

        /**
         * Obtiene el valor de la propiedad europeanParliamentMemberSearch.
         * 
         * @return
         *     possible object is
         *     {@link EuropeanParliamentMemberSearchType }
         *     
         */
        public EuropeanParliamentMemberSearchType getEuropeanParliamentMemberSearch() {
            return europeanParliamentMemberSearch;
        }

        /**
         * Define el valor de la propiedad europeanParliamentMemberSearch.
         * 
         * @param value
         *     allowed object is
         *     {@link EuropeanParliamentMemberSearchType }
         *     
         */
        public void setEuropeanParliamentMemberSearch(EuropeanParliamentMemberSearchType value) {
            this.europeanParliamentMemberSearch = value;
        }

        /**
         * Obtiene el valor de la propiedad publicLawBodySearch.
         * 
         * @return
         *     possible object is
         *     {@link PublicLawBodySearchType }
         *     
         */
        public PublicLawBodySearchType getPublicLawBodySearch() {
            return publicLawBodySearch;
        }

        /**
         * Define el valor de la propiedad publicLawBodySearch.
         * 
         * @param value
         *     allowed object is
         *     {@link PublicLawBodySearchType }
         *     
         */
        public void setPublicLawBodySearch(PublicLawBodySearchType value) {
            this.publicLawBodySearch = value;
        }

        /**
         * Obtiene el valor de la propiedad privateLawBodySearch.
         * 
         * @return
         *     possible object is
         *     {@link PrivateLawBodySearchType }
         *     
         */
        public PrivateLawBodySearchType getPrivateLawBodySearch() {
            return privateLawBodySearch;
        }

        /**
         * Define el valor de la propiedad privateLawBodySearch.
         * 
         * @param value
         *     allowed object is
         *     {@link PrivateLawBodySearchType }
         *     
         */
        public void setPrivateLawBodySearch(PrivateLawBodySearchType value) {
            this.privateLawBodySearch = value;
        }

        /**
         * Obtiene el valor de la propiedad technicalLegalEntitySearch.
         * 
         * @return
         *     possible object is
         *     {@link TechnicalLegalEntitySearchType }
         *     
         */
        public TechnicalLegalEntitySearchType getTechnicalLegalEntitySearch() {
            return technicalLegalEntitySearch;
        }

        /**
         * Define el valor de la propiedad technicalLegalEntitySearch.
         * 
         * @param value
         *     allowed object is
         *     {@link TechnicalLegalEntitySearchType }
         *     
         */
        public void setTechnicalLegalEntitySearch(TechnicalLegalEntitySearchType value) {
            this.technicalLegalEntitySearch = value;
        }

    }

}
