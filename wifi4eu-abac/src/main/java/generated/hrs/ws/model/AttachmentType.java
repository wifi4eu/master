
package generated.hrs.ws.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AttachmentType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AttachmentType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NATIVE_ELECTRONIC"/>
 *     &lt;enumeration value="SCANNED"/>
 *     &lt;enumeration value="EMAIL"/>
 *     &lt;enumeration value="ARES_SCANNED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AttachmentType")
@XmlEnum
public enum AttachmentType {

    NATIVE_ELECTRONIC,
    SCANNED,
    EMAIL,
    ARES_SCANNED;

    public String value() {
        return name();
    }

    public static AttachmentType fromValue(String v) {
        return valueOf(v);
    }

}
