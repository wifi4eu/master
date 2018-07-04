
package generated.jagate.model.projectref.v3;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the generated.jagate.model.projectref.v3 package. 
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

    private final static QName _ProposalId_QNAME = new QName("http://ec.europa.eu/research/fp/model/project-ref/V3", "ProposalId");
    private final static QName _ProjectId_QNAME = new QName("http://ec.europa.eu/research/fp/model/project-ref/V3", "ProjectId");
    private final static QName _ProjectRef_QNAME = new QName("http://ec.europa.eu/research/fp/model/project-ref/V3", "ProjectRef");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated.jagate.model.projectref.v3
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ProjectIdType }
     * 
     */
    public ProjectIdType createProjectIdType() {
        return new ProjectIdType();
    }

    /**
     * Create an instance of {@link ProposalIdType }
     * 
     */
    public ProposalIdType createProposalIdType() {
        return new ProposalIdType();
    }

    /**
     * Create an instance of {@link ProjectRefType }
     * 
     */
    public ProjectRefType createProjectRefType() {
        return new ProjectRefType();
    }

    /**
     * Create an instance of {@link DraftProposalIDListType }
     * 
     */
    public DraftProposalIDListType createDraftProposalIDListType() {
        return new DraftProposalIDListType();
    }

    /**
     * Create an instance of {@link ProjectRefListType }
     * 
     */
    public ProjectRefListType createProjectRefListType() {
        return new ProjectRefListType();
    }

    /**
     * Create an instance of {@link ProposalIDListType }
     * 
     */
    public ProposalIDListType createProposalIDListType() {
        return new ProposalIDListType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProposalIdType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/research/fp/model/project-ref/V3", name = "ProposalId")
    public JAXBElement<ProposalIdType> createProposalId(ProposalIdType value) {
        return new JAXBElement<ProposalIdType>(_ProposalId_QNAME, ProposalIdType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProjectIdType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/research/fp/model/project-ref/V3", name = "ProjectId")
    public JAXBElement<ProjectIdType> createProjectId(ProjectIdType value) {
        return new JAXBElement<ProjectIdType>(_ProjectId_QNAME, ProjectIdType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProjectRefType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/research/fp/model/project-ref/V3", name = "ProjectRef")
    public JAXBElement<ProjectRefType> createProjectRef(ProjectRefType value) {
        return new JAXBElement<ProjectRefType>(_ProjectRef_QNAME, ProjectRefType.class, null, value);
    }

}
