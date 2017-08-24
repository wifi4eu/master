
package eu.europa.ec.budg.abac.message.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para TestType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="TestType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="PROXY"/&gt;
 *     &lt;enumeration value="FULL"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "TestType")
@XmlEnum
public enum TestType {

    PROXY,
    FULL;

    public String value() {
        return name();
    }

    public static TestType fromValue(String v) {
        return valueOf(v);
    }

}
