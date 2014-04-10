package uk.co.pat.postman;

import uk.co.pat.postman.model.BookingRequest;
import uk.co.pat.postman.model.BookingResult;
import uk.co.pat.postman.service.ServiceCalendar;

/**
 * Created by plamond on 10/04/2014.
 */
public class SpecialDeliveryAPI {

    private ServiceCalendar serviceCalendar;

    public SpecialDeliveryAPI(ServiceCalendar serviceCalendar) {
        this.serviceCalendar = serviceCalendar;
    }

    public BookingResult makeBooking(BookingRequest bookingRequest) {
        return new BookingResult();
    }
}
