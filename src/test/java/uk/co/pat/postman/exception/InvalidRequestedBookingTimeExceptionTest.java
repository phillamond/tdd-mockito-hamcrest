package uk.co.pat.postman.exception;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by plamond on 10/04/2014.
 */
public class InvalidRequestedBookingTimeExceptionTest {

    @Test
    public void shouldHaveCorrectDefaultMessage() {
        try {
            throw new InvalidRequestedBookingTimeException();
        } catch (InvalidRequestedBookingTimeException e) {
            assertThat(e.getMessage(), is("Invalid request booking time"));
        }
    }

    @Test
    public void shouldHaveCorrectCustomMessage() {
        try {
            throw new InvalidRequestedBookingTimeException("calling client message");
        } catch (InvalidRequestedBookingTimeException e) {
            assertThat(e.getMessage(), is("Invalid request booking time, calling client message"));
        }
    }

}
