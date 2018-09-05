
package generated.hrs.ws.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AfterRegistrationAccess.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AfterRegistrationAccess">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="RESTRICTED"/>
 *     &lt;enumeration value="EXTENDED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AfterRegistrationAccess")
@XmlEnum
public enum AfterRegistrationAccess {


    /**
     * Depict that the chosen access level is RESTRICTED
     * 
     */
    RESTRICTED,

    /**
     * Depict that the chosen access level is EXTENDED
     * 
     */
    EXTENDED;

    public String value() {
        return name();
    }

    public static AfterRegistrationAccess fromValue(String v) {
        return valueOf(v);
    }

}
