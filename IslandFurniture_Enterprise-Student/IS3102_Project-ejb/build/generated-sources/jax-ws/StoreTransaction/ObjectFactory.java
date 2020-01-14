
package StoreTransaction;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the StoreTransaction package. 
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

    private final static QName _CreateSalesRecordResponse_QNAME = new QName("http://SalesRecording.OperationalCRM/", "createSalesRecordResponse");
    private final static QName _CreateSalesRecord_QNAME = new QName("http://SalesRecording.OperationalCRM/", "createSalesRecord");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: StoreTransaction
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreateSalesRecordResponse }
     * 
     */
    public CreateSalesRecordResponse createCreateSalesRecordResponse() {
        return new CreateSalesRecordResponse();
    }

    /**
     * Create an instance of {@link CreateSalesRecord }
     * 
     */
    public CreateSalesRecord createCreateSalesRecord() {
        return new CreateSalesRecord();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateSalesRecordResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://SalesRecording.OperationalCRM/", name = "createSalesRecordResponse")
    public JAXBElement<CreateSalesRecordResponse> createCreateSalesRecordResponse(CreateSalesRecordResponse value) {
        return new JAXBElement<CreateSalesRecordResponse>(_CreateSalesRecordResponse_QNAME, CreateSalesRecordResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateSalesRecord }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://SalesRecording.OperationalCRM/", name = "createSalesRecord")
    public JAXBElement<CreateSalesRecord> createCreateSalesRecord(CreateSalesRecord value) {
        return new JAXBElement<CreateSalesRecord>(_CreateSalesRecord_QNAME, CreateSalesRecord.class, null, value);
    }

}
