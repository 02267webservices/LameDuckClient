/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dtu.ws.group8.lameduck.client;

import dtu.ws.group8.lameduck.LameDuckPortType;
import dtu.ws.group8.lameduck.LameDuckService;
import dtu.ws.group8.lameduck.types.FlightInfoListType;
import dtu.ws.group8.lameduck.types.FlightInfoType;
import dtu.ws.group8.lameduck.types.GetFlightRequestType;
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
             
        LameDuckPortType port = service.getLameDuckPort();
             
        // TODO initialize WS operation arguments here
             
        GetFlightRequestType input = new GetFlightRequestType();
        input.setFlightStartAirport("Copenhagen");
        input.setFlightDestinationAirport("Berlin");

        DatatypeFactory df = DatatypeFactory.newInstance();
        XMLGregorianCalendar dateFlight = df.newXMLGregorianCalendar("2015-01-01");
        input.setFlightDate(dateFlight);
             
        // TODO process result here
             
        FlightInfoListType result = port.lameDuck(input);
        System.out.println("Size of result: " +result.getFlightInformation().size());
        
        
        FlightInfoType myResultToPrint = result.getFlightInformation().get(0);
        
        
        System.out.println(myResultToPrint.getFlightReservationService()+ "\n" +
                           myResultToPrint.getFlightBookingNumber()+ "\n" +
                           Double.toString(myResultToPrint.getFlightPrice()) + "\n" +
                           myResultToPrint.getFlightInfo().getCarrierName() + "\n" +
                           myResultToPrint.getFlightInfo().getDestinationAirport() + "\n" +
                           myResultToPrint.getFlightInfo().getStartAirport());
    
     
        //FlightInfoType result2 = lameDuck(input).getFlightInformation().get(0);
        
    
    }
    
    
    
    
    /*
    @Test
    public void testGetFlights() throws DatatypeConfigurationException {
        GetFlightRequestType input = new GetFlightRequestType();
        input.setFlightStartAirport("Copenhagen");
        input.setFlightDestinationAirport("Berlin");

        DatatypeFactory df = DatatypeFactory.newInstance();
        XMLGregorianCalendar dateFlight = df.newXMLGregorianCalendar("2015-01-01");
        input.setFlightDate(dateFlight);
    
    }
    */
    
   
    
    private static FlightInfoListType lameDuck(dtu.ws.group8.lameduck.types.GetFlightRequestType input) {
        dtu.ws.group8.lameduck.LameDuckService service = new dtu.ws.group8.lameduck.LameDuckService();
        dtu.ws.group8.lameduck.LameDuckPortType port = service.getLameDuckPort();
        return port.lameDuck(input);
    }
   
    
    
}