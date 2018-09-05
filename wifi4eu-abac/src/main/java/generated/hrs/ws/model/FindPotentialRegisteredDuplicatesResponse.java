
package generated.hrs.ws.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
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
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="potentialDuplicateRegisteredDocuments" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="potentialDuplicateRegisteredDocumentInfo" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="documentId" type="{http://ec.europa.eu/sg/hrs/types}ObjectId"/>
 *                             &lt;element name="registrationDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                             &lt;element name="registrationNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="registrationAuthor">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="ecasId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="fullName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="dg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="service" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="phone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="visible" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                             &lt;element name="score" type="{http://ec.europa.eu/sg/hrs/types}DecimalPercentage" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
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
@XmlType(name = "", propOrder = {
    "potentialDuplicateRegisteredDocuments"
})
@XmlRootElement(name = "findPotentialRegisteredDuplicatesResponse")
public class FindPotentialRegisteredDuplicatesResponse
    implements Equals, HashCode, ToString
{

    protected FindPotentialRegisteredDuplicatesResponse.PotentialDuplicateRegisteredDocuments potentialDuplicateRegisteredDocuments;

    /**
     * Gets the value of the potentialDuplicateRegisteredDocuments property.
     * 
     * @return
     *     possible object is
     *     {@link FindPotentialRegisteredDuplicatesResponse.PotentialDuplicateRegisteredDocuments }
     *     
     */
    public FindPotentialRegisteredDuplicatesResponse.PotentialDuplicateRegisteredDocuments getPotentialDuplicateRegisteredDocuments() {
        return potentialDuplicateRegisteredDocuments;
    }

    /**
     * Sets the value of the potentialDuplicateRegisteredDocuments property.
     * 
     * @param value
     *     allowed object is
     *     {@link FindPotentialRegisteredDuplicatesResponse.PotentialDuplicateRegisteredDocuments }
     *     
     */
    public void setPotentialDuplicateRegisteredDocuments(FindPotentialRegisteredDuplicatesResponse.PotentialDuplicateRegisteredDocuments value) {
        this.potentialDuplicateRegisteredDocuments = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof FindPotentialRegisteredDuplicatesResponse)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final FindPotentialRegisteredDuplicatesResponse that = ((FindPotentialRegisteredDuplicatesResponse) object);
        {
            FindPotentialRegisteredDuplicatesResponse.PotentialDuplicateRegisteredDocuments lhsPotentialDuplicateRegisteredDocuments;
            lhsPotentialDuplicateRegisteredDocuments = this.getPotentialDuplicateRegisteredDocuments();
            FindPotentialRegisteredDuplicatesResponse.PotentialDuplicateRegisteredDocuments rhsPotentialDuplicateRegisteredDocuments;
            rhsPotentialDuplicateRegisteredDocuments = that.getPotentialDuplicateRegisteredDocuments();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "potentialDuplicateRegisteredDocuments", lhsPotentialDuplicateRegisteredDocuments), LocatorUtils.property(thatLocator, "potentialDuplicateRegisteredDocuments", rhsPotentialDuplicateRegisteredDocuments), lhsPotentialDuplicateRegisteredDocuments, rhsPotentialDuplicateRegisteredDocuments)) {
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
            FindPotentialRegisteredDuplicatesResponse.PotentialDuplicateRegisteredDocuments thePotentialDuplicateRegisteredDocuments;
            thePotentialDuplicateRegisteredDocuments = this.getPotentialDuplicateRegisteredDocuments();
            strategy.appendField(locator, this, "potentialDuplicateRegisteredDocuments", buffer, thePotentialDuplicateRegisteredDocuments);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            FindPotentialRegisteredDuplicatesResponse.PotentialDuplicateRegisteredDocuments thePotentialDuplicateRegisteredDocuments;
            thePotentialDuplicateRegisteredDocuments = this.getPotentialDuplicateRegisteredDocuments();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "potentialDuplicateRegisteredDocuments", thePotentialDuplicateRegisteredDocuments), currentHashCode, thePotentialDuplicateRegisteredDocuments);
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
     *         &lt;element name="potentialDuplicateRegisteredDocumentInfo" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="documentId" type="{http://ec.europa.eu/sg/hrs/types}ObjectId"/>
     *                   &lt;element name="registrationDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *                   &lt;element name="registrationNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="registrationAuthor">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="ecasId" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="fullName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                             &lt;element name="dg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                             &lt;element name="service" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                             &lt;element name="phone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                             &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="visible" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *                   &lt;element name="score" type="{http://ec.europa.eu/sg/hrs/types}DecimalPercentage" minOccurs="0"/>
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
    @XmlType(name = "", propOrder = {
        "potentialDuplicateRegisteredDocumentInfo"
    })
    public static class PotentialDuplicateRegisteredDocuments
        implements Equals, HashCode, ToString
    {

        protected List<FindPotentialRegisteredDuplicatesResponse.PotentialDuplicateRegisteredDocuments.PotentialDuplicateRegisteredDocumentInfo> potentialDuplicateRegisteredDocumentInfo;

        /**
         * Gets the value of the potentialDuplicateRegisteredDocumentInfo property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the potentialDuplicateRegisteredDocumentInfo property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPotentialDuplicateRegisteredDocumentInfo().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link FindPotentialRegisteredDuplicatesResponse.PotentialDuplicateRegisteredDocuments.PotentialDuplicateRegisteredDocumentInfo }
         * 
         * 
         */
        public List<FindPotentialRegisteredDuplicatesResponse.PotentialDuplicateRegisteredDocuments.PotentialDuplicateRegisteredDocumentInfo> getPotentialDuplicateRegisteredDocumentInfo() {
            if (potentialDuplicateRegisteredDocumentInfo == null) {
                potentialDuplicateRegisteredDocumentInfo = new ArrayList<FindPotentialRegisteredDuplicatesResponse.PotentialDuplicateRegisteredDocuments.PotentialDuplicateRegisteredDocumentInfo>();
            }
            return this.potentialDuplicateRegisteredDocumentInfo;
        }

        public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
            if (!(object instanceof FindPotentialRegisteredDuplicatesResponse.PotentialDuplicateRegisteredDocuments)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final FindPotentialRegisteredDuplicatesResponse.PotentialDuplicateRegisteredDocuments that = ((FindPotentialRegisteredDuplicatesResponse.PotentialDuplicateRegisteredDocuments) object);
            {
                List<FindPotentialRegisteredDuplicatesResponse.PotentialDuplicateRegisteredDocuments.PotentialDuplicateRegisteredDocumentInfo> lhsPotentialDuplicateRegisteredDocumentInfo;
                lhsPotentialDuplicateRegisteredDocumentInfo = (((this.potentialDuplicateRegisteredDocumentInfo!= null)&&(!this.potentialDuplicateRegisteredDocumentInfo.isEmpty()))?this.getPotentialDuplicateRegisteredDocumentInfo():null);
                List<FindPotentialRegisteredDuplicatesResponse.PotentialDuplicateRegisteredDocuments.PotentialDuplicateRegisteredDocumentInfo> rhsPotentialDuplicateRegisteredDocumentInfo;
                rhsPotentialDuplicateRegisteredDocumentInfo = (((that.potentialDuplicateRegisteredDocumentInfo!= null)&&(!that.potentialDuplicateRegisteredDocumentInfo.isEmpty()))?that.getPotentialDuplicateRegisteredDocumentInfo():null);
                if (!strategy.equals(LocatorUtils.property(thisLocator, "potentialDuplicateRegisteredDocumentInfo", lhsPotentialDuplicateRegisteredDocumentInfo), LocatorUtils.property(thatLocator, "potentialDuplicateRegisteredDocumentInfo", rhsPotentialDuplicateRegisteredDocumentInfo), lhsPotentialDuplicateRegisteredDocumentInfo, rhsPotentialDuplicateRegisteredDocumentInfo)) {
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
                List<FindPotentialRegisteredDuplicatesResponse.PotentialDuplicateRegisteredDocuments.PotentialDuplicateRegisteredDocumentInfo> thePotentialDuplicateRegisteredDocumentInfo;
                thePotentialDuplicateRegisteredDocumentInfo = (((this.potentialDuplicateRegisteredDocumentInfo!= null)&&(!this.potentialDuplicateRegisteredDocumentInfo.isEmpty()))?this.getPotentialDuplicateRegisteredDocumentInfo():null);
                strategy.appendField(locator, this, "potentialDuplicateRegisteredDocumentInfo", buffer, thePotentialDuplicateRegisteredDocumentInfo);
            }
            return buffer;
        }

        public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
            int currentHashCode = 1;
            {
                List<FindPotentialRegisteredDuplicatesResponse.PotentialDuplicateRegisteredDocuments.PotentialDuplicateRegisteredDocumentInfo> thePotentialDuplicateRegisteredDocumentInfo;
                thePotentialDuplicateRegisteredDocumentInfo = (((this.potentialDuplicateRegisteredDocumentInfo!= null)&&(!this.potentialDuplicateRegisteredDocumentInfo.isEmpty()))?this.getPotentialDuplicateRegisteredDocumentInfo():null);
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "potentialDuplicateRegisteredDocumentInfo", thePotentialDuplicateRegisteredDocumentInfo), currentHashCode, thePotentialDuplicateRegisteredDocumentInfo);
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
         *         &lt;element name="documentId" type="{http://ec.europa.eu/sg/hrs/types}ObjectId"/>
         *         &lt;element name="registrationDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
         *         &lt;element name="registrationNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="registrationAuthor">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="ecasId" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="fullName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                   &lt;element name="dg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                   &lt;element name="service" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                   &lt;element name="phone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                   &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="visible" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
         *         &lt;element name="score" type="{http://ec.europa.eu/sg/hrs/types}DecimalPercentage" minOccurs="0"/>
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
            "documentId",
            "registrationDate",
            "registrationNumber",
            "registrationAuthor",
            "visible",
            "score"
        })
        public static class PotentialDuplicateRegisteredDocumentInfo
            implements Equals, HashCode, ToString
        {

            @XmlElement(required = true)
            protected String documentId;
            @XmlElement(required = true)
            @XmlSchemaType(name = "date")
            protected XMLGregorianCalendar registrationDate;
            @XmlElement(required = true)
            protected String registrationNumber;
            @XmlElement(required = true)
            protected FindPotentialRegisteredDuplicatesResponse.PotentialDuplicateRegisteredDocuments.PotentialDuplicateRegisteredDocumentInfo.RegistrationAuthor registrationAuthor;
            protected boolean visible;
            protected BigDecimal score;

            /**
             * Gets the value of the documentId property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDocumentId() {
                return documentId;
            }

            /**
             * Sets the value of the documentId property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDocumentId(String value) {
                this.documentId = value;
            }

            /**
             * Gets the value of the registrationDate property.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getRegistrationDate() {
                return registrationDate;
            }

            /**
             * Sets the value of the registrationDate property.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setRegistrationDate(XMLGregorianCalendar value) {
                this.registrationDate = value;
            }

            /**
             * Gets the value of the registrationNumber property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRegistrationNumber() {
                return registrationNumber;
            }

            /**
             * Sets the value of the registrationNumber property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRegistrationNumber(String value) {
                this.registrationNumber = value;
            }

            /**
             * Gets the value of the registrationAuthor property.
             * 
             * @return
             *     possible object is
             *     {@link FindPotentialRegisteredDuplicatesResponse.PotentialDuplicateRegisteredDocuments.PotentialDuplicateRegisteredDocumentInfo.RegistrationAuthor }
             *     
             */
            public FindPotentialRegisteredDuplicatesResponse.PotentialDuplicateRegisteredDocuments.PotentialDuplicateRegisteredDocumentInfo.RegistrationAuthor getRegistrationAuthor() {
                return registrationAuthor;
            }

            /**
             * Sets the value of the registrationAuthor property.
             * 
             * @param value
             *     allowed object is
             *     {@link FindPotentialRegisteredDuplicatesResponse.PotentialDuplicateRegisteredDocuments.PotentialDuplicateRegisteredDocumentInfo.RegistrationAuthor }
             *     
             */
            public void setRegistrationAuthor(FindPotentialRegisteredDuplicatesResponse.PotentialDuplicateRegisteredDocuments.PotentialDuplicateRegisteredDocumentInfo.RegistrationAuthor value) {
                this.registrationAuthor = value;
            }

            /**
             * Gets the value of the visible property.
             * 
             */
            public boolean isVisible() {
                return visible;
            }

            /**
             * Sets the value of the visible property.
             * 
             */
            public void setVisible(boolean value) {
                this.visible = value;
            }

            /**
             * Gets the value of the score property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getScore() {
                return score;
            }

            /**
             * Sets the value of the score property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setScore(BigDecimal value) {
                this.score = value;
            }

            public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
                if (!(object instanceof FindPotentialRegisteredDuplicatesResponse.PotentialDuplicateRegisteredDocuments.PotentialDuplicateRegisteredDocumentInfo)) {
                    return false;
                }
                if (this == object) {
                    return true;
                }
                final FindPotentialRegisteredDuplicatesResponse.PotentialDuplicateRegisteredDocuments.PotentialDuplicateRegisteredDocumentInfo that = ((FindPotentialRegisteredDuplicatesResponse.PotentialDuplicateRegisteredDocuments.PotentialDuplicateRegisteredDocumentInfo) object);
                {
                    String lhsDocumentId;
                    lhsDocumentId = this.getDocumentId();
                    String rhsDocumentId;
                    rhsDocumentId = that.getDocumentId();
                    if (!strategy.equals(LocatorUtils.property(thisLocator, "documentId", lhsDocumentId), LocatorUtils.property(thatLocator, "documentId", rhsDocumentId), lhsDocumentId, rhsDocumentId)) {
                        return false;
                    }
                }
                {
                    XMLGregorianCalendar lhsRegistrationDate;
                    lhsRegistrationDate = this.getRegistrationDate();
                    XMLGregorianCalendar rhsRegistrationDate;
                    rhsRegistrationDate = that.getRegistrationDate();
                    if (!strategy.equals(LocatorUtils.property(thisLocator, "registrationDate", lhsRegistrationDate), LocatorUtils.property(thatLocator, "registrationDate", rhsRegistrationDate), lhsRegistrationDate, rhsRegistrationDate)) {
                        return false;
                    }
                }
                {
                    String lhsRegistrationNumber;
                    lhsRegistrationNumber = this.getRegistrationNumber();
                    String rhsRegistrationNumber;
                    rhsRegistrationNumber = that.getRegistrationNumber();
                    if (!strategy.equals(LocatorUtils.property(thisLocator, "registrationNumber", lhsRegistrationNumber), LocatorUtils.property(thatLocator, "registrationNumber", rhsRegistrationNumber), lhsRegistrationNumber, rhsRegistrationNumber)) {
                        return false;
                    }
                }
                {
                    FindPotentialRegisteredDuplicatesResponse.PotentialDuplicateRegisteredDocuments.PotentialDuplicateRegisteredDocumentInfo.RegistrationAuthor lhsRegistrationAuthor;
                    lhsRegistrationAuthor = this.getRegistrationAuthor();
                    FindPotentialRegisteredDuplicatesResponse.PotentialDuplicateRegisteredDocuments.PotentialDuplicateRegisteredDocumentInfo.RegistrationAuthor rhsRegistrationAuthor;
                    rhsRegistrationAuthor = that.getRegistrationAuthor();
                    if (!strategy.equals(LocatorUtils.property(thisLocator, "registrationAuthor", lhsRegistrationAuthor), LocatorUtils.property(thatLocator, "registrationAuthor", rhsRegistrationAuthor), lhsRegistrationAuthor, rhsRegistrationAuthor)) {
                        return false;
                    }
                }
                {
                    boolean lhsVisible;
                    lhsVisible = (true?this.isVisible():false);
                    boolean rhsVisible;
                    rhsVisible = (true?that.isVisible():false);
                    if (!strategy.equals(LocatorUtils.property(thisLocator, "visible", lhsVisible), LocatorUtils.property(thatLocator, "visible", rhsVisible), lhsVisible, rhsVisible)) {
                        return false;
                    }
                }
                {
                    BigDecimal lhsScore;
                    lhsScore = this.getScore();
                    BigDecimal rhsScore;
                    rhsScore = that.getScore();
                    if (!strategy.equals(LocatorUtils.property(thisLocator, "score", lhsScore), LocatorUtils.property(thatLocator, "score", rhsScore), lhsScore, rhsScore)) {
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
                    String theDocumentId;
                    theDocumentId = this.getDocumentId();
                    strategy.appendField(locator, this, "documentId", buffer, theDocumentId);
                }
                {
                    XMLGregorianCalendar theRegistrationDate;
                    theRegistrationDate = this.getRegistrationDate();
                    strategy.appendField(locator, this, "registrationDate", buffer, theRegistrationDate);
                }
                {
                    String theRegistrationNumber;
                    theRegistrationNumber = this.getRegistrationNumber();
                    strategy.appendField(locator, this, "registrationNumber", buffer, theRegistrationNumber);
                }
                {
                    FindPotentialRegisteredDuplicatesResponse.PotentialDuplicateRegisteredDocuments.PotentialDuplicateRegisteredDocumentInfo.RegistrationAuthor theRegistrationAuthor;
                    theRegistrationAuthor = this.getRegistrationAuthor();
                    strategy.appendField(locator, this, "registrationAuthor", buffer, theRegistrationAuthor);
                }
                {
                    boolean theVisible;
                    theVisible = (true?this.isVisible():false);
                    strategy.appendField(locator, this, "visible", buffer, theVisible);
                }
                {
                    BigDecimal theScore;
                    theScore = this.getScore();
                    strategy.appendField(locator, this, "score", buffer, theScore);
                }
                return buffer;
            }

            public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
                int currentHashCode = 1;
                {
                    String theDocumentId;
                    theDocumentId = this.getDocumentId();
                    currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "documentId", theDocumentId), currentHashCode, theDocumentId);
                }
                {
                    XMLGregorianCalendar theRegistrationDate;
                    theRegistrationDate = this.getRegistrationDate();
                    currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "registrationDate", theRegistrationDate), currentHashCode, theRegistrationDate);
                }
                {
                    String theRegistrationNumber;
                    theRegistrationNumber = this.getRegistrationNumber();
                    currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "registrationNumber", theRegistrationNumber), currentHashCode, theRegistrationNumber);
                }
                {
                    FindPotentialRegisteredDuplicatesResponse.PotentialDuplicateRegisteredDocuments.PotentialDuplicateRegisteredDocumentInfo.RegistrationAuthor theRegistrationAuthor;
                    theRegistrationAuthor = this.getRegistrationAuthor();
                    currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "registrationAuthor", theRegistrationAuthor), currentHashCode, theRegistrationAuthor);
                }
                {
                    boolean theVisible;
                    theVisible = (true?this.isVisible():false);
                    currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "visible", theVisible), currentHashCode, theVisible);
                }
                {
                    BigDecimal theScore;
                    theScore = this.getScore();
                    currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "score", theScore), currentHashCode, theScore);
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
             *         &lt;element name="ecasId" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="fullName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *         &lt;element name="dg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *         &lt;element name="service" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *         &lt;element name="phone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
                "ecasId",
                "fullName",
                "dg",
                "service",
                "phone",
                "email"
            })
            public static class RegistrationAuthor
                implements Equals, HashCode, ToString
            {

                @XmlElement(required = true)
                protected String ecasId;
                protected String fullName;
                protected String dg;
                protected String service;
                protected String phone;
                protected String email;

                /**
                 * Gets the value of the ecasId property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getEcasId() {
                    return ecasId;
                }

                /**
                 * Sets the value of the ecasId property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setEcasId(String value) {
                    this.ecasId = value;
                }

                /**
                 * Gets the value of the fullName property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getFullName() {
                    return fullName;
                }

                /**
                 * Sets the value of the fullName property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setFullName(String value) {
                    this.fullName = value;
                }

                /**
                 * Gets the value of the dg property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getDg() {
                    return dg;
                }

                /**
                 * Sets the value of the dg property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setDg(String value) {
                    this.dg = value;
                }

                /**
                 * Gets the value of the service property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getService() {
                    return service;
                }

                /**
                 * Sets the value of the service property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setService(String value) {
                    this.service = value;
                }

                /**
                 * Gets the value of the phone property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getPhone() {
                    return phone;
                }

                /**
                 * Sets the value of the phone property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setPhone(String value) {
                    this.phone = value;
                }

                /**
                 * Gets the value of the email property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getEmail() {
                    return email;
                }

                /**
                 * Sets the value of the email property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setEmail(String value) {
                    this.email = value;
                }

                public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
                    if (!(object instanceof FindPotentialRegisteredDuplicatesResponse.PotentialDuplicateRegisteredDocuments.PotentialDuplicateRegisteredDocumentInfo.RegistrationAuthor)) {
                        return false;
                    }
                    if (this == object) {
                        return true;
                    }
                    final FindPotentialRegisteredDuplicatesResponse.PotentialDuplicateRegisteredDocuments.PotentialDuplicateRegisteredDocumentInfo.RegistrationAuthor that = ((FindPotentialRegisteredDuplicatesResponse.PotentialDuplicateRegisteredDocuments.PotentialDuplicateRegisteredDocumentInfo.RegistrationAuthor) object);
                    {
                        String lhsEcasId;
                        lhsEcasId = this.getEcasId();
                        String rhsEcasId;
                        rhsEcasId = that.getEcasId();
                        if (!strategy.equals(LocatorUtils.property(thisLocator, "ecasId", lhsEcasId), LocatorUtils.property(thatLocator, "ecasId", rhsEcasId), lhsEcasId, rhsEcasId)) {
                            return false;
                        }
                    }
                    {
                        String lhsFullName;
                        lhsFullName = this.getFullName();
                        String rhsFullName;
                        rhsFullName = that.getFullName();
                        if (!strategy.equals(LocatorUtils.property(thisLocator, "fullName", lhsFullName), LocatorUtils.property(thatLocator, "fullName", rhsFullName), lhsFullName, rhsFullName)) {
                            return false;
                        }
                    }
                    {
                        String lhsDg;
                        lhsDg = this.getDg();
                        String rhsDg;
                        rhsDg = that.getDg();
                        if (!strategy.equals(LocatorUtils.property(thisLocator, "dg", lhsDg), LocatorUtils.property(thatLocator, "dg", rhsDg), lhsDg, rhsDg)) {
                            return false;
                        }
                    }
                    {
                        String lhsService;
                        lhsService = this.getService();
                        String rhsService;
                        rhsService = that.getService();
                        if (!strategy.equals(LocatorUtils.property(thisLocator, "service", lhsService), LocatorUtils.property(thatLocator, "service", rhsService), lhsService, rhsService)) {
                            return false;
                        }
                    }
                    {
                        String lhsPhone;
                        lhsPhone = this.getPhone();
                        String rhsPhone;
                        rhsPhone = that.getPhone();
                        if (!strategy.equals(LocatorUtils.property(thisLocator, "phone", lhsPhone), LocatorUtils.property(thatLocator, "phone", rhsPhone), lhsPhone, rhsPhone)) {
                            return false;
                        }
                    }
                    {
                        String lhsEmail;
                        lhsEmail = this.getEmail();
                        String rhsEmail;
                        rhsEmail = that.getEmail();
                        if (!strategy.equals(LocatorUtils.property(thisLocator, "email", lhsEmail), LocatorUtils.property(thatLocator, "email", rhsEmail), lhsEmail, rhsEmail)) {
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
                        String theEcasId;
                        theEcasId = this.getEcasId();
                        strategy.appendField(locator, this, "ecasId", buffer, theEcasId);
                    }
                    {
                        String theFullName;
                        theFullName = this.getFullName();
                        strategy.appendField(locator, this, "fullName", buffer, theFullName);
                    }
                    {
                        String theDg;
                        theDg = this.getDg();
                        strategy.appendField(locator, this, "dg", buffer, theDg);
                    }
                    {
                        String theService;
                        theService = this.getService();
                        strategy.appendField(locator, this, "service", buffer, theService);
                    }
                    {
                        String thePhone;
                        thePhone = this.getPhone();
                        strategy.appendField(locator, this, "phone", buffer, thePhone);
                    }
                    {
                        String theEmail;
                        theEmail = this.getEmail();
                        strategy.appendField(locator, this, "email", buffer, theEmail);
                    }
                    return buffer;
                }

                public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
                    int currentHashCode = 1;
                    {
                        String theEcasId;
                        theEcasId = this.getEcasId();
                        currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "ecasId", theEcasId), currentHashCode, theEcasId);
                    }
                    {
                        String theFullName;
                        theFullName = this.getFullName();
                        currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fullName", theFullName), currentHashCode, theFullName);
                    }
                    {
                        String theDg;
                        theDg = this.getDg();
                        currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "dg", theDg), currentHashCode, theDg);
                    }
                    {
                        String theService;
                        theService = this.getService();
                        currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "service", theService), currentHashCode, theService);
                    }
                    {
                        String thePhone;
                        thePhone = this.getPhone();
                        currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "phone", thePhone), currentHashCode, thePhone);
                    }
                    {
                        String theEmail;
                        theEmail = this.getEmail();
                        currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "email", theEmail), currentHashCode, theEmail);
                    }
                    return currentHashCode;
                }

                public int hashCode() {
                    final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
                    return this.hashCode(null, strategy);
                }

            }

        }

    }

}
