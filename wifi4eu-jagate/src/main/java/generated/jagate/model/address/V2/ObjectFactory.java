
package generated.jagate.model.address.V2;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the generated.jagate.model.address.V2 package. 
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

    private final static QName _Address_QNAME = new QName("http://ec.europa.eu/research/fp/model/address/V2", "Address");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated.jagate.model.address.V2
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddressType }
     * 
     */
    public AddressType createAddressType() {
        return new AddressType();
    }

    /**
     * Create an instance of {@link AddressType.Phone }
     * 
     */
    public AddressType.Phone createAddressTypePhone() {
        return new AddressType.Phone();
    }

    /**
     * Create an instance of {@link AddressType.Fax }
     * 
     */
    public AddressType.Fax createAddressTypeFax() {
        return new AddressType.Fax();
    }

    /**
     * Create an instance of {@link AddressType.Email }
     * 
     */
    public AddressType.Email createAddressTypeEmail() {
        return new AddressType.Email();
    }

    /**
     * Create an instance of {@link AddressType.WebLink }
     * 
     */
    public AddressType.WebLink createAddressTypeWebLink() {
        return new AddressType.WebLink();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddressType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/research/fp/model/address/V2", name = "Address")
    public JAXBElement<AddressType> createAddress(AddressType value) {
        return new JAXBElement<AddressType>(_Address_QNAME, AddressType.class, null, value);
    }

}
