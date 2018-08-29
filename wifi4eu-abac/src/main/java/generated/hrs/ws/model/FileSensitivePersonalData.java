
package generated.hrs.ws.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FileSensitivePersonalData.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="FileSensitivePersonalData">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="UNKNOWN"/>
 *     &lt;enumeration value="NO"/>
 *     &lt;enumeration value="YES"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "FileSensitivePersonalData")
@XmlEnum
public enum FileSensitivePersonalData {

    UNKNOWN,
    NO,
    YES;

    public String value() {
        return name();
    }

    public static FileSensitivePersonalData fromValue(String v) {
        return valueOf(v);
    }

}
