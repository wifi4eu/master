
package generated.hrs.ws.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ExternalizationStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ExternalizationStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NOT_EXTERNALIZED"/>
 *     &lt;enumeration value="EXTERNALIZATION_INITIATED"/>
 *     &lt;enumeration value="EXTERNALIZED"/>
 *     &lt;enumeration value="REVOCATION_INITIATED"/>
 *     &lt;enumeration value="REVOKED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ExternalizationStatus")
@XmlEnum
public enum ExternalizationStatus {

    NOT_EXTERNALIZED,
    EXTERNALIZATION_INITIATED,
    EXTERNALIZED,
    REVOCATION_INITIATED,
    REVOKED;

    public String value() {
        return name();
    }

    public static ExternalizationStatus fromValue(String v) {
        return valueOf(v);
    }

}
