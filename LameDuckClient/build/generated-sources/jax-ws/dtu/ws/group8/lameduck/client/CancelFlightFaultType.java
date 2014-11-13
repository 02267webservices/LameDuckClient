
package dtu.ws.group8.lameduck.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for cancelFlightFaultType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cancelFlightFaultType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cancelFlightFaultMassage" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cancelFlightFaultType", propOrder = {
    "cancelFlightFaultMassage"
})
public class CancelFlightFaultType {

    @XmlElement(required = true)
    protected String cancelFlightFaultMassage;

    /**
     * Gets the value of the cancelFlightFaultMassage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCancelFlightFaultMassage() {
        return cancelFlightFaultMassage;
    }

    /**
     * Sets the value of the cancelFlightFaultMassage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCancelFlightFaultMassage(String value) {
        this.cancelFlightFaultMassage = value;
    }

}
