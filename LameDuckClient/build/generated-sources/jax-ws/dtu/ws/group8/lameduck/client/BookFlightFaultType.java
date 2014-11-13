
package dtu.ws.group8.lameduck.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for bookFlightFaultType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="bookFlightFaultType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bookFlightFaultMessage" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bookFlightFaultType", propOrder = {
    "bookFlightFaultMessage"
})
public class BookFlightFaultType {

    @XmlElement(required = true)
    protected String bookFlightFaultMessage;

    /**
     * Gets the value of the bookFlightFaultMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBookFlightFaultMessage() {
        return bookFlightFaultMessage;
    }

    /**
     * Sets the value of the bookFlightFaultMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBookFlightFaultMessage(String value) {
        this.bookFlightFaultMessage = value;
    }

}
