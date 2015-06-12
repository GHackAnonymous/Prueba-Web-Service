
package Mesaje;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the Mesaje package. 
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

    private final static QName _Hello_QNAME = new QName("http://Mensaje/", "hello");
    private final static QName _Operation_QNAME = new QName("http://Mensaje/", "operation");
    private final static QName _OperacionBDResponse_QNAME = new QName("http://Mensaje/", "OperacionBDResponse");
    private final static QName _HelloResponse_QNAME = new QName("http://Mensaje/", "helloResponse");
    private final static QName _OperacionBD_QNAME = new QName("http://Mensaje/", "OperacionBD");
    private final static QName _OperationResponse_QNAME = new QName("http://Mensaje/", "operationResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: Mesaje
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link Operation }
     * 
     */
    public Operation createOperation() {
        return new Operation();
    }

    /**
     * Create an instance of {@link OperacionBDResponse }
     * 
     */
    public OperacionBDResponse createOperacionBDResponse() {
        return new OperacionBDResponse();
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link OperationResponse }
     * 
     */
    public OperationResponse createOperationResponse() {
        return new OperationResponse();
    }

    /**
     * Create an instance of {@link OperacionBD }
     * 
     */
    public OperacionBD createOperacionBD() {
        return new OperacionBD();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Mensaje/", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Operation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Mensaje/", name = "operation")
    public JAXBElement<Operation> createOperation(Operation value) {
        return new JAXBElement<Operation>(_Operation_QNAME, Operation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperacionBDResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Mensaje/", name = "OperacionBDResponse")
    public JAXBElement<OperacionBDResponse> createOperacionBDResponse(OperacionBDResponse value) {
        return new JAXBElement<OperacionBDResponse>(_OperacionBDResponse_QNAME, OperacionBDResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Mensaje/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperacionBD }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Mensaje/", name = "OperacionBD")
    public JAXBElement<OperacionBD> createOperacionBD(OperacionBD value) {
        return new JAXBElement<OperacionBD>(_OperacionBD_QNAME, OperacionBD.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Mensaje/", name = "operationResponse")
    public JAXBElement<OperationResponse> createOperationResponse(OperationResponse value) {
        return new JAXBElement<OperationResponse>(_OperationResponse_QNAME, OperationResponse.class, null, value);
    }

}
