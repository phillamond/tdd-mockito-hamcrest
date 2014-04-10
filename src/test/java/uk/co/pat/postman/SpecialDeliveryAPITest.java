package uk.co.pat.postman;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import uk.co.pat.postman.exception.InvalidRequestedBookingTimeException;
import uk.co.pat.postman.model.BookingRequest;
import uk.co.pat.postman.model.BookingResult;
import uk.co.pat.postman.service.BookingService;
import uk.co.pat.postman.service.ServiceCalendar;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willThrow;
import static org.mockito.Matchers.any;
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

    private String name;
    private String address;

    @Before
    public void setUp() {
        specialDeliveryAPI = new SpecialDeliveryAPI(serviceCalendar, bookingService);
        name = "Mrs Bobbins";
        address = "26 Valley Road, Greendale";
    }

    @Test
    public void shouldAcceptBookingsAtOperationalTimes() {
        DateTime requestedTime = new DateTime().withDate(2014, 4, 12).withTime(14, 0, 0, 0);
        BookingRequest bookingRequest = new BookingRequest(name, address, requestedTime);
        BookingResult expectedBookingResult = new BookingResult(name, address);
        given(bookingService.book(bookingRequest)).willReturn(expectedBookingResult);

        BookingResult bookingResult = specialDeliveryAPI.makeBooking(bookingRequest);

        verify(serviceCalendar, times(1)).checkBookingTime(any(DateTime.class));
        verify(bookingService, times(1)).book(bookingRequest);
        assertThat(bookingResult, is(sameInstance(expectedBookingResult)));
    }

    @Test(expected = InvalidRequestedBookingTimeException.class)
    public void shouldPropogateCustomExceptionForBadBookingTime() {
        DateTime requestedTime = new DateTime().withDate(2014, 4, 12).withTime(8, 0, 0, 0);
        willThrow(InvalidRequestedBookingTimeException.class).given(serviceCalendar).checkBookingTime(any(DateTime.class));

        specialDeliveryAPI.makeBooking(new BookingRequest(name, address, requestedTime));
    }

}
