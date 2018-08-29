
package generated.hrs.ws.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CategoryStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CategoryStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="INACTIVE"/>
 *     &lt;enumeration value="ACTIVE"/>
 *     &lt;enumeration value="FROZEN"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CategoryStatus")
@XmlEnum
public enum CategoryStatus {

    INACTIVE,
    ACTIVE,
    FROZEN;

    public String value() {
        return name();
    }

    public static CategoryStatus fromValue(String v) {
        return valueOf(v);
    }

}
