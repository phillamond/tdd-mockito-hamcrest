package uk.co.pat.postman;

import uk.co.pat.postman.exception.InvalidRequestedBookingTimeException;
import uk.co.pat.postman.model.BookingRequest;
import uk.co.pat.postman.model.BookingResult;
import uk.co.pat.postman.service.BookingService;
import uk.co.pat.postman.service.ServiceCalendar;

/**
 * Created by plamond on 10/04/2014.
 */
public class SpecialDeliveryAPI {

    private ServiceCalendar serviceCalendar;
    private BookingService bookingService;

    public SpecialDeliveryAPI(ServiceCalendar serviceCalendar, BookingService bookingService) {
        this.serviceCalendar = serviceCalendar;
        this.bookingService = bookingService;
    }

    public BookingResult makeBooking(BookingRequest bookingRequest) throws InvalidRequestedBookingTimeException {
        serviceCalendar.checkBookingTime(bookingRequest.getRequestedTime());
        return bookingService.book(bookingRequest);
    }
}
