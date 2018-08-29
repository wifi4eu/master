
package generated.hrs.ws.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import org.jvnet.jaxb2_commons.lang.Equals;
import org.jvnet.jaxb2_commons.lang.EqualsStrategy;
import org.jvnet.jaxb2_commons.lang.HashCode;
import org.jvnet.jaxb2_commons.lang.HashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBEqualsStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBHashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;
import org.jvnet.jaxb2_commons.locator.util.LocatorUtils;


/**
 * The signature information for a document in case the document was externally signed.
 * 
 *                 This information is provided only for information purposes and Hermes will not
 *                 validate or guarantee that the actual signing took place.
 * 
 * <p>Java class for ExternalSignaturesToAdd complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExternalSignaturesToAdd">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="signature" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;choice>
 *                     &lt;sequence>
 *                       &lt;choice>
 *                         &lt;element name="signedBy" type="{http://ec.europa.eu/sg/hrs/types}CurrentEntityId"/>
 *                         &lt;element name="signedBySearchExpression" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                       &lt;/choice>
 *                       &lt;element name="dateSigned" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *                     &lt;/sequence>
 *                     &lt;element name="ecasSignature" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
 *                   &lt;/choice>
 *                   &lt;element name="application" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExternalSignaturesToAdd", propOrder = {
    "signature"
})
public class ExternalSignaturesToAdd
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected List<ExternalSignaturesToAdd.Signature> signature;

    /**
     * Gets the value of the signature property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the signature property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSignature().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExternalSignaturesToAdd.Signature }
     * 
     * 
     */
    public List<ExternalSignaturesToAdd.Signature> getSignature() {
        if (signature == null) {
            signature = new ArrayList<ExternalSignaturesToAdd.Signature>();
        }
        return this.signature;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ExternalSignaturesToAdd)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final ExternalSignaturesToAdd that = ((ExternalSignaturesToAdd) object);
        {
            List<ExternalSignaturesToAdd.Signature> lhsSignature;
            lhsSignature = (((this.signature!= null)&&(!this.signature.isEmpty()))?this.getSignature():null);
            List<ExternalSignaturesToAdd.Signature> rhsSignature;
            rhsSignature = (((that.signature!= null)&&(!that.signature.isEmpty()))?that.getSignature():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "signature", lhsSignature), LocatorUtils.property(thatLocator, "signature", rhsSignature), lhsSignature, rhsSignature)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object object) {
        final EqualsStrategy strategy = JAXBEqualsStrategy.INSTANCE;
        return equals(null, null, object, strategy);
    }

    public String toString() {
        final ToStringStrategy strategy = JAXBToStringStrategy.INSTANCE;
        final StringBuilder buffer = new StringBuilder();
        append(null, buffer, strategy);
        return buffer.toString();
    }

    public StringBuilder append(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
        strategy.appendStart(locator, this, buffer);
        appendFields(locator, buffer, strategy);
        strategy.appendEnd(locator, this, buffer);
        return buffer;
    }

    public StringBuilder appendFields(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
        {
            List<ExternalSignaturesToAdd.Signature> theSignature;
            theSignature = (((this.signature!= null)&&(!this.signature.isEmpty()))?this.getSignature():null);
            strategy.appendField(locator, this, "signature", buffer, theSignature);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            List<ExternalSignaturesToAdd.Signature> theSignature;
            theSignature = (((this.signature!= null)&&(!this.signature.isEmpty()))?this.getSignature():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "signature", theSignature), currentHashCode, theSignature);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;choice>
     *           &lt;sequence>
     *             &lt;choice>
     *               &lt;element name="signedBy" type="{http://ec.europa.eu/sg/hrs/types}CurrentEntityId"/>
     *               &lt;element name="signedBySearchExpression" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *             &lt;/choice>
     *             &lt;element name="dateSigned" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
     *           &lt;/sequence>
     *           &lt;element name="ecasSignature" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
     *         &lt;/choice>
     *         &lt;element name="application" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "signedBy",
        "signedBySearchExpression",
        "dateSigned",
        "ecasSignature",
        "application"
    })
    public static class Signature
        implements Equals, HashCode, ToString
    {

        protected String signedBy;
        protected String signedBySearchExpression;
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar dateSigned;
        protected byte[] ecasSignature;
        @XmlElement(required = true)
        protected String application;

        /**
         * Gets the value of the signedBy property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSignedBy() {
            return signedBy;
        }

        /**
         * Sets the value of the signedBy property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSignedBy(String value) {
            this.signedBy = value;
        }

        /**
         * Gets the value of the signedBySearchExpression property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSignedBySearchExpression() {
            return signedBySearchExpression;
        }

        /**
         * Sets the value of the signedBySearchExpression property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSignedBySearchExpression(String value) {
            this.signedBySearchExpression = value;
        }

        /**
         * Gets the value of the dateSigned property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getDateSigned() {
            return dateSigned;
        }

        /**
         * Sets the value of the dateSigned property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setDateSigned(XMLGregorianCalendar value) {
            this.dateSigned = value;
        }

        /**
         * Gets the value of the ecasSignature property.
         * 
         * @return
         *     possible object is
         *     byte[]
         */
        public byte[] getEcasSignature() {
            return ecasSignature;
        }

        /**
         * Sets the value of the ecasSignature property.
         * 
         * @param value
         *     allowed object is
         *     byte[]
         */
        public void setEcasSignature(byte[] value) {
            this.ecasSignature = value;
        }

        /**
         * Gets the value of the application property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getApplication() {
            return application;
        }

        /**
         * Sets the value of the application property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setApplication(String value) {
            this.application = value;
        }

        public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
            if (!(object instanceof ExternalSignaturesToAdd.Signature)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final ExternalSignaturesToAdd.Signature that = ((ExternalSignaturesToAdd.Signature) object);
            {
                String lhsSignedBy;
                lhsSignedBy = this.getSignedBy();
                String rhsSignedBy;
                rhsSignedBy = that.getSignedBy();
                if (!strategy.equals(LocatorUtils.property(thisLocator, "signedBy", lhsSignedBy), LocatorUtils.property(thatLocator, "signedBy", rhsSignedBy), lhsSignedBy, rhsSignedBy)) {
                    return false;
                }
            }
            {
                String lhsSignedBySearchExpression;
                lhsSignedBySearchExpression = this.getSignedBySearchExpression();
                String rhsSignedBySearchExpression;
                rhsSignedBySearchExpression = that.getSignedBySearchExpression();
                if (!strategy.equals(LocatorUtils.property(thisLocator, "signedBySearchExpression", lhsSignedBySearchExpression), LocatorUtils.property(thatLocator, "signedBySearchExpression", rhsSignedBySearchExpression), lhsSignedBySearchExpression, rhsSignedBySearchExpression)) {
                    return false;
                }
            }
            {
                XMLGregorianCalendar lhsDateSigned;
                lhsDateSigned = this.getDateSigned();
                XMLGregorianCalendar rhsDateSigned;
                rhsDateSigned = that.getDateSigned();
                if (!strategy.equals(LocatorUtils.property(thisLocator, "dateSigned", lhsDateSigned), LocatorUtils.property(thatLocator, "dateSigned", rhsDateSigned), lhsDateSigned, rhsDateSigned)) {
                    return false;
                }
            }
            {
                byte[] lhsEcasSignature;
                lhsEcasSignature = this.getEcasSignature();
                byte[] rhsEcasSignature;
                rhsEcasSignature = that.getEcasSignature();
                if (!strategy.equals(LocatorUtils.property(thisLocator, "ecasSignature", lhsEcasSignature), LocatorUtils.property(thatLocator, "ecasSignature", rhsEcasSignature), lhsEcasSignature, rhsEcasSignature)) {
                    return false;
                }
            }
            {
                String lhsApplication;
                lhsApplication = this.getApplication();
                String rhsApplication;
                rhsApplication = that.getApplication();
                if (!strategy.equals(LocatorUtils.property(thisLocator, "application", lhsApplication), LocatorUtils.property(thatLocator, "application", rhsApplication), lhsApplication, rhsApplication)) {
                    return false;
                }
            }
            return true;
        }

        public boolean equals(Object object) {
            final EqualsStrategy strategy = JAXBEqualsStrategy.INSTANCE;
            return equals(null, null, object, strategy);
        }

        public String toString() {
            final ToStringStrategy strategy = JAXBToStringStrategy.INSTANCE;
            final StringBuilder buffer = new StringBuilder();
            append(null, buffer, strategy);
            return buffer.toString();
        }

        public StringBuilder append(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
            strategy.appendStart(locator, this, buffer);
            appendFields(locator, buffer, strategy);
            strategy.appendEnd(locator, this, buffer);
            return buffer;
        }

        public StringBuilder appendFields(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
            {
                String theSignedBy;
                theSignedBy = this.getSignedBy();
                strategy.appendField(locator, this, "signedBy", buffer, theSignedBy);
            }
            {
                String theSignedBySearchExpression;
                theSignedBySearchExpression = this.getSignedBySearchExpression();
                strategy.appendField(locator, this, "signedBySearchExpression", buffer, theSignedBySearchExpression);
            }
            {
                XMLGregorianCalendar theDateSigned;
                theDateSigned = this.getDateSigned();
                strategy.appendField(locator, this, "dateSigned", buffer, theDateSigned);
            }
            {
                byte[] theEcasSignature;
                theEcasSignature = this.getEcasSignature();
                strategy.appendField(locator, this, "ecasSignature", buffer, theEcasSignature);
            }
            {
                String theApplication;
                theApplication = this.getApplication();
                strategy.appendField(locator, this, "application", buffer, theApplication);
            }
            return buffer;
        }

        public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
            int currentHashCode = 1;
            {
                String theSignedBy;
                theSignedBy = this.getSignedBy();
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "signedBy", theSignedBy), currentHashCode, theSignedBy);
            }
            {
                String theSignedBySearchExpression;
                theSignedBySearchExpression = this.getSignedBySearchExpression();
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "signedBySearchExpression", theSignedBySearchExpression), currentHashCode, theSignedBySearchExpression);
            }
            {
                XMLGregorianCalendar theDateSigned;
                theDateSigned = this.getDateSigned();
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "dateSigned", theDateSigned), currentHashCode, theDateSigned);
            }
            {
                byte[] theEcasSignature;
                theEcasSignature = this.getEcasSignature();
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "ecasSignature", theEcasSignature), currentHashCode, theEcasSignature);
            }
            {
                String theApplication;
                theApplication = this.getApplication();
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "application", theApplication), currentHashCode, theApplication);
            }
            return currentHashCode;
        }

        public int hashCode() {
            final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
            return this.hashCode(null, strategy);
        }

    }

}
