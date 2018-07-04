
package generated.jagate.ws.domain.constants.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ERequestClient.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ERequestClient">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PHOENIX"/>
 *     &lt;enumeration value="ARPS"/>
 *     &lt;enumeration value="IFLOW"/>
 *     &lt;enumeration value="FP7_PREFINANCEMENT_DOC"/>
 *     &lt;enumeration value="FP7_FIN_PAY_COMM"/>
 *     &lt;enumeration value="FP7_TERM_PAY_COORD"/>
 *     &lt;enumeration value="CIP_PREFINANCEMENT_DOC"/>
 *     &lt;enumeration value="FP7_PREFINANCEMENT_PAYMENT"/>
 *     &lt;enumeration value="CIP_PREFINANCEMENT_PAYMENT"/>
 *     &lt;enumeration value="CREATE_AL_PAYMENT_REQUEST"/>
 *     &lt;enumeration value="VISA"/>
 *     &lt;enumeration value="STATUS_CHECK"/>
 *     &lt;enumeration value="CREATE_LE_REQUEST"/>
 *     &lt;enumeration value="CREATE_BA_REQUEST"/>
 *     &lt;enumeration value="CREATE_LEBA_LINK_REQUEST"/>
 *     &lt;enumeration value="FP7_INVOICE_COST_CLAIM_REQUEST"/>
 *     &lt;enumeration value="IFLOW_CREATE_COMMITMENT"/>
 *     &lt;enumeration value="PHOENIX_CREATE_COMMITMENT"/>
 *     &lt;enumeration value="SYGMA_CREATE_COMMITMENT"/>
 *     &lt;enumeration value="SYGMA_UPDATE_COMMITMENT"/>
 *     &lt;enumeration value="SYGMA_CONTRACT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ERequestClient", namespace = "http://ec.europa.eu/rdg/jagate/ws/domain/constants/v1")
@XmlEnum
public enum ERequestClient {

    PHOENIX("PHOENIX"),
    ARPS("ARPS"),
    IFLOW("IFLOW"),
    @XmlEnumValue("FP7_PREFINANCEMENT_DOC")
    FP_7_PREFINANCEMENT_DOC("FP7_PREFINANCEMENT_DOC"),
    @XmlEnumValue("FP7_FIN_PAY_COMM")
    FP_7_FIN_PAY_COMM("FP7_FIN_PAY_COMM"),
    @XmlEnumValue("FP7_TERM_PAY_COORD")
    FP_7_TERM_PAY_COORD("FP7_TERM_PAY_COORD"),
    CIP_PREFINANCEMENT_DOC("CIP_PREFINANCEMENT_DOC"),
    @XmlEnumValue("FP7_PREFINANCEMENT_PAYMENT")
    FP_7_PREFINANCEMENT_PAYMENT("FP7_PREFINANCEMENT_PAYMENT"),
    CIP_PREFINANCEMENT_PAYMENT("CIP_PREFINANCEMENT_PAYMENT"),
    CREATE_AL_PAYMENT_REQUEST("CREATE_AL_PAYMENT_REQUEST"),
    VISA("VISA"),
    STATUS_CHECK("STATUS_CHECK"),
    CREATE_LE_REQUEST("CREATE_LE_REQUEST"),
    CREATE_BA_REQUEST("CREATE_BA_REQUEST"),
    CREATE_LEBA_LINK_REQUEST("CREATE_LEBA_LINK_REQUEST"),
    @XmlEnumValue("FP7_INVOICE_COST_CLAIM_REQUEST")
    FP_7_INVOICE_COST_CLAIM_REQUEST("FP7_INVOICE_COST_CLAIM_REQUEST"),
    IFLOW_CREATE_COMMITMENT("IFLOW_CREATE_COMMITMENT"),
    PHOENIX_CREATE_COMMITMENT("PHOENIX_CREATE_COMMITMENT"),
    SYGMA_CREATE_COMMITMENT("SYGMA_CREATE_COMMITMENT"),
    SYGMA_UPDATE_COMMITMENT("SYGMA_UPDATE_COMMITMENT"),
    SYGMA_CONTRACT("SYGMA_CONTRACT");
    private final String value;

    ERequestClient(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ERequestClient fromValue(String v) {
        for (ERequestClient c: ERequestClient.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
