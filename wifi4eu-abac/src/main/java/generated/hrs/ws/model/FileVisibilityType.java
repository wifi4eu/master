
package generated.hrs.ws.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FileVisibilityType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="FileVisibilityType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ALL"/>
 *     &lt;enumeration value="INSTITUTION"/>
 *     &lt;enumeration value="DG"/>
 *     &lt;enumeration value="LIMITED"/>
 *     &lt;enumeration value="SPECIFIC"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "FileVisibilityType")
@XmlEnum
public enum FileVisibilityType {


    /**
     * Visible to all users
     * 
     */
    ALL,

    /**
     * Visible to the institution (e.g. Commission, EEAS, ...)
     * 
     */
    INSTITUTION,

    /**
     * Visible to the DG (e.g. SG, DIGIT, ...)
     * 
     */
    DG,

    /**
     * Visible to a selected number of users/groups
     * 
     */
    LIMITED,

    /**
     * A special file with specific visibility which is not propagated to the containing documents. E.g. 'PMO file'
     * 
     */
    SPECIFIC;

    public String value() {
        return name();
    }

    public static FileVisibilityType fromValue(String v) {
        return valueOf(v);
    }

}
