
package dtu.ws.group8.lameduck.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for getFlightRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getFlightRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="flightStartAirport" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="flightDestinationAirport" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="flightDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getFlightRequestType", propOrder = {
    "flightStartAirport",
    "flightDestinationAirport",
    "flightDate"
})
public class GetFlightRequestType {

    @XmlElement(required = true)
    protected String flightStartAirport;
    @XmlElement(required = true)
    protected String flightDestinationAirport;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar flightDate;

    /**
     * Gets the value of the flightStartAirport property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlightStartAirport() {
        return flightStartAirport;
    }

    /**
     * Sets the value of the flightStartAirport property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlightStartAirport(String value) {
        this.flightStartAirport = value;
    }

    /**
     * Gets the value of the flightDestinationAirport property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlightDestinationAirport() {
        return flightDestinationAirport;
    }

    /**
     * Sets the value of the flightDestinationAirport property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlightDestinationAirport(String value) {
        this.flightDestinationAirport = value;
    }

    /**
     * Gets the value of the flightDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFlightDate() {
        return flightDate;
    }

    /**
     * Sets the value of the flightDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFlightDate(XMLGregorianCalendar value) {
        this.flightDate = value;
    }

}
