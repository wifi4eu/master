
package eu.europa.ec.rdg.jagate.ws.domain.transaction.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TransactionSubtype.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TransactionSubtype">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CREATE_CONTRACT"/>
 *     &lt;enumeration value="LEGAL_COMMITMENT"/>
 *     &lt;enumeration value="PAYMENT_ORDER"/>
 *     &lt;enumeration value="PAYMENT_REQUEST"/>
 *     &lt;enumeration value="COMMITMENT_LEVEL_2"/>
 *     &lt;enumeration value="INVOICE"/>
 *     &lt;enumeration value="LEGAL_COMMITMENT"/>
 *     &lt;enumeration value="LEGAL_ENTITY_CREATE"/>
 *     &lt;enumeration value="PAYMENT_REQUEST_JRC"/>
 *     &lt;enumeration value="RECOVERY_ORDER"/>
 *     &lt;enumeration value="LEGAL_ENTITY_UPDATE"/>
 *     &lt;enumeration value="INVOICE_JRC"/>
 *     &lt;enumeration value="PAYMENT_REQUEST_JRC"/>
 *     &lt;enumeration value="PAYMENT_ORDER_JRC"/>
 *     &lt;enumeration value="PAYMENT_REQUEST_JRC_GF"/>
 *     &lt;enumeration value="PAYMENT_ORDER_JRC_GF"/>
 *     &lt;enumeration value="AL_PAYMENT_REQUEST_CREATE"/>
 *     &lt;enumeration value="AL_PAYMENT_ORDER_CREATE"/>
 *     &lt;enumeration value="COMMITMENT_LEVEL_1"/>
 *     &lt;enumeration value="BANK_ACCOUNT"/>
 *     &lt;enumeration value="CLOCK"/>
 *     &lt;enumeration value="CREATE_RECOVERY_ORDER"/>
 *     &lt;enumeration value="GRANT_LEGAL_COMMITMENT"/>
 *     &lt;enumeration value="EXPERTS_PAYMENT_REQUEST"/>
 *     &lt;enumeration value="EXPERTS_PAYMENT_ORDER"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TransactionSubtype")
@XmlEnum
public enum TransactionSubtype {

    CREATE_CONTRACT,
    LEGAL_COMMITMENT,
    PAYMENT_ORDER,
    PAYMENT_REQUEST,
    COMMITMENT_LEVEL_2,
    INVOICE,
    LEGAL_ENTITY_CREATE,
    PAYMENT_REQUEST_JRC,
    RECOVERY_ORDER,
    LEGAL_ENTITY_UPDATE,
    INVOICE_JRC,
    PAYMENT_ORDER_JRC,
    PAYMENT_REQUEST_JRC_GF,
    PAYMENT_ORDER_JRC_GF,
    AL_PAYMENT_REQUEST_CREATE,
    AL_PAYMENT_ORDER_CREATE,
    COMMITMENT_LEVEL_1,
    BANK_ACCOUNT,
    CLOCK,
    CREATE_RECOVERY_ORDER,
    GRANT_LEGAL_COMMITMENT,
    EXPERTS_PAYMENT_REQUEST,
    EXPERTS_PAYMENT_ORDER;

    public String value() {
        return name();
    }

    public static TransactionSubtype fromValue(String v) {
        return valueOf(v);
    }

}
