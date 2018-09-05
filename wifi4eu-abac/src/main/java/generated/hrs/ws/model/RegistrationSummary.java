
package generated.hrs.ws.model;

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
 * <p>Java class for RegistrationSummary complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RegistrationSummary">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="documentId" type="{http://ec.europa.eu/sg/hrs/types}ObjectId"/>
 *         &lt;element name="encodingDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="registrationDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="registrationNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="saveNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="filingResult" type="{http://ec.europa.eu/sg/hrs/types}OperationResponse" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RegistrationSummary", propOrder = {
    "documentId",
    "encodingDate",
    "registrationDate",
    "registrationNumber",
    "saveNumber",
    "filingResult"
})
public class RegistrationSummary
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected String documentId;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar encodingDate;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar registrationDate;
    @XmlElement(required = true)
    protected String registrationNumber;
    @XmlElement(required = true)
    protected String saveNumber;
    protected OperationResponse filingResult;

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
     * Gets the value of the encodingDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEncodingDate() {
        return encodingDate;
    }

    /**
     * Sets the value of the encodingDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEncodingDate(XMLGregorianCalendar value) {
        this.encodingDate = value;
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
     * Gets the value of the saveNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSaveNumber() {
        return saveNumber;
    }

    /**
     * Sets the value of the saveNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSaveNumber(String value) {
        this.saveNumber = value;
    }

    /**
     * Gets the value of the filingResult property.
     * 
     * @return
     *     possible object is
     *     {@link OperationResponse }
     *     
     */
    public OperationResponse getFilingResult() {
        return filingResult;
    }

    /**
     * Sets the value of the filingResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link OperationResponse }
     *     
     */
    public void setFilingResult(OperationResponse value) {
        this.filingResult = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof RegistrationSummary)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final RegistrationSummary that = ((RegistrationSummary) object);
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
            XMLGregorianCalendar lhsEncodingDate;
            lhsEncodingDate = this.getEncodingDate();
            XMLGregorianCalendar rhsEncodingDate;
            rhsEncodingDate = that.getEncodingDate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "encodingDate", lhsEncodingDate), LocatorUtils.property(thatLocator, "encodingDate", rhsEncodingDate), lhsEncodingDate, rhsEncodingDate)) {
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
            String lhsSaveNumber;
            lhsSaveNumber = this.getSaveNumber();
            String rhsSaveNumber;
            rhsSaveNumber = that.getSaveNumber();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "saveNumber", lhsSaveNumber), LocatorUtils.property(thatLocator, "saveNumber", rhsSaveNumber), lhsSaveNumber, rhsSaveNumber)) {
                return false;
            }
        }
        {
            OperationResponse lhsFilingResult;
            lhsFilingResult = this.getFilingResult();
            OperationResponse rhsFilingResult;
            rhsFilingResult = that.getFilingResult();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "filingResult", lhsFilingResult), LocatorUtils.property(thatLocator, "filingResult", rhsFilingResult), lhsFilingResult, rhsFilingResult)) {
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
            XMLGregorianCalendar theEncodingDate;
            theEncodingDate = this.getEncodingDate();
            strategy.appendField(locator, this, "encodingDate", buffer, theEncodingDate);
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
            String theSaveNumber;
            theSaveNumber = this.getSaveNumber();
            strategy.appendField(locator, this, "saveNumber", buffer, theSaveNumber);
        }
        {
            OperationResponse theFilingResult;
            theFilingResult = this.getFilingResult();
            strategy.appendField(locator, this, "filingResult", buffer, theFilingResult);
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
            XMLGregorianCalendar theEncodingDate;
            theEncodingDate = this.getEncodingDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "encodingDate", theEncodingDate), currentHashCode, theEncodingDate);
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
            String theSaveNumber;
            theSaveNumber = this.getSaveNumber();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "saveNumber", theSaveNumber), currentHashCode, theSaveNumber);
        }
        {
            OperationResponse theFilingResult;
            theFilingResult = this.getFilingResult();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "filingResult", theFilingResult), currentHashCode, theFilingResult);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
