
package eu.europa.ec.research.fp.model.legalentity.v11;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import generated.jagate.model.coderef.V3.CodeRefType;
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
 * <p>Java class for CivilSocietyFactType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CivilSocietyFactType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CivilSocietyOrganisation" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="CivilSocietyType" type="{http://ec.europa.eu/research/fp/model/code-ref/V3}CodeRefType" minOccurs="0"/>
 *         &lt;element name="Comment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CivilSocietyFactType", propOrder = {
    "civilSocietyOrganisation",
    "civilSocietyType",
    "comment"
})
public class CivilSocietyFactType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "CivilSocietyOrganisation")
    protected boolean civilSocietyOrganisation;
    @XmlElement(name = "CivilSocietyType")
    protected CodeRefType civilSocietyType;
    @XmlElement(name = "Comment")
    protected String comment;

    /**
     * Gets the value of the civilSocietyOrganisation property.
     * 
     */
    public boolean isCivilSocietyOrganisation() {
        return civilSocietyOrganisation;
    }

    /**
     * Sets the value of the civilSocietyOrganisation property.
     * 
     */
    public void setCivilSocietyOrganisation(boolean value) {
        this.civilSocietyOrganisation = value;
    }

    /**
     * Gets the value of the civilSocietyType property.
     * 
     * @return
     *     possible object is
     *     {@link CodeRefType }
     *     
     */
    public CodeRefType getCivilSocietyType() {
        return civilSocietyType;
    }

    /**
     * Sets the value of the civilSocietyType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeRefType }
     *     
     */
    public void setCivilSocietyType(CodeRefType value) {
        this.civilSocietyType = value;
    }

    /**
     * Gets the value of the comment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets the value of the comment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComment(String value) {
        this.comment = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof CivilSocietyFactType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final CivilSocietyFactType that = ((CivilSocietyFactType) object);
        {
            boolean lhsCivilSocietyOrganisation;
            lhsCivilSocietyOrganisation = (true?this.isCivilSocietyOrganisation():false);
            boolean rhsCivilSocietyOrganisation;
            rhsCivilSocietyOrganisation = (true?that.isCivilSocietyOrganisation():false);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "civilSocietyOrganisation", lhsCivilSocietyOrganisation), LocatorUtils.property(thatLocator, "civilSocietyOrganisation", rhsCivilSocietyOrganisation), lhsCivilSocietyOrganisation, rhsCivilSocietyOrganisation)) {
                return false;
            }
        }
        {
            CodeRefType lhsCivilSocietyType;
            lhsCivilSocietyType = this.getCivilSocietyType();
            CodeRefType rhsCivilSocietyType;
            rhsCivilSocietyType = that.getCivilSocietyType();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "civilSocietyType", lhsCivilSocietyType), LocatorUtils.property(thatLocator, "civilSocietyType", rhsCivilSocietyType), lhsCivilSocietyType, rhsCivilSocietyType)) {
                return false;
            }
        }
        {
            String lhsComment;
            lhsComment = this.getComment();
            String rhsComment;
            rhsComment = that.getComment();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "comment", lhsComment), LocatorUtils.property(thatLocator, "comment", rhsComment), lhsComment, rhsComment)) {
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
            boolean theCivilSocietyOrganisation;
            theCivilSocietyOrganisation = (true?this.isCivilSocietyOrganisation():false);
            strategy.appendField(locator, this, "civilSocietyOrganisation", buffer, theCivilSocietyOrganisation);
        }
        {
            CodeRefType theCivilSocietyType;
            theCivilSocietyType = this.getCivilSocietyType();
            strategy.appendField(locator, this, "civilSocietyType", buffer, theCivilSocietyType);
        }
        {
            String theComment;
            theComment = this.getComment();
            strategy.appendField(locator, this, "comment", buffer, theComment);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            boolean theCivilSocietyOrganisation;
            theCivilSocietyOrganisation = (true?this.isCivilSocietyOrganisation():false);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "civilSocietyOrganisation", theCivilSocietyOrganisation), currentHashCode, theCivilSocietyOrganisation);
        }
        {
            CodeRefType theCivilSocietyType;
            theCivilSocietyType = this.getCivilSocietyType();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "civilSocietyType", theCivilSocietyType), currentHashCode, theCivilSocietyType);
        }
        {
            String theComment;
            theComment = this.getComment();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "comment", theComment), currentHashCode, theComment);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
