package uk.co.pat.postman.service;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import uk.co.pat.postman.exception.InvalidRequestedBookingTimeException;

/**
 * Created by plamond on 10/04/2014.
 */
@RunWith(MockitoJUnitRunner.class)
public class ServiceCalendarTest {

    private ServiceCalendar serviceCalendar;

    @Before
    public void setUp() {
        serviceCalendar = new ServiceCalendar();
    }

    @Test(expected = InvalidRequestedBookingTimeException.class)
    public void shouldThrowCustomExceptionForInvalidMorningPeriod() {
        serviceCalendar.checkBookingTime(new DateTime().withDate(2014,4,12).withTime(8,30,0,0));
    }

    @Test(expected = InvalidRequestedBookingTimeException.class)
    public void shouldThrowCustomExceptionForInvalidAfternoonPeriod() {
        serviceCalendar.checkBookingTime(new DateTime().withDate(2014,4,12).withTime(12,01,0,0));
    }

    @Test(expected = InvalidRequestedBookingTimeException.class)
    public void shouldThrowCustomExceptionForOutOfHoursPeriod() {
        serviceCalendar.checkBookingTime(new DateTime().withDate(2014,4,12).withTime(20,30,0,0));
    }

}
