
package generated.jagate.ws.domain.reference.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EAgentType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EAgentType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="IA"/>
 *     &lt;enumeration value="DEA"/>
 *     &lt;enumeration value="OIA"/>
 *     &lt;enumeration value="FIA"/>
 *     &lt;enumeration value="OVA"/>
 *     &lt;enumeration value="FVA"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "EAgentType", namespace = "http://ec.europa.eu/rdg/jagate/ws/domain/reference/v1")
@XmlEnum
public enum EAgentType {


    /**
     * Initiating agent
     * 
     */
    IA,

    /**
     * Data Entry Agent
     * 
     */
    DEA,

    /**
     * Operational Initiating Agent
     * 
     */
    OIA,

    /**
     * Financial Initiating Agent
     * 
     */
    FIA,

    /**
     * Operational Verifying Agent
     * 
     */
    OVA,

    /**
     * Financial Verifying Agent
     * 
     */
    FVA;

    public String value() {
        return name();
    }

    public static EAgentType fromValue(String v) {
        return valueOf(v);
    }

}
