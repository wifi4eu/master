
package generated.jagate.model.certificate.v4;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the generated.jagate.model.certificate.v4 package. 
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

    private final static QName _CertificateOnMethodology_QNAME = new QName("http://ec.europa.eu/research/fp/model/certificate/V4", "CertificateOnMethodology");
    private final static QName _Certificate_QNAME = new QName("http://ec.europa.eu/research/fp/model/certificate/V4", "Certificate");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated.jagate.model.certificate.v4
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CertificateOnMethodologyType }
     * 
     */
    public CertificateOnMethodologyType createCertificateOnMethodologyType() {
        return new CertificateOnMethodologyType();
    }

    /**
     * Create an instance of {@link CertificateType }
     * 
     */
    public CertificateType createCertificateType() {
        return new CertificateType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CertificateOnMethodologyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/research/fp/model/certificate/V4", name = "CertificateOnMethodology")
    public JAXBElement<CertificateOnMethodologyType> createCertificateOnMethodology(CertificateOnMethodologyType value) {
        return new JAXBElement<CertificateOnMethodologyType>(_CertificateOnMethodology_QNAME, CertificateOnMethodologyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CertificateType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/research/fp/model/certificate/V4", name = "Certificate")
    public JAXBElement<CertificateType> createCertificate(CertificateType value) {
        return new JAXBElement<CertificateType>(_Certificate_QNAME, CertificateType.class, null, value);
    }

}
