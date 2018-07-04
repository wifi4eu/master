
package generated.jagate.model.bankaccount.V4;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the generated.jagate.model.bankaccount.V4 package. 
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

    private final static QName _BankAccountType_QNAME = new QName("http://ec.europa.eu/research/fp/model/bankaccount/V4", "BankAccountType");
    private final static QName _BankType_QNAME = new QName("http://ec.europa.eu/research/fp/model/bankaccount/V4", "BankType");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated.jagate.model.bankaccount.V4
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link BankAccountType }
     * 
     */
    public BankAccountType createBankAccountType() {
        return new BankAccountType();
    }

    /**
     * Create an instance of {@link BankType }
     * 
     */
    public BankType createBankType() {
        return new BankType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BankAccountType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/research/fp/model/bankaccount/V4", name = "BankAccountType")
    public JAXBElement<BankAccountType> createBankAccountType(BankAccountType value) {
        return new JAXBElement<BankAccountType>(_BankAccountType_QNAME, BankAccountType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BankType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/research/fp/model/bankaccount/V4", name = "BankType")
    public JAXBElement<BankType> createBankType(BankType value) {
        return new JAXBElement<BankType>(_BankType_QNAME, BankType.class, null, value);
    }

}
