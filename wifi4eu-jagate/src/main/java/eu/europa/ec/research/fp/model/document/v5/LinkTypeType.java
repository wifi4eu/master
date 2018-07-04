
package eu.europa.ec.research.fp.model.document.v5;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LinkTypeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="LinkTypeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DUPLICATE"/>
 *     &lt;enumeration value="GENERAL"/>
 *     &lt;enumeration value="REQUEST"/>
 *     &lt;enumeration value="RESPONSE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "LinkTypeType")
@XmlEnum
public enum LinkTypeType {

    DUPLICATE,
    GENERAL,
    REQUEST,
    RESPONSE;

    public String value() {
        return name();
    }

    public static LinkTypeType fromValue(String v) {
        return valueOf(v);
    }

}
