
package eu.europa.ec.rdg.jagate.ws.domain.legalentity.v6;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LegalEntityStatusCodeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="LegalEntityStatusCodeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="VALID"/>
 *     &lt;enumeration value="INVALID"/>
 *     &lt;enumeration value="PENDING"/>
 *     &lt;enumeration value="BLOCKED"/>
 *     &lt;enumeration value="FOLLOW_UP"/>
 *     &lt;enumeration value="REJECTED"/>
 *     &lt;enumeration value="UNKNOWN"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "LegalEntityStatusCodeType")
@XmlEnum
public enum LegalEntityStatusCodeType {

    VALID,
    INVALID,
    PENDING,
    BLOCKED,
    FOLLOW_UP,
    REJECTED,
    UNKNOWN;

    public String value() {
        return name();
    }

    public static LegalEntityStatusCodeType fromValue(String v) {
        return valueOf(v);
    }

}
