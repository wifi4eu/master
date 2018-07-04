
package eu.europa.ec.research.fp.model.document.v5;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TransmitType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TransmitType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="TO"/>
 *     &lt;enumeration value="CC"/>
 *     &lt;enumeration value="BCC"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TransmitType")
@XmlEnum
public enum TransmitType {

    TO,
    CC,
    BCC;

    public String value() {
        return name();
    }

    public static TransmitType fromValue(String v) {
        return valueOf(v);
    }

}
