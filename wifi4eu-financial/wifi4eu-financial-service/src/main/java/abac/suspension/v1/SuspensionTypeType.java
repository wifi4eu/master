
package abac.suspension.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para SuspensionTypeType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="SuspensionTypeType"&gt;
 *   &lt;restriction base="{http://www.ec.europa.eu/budg/abac/simple_type/v1}CodeType"&gt;
 *     &lt;minLength value="1"/&gt;
 *     &lt;maxLength value="8"/&gt;
 *     &lt;enumeration value="TOTAL"/&gt;
 *     &lt;enumeration value="PARTIAL"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "SuspensionTypeType")
@XmlEnum
public enum SuspensionTypeType {

    TOTAL,
    PARTIAL;

    public String value() {
        return name();
    }

    public static SuspensionTypeType fromValue(String v) {
        return valueOf(v);
    }

}
