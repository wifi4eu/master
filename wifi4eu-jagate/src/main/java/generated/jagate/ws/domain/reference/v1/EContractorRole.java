
package generated.jagate.ws.domain.reference.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EContractorRole.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EContractorRole">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="COC"/>
 *     &lt;enumeration value="COO"/>
 *     &lt;enumeration value="CTT"/>
 *     &lt;enumeration value="SUB"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "EContractorRole", namespace = "http://ec.europa.eu/rdg/jagate/ws/domain/reference/v1")
@XmlEnum
public enum EContractorRole {


    /**
     * Co-Contractor
     * 
     */
    COC,

    /**
     * Single Contractor / Coordinator
     * 
     */
    COO,

    /**
     * Associate Contractor
     * 
     */
    CTT,

    /**
     * Subcontractor
     * 
     */
    SUB;

    public String value() {
        return name();
    }

    public static EContractorRole fromValue(String v) {
        return valueOf(v);
    }

}
