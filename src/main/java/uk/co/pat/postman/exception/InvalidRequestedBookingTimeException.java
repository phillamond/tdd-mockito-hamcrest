package uk.co.pat.postman.exception;

/**
 * Created by plamond on 10/04/2014.
 */
public class InvalidRequestedBookingTimeException extends RuntimeException {
    public InvalidRequestedBookingTimeException() {
        super("Invalid request booking time");
    }

    public InvalidRequestedBookingTimeException(String msg) {
        super("Invalid request booking time, " + msg);
    }
}
