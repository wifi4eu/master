
package eu.europa.ec.rdg.jagate.ws.domain.legalentity.v6;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PrivateBodyAccountGroupType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PrivateBodyAccountGroupType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PRIVATE_COMPANIES"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PrivateBodyAccountGroupType")
@XmlEnum
public enum PrivateBodyAccountGroupType {

    PRIVATE_COMPANIES;

    public String value() {
        return name();
    }

    public static PrivateBodyAccountGroupType fromValue(String v) {
        return valueOf(v);
    }

}
