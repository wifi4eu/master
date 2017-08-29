
package abac.organisation.v1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.organisation.v1 package.
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

    private final static QName _OrganisationGetRequest_QNAME = new QName("http://www.ec.europa.eu/budg/abac/organisation/v1", "OrganisationGetRequest");
    private final static QName _OrganisationGetResponse_QNAME = new QName("http://www.ec.europa.eu/budg/abac/organisation/v1", "OrganisationGetResponse");
    private final static QName _OrganisationGetFirstAncestorForWorkflowRequest_QNAME = new QName("http://www.ec.europa.eu/budg/abac/organisation/v1", "OrganisationGetFirstAncestorForWorkflowRequest");
    private final static QName _OrganisationGetFirstAncestorForWorkflowResponse_QNAME = new QName("http://www.ec.europa.eu/budg/abac/organisation/v1", "OrganisationGetFirstAncestorForWorkflowResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.organisation.v1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link OrganisationGetRequestType }
     * 
     */
    public OrganisationGetRequestType createOrganisationGetRequestType() {
        return new OrganisationGetRequestType();
    }

    /**
     * Create an instance of {@link OrganisationGetResponseType }
     * 
     */
    public OrganisationGetResponseType createOrganisationGetResponseType() {
        return new OrganisationGetResponseType();
    }

    /**
     * Create an instance of {@link OrganisationGetFirstAncestorForWorkflowRequestType }
     * 
     */
    public OrganisationGetFirstAncestorForWorkflowRequestType createOrganisationGetFirstAncestorForWorkflowRequestType() {
        return new OrganisationGetFirstAncestorForWorkflowRequestType();
    }

    /**
     * Create an instance of {@link OrganisationGetFirstAncestorForWorkflowResponseType }
     * 
     */
    public OrganisationGetFirstAncestorForWorkflowResponseType createOrganisationGetFirstAncestorForWorkflowResponseType() {
        return new OrganisationGetFirstAncestorForWorkflowResponseType();
    }

    /**
     * Create an instance of {@link ResponsibleOrganisationType }
     * 
     */
    public ResponsibleOrganisationType createResponsibleOrganisationType() {
        return new ResponsibleOrganisationType();
    }

    /**
     * Create an instance of {@link OrganisationType }
     * 
     */
    public OrganisationType createOrganisationType() {
        return new OrganisationType();
    }

    /**
     * Create an instance of {@link OrganisationKeyType }
     * 
     */
    public OrganisationKeyType createOrganisationKeyType() {
        return new OrganisationKeyType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrganisationGetRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ec.europa.eu/budg/abac/organisation/v1", name = "OrganisationGetRequest")
    public JAXBElement<OrganisationGetRequestType> createOrganisationGetRequest(OrganisationGetRequestType value) {
        return new JAXBElement<OrganisationGetRequestType>(_OrganisationGetRequest_QNAME, OrganisationGetRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrganisationGetResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ec.europa.eu/budg/abac/organisation/v1", name = "OrganisationGetResponse")
    public JAXBElement<OrganisationGetResponseType> createOrganisationGetResponse(OrganisationGetResponseType value) {
        return new JAXBElement<OrganisationGetResponseType>(_OrganisationGetResponse_QNAME, OrganisationGetResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrganisationGetFirstAncestorForWorkflowRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ec.europa.eu/budg/abac/organisation/v1", name = "OrganisationGetFirstAncestorForWorkflowRequest")
    public JAXBElement<OrganisationGetFirstAncestorForWorkflowRequestType> createOrganisationGetFirstAncestorForWorkflowRequest(OrganisationGetFirstAncestorForWorkflowRequestType value) {
        return new JAXBElement<OrganisationGetFirstAncestorForWorkflowRequestType>(_OrganisationGetFirstAncestorForWorkflowRequest_QNAME, OrganisationGetFirstAncestorForWorkflowRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrganisationGetFirstAncestorForWorkflowResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ec.europa.eu/budg/abac/organisation/v1", name = "OrganisationGetFirstAncestorForWorkflowResponse")
    public JAXBElement<OrganisationGetFirstAncestorForWorkflowResponseType> createOrganisationGetFirstAncestorForWorkflowResponse(OrganisationGetFirstAncestorForWorkflowResponseType value) {
        return new JAXBElement<OrganisationGetFirstAncestorForWorkflowResponseType>(_OrganisationGetFirstAncestorForWorkflowResponse_QNAME, OrganisationGetFirstAncestorForWorkflowResponseType.class, null, value);
    }

}
