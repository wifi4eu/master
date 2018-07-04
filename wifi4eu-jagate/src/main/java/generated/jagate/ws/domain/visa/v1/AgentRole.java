
package generated.jagate.ws.domain.visa.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AgentRole.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AgentRole">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="FINANCIAL_AGENT"/>
 *     &lt;enumeration value="OPERATIONAL_AGENT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AgentRole")
@XmlEnum
public enum AgentRole {

    FINANCIAL_AGENT,
    OPERATIONAL_AGENT;

    public String value() {
        return name();
    }

    public static AgentRole fromValue(String v) {
        return valueOf(v);
    }

}
