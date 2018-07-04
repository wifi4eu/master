
package generated.jagate.model.person.V2;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the generated.jagate.model.person.V2 package. 
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

    private final static QName _Person_QNAME = new QName("http://ec.europa.eu/research/fp/model/person/V2", "Person");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated.jagate.model.person.V2
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PersonType }
     * 
     */
    public PersonType createPersonType() {
        return new PersonType();
    }

    /**
     * Create an instance of {@link PersonIdentificationType }
     * 
     */
    public PersonIdentificationType createPersonIdentificationType() {
        return new PersonIdentificationType();
    }

    /**
     * Create an instance of {@link PersonType.PersonIdentificationList }
     * 
     */
    public PersonType.PersonIdentificationList createPersonTypePersonIdentificationList() {
        return new PersonType.PersonIdentificationList();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/research/fp/model/person/V2", name = "Person")
    public JAXBElement<PersonType> createPerson(PersonType value) {
        return new JAXBElement<PersonType>(_Person_QNAME, PersonType.class, null, value);
    }

}
