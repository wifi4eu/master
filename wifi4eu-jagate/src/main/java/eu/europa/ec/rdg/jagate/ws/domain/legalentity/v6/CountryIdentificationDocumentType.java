
package eu.europa.ec.rdg.jagate.ws.domain.legalentity.v6;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CountryIdentificationDocumentType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CountryIdentificationDocumentType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NATIONAL_ID_NUMBER"/>
 *     &lt;enumeration value="PASSPORT_NUMBER"/>
 *     &lt;enumeration value="DRIVING_LICENSE_NUMBER"/>
 *     &lt;enumeration value="ID_CARD_NUMBER"/>
 *     &lt;enumeration value="OTHER_IDENTIFICATION_NUMBER"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CountryIdentificationDocumentType")
@XmlEnum
public enum CountryIdentificationDocumentType {

    NATIONAL_ID_NUMBER,
    PASSPORT_NUMBER,
    DRIVING_LICENSE_NUMBER,
    ID_CARD_NUMBER,
    OTHER_IDENTIFICATION_NUMBER;

    public String value() {
        return name();
    }

    public static CountryIdentificationDocumentType fromValue(String v) {
        return valueOf(v);
    }

}
