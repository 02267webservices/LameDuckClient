/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dtu.ws.group8.lameduck.client;

import java.util.List;
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
    public void lameDuckServiceTesting() {
    
        //Testing getFlights
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
        
        List<FlightInfoType> flightsInfo = result.getFlightInformation();
        
        System.out.println("Size of result: " +result.getFlightInformation().size());
        
        
        if (!flightsInfo.isEmpty()){
            for (int i = 0; i < flightsInfo.size(); i++) {
		System.out.println(flightsInfo.get(i).getFlightReservationService()+ "\n" +
                           flightsInfo.get(i).getFlightBookingNumber()+ "\n" +
                           Double.toString(flightsInfo.get(i).getFlightPrice()) + "\n" +
                           flightsInfo.get(i).getFlightInfo().getCarrierName() + "\n" +
                           flightsInfo.get(i).getFlightInfo().getDestinationAirport() + "\n" +
                           flightsInfo.get(i).getFlightInfo().getStartAirport());
            }
        }
        
        //Testing bookFlight
        BookFlightRequestType bookFlightInput = new BookFlightRequestType();
        bookFlightInput.setFlightBookingNumber("ABC1234");        
        bookFlightInput.setCreditCardInfo(getCardInfo());
             
        try {
            boolean bookFlightResult = bookFlight(bookFlightInput);
            System.out.println("True if booked: " +bookFlightResult);
            assertTrue(bookFlightResult);
        }catch (BookFlightFault ex){
            System.out.println("Booking failed with message: " +ex.getMessage());
        }
        
        //Testing cancelFlight
        
        CancelFlightRequestType cancelFlightInput = new CancelFlightRequestType();
        cancelFlightInput.setFlightBookingNumber("ABC1234");
        cancelFlightInput.setCreditCardInfo(getCardInfo());
        
        try {
            boolean cancelFlightInputResult = cancelFlight(cancelFlightInput);
            System.out.println("True if booking was succesful cancelled: " +cancelFlightInputResult);
            assertTrue(cancelFlightInputResult);
        }catch (CancelFlightFault ex){
            System.out.println("Cancellation failed with message: " +ex.getMessage());
        }
        
    }
    
    /*
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
        
        List<FlightInfoType> flightsInfo = result.getFlightInformation();
        
        System.out.println("Size of result: " +result.getFlightInformation().size());
        
        
        if (!flightsInfo.isEmpty()){
            for (int i = 0; i < flightsInfo.size(); i++) {
		System.out.println(flightsInfo.get(i).getFlightReservationService()+ "\n" +
                           flightsInfo.get(i).getFlightBookingNumber()+ "\n" +
                           Double.toString(flightsInfo.get(i).getFlightPrice()) + "\n" +
                           flightsInfo.get(i).getFlightInfo().getCarrierName() + "\n" +
                           flightsInfo.get(i).getFlightInfo().getDestinationAirport() + "\n" +
                           flightsInfo.get(i).getFlightInfo().getStartAirport());
            }
            
            
        }
        
        
    
    }
    
    @Test
    public void testBookFlight() throws BookFlightFault {

        BookFlightRequestType input = new BookFlightRequestType();
        input.setFlightBookingNumber("ABC12341");        
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
    */
    
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