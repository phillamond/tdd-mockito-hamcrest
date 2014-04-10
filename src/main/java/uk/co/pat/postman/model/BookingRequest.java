package uk.co.pat.postman.model;

import org.joda.time.DateTime;

/**
 * Created by plamond on 10/04/2014.
 */
public class BookingRequest {
    private DateTime requestedTime;

    public BookingRequest(String name, String address, DateTime requestedBookingTime) {
    }

    public DateTime getRequestedTime() {
        return requestedTime;
    }
}
