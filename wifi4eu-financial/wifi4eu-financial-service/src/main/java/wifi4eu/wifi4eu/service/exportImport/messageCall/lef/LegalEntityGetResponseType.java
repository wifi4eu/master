
package wifi4eu.wifi4eu.service.exportImport.messageCall.lef;

import eu.europa.ec.budg.abac.message.v1.MessageResponseType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para LegalEntityGetResponseType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="LegalEntityGetResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.ec.europa.eu/budg/abac/message/v1}MessageResponseType"&gt;
 *       &lt;group ref="{http://www.ec.europa.eu/budg/abac/legal_entity/v2}LegalEntityGetChoiceGroup"/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LegalEntityGetResponseType", propOrder = {
    "europeanParliamentMember",
    "exStaffMember",
    "privatePerson",
    "staffMember",
    "publicLawBody",
    "privateLawBody",
    "technicalLegalEntity"
})
public class LegalEntityGetResponseType
    extends MessageResponseType
{

    @XmlElement(name = "EuropeanParliamentMember")
    protected EuropeanParliamentMemberGetType europeanParliamentMember;
    @XmlElement(name = "ExStaffMember")
    protected ExStaffMemberGetType exStaffMember;
    @XmlElement(name = "PrivatePerson")
    protected PrivatePersonGetType privatePerson;
    @XmlElement(name = "StaffMember")
    protected StaffMemberGetType staffMember;
    @XmlElement(name = "PublicLawBody")
    protected PublicLawBodyGetType publicLawBody;
    @XmlElement(name = "PrivateLawBody")
    protected PrivateLawBodyGetType privateLawBody;
    @XmlElement(name = "TechnicalLegalEntity")
    protected TechnicalLegalEntityGetType technicalLegalEntity;

    /**
     * Obtiene el valor de la propiedad europeanParliamentMember.
     *
     * @return
     *     possible object is
     *     {@link EuropeanParliamentMemberGetType }
     *
     */
    public EuropeanParliamentMemberGetType getEuropeanParliamentMember() {
        return europeanParliamentMember;
    }

    /**
     * Define el valor de la propiedad europeanParliamentMember.
     *
     * @param value
     *     allowed object is
     *     {@link EuropeanParliamentMemberGetType }
     *
     */
    public void setEuropeanParliamentMember(EuropeanParliamentMemberGetType value) {
        this.europeanParliamentMember = value;
    }

    /**
     * Obtiene el valor de la propiedad exStaffMember.
     *
     * @return
     *     possible object is
     *     {@link ExStaffMemberGetType }
     *
     */
    public ExStaffMemberGetType getExStaffMember() {
        return exStaffMember;
    }

    /**
     * Define el valor de la propiedad exStaffMember.
     *
     * @param value
     *     allowed object is
     *     {@link ExStaffMemberGetType }
     *
     */
    public void setExStaffMember(ExStaffMemberGetType value) {
        this.exStaffMember = value;
    }

    /**
     * Obtiene el valor de la propiedad privatePerson.
     *
     * @return
     *     possible object is
     *     {@link PrivatePersonGetType }
     *
     */
    public PrivatePersonGetType getPrivatePerson() {
        return privatePerson;
    }

    /**
     * Define el valor de la propiedad privatePerson.
     *
     * @param value
     *     allowed object is
     *     {@link PrivatePersonGetType }
     *
     */
    public void setPrivatePerson(PrivatePersonGetType value) {
        this.privatePerson = value;
    }

    /**
     * Obtiene el valor de la propiedad staffMember.
     *
     * @return
     *     possible object is
     *     {@link StaffMemberGetType }
     *
     */
    public StaffMemberGetType getStaffMember() {
        return staffMember;
    }

    /**
     * Define el valor de la propiedad staffMember.
     *
     * @param value
     *     allowed object is
     *     {@link StaffMemberGetType }
     *
     */
    public void setStaffMember(StaffMemberGetType value) {
        this.staffMember = value;
    }

    /**
     * Obtiene el valor de la propiedad publicLawBody.
     *
     * @return
     *     possible object is
     *     {@link PublicLawBodyGetType }
     *
     */
    public PublicLawBodyGetType getPublicLawBody() {
        return publicLawBody;
    }

    /**
     * Define el valor de la propiedad publicLawBody.
     *
     * @param value
     *     allowed object is
     *     {@link PublicLawBodyGetType }
     *
     */
    public void setPublicLawBody(PublicLawBodyGetType value) {
        this.publicLawBody = value;
    }

    /**
     * Obtiene el valor de la propiedad privateLawBody.
     *
     * @return
     *     possible object is
     *     {@link PrivateLawBodyGetType }
     *
     */
    public PrivateLawBodyGetType getPrivateLawBody() {
        return privateLawBody;
    }

    /**
     * Define el valor de la propiedad privateLawBody.
     *
     * @param value
     *     allowed object is
     *     {@link PrivateLawBodyGetType }
     *
     */
    public void setPrivateLawBody(PrivateLawBodyGetType value) {
        this.privateLawBody = value;
    }

    /**
     * Obtiene el valor de la propiedad technicalLegalEntity.
     *
     * @return
     *     possible object is
     *     {@link TechnicalLegalEntityGetType }
     *
     */
    public TechnicalLegalEntityGetType getTechnicalLegalEntity() {
        return technicalLegalEntity;
    }

    /**
     * Define el valor de la propiedad technicalLegalEntity.
     *
     * @param value
     *     allowed object is
     *     {@link TechnicalLegalEntityGetType }
     *     
     */
    public void setTechnicalLegalEntity(TechnicalLegalEntityGetType value) {
        this.technicalLegalEntity = value;
    }

}
