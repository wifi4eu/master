
package generated.jagate.ws.domain.constants.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JagateClient.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="JagateClient">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SYGMA"/>
 *     &lt;enumeration value="COMPASS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "JagateClient", namespace = "http://ec.europa.eu/rdg/jagate/ws/domain/constants/v1")
@XmlEnum
public enum JagateClient {

    SYGMA,
    COMPASS;

    public String value() {
        return name();
    }

    public static JagateClient fromValue(String v) {
        return valueOf(v);
    }

}
