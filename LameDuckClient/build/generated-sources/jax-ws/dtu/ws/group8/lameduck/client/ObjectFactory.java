
package dtu.ws.group8.lameduck.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the dtu.ws.group8.lameduck.client package. 
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

    private final static QName _BookFlightFaultElement_QNAME = new QName("http://types.lameduck.group8.ws.dtu", "bookFlightFaultElement");
    private final static QName _CancelFlightFaultElement_QNAME = new QName("http://types.lameduck.group8.ws.dtu", "cancelFlightFaultElement");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: dtu.ws.group8.lameduck.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CancelFlightFaultType }
     * 
     */
    public CancelFlightFaultType createCancelFlightFaultType() {
        return new CancelFlightFaultType();
    }

    /**
     * Create an instance of {@link BookFlightFaultType }
     * 
     */
    public BookFlightFaultType createBookFlightFaultType() {
        return new BookFlightFaultType();
    }

    /**
     * Create an instance of {@link CancelFlightRequestType }
     * 
     */
    public CancelFlightRequestType createCancelFlightRequestType() {
        return new CancelFlightRequestType();
    }

    /**
     * Create an instance of {@link FlightInfoListType }
     * 
     */
    public FlightInfoListType createFlightInfoListType() {
        return new FlightInfoListType();
    }

    /**
     * Create an instance of {@link FlightInfoType }
     * 
     */
    public FlightInfoType createFlightInfoType() {
        return new FlightInfoType();
    }

    /**
     * Create an instance of {@link BookFlightRequestType }
     * 
     */
    public BookFlightRequestType createBookFlightRequestType() {
        return new BookFlightRequestType();
    }

    /**
     * Create an instance of {@link DefaultFaultType }
     * 
     */
    public DefaultFaultType createDefaultFaultType() {
        return new DefaultFaultType();
    }

    /**
     * Create an instance of {@link CreditCardInfoType }
     * 
     */
    public CreditCardInfoType createCreditCardInfoType() {
        return new CreditCardInfoType();
    }

    /**
     * Create an instance of {@link FlightDetails }
     * 
     */
    public FlightDetails createFlightDetails() {
        return new FlightDetails();
    }

    /**
     * Create an instance of {@link GetFlightRequestType }
     * 
     */
    public GetFlightRequestType createGetFlightRequestType() {
        return new GetFlightRequestType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BookFlightFaultType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://types.lameduck.group8.ws.dtu", name = "bookFlightFaultElement")
    public JAXBElement<BookFlightFaultType> createBookFlightFaultElement(BookFlightFaultType value) {
        return new JAXBElement<BookFlightFaultType>(_BookFlightFaultElement_QNAME, BookFlightFaultType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelFlightFaultType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://types.lameduck.group8.ws.dtu", name = "cancelFlightFaultElement")
    public JAXBElement<CancelFlightFaultType> createCancelFlightFaultElement(CancelFlightFaultType value) {
        return new JAXBElement<CancelFlightFaultType>(_CancelFlightFaultElement_QNAME, CancelFlightFaultType.class, null, value);
    }

}
