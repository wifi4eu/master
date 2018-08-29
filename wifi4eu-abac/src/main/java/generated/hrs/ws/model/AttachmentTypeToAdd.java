
package generated.hrs.ws.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AttachmentTypeToAdd.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AttachmentTypeToAdd">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NATIVE_ELECTRONIC"/>
 *     &lt;enumeration value="SCANNED"/>
 *     &lt;enumeration value="EMAIL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AttachmentTypeToAdd")
@XmlEnum
public enum AttachmentTypeToAdd {

    NATIVE_ELECTRONIC,
    SCANNED,
    EMAIL;

    public String value() {
        return name();
    }

    public static AttachmentTypeToAdd fromValue(String v) {
        return valueOf(v);
    }

}
