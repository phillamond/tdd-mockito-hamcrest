package uk.co.pat.postman;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import uk.co.pat.postman.model.BookingRequest;
import uk.co.pat.postman.model.BookingResult;
import uk.co.pat.postman.service.BookingService;
import uk.co.pat.postman.service.ServiceCalendar;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by plamond on 10/04/2014.
 */
@RunWith(MockitoJUnitRunner.class)
public class SpecialDeliveryAPITest {

    private SpecialDeliveryAPI specialDeliveryAPI;

    @Mock
    private ServiceCalendar serviceCalendar;

    @Mock
    private BookingService bookingService;

    @Before
    public void setUp() {
        specialDeliveryAPI = new SpecialDeliveryAPI(serviceCalendar);
    }

    @Test
    public void shouldAcceptBookingsAtOperationalTimes() {
        DateTime requestedTime = new DateTime().withDate(2014, 4, 12).withTime(14, 0, 0, 0);
        BookingRequest bookingRequest = new BookingRequest(
                "Mrs Bobbins",
                "26 Valley Road, Greendale",
                requestedTime
        );
        given(serviceCalendar.checkBookingTime(requestedTime)).willReturn(true);
        given(bookingService.book(bookingRequest)).willReturn(true);

        BookingResult bookingResult = specialDeliveryAPI.makeBooking(bookingRequest);

        verify(serviceCalendar, times(1)).checkBookingTime(requestedTime);
        verify(bookingService.book(bookingRequest));
        assertThat(bookingResult.isSuccessful(), is(true));
    }

}
