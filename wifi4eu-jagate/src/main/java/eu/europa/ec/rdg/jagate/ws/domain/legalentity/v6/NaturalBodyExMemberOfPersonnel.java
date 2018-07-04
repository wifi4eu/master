
package eu.europa.ec.rdg.jagate.ws.domain.legalentity.v6;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
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
 * <p>Java class for NaturalBodyExMemberOfPersonnel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NaturalBodyExMemberOfPersonnel">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ec.europa.eu/rdg/jagate/ws/domain/legalentity/v6}AbstractNaturalBody">
 *       &lt;sequence>
 *         &lt;element name="NupNumber" type="{http://ec.europa.eu/rdg/jagate/ws/domain/base/v2}NonEmptyString"/>
 *         &lt;element name="CountryIdentificationNumber" type="{http://ec.europa.eu/rdg/jagate/ws/domain/legalentity/v6}CountryIdentificationNumberType" maxOccurs="4"/>
 *         &lt;element name="VAT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BirthData" type="{http://ec.europa.eu/rdg/jagate/ws/domain/legalentity/v6}NaturalPersonBirthDataType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NaturalBodyExMemberOfPersonnel", propOrder = {
    "nupNumber",
    "countryIdentificationNumber",
    "vat",
    "birthData"
})
public class NaturalBodyExMemberOfPersonnel
    extends AbstractNaturalBody
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "NupNumber", required = true)
    protected String nupNumber;
    @XmlElement(name = "CountryIdentificationNumber", required = true)
    protected List<CountryIdentificationNumberType> countryIdentificationNumber;
    @XmlElement(name = "VAT")
    protected String vat;
    @XmlElement(name = "BirthData", required = true)
    protected NaturalPersonBirthDataType birthData;

    /**
     * Gets the value of the nupNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNupNumber() {
        return nupNumber;
    }

    /**
     * Sets the value of the nupNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNupNumber(String value) {
        this.nupNumber = value;
    }

    /**
     * Gets the value of the countryIdentificationNumber property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the countryIdentificationNumber property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCountryIdentificationNumber().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CountryIdentificationNumberType }
     * 
     * 
     */
    public List<CountryIdentificationNumberType> getCountryIdentificationNumber() {
        if (countryIdentificationNumber == null) {
            countryIdentificationNumber = new ArrayList<CountryIdentificationNumberType>();
        }
        return this.countryIdentificationNumber;
    }

    /**
     * Gets the value of the vat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVAT() {
        return vat;
    }

    /**
     * Sets the value of the vat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVAT(String value) {
        this.vat = value;
    }

    /**
     * Gets the value of the birthData property.
     * 
     * @return
     *     possible object is
     *     {@link NaturalPersonBirthDataType }
     *     
     */
    public NaturalPersonBirthDataType getBirthData() {
        return birthData;
    }

    /**
     * Sets the value of the birthData property.
     * 
     * @param value
     *     allowed object is
     *     {@link NaturalPersonBirthDataType }
     *     
     */
    public void setBirthData(NaturalPersonBirthDataType value) {
        this.birthData = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof NaturalBodyExMemberOfPersonnel)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final NaturalBodyExMemberOfPersonnel that = ((NaturalBodyExMemberOfPersonnel) object);
        {
            String lhsNupNumber;
            lhsNupNumber = this.getNupNumber();
            String rhsNupNumber;
            rhsNupNumber = that.getNupNumber();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "nupNumber", lhsNupNumber), LocatorUtils.property(thatLocator, "nupNumber", rhsNupNumber), lhsNupNumber, rhsNupNumber)) {
                return false;
            }
        }
        {
            List<CountryIdentificationNumberType> lhsCountryIdentificationNumber;
            lhsCountryIdentificationNumber = (((this.countryIdentificationNumber!= null)&&(!this.countryIdentificationNumber.isEmpty()))?this.getCountryIdentificationNumber():null);
            List<CountryIdentificationNumberType> rhsCountryIdentificationNumber;
            rhsCountryIdentificationNumber = (((that.countryIdentificationNumber!= null)&&(!that.countryIdentificationNumber.isEmpty()))?that.getCountryIdentificationNumber():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "countryIdentificationNumber", lhsCountryIdentificationNumber), LocatorUtils.property(thatLocator, "countryIdentificationNumber", rhsCountryIdentificationNumber), lhsCountryIdentificationNumber, rhsCountryIdentificationNumber)) {
                return false;
            }
        }
        {
            String lhsVAT;
            lhsVAT = this.getVAT();
            String rhsVAT;
            rhsVAT = that.getVAT();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "vat", lhsVAT), LocatorUtils.property(thatLocator, "vat", rhsVAT), lhsVAT, rhsVAT)) {
                return false;
            }
        }
        {
            NaturalPersonBirthDataType lhsBirthData;
            lhsBirthData = this.getBirthData();
            NaturalPersonBirthDataType rhsBirthData;
            rhsBirthData = that.getBirthData();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "birthData", lhsBirthData), LocatorUtils.property(thatLocator, "birthData", rhsBirthData), lhsBirthData, rhsBirthData)) {
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
            String theNupNumber;
            theNupNumber = this.getNupNumber();
            strategy.appendField(locator, this, "nupNumber", buffer, theNupNumber);
        }
        {
            List<CountryIdentificationNumberType> theCountryIdentificationNumber;
            theCountryIdentificationNumber = (((this.countryIdentificationNumber!= null)&&(!this.countryIdentificationNumber.isEmpty()))?this.getCountryIdentificationNumber():null);
            strategy.appendField(locator, this, "countryIdentificationNumber", buffer, theCountryIdentificationNumber);
        }
        {
            String theVAT;
            theVAT = this.getVAT();
            strategy.appendField(locator, this, "vat", buffer, theVAT);
        }
        {
            NaturalPersonBirthDataType theBirthData;
            theBirthData = this.getBirthData();
            strategy.appendField(locator, this, "birthData", buffer, theBirthData);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = super.hashCode(locator, strategy);
        {
            String theNupNumber;
            theNupNumber = this.getNupNumber();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "nupNumber", theNupNumber), currentHashCode, theNupNumber);
        }
        {
            List<CountryIdentificationNumberType> theCountryIdentificationNumber;
            theCountryIdentificationNumber = (((this.countryIdentificationNumber!= null)&&(!this.countryIdentificationNumber.isEmpty()))?this.getCountryIdentificationNumber():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "countryIdentificationNumber", theCountryIdentificationNumber), currentHashCode, theCountryIdentificationNumber);
        }
        {
            String theVAT;
            theVAT = this.getVAT();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "vat", theVAT), currentHashCode, theVAT);
        }
        {
            NaturalPersonBirthDataType theBirthData;
            theBirthData = this.getBirthData();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "birthData", theBirthData), currentHashCode, theBirthData);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
