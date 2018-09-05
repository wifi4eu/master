
package generated.hrs.ws.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HeadingStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HeadingStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="INACTIVE"/>
 *     &lt;enumeration value="ACTIVE"/>
 *     &lt;enumeration value="EXTINCT"/>
 *     &lt;enumeration value="FROZEN"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "HeadingStatus")
@XmlEnum
public enum HeadingStatus {

    INACTIVE,
    ACTIVE,
    EXTINCT,
    FROZEN;

    public String value() {
        return name();
    }

    public static HeadingStatus fromValue(String v) {
        return valueOf(v);
    }

}
