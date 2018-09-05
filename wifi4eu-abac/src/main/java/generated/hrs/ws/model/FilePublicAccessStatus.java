
package generated.hrs.ws.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FilePublicAccessStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="FilePublicAccessStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NO"/>
 *     &lt;enumeration value="PARTIAL"/>
 *     &lt;enumeration value="FULL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "FilePublicAccessStatus")
@XmlEnum
public enum FilePublicAccessStatus {

    NO,
    PARTIAL,
    FULL;

    public String value() {
        return name();
    }

    public static FilePublicAccessStatus fromValue(String v) {
        return valueOf(v);
    }

}
