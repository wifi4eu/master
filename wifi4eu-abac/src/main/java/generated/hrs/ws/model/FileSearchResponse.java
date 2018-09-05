
package generated.hrs.ws.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 * Structure representing the response for the operation searchFilesByExpression
 * 
 * <p>Java class for FileSearchResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FileSearchResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="totalRetrievable" type="{http://ec.europa.eu/sg/hrs/types}int0To300"/>
 *         &lt;element name="file" type="{http://ec.europa.eu/sg/hrs/types}File" maxOccurs="300" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FileSearchResponse", propOrder = {
    "totalRetrievable",
    "file"
})
public class FileSearchResponse
    implements Equals, HashCode, ToString
{

    protected int totalRetrievable;
    protected List<File> file;

    /**
     * Gets the value of the totalRetrievable property.
     * 
     */
    public int getTotalRetrievable() {
        return totalRetrievable;
    }

    /**
     * Sets the value of the totalRetrievable property.
     * 
     */
    public void setTotalRetrievable(int value) {
        this.totalRetrievable = value;
    }

    /**
     * Gets the value of the file property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the file property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFile().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link File }
     * 
     * 
     */
    public List<File> getFile() {
        if (file == null) {
            file = new ArrayList<File>();
        }
        return this.file;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof FileSearchResponse)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final FileSearchResponse that = ((FileSearchResponse) object);
        {
            int lhsTotalRetrievable;
            lhsTotalRetrievable = (true?this.getTotalRetrievable(): 0);
            int rhsTotalRetrievable;
            rhsTotalRetrievable = (true?that.getTotalRetrievable(): 0);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "totalRetrievable", lhsTotalRetrievable), LocatorUtils.property(thatLocator, "totalRetrievable", rhsTotalRetrievable), lhsTotalRetrievable, rhsTotalRetrievable)) {
                return false;
            }
        }
        {
            List<File> lhsFile;
            lhsFile = (((this.file!= null)&&(!this.file.isEmpty()))?this.getFile():null);
            List<File> rhsFile;
            rhsFile = (((that.file!= null)&&(!that.file.isEmpty()))?that.getFile():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "file", lhsFile), LocatorUtils.property(thatLocator, "file", rhsFile), lhsFile, rhsFile)) {
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
            int theTotalRetrievable;
            theTotalRetrievable = (true?this.getTotalRetrievable(): 0);
            strategy.appendField(locator, this, "totalRetrievable", buffer, theTotalRetrievable);
        }
        {
            List<File> theFile;
            theFile = (((this.file!= null)&&(!this.file.isEmpty()))?this.getFile():null);
            strategy.appendField(locator, this, "file", buffer, theFile);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            int theTotalRetrievable;
            theTotalRetrievable = (true?this.getTotalRetrievable(): 0);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "totalRetrievable", theTotalRetrievable), currentHashCode, theTotalRetrievable);
        }
        {
            List<File> theFile;
            theFile = (((this.file!= null)&&(!this.file.isEmpty()))?this.getFile():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "file", theFile), currentHashCode, theFile);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
