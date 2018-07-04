
package eu.europa.ec.research.fp.model.legalentity.v11;

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
 * <p>Java class for NonBankruptcyDeclarationFactType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NonBankruptcyDeclarationFactType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Year" type="{http://ec.europa.eu/research/fp/model/base/V1}YearType"/>
 *         &lt;element name="Declared" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NonBankruptcyDeclarationFactType", propOrder = {
    "year",
    "declared"
})
public class NonBankruptcyDeclarationFactType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "Year")
    protected int year;
    @XmlElement(name = "Declared")
    protected boolean declared;

    /**
     * Gets the value of the year property.
     * 
     */
    public int getYear() {
        return year;
    }

    /**
     * Sets the value of the year property.
     * 
     */
    public void setYear(int value) {
        this.year = value;
    }

    /**
     * Gets the value of the declared property.
     * 
     */
    public boolean isDeclared() {
        return declared;
    }

    /**
     * Sets the value of the declared property.
     * 
     */
    public void setDeclared(boolean value) {
        this.declared = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof NonBankruptcyDeclarationFactType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final NonBankruptcyDeclarationFactType that = ((NonBankruptcyDeclarationFactType) object);
        {
            int lhsYear;
            lhsYear = (true?this.getYear(): 0);
            int rhsYear;
            rhsYear = (true?that.getYear(): 0);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "year", lhsYear), LocatorUtils.property(thatLocator, "year", rhsYear), lhsYear, rhsYear)) {
                return false;
            }
        }
        {
            boolean lhsDeclared;
            lhsDeclared = (true?this.isDeclared():false);
            boolean rhsDeclared;
            rhsDeclared = (true?that.isDeclared():false);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "declared", lhsDeclared), LocatorUtils.property(thatLocator, "declared", rhsDeclared), lhsDeclared, rhsDeclared)) {
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
            int theYear;
            theYear = (true?this.getYear(): 0);
            strategy.appendField(locator, this, "year", buffer, theYear);
        }
        {
            boolean theDeclared;
            theDeclared = (true?this.isDeclared():false);
            strategy.appendField(locator, this, "declared", buffer, theDeclared);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            int theYear;
            theYear = (true?this.getYear(): 0);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "year", theYear), currentHashCode, theYear);
        }
        {
            boolean theDeclared;
            theDeclared = (true?this.isDeclared():false);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "declared", theDeclared), currentHashCode, theDeclared);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
