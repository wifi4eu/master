
package abac.search_criterion.v1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.search_criterion.v1 package.
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

    private final static QName _TextCriterion_QNAME = new QName("http://www.ec.europa.eu/budg/abac/search_criterion/v1", "TextCriterion");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.search_criterion.v1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TextCriterionType }
     * 
     */
    public TextCriterionType createTextCriterionType() {
        return new TextCriterionType();
    }

    /**
     * Create an instance of {@link DateCriterionType }
     * 
     */
    public DateCriterionType createDateCriterionType() {
        return new DateCriterionType();
    }

    /**
     * Create an instance of {@link IndicatorCriterionType }
     * 
     */
    public IndicatorCriterionType createIndicatorCriterionType() {
        return new IndicatorCriterionType();
    }

    /**
     * Create an instance of {@link NumberCriterionType }
     * 
     */
    public NumberCriterionType createNumberCriterionType() {
        return new NumberCriterionType();
    }

    /**
     * Create an instance of {@link NumericIdentifierCriterionType }
     * 
     */
    public NumericIdentifierCriterionType createNumericIdentifierCriterionType() {
        return new NumericIdentifierCriterionType();
    }

    /**
     * Create an instance of {@link OracleTextCriterionType }
     * 
     */
    public OracleTextCriterionType createOracleTextCriterionType() {
        return new OracleTextCriterionType();
    }

    /**
     * Create an instance of {@link SortType }
     * 
     */
    public SortType createSortType() {
        return new SortType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextCriterionType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ec.europa.eu/budg/abac/search_criterion/v1", name = "TextCriterion")
    public JAXBElement<TextCriterionType> createTextCriterion(TextCriterionType value) {
        return new JAXBElement<TextCriterionType>(_TextCriterion_QNAME, TextCriterionType.class, null, value);
    }

}
