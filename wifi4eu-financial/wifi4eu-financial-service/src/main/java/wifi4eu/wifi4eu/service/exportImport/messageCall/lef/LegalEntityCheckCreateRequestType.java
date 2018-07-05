
package wifi4eu.wifi4eu.service.exportImport.messageCall.lef;

import eu.europa.ec.budg.abac.message.v1.MessageRequestType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para LegalEntityCheckCreateRequestType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="LegalEntityCheckCreateRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.ec.europa.eu/budg/abac/message/v1}MessageRequestType"&gt;
 *       &lt;sequence&gt;
 *         &lt;group ref="{http://www.ec.europa.eu/budg/abac/legal_entity/v2}LegalEntityCreateChoiceGroup"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LegalEntityCheckCreateRequestType", propOrder = {
    "europeanParliamentMember",
    "exStaffMember",
    "privatePerson",
    "staffMember",
    "publicLawBody",
    "privateLawBody"
})
public class LegalEntityCheckCreateRequestType
    extends MessageRequestType
{

    @XmlElement(name = "EuropeanParliamentMember")
    protected EuropeanParliamentMemberCreateType europeanParliamentMember;
    @XmlElement(name = "ExStaffMember")
    protected ExStaffMemberCreateType exStaffMember;
    @XmlElement(name = "PrivatePerson")
    protected PrivatePersonCreateType privatePerson;
    @XmlElement(name = "StaffMember")
    protected StaffMemberCreateType staffMember;
    @XmlElement(name = "PublicLawBody")
    protected PublicLawBodyCreateType publicLawBody;
    @XmlElement(name = "PrivateLawBody")
    protected PrivateLawBodyCreateType privateLawBody;

    /**
     * Obtiene el valor de la propiedad europeanParliamentMember.
     *
     * @return
     *     possible object is
     *     {@link EuropeanParliamentMemberCreateType }
     *
     */
    public EuropeanParliamentMemberCreateType getEuropeanParliamentMember() {
        return europeanParliamentMember;
    }

    /**
     * Define el valor de la propiedad europeanParliamentMember.
     *
     * @param value
     *     allowed object is
     *     {@link EuropeanParliamentMemberCreateType }
     *
     */
    public void setEuropeanParliamentMember(EuropeanParliamentMemberCreateType value) {
        this.europeanParliamentMember = value;
    }

    /**
     * Obtiene el valor de la propiedad exStaffMember.
     *
     * @return
     *     possible object is
     *     {@link ExStaffMemberCreateType }
     *
     */
    public ExStaffMemberCreateType getExStaffMember() {
        return exStaffMember;
    }

    /**
     * Define el valor de la propiedad exStaffMember.
     *
     * @param value
     *     allowed object is
     *     {@link ExStaffMemberCreateType }
     *
     */
    public void setExStaffMember(ExStaffMemberCreateType value) {
        this.exStaffMember = value;
    }

    /**
     * Obtiene el valor de la propiedad privatePerson.
     *
     * @return
     *     possible object is
     *     {@link PrivatePersonCreateType }
     *
     */
    public PrivatePersonCreateType getPrivatePerson() {
        return privatePerson;
    }

    /**
     * Define el valor de la propiedad privatePerson.
     *
     * @param value
     *     allowed object is
     *     {@link PrivatePersonCreateType }
     *
     */
    public void setPrivatePerson(PrivatePersonCreateType value) {
        this.privatePerson = value;
    }

    /**
     * Obtiene el valor de la propiedad staffMember.
     *
     * @return
     *     possible object is
     *     {@link StaffMemberCreateType }
     *
     */
    public StaffMemberCreateType getStaffMember() {
        return staffMember;
    }

    /**
     * Define el valor de la propiedad staffMember.
     *
     * @param value
     *     allowed object is
     *     {@link StaffMemberCreateType }
     *
     */
    public void setStaffMember(StaffMemberCreateType value) {
        this.staffMember = value;
    }

    /**
     * Obtiene el valor de la propiedad publicLawBody.
     *
     * @return
     *     possible object is
     *     {@link PublicLawBodyCreateType }
     *
     */
    public PublicLawBodyCreateType getPublicLawBody() {
        return publicLawBody;
    }

    /**
     * Define el valor de la propiedad publicLawBody.
     *
     * @param value
     *     allowed object is
     *     {@link PublicLawBodyCreateType }
     *     
     */
    public void setPublicLawBody(PublicLawBodyCreateType value) {
        this.publicLawBody = value;
    }

    /**
     * Obtiene el valor de la propiedad privateLawBody.
     * 
     * @return
     *     possible object is
     *     {@link PrivateLawBodyCreateType }
     *     
     */
    public PrivateLawBodyCreateType getPrivateLawBody() {
        return privateLawBody;
    }

    /**
     * Define el valor de la propiedad privateLawBody.
     * 
     * @param value
     *     allowed object is
     *     {@link PrivateLawBodyCreateType }
     *     
     */
    public void setPrivateLawBody(PrivateLawBodyCreateType value) {
        this.privateLawBody = value;
    }

}
