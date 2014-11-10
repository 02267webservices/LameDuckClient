
package dtu.ws.group8.lameduck.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for flightInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="flightInfoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="flightBookingNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="flightPrice" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="flightReservationService" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="flightInfo" type="{http://types.lameduck.group8.ws.dtu}flightDetails"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "flightInfoType", propOrder = {
    "flightBookingNumber",
    "flightPrice",
    "flightReservationService",
    "flightInfo"
})
public class FlightInfoType {

    @XmlElement(required = true)
    protected String flightBookingNumber;
    protected double flightPrice;
    @XmlElement(required = true)
    protected String flightReservationService;
    @XmlElement(required = true)
    protected FlightDetails flightInfo;

    /**
     * Gets the value of the flightBookingNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlightBookingNumber() {
        return flightBookingNumber;
    }

    /**
     * Sets the value of the flightBookingNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlightBookingNumber(String value) {
        this.flightBookingNumber = value;
    }

    /**
     * Gets the value of the flightPrice property.
     * 
     */
    public double getFlightPrice() {
        return flightPrice;
    }

    /**
     * Sets the value of the flightPrice property.
     * 
     */
    public void setFlightPrice(double value) {
        this.flightPrice = value;
    }

    /**
     * Gets the value of the flightReservationService property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlightReservationService() {
        return flightReservationService;
    }

    /**
     * Sets the value of the flightReservationService property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlightReservationService(String value) {
        this.flightReservationService = value;
    }

    /**
     * Gets the value of the flightInfo property.
     * 
     * @return
     *     possible object is
     *     {@link FlightDetails }
     *     
     */
    public FlightDetails getFlightInfo() {
        return flightInfo;
    }

    /**
     * Sets the value of the flightInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link FlightDetails }
     *     
     */
    public void setFlightInfo(FlightDetails value) {
        this.flightInfo = value;
    }

}
