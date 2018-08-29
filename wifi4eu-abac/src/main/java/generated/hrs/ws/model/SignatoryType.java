
package generated.hrs.ws.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SignatoryType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SignatoryType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PAPER"/>
 *     &lt;enumeration value="ESIGNATORY"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SignatoryType")
@XmlEnum
public enum SignatoryType {

    PAPER,
    ESIGNATORY;

    public String value() {
        return name();
    }

    public static SignatoryType fromValue(String v) {
        return valueOf(v);
    }

}
