
package abac.legal_entity.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import abac.message.v1.MessageRequestType;


/**
 * <p>Clase Java para LegalEntityCheckModifyRequestType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="LegalEntityCheckModifyRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.ec.europa.eu/budg/abac/message/v1}MessageRequestType"&gt;
 *       &lt;sequence&gt;
 *         &lt;group ref="{http://www.ec.europa.eu/budg/abac/legal_entity/v2}LegalEntityModifyChoiceGroup"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LegalEntityCheckModifyRequestType", propOrder = {
    "europeanParliamentMember",
    "exStaffMember",
    "privatePerson",
    "staffMember",
    "publicLawBody",
    "privateLawBody"
})
public class LegalEntityCheckModifyRequestType
    extends MessageRequestType
{

    @XmlElement(name = "EuropeanParliamentMember")
    protected EuropeanParliamentMemberWritableType europeanParliamentMember;
    @XmlElement(name = "ExStaffMember")
    protected ExStaffMemberWritableType exStaffMember;
    @XmlElement(name = "PrivatePerson")
    protected PrivatePersonWritableType privatePerson;
    @XmlElement(name = "StaffMember")
    protected StaffMemberWritableType staffMember;
    @XmlElement(name = "PublicLawBody")
    protected PublicLawBodyWritableType publicLawBody;
    @XmlElement(name = "PrivateLawBody")
    protected PrivateLawBodyWritableType privateLawBody;

    /**
     * Obtiene el valor de la propiedad europeanParliamentMember.
     * 
     * @return
     *     possible object is
     *     {@link EuropeanParliamentMemberWritableType }
     *     
     */
    public EuropeanParliamentMemberWritableType getEuropeanParliamentMember() {
        return europeanParliamentMember;
    }

    /**
     * Define el valor de la propiedad europeanParliamentMember.
     * 
     * @param value
     *     allowed object is
     *     {@link EuropeanParliamentMemberWritableType }
     *     
     */
    public void setEuropeanParliamentMember(EuropeanParliamentMemberWritableType value) {
        this.europeanParliamentMember = value;
    }

    /**
     * Obtiene el valor de la propiedad exStaffMember.
     * 
     * @return
     *     possible object is
     *     {@link ExStaffMemberWritableType }
     *     
     */
    public ExStaffMemberWritableType getExStaffMember() {
        return exStaffMember;
    }

    /**
     * Define el valor de la propiedad exStaffMember.
     * 
     * @param value
     *     allowed object is
     *     {@link ExStaffMemberWritableType }
     *     
     */
    public void setExStaffMember(ExStaffMemberWritableType value) {
        this.exStaffMember = value;
    }

    /**
     * Obtiene el valor de la propiedad privatePerson.
     * 
     * @return
     *     possible object is
     *     {@link PrivatePersonWritableType }
     *     
     */
    public PrivatePersonWritableType getPrivatePerson() {
        return privatePerson;
    }

    /**
     * Define el valor de la propiedad privatePerson.
     * 
     * @param value
     *     allowed object is
     *     {@link PrivatePersonWritableType }
     *     
     */
    public void setPrivatePerson(PrivatePersonWritableType value) {
        this.privatePerson = value;
    }

    /**
     * Obtiene el valor de la propiedad staffMember.
     * 
     * @return
     *     possible object is
     *     {@link StaffMemberWritableType }
     *     
     */
    public StaffMemberWritableType getStaffMember() {
        return staffMember;
    }

    /**
     * Define el valor de la propiedad staffMember.
     * 
     * @param value
     *     allowed object is
     *     {@link StaffMemberWritableType }
     *     
     */
    public void setStaffMember(StaffMemberWritableType value) {
        this.staffMember = value;
    }

    /**
     * Obtiene el valor de la propiedad publicLawBody.
     * 
     * @return
     *     possible object is
     *     {@link PublicLawBodyWritableType }
     *     
     */
    public PublicLawBodyWritableType getPublicLawBody() {
        return publicLawBody;
    }

    /**
     * Define el valor de la propiedad publicLawBody.
     * 
     * @param value
     *     allowed object is
     *     {@link PublicLawBodyWritableType }
     *     
     */
    public void setPublicLawBody(PublicLawBodyWritableType value) {
        this.publicLawBody = value;
    }

    /**
     * Obtiene el valor de la propiedad privateLawBody.
     * 
     * @return
     *     possible object is
     *     {@link PrivateLawBodyWritableType }
     *     
     */
    public PrivateLawBodyWritableType getPrivateLawBody() {
        return privateLawBody;
    }

    /**
     * Define el valor de la propiedad privateLawBody.
     * 
     * @param value
     *     allowed object is
     *     {@link PrivateLawBodyWritableType }
     *     
     */
    public void setPrivateLawBody(PrivateLawBodyWritableType value) {
        this.privateLawBody = value;
    }

}
