
package generated.jagate.ws.domain.reference.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ERequestType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ERequestType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CREATE_AUDIT"/>
 *     &lt;enumeration value="UPDATE_AUDIT"/>
 *     &lt;enumeration value="DELETE_AUDIT"/>
 *     &lt;enumeration value="CREATE_CONTRACT"/>
 *     &lt;enumeration value="SYGMA_CONTRACT"/>
 *     &lt;enumeration value="CREATE_PREFINANCING_DOC"/>
 *     &lt;enumeration value="CREATE_PAYMENT_REQUEST"/>
 *     &lt;enumeration value="CREATE_AL_PAYMENT_REQUEST"/>
 *     &lt;enumeration value="CREATE_LE"/>
 *     &lt;enumeration value="CREATE_BA"/>
 *     &lt;enumeration value="CREATE_LEBA_LINK"/>
 *     &lt;enumeration value="CREATE_RO"/>
 *     &lt;enumeration value="CREATE_VISA"/>
 *     &lt;enumeration value="CREATE_INVOICE_COST_CLAIM"/>
 *     &lt;enumeration value="CREATE_COMMITMENT"/>
 *     &lt;enumeration value="CREATE_COMMITMENT_LEVEL1"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ERequestType", namespace = "http://ec.europa.eu/rdg/jagate/ws/domain/reference/v1")
@XmlEnum
public enum ERequestType {

    CREATE_AUDIT("CREATE_AUDIT"),
    UPDATE_AUDIT("UPDATE_AUDIT"),
    DELETE_AUDIT("DELETE_AUDIT"),
    CREATE_CONTRACT("CREATE_CONTRACT"),
    SYGMA_CONTRACT("SYGMA_CONTRACT"),
    CREATE_PREFINANCING_DOC("CREATE_PREFINANCING_DOC"),
    CREATE_PAYMENT_REQUEST("CREATE_PAYMENT_REQUEST"),
    CREATE_AL_PAYMENT_REQUEST("CREATE_AL_PAYMENT_REQUEST"),
    CREATE_LE("CREATE_LE"),
    CREATE_BA("CREATE_BA"),
    CREATE_LEBA_LINK("CREATE_LEBA_LINK"),
    CREATE_RO("CREATE_RO"),
    CREATE_VISA("CREATE_VISA"),
    CREATE_INVOICE_COST_CLAIM("CREATE_INVOICE_COST_CLAIM"),
    CREATE_COMMITMENT("CREATE_COMMITMENT"),
    @XmlEnumValue("CREATE_COMMITMENT_LEVEL1")
    CREATE_COMMITMENT_LEVEL_1("CREATE_COMMITMENT_LEVEL1");
    private final String value;

    ERequestType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ERequestType fromValue(String v) {
        for (ERequestType c: ERequestType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
