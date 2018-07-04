
package generated.jagate.ws.domain.visa.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AgentType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AgentType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="INITIATING_AGENT"/>
 *     &lt;enumeration value="VERIFYING_AGENT"/>
 *     &lt;enumeration value="AUTHORISING_OFFICER"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AgentType")
@XmlEnum
public enum AgentType {

    INITIATING_AGENT,
    VERIFYING_AGENT,
    AUTHORISING_OFFICER;

    public String value() {
        return name();
    }

    public static AgentType fromValue(String v) {
        return valueOf(v);
    }

}
