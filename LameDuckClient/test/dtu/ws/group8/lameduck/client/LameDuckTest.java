/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dtu.ws.group8.lameduck.client;

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
    public void testGetFlights() {

        GetFlightRequestType input = new GetFlightRequestType();
        input.setFlightStartAirport("Copenhagen");
        input.setFlightDestinationAirport("Berlin");

        try {
            DatatypeFactory df = DatatypeFactory.newInstance();
            XMLGregorianCalendar dateFlight = df.newXMLGregorianCalendar("2015-01-01");
            input.setFlightDate(dateFlight);
        }catch (Exception ex) {
        }
        
        FlightInfoListType result = getFlights(input);
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

        BookFlightRequestType input = new BookFlightRequestType();
        input.setFlightBookingNumber("ABC1234");        
        input.setCreditCardInfo(getCardInfo());
             
        try {
            boolean result = bookFlight(input);
            System.out.println("True if booked: " +result);
            assertTrue(result);
        }catch (BookFlightFault ex){
            System.out.println(ex.getFaultInfo().getBookFlightFaultMessage());
        }
    } 
    
    @Test
    public void testCancelFlight() throws CancelFlightFault {

        CancelFlightRequestType input = new CancelFlightRequestType();
        input.setFlightBookingNumber("ABC1234");
        input.setCreditCardInfo(getCardInfo());
        
        try {
            boolean result = cancelFlight(input);
            System.out.println("True if booking was succesful cancelled: " +result);
            assertTrue(result);
        }catch (CancelFlightFault ex){
            System.out.println(ex.getFaultInfo().getCancelFlightFaultMassage());
        }
    }
    
    private CreditCardInfoType getCardInfo() {
        CreditCardInfoType cardInfo = new CreditCardInfoType();
        cardInfo.setCardNumber("50408825");
        cardInfo.setName("Thor-Jensen Claus");
        
        try {
            DatatypeFactory df = DatatypeFactory.newInstance();
            XMLGregorianCalendar expDate = df.newXMLGregorianCalendar("2009-05-05");
            cardInfo.setExpiryDate(expDate);
        }catch (Exception ex) {
        }
        return cardInfo;
    } 
    
    //Webservice stubs
    private static FlightInfoListType getFlights(dtu.ws.group8.lameduck.client.GetFlightRequestType input) {
        dtu.ws.group8.lameduck.client.LameDuckService service = new dtu.ws.group8.lameduck.client.LameDuckService();
        dtu.ws.group8.lameduck.client.LameDuckWSDLPortType port = service.getLameDuckPort();
        return port.getFlights(input);
    }

    private static boolean bookFlight(dtu.ws.group8.lameduck.client.BookFlightRequestType input) throws BookFlightFault {
        dtu.ws.group8.lameduck.client.LameDuckService service = new dtu.ws.group8.lameduck.client.LameDuckService();
        dtu.ws.group8.lameduck.client.LameDuckWSDLPortType port = service.getLameDuckPort();
        return port.bookFlight(input);
    }

    private static boolean cancelFlight(dtu.ws.group8.lameduck.client.CancelFlightRequestType input) throws CancelFlightFault {
        dtu.ws.group8.lameduck.client.LameDuckService service = new dtu.ws.group8.lameduck.client.LameDuckService();
        dtu.ws.group8.lameduck.client.LameDuckWSDLPortType port = service.getLameDuckPort();
        return port.cancelFlight(input);
    }
     
    
}