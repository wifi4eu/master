
package generated.jagate.ws.domain.visa.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VisaStatusType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="VisaStatusType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PENDING"/>
 *     &lt;enumeration value="GIVEN"/>
 *     &lt;enumeration value="ERROR"/>
 *     &lt;enumeration value="REQUIRED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "VisaStatusType")
@XmlEnum
public enum VisaStatusType {

    PENDING,
    GIVEN,
    ERROR,
    REQUIRED;

    public String value() {
        return name();
    }

    public static VisaStatusType fromValue(String v) {
        return valueOf(v);
    }

}
