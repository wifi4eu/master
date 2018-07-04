
package eu.europa.ec.research.fp.model.legalentity.v11;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import generated.jagate.model.base.V1.LocalRefType;
import generated.jagate.model.coderef.V3.CodeRefType;
import generated.jagate.model.legalentityref.v3.HierarchyDataType;
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
 * <p>Java class for LegalEntityType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LegalEntityType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ec.europa.eu/research/fp/model/legalentity/V11}ExtendedFactListType">
 *       &lt;sequence>
 *         &lt;element name="PIC" type="{http://ec.europa.eu/research/fp/model/legalentity-ref/V3}LegalEntityIdType"/>
 *         &lt;element name="ValidityType" type="{http://ec.europa.eu/research/fp/model/code-ref/V3}CodeRefType"/>
 *         &lt;element name="ValidityDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="HierarchyData" type="{http://ec.europa.eu/research/fp/model/legalentity-ref/V3}HierarchyDataType" minOccurs="0"/>
 *         &lt;element name="ExternalReferenceList" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ExternalReference" type="{http://ec.europa.eu/research/fp/model/base/V1}LocalRefType" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ParticipationList" type="{http://ec.europa.eu/research/fp/model/legalentity/V11}ParticipationListType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LegalEntityType", propOrder = {
    "pic",
    "validityType",
    "validityDate",
    "hierarchyData",
    "externalReferenceList",
    "participationList"
})
public class LegalEntityType
    extends ExtendedFactListType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "PIC", required = true)
    protected String pic;
    @XmlElement(name = "ValidityType", required = true)
    protected CodeRefType validityType;
    @XmlElement(name = "ValidityDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar validityDate;
    @XmlElement(name = "HierarchyData")
    protected HierarchyDataType hierarchyData;
    @XmlElement(name = "ExternalReferenceList")
    protected LegalEntityType.ExternalReferenceList externalReferenceList;
    @XmlElement(name = "ParticipationList")
    protected ParticipationListType participationList;

    /**
     * Gets the value of the pic property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPIC() {
        return pic;
    }

    /**
     * Sets the value of the pic property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPIC(String value) {
        this.pic = value;
    }

    /**
     * Gets the value of the validityType property.
     * 
     * @return
     *     possible object is
     *     {@link CodeRefType }
     *     
     */
    public CodeRefType getValidityType() {
        return validityType;
    }

    /**
     * Sets the value of the validityType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeRefType }
     *     
     */
    public void setValidityType(CodeRefType value) {
        this.validityType = value;
    }

    /**
     * Gets the value of the validityDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getValidityDate() {
        return validityDate;
    }

    /**
     * Sets the value of the validityDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setValidityDate(XMLGregorianCalendar value) {
        this.validityDate = value;
    }

    /**
     * Gets the value of the hierarchyData property.
     * 
     * @return
     *     possible object is
     *     {@link HierarchyDataType }
     *     
     */
    public HierarchyDataType getHierarchyData() {
        return hierarchyData;
    }

    /**
     * Sets the value of the hierarchyData property.
     * 
     * @param value
     *     allowed object is
     *     {@link HierarchyDataType }
     *     
     */
    public void setHierarchyData(HierarchyDataType value) {
        this.hierarchyData = value;
    }

    /**
     * Gets the value of the externalReferenceList property.
     * 
     * @return
     *     possible object is
     *     {@link LegalEntityType.ExternalReferenceList }
     *     
     */
    public LegalEntityType.ExternalReferenceList getExternalReferenceList() {
        return externalReferenceList;
    }

    /**
     * Sets the value of the externalReferenceList property.
     * 
     * @param value
     *     allowed object is
     *     {@link LegalEntityType.ExternalReferenceList }
     *     
     */
    public void setExternalReferenceList(LegalEntityType.ExternalReferenceList value) {
        this.externalReferenceList = value;
    }

    /**
     * Gets the value of the participationList property.
     * 
     * @return
     *     possible object is
     *     {@link ParticipationListType }
     *     
     */
    public ParticipationListType getParticipationList() {
        return participationList;
    }

    /**
     * Sets the value of the participationList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParticipationListType }
     *     
     */
    public void setParticipationList(ParticipationListType value) {
        this.participationList = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof LegalEntityType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final LegalEntityType that = ((LegalEntityType) object);
        {
            String lhsPIC;
            lhsPIC = this.getPIC();
            String rhsPIC;
            rhsPIC = that.getPIC();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "pic", lhsPIC), LocatorUtils.property(thatLocator, "pic", rhsPIC), lhsPIC, rhsPIC)) {
                return false;
            }
        }
        {
            CodeRefType lhsValidityType;
            lhsValidityType = this.getValidityType();
            CodeRefType rhsValidityType;
            rhsValidityType = that.getValidityType();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "validityType", lhsValidityType), LocatorUtils.property(thatLocator, "validityType", rhsValidityType), lhsValidityType, rhsValidityType)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsValidityDate;
            lhsValidityDate = this.getValidityDate();
            XMLGregorianCalendar rhsValidityDate;
            rhsValidityDate = that.getValidityDate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "validityDate", lhsValidityDate), LocatorUtils.property(thatLocator, "validityDate", rhsValidityDate), lhsValidityDate, rhsValidityDate)) {
                return false;
            }
        }
        {
            HierarchyDataType lhsHierarchyData;
            lhsHierarchyData = this.getHierarchyData();
            HierarchyDataType rhsHierarchyData;
            rhsHierarchyData = that.getHierarchyData();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "hierarchyData", lhsHierarchyData), LocatorUtils.property(thatLocator, "hierarchyData", rhsHierarchyData), lhsHierarchyData, rhsHierarchyData)) {
                return false;
            }
        }
        {
            LegalEntityType.ExternalReferenceList lhsExternalReferenceList;
            lhsExternalReferenceList = this.getExternalReferenceList();
            LegalEntityType.ExternalReferenceList rhsExternalReferenceList;
            rhsExternalReferenceList = that.getExternalReferenceList();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "externalReferenceList", lhsExternalReferenceList), LocatorUtils.property(thatLocator, "externalReferenceList", rhsExternalReferenceList), lhsExternalReferenceList, rhsExternalReferenceList)) {
                return false;
            }
        }
        {
            ParticipationListType lhsParticipationList;
            lhsParticipationList = this.getParticipationList();
            ParticipationListType rhsParticipationList;
            rhsParticipationList = that.getParticipationList();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "participationList", lhsParticipationList), LocatorUtils.property(thatLocator, "participationList", rhsParticipationList), lhsParticipationList, rhsParticipationList)) {
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
        super.appendFields(locator, buffer, strategy);
        {
            String thePIC;
            thePIC = this.getPIC();
            strategy.appendField(locator, this, "pic", buffer, thePIC);
        }
        {
            CodeRefType theValidityType;
            theValidityType = this.getValidityType();
            strategy.appendField(locator, this, "validityType", buffer, theValidityType);
        }
        {
            XMLGregorianCalendar theValidityDate;
            theValidityDate = this.getValidityDate();
            strategy.appendField(locator, this, "validityDate", buffer, theValidityDate);
        }
        {
            HierarchyDataType theHierarchyData;
            theHierarchyData = this.getHierarchyData();
            strategy.appendField(locator, this, "hierarchyData", buffer, theHierarchyData);
        }
        {
            LegalEntityType.ExternalReferenceList theExternalReferenceList;
            theExternalReferenceList = this.getExternalReferenceList();
            strategy.appendField(locator, this, "externalReferenceList", buffer, theExternalReferenceList);
        }
        {
            ParticipationListType theParticipationList;
            theParticipationList = this.getParticipationList();
            strategy.appendField(locator, this, "participationList", buffer, theParticipationList);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = super.hashCode(locator, strategy);
        {
            String thePIC;
            thePIC = this.getPIC();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "pic", thePIC), currentHashCode, thePIC);
        }
        {
            CodeRefType theValidityType;
            theValidityType = this.getValidityType();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "validityType", theValidityType), currentHashCode, theValidityType);
        }
        {
            XMLGregorianCalendar theValidityDate;
            theValidityDate = this.getValidityDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "validityDate", theValidityDate), currentHashCode, theValidityDate);
        }
        {
            HierarchyDataType theHierarchyData;
            theHierarchyData = this.getHierarchyData();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "hierarchyData", theHierarchyData), currentHashCode, theHierarchyData);
        }
        {
            LegalEntityType.ExternalReferenceList theExternalReferenceList;
            theExternalReferenceList = this.getExternalReferenceList();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "externalReferenceList", theExternalReferenceList), currentHashCode, theExternalReferenceList);
        }
        {
            ParticipationListType theParticipationList;
            theParticipationList = this.getParticipationList();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "participationList", theParticipationList), currentHashCode, theParticipationList);
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
     *         &lt;element name="ExternalReference" type="{http://ec.europa.eu/research/fp/model/base/V1}LocalRefType" maxOccurs="unbounded" minOccurs="0"/>
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
        "externalReference"
    })
    public static class ExternalReferenceList
        implements Equals, HashCode, ToString
    {

        @XmlElement(name = "ExternalReference")
        protected List<LocalRefType> externalReference;

        /**
         * Gets the value of the externalReference property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the externalReference property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getExternalReference().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link LocalRefType }
         * 
         * 
         */
        public List<LocalRefType> getExternalReference() {
            if (externalReference == null) {
                externalReference = new ArrayList<LocalRefType>();
            }
            return this.externalReference;
        }

        public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
            if (!(object instanceof LegalEntityType.ExternalReferenceList)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final LegalEntityType.ExternalReferenceList that = ((LegalEntityType.ExternalReferenceList) object);
            {
                List<LocalRefType> lhsExternalReference;
                lhsExternalReference = (((this.externalReference!= null)&&(!this.externalReference.isEmpty()))?this.getExternalReference():null);
                List<LocalRefType> rhsExternalReference;
                rhsExternalReference = (((that.externalReference!= null)&&(!that.externalReference.isEmpty()))?that.getExternalReference():null);
                if (!strategy.equals(LocatorUtils.property(thisLocator, "externalReference", lhsExternalReference), LocatorUtils.property(thatLocator, "externalReference", rhsExternalReference), lhsExternalReference, rhsExternalReference)) {
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
                List<LocalRefType> theExternalReference;
                theExternalReference = (((this.externalReference!= null)&&(!this.externalReference.isEmpty()))?this.getExternalReference():null);
                strategy.appendField(locator, this, "externalReference", buffer, theExternalReference);
            }
            return buffer;
        }

        public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
            int currentHashCode = 1;
            {
                List<LocalRefType> theExternalReference;
                theExternalReference = (((this.externalReference!= null)&&(!this.externalReference.isEmpty()))?this.getExternalReference():null);
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "externalReference", theExternalReference), currentHashCode, theExternalReference);
            }
            return currentHashCode;
        }

        public int hashCode() {
            final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
            return this.hashCode(null, strategy);
        }

    }

}
