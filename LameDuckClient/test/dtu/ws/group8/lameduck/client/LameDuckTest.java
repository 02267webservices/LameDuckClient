/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dtu.ws.group8.lameduck.client;

import dtu.ws.group8.lameduck.client.LameDuckWSDLPortType;
import dtu.ws.group8.lameduck.client.LameDuckService;
import dtu.ws.group8.lameduck.client.FlightInfoListType;
import dtu.ws.group8.lameduck.client.FlightInfoType;
import dtu.ws.group8.lameduck.client.GetFlightRequestType;
import dtu.ws.group8.lameduck.client.BookFlightRequestType;
import dtu.ws.group8.lameduck.client.CancelFlightRequestType;
import dtu.ws.group8.lameduck.client.BookFlightFault;
import dtu.ws.group8.lameduck.client.CancelFlightFault;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gravr
 */
public class LameDuckTest {
    
    
    @Test
    public void testGetFlights() throws DatatypeConfigurationException {

        LameDuckService service = new LameDuckService();
             
        LameDuckWSDLPortType port = service.getLameDuckPort();
             
        GetFlightRequestType input = new GetFlightRequestType();
        input.setFlightStartAirport("Copenhagen");
        input.setFlightDestinationAirport("Berlin");

        DatatypeFactory df = DatatypeFactory.newInstance();
        XMLGregorianCalendar dateFlight = df.newXMLGregorianCalendar("2015-01-01");
        input.setFlightDate(dateFlight);
             
        FlightInfoListType result = port.getFlights(input);
        System.out.println("Size of result: " +result.getFlightInformation().size());
        
        
        FlightInfoType myResultToPrint = result.getFlightInformation().get(0);
        
        
        System.out.println(myResultToPrint.getFlightReservationService()+ "\n" +
                           myResultToPrint.getFlightBookingNumber()+ "\n" +
                           Double.toString(myResultToPrint.getFlightPrice()) + "\n" +
                           myResultToPrint.getFlightInfo().getCarrierName() + "\n" +
                           myResultToPrint.getFlightInfo().getDestinationAirport() + "\n" +
                           myResultToPrint.getFlightInfo().getStartAirport());
    
    }
    
    @Test
    public void testBookFlight() throws BookFlightFault {

        LameDuckService service = new LameDuckService();
        LameDuckWSDLPortType port = service.getLameDuckPort();
             
        BookFlightRequestType input = new BookFlightRequestType();
        input.setFlightBookingNumber("ABC1234");
             
        
        try {
            boolean result = port.bookFlight(input);
            System.out.println("True if booked: " +result);
            assertTrue(result);
        }catch (BookFlightFault ex){
            System.out.println(ex.getFaultInfo().getBookFlightFaultMessage());
        }
    }
    
    @Test
    public void testCancelFlight() throws CancelFlightFault {

        LameDuckService service = new LameDuckService();
        LameDuckWSDLPortType port = service.getLameDuckPort();
             
        CancelFlightRequestType input = new CancelFlightRequestType();
        input.setFlightBookingNumber("ABC1234");
             
        
        try {
            boolean result = port.cancelFlight(input);
            System.out.println("True if booking was succesful cancelled: " +result);
            assertTrue(result);
        }catch (CancelFlightFault ex){
            System.out.println(ex.getFaultInfo().getCancelFlightFaultMassage());
        }
    }
    
    
    /*
    private static FlightInfoListType lameDuck(dtu.ws.group8.lameduck.types.GetFlightRequestType input) {
        dtu.ws.group8.lameduck.LameDuckService service = new dtu.ws.group8.lameduck.LameDuckService();
        dtu.ws.group8.lameduck.LameDuckPortType port = service.getLameDuckPort();
        return port.lameDuck(input);
    }
   */
    
    
}