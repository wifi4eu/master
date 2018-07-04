
package generated.jagate.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import eu.europa.ec.rdg.jagate.ws.domain.legalentity.v6.LegalEntityEwsType;
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
 * <p>Java class for GetEwsByFelIdResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetEwsByFelIdResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="legalEntity" type="{http://ec.europa.eu/rdg/jagate/ws/domain/legalentity/v6}LegalEntityEwsType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetEwsByFelIdResponseType", propOrder = {
    "legalEntity"
})
public class GetEwsByFelIdResponseType
    implements Equals, HashCode, ToString
{

    protected List<LegalEntityEwsType> legalEntity;

    /**
     * Gets the value of the legalEntity property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the legalEntity property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLegalEntity().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LegalEntityEwsType }
     * 
     * 
     */
    public List<LegalEntityEwsType> getLegalEntity() {
        if (legalEntity == null) {
            legalEntity = new ArrayList<LegalEntityEwsType>();
        }
        return this.legalEntity;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof GetEwsByFelIdResponseType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final GetEwsByFelIdResponseType that = ((GetEwsByFelIdResponseType) object);
        {
            List<LegalEntityEwsType> lhsLegalEntity;
            lhsLegalEntity = (((this.legalEntity!= null)&&(!this.legalEntity.isEmpty()))?this.getLegalEntity():null);
            List<LegalEntityEwsType> rhsLegalEntity;
            rhsLegalEntity = (((that.legalEntity!= null)&&(!that.legalEntity.isEmpty()))?that.getLegalEntity():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "legalEntity", lhsLegalEntity), LocatorUtils.property(thatLocator, "legalEntity", rhsLegalEntity), lhsLegalEntity, rhsLegalEntity)) {
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
            List<LegalEntityEwsType> theLegalEntity;
            theLegalEntity = (((this.legalEntity!= null)&&(!this.legalEntity.isEmpty()))?this.getLegalEntity():null);
            strategy.appendField(locator, this, "legalEntity", buffer, theLegalEntity);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            List<LegalEntityEwsType> theLegalEntity;
            theLegalEntity = (((this.legalEntity!= null)&&(!this.legalEntity.isEmpty()))?this.getLegalEntity():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "legalEntity", theLegalEntity), currentHashCode, theLegalEntity);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
