
package eu.europa.ec.research.fp.model.document.v5;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MailTypeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MailTypeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="INCOMING"/>
 *     &lt;enumeration value="INTERNAL"/>
 *     &lt;enumeration value="OUTGOING"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "MailTypeType")
@XmlEnum
public enum MailTypeType {

    INCOMING,
    INTERNAL,
    OUTGOING;

    public String value() {
        return name();
    }

    public static MailTypeType fromValue(String v) {
        return valueOf(v);
    }

}
