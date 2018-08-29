
package generated.hrs.ws.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HeadingType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HeadingType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="COMMON"/>
 *     &lt;enumeration value="SPECIFIC"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "HeadingType")
@XmlEnum
public enum HeadingType {

    COMMON,
    SPECIFIC;

    public String value() {
        return name();
    }

    public static HeadingType fromValue(String v) {
        return valueOf(v);
    }

}
