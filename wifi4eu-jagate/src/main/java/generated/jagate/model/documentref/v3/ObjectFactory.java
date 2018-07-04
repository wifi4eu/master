
package generated.jagate.model.documentref.v3;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the generated.jagate.model.documentref.v3 package. 
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

    private final static QName _DocumentRef_QNAME = new QName("http://ec.europa.eu/research/fp/model/document-ref/V3", "DocumentRef");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated.jagate.model.documentref.v3
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DocumentRefType }
     * 
     */
    public DocumentRefType createDocumentRefType() {
        return new DocumentRefType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocumentRefType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/research/fp/model/document-ref/V3", name = "DocumentRef")
    public JAXBElement<DocumentRefType> createDocumentRef(DocumentRefType value) {
        return new JAXBElement<DocumentRefType>(_DocumentRef_QNAME, DocumentRefType.class, null, value);
    }

}
