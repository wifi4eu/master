
package generated.hrs.ws.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FileStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="FileStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="INACTIVE"/>
 *     &lt;enumeration value="ACTIVE"/>
 *     &lt;enumeration value="CLOSED"/>
 *     &lt;enumeration value="TRANSFERRED"/>
 *     &lt;enumeration value="ELIMINATED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "FileStatus")
@XmlEnum
public enum FileStatus {

    INACTIVE,
    ACTIVE,
    CLOSED,
    TRANSFERRED,
    ELIMINATED;

    public String value() {
        return name();
    }

    public static FileStatus fromValue(String v) {
        return valueOf(v);
    }

}
