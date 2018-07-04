
package generated.jagate.model.coderef.V2;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the generated.jagate.model.coderef.V2 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CodeRef_QNAME = new QName("http://ec.europa.eu/research/fp/model/code-ref/V2", "CodeRef");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated.jagate.model.coderef.V2
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CodeRefType }
     * 
     */
    public CodeRefType createCodeRefType() {
        return new CodeRefType();
    }

    /**
     * Create an instance of {@link CodeRefListType }
     * 
     */
    public CodeRefListType createCodeRefListType() {
        return new CodeRefListType();
    }

    /**
     * Create an instance of {@link CodeIdListType }
     * 
     */
    public CodeIdListType createCodeIdListType() {
        return new CodeIdListType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CodeRefType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/research/fp/model/code-ref/V2", name = "CodeRef")
    public JAXBElement<CodeRefType> createCodeRef(CodeRefType value) {
        return new JAXBElement<CodeRefType>(_CodeRef_QNAME, CodeRefType.class, null, value);
    }

}
