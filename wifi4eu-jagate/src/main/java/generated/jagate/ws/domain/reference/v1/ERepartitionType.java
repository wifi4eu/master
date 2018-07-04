
package generated.jagate.ws.domain.reference.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ERepartitionType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ERepartitionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PR"/>
 *     &lt;enumeration value="MT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ERepartitionType", namespace = "http://ec.europa.eu/rdg/jagate/ws/domain/reference/v1")
@XmlEnum
public enum ERepartitionType {


    /**
     * Percent
     * 
     */
    PR,

    /**
     * Amount
     * 
     */
    MT;

    public String value() {
        return name();
    }

    public static ERepartitionType fromValue(String v) {
        return valueOf(v);
    }

}
