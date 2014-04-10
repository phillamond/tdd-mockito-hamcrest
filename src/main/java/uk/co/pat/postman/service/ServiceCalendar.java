package uk.co.pat.postman.service;

import org.joda.time.DateTime;
import uk.co.pat.postman.exception.InvalidRequestedBookingTimeException;

/**
 * Created by plamond on 10/04/2014.
 */
public class ServiceCalendar {

    public void checkBookingTime(DateTime requestedTime) {
        int year = requestedTime.getYear();
        int month = requestedTime.getMonthOfYear();
        int dayOfMonth = requestedTime.getDayOfMonth();

        DateTime sevenAm = new DateTime().withDate(year, month, dayOfMonth).withTime(7, 0, 0, 0);
        DateTime nineAm = new DateTime().withDate(year, month, dayOfMonth).withTime(9, 0, 0, 0);
        if (requestedTime.toLocalDateTime().isAfter(sevenAm.toLocalDateTime()) &&
                requestedTime.toLocalDateTime().isBefore(nineAm.toLocalDateTime())) {
            throw new InvalidRequestedBookingTimeException("Between 7am and 9am");
        }

        DateTime twelvePm = new DateTime().withDate(year, month, dayOfMonth).withTime(12, 0, 0, 0);
        DateTime onePm = new DateTime().withDate(year, month, dayOfMonth).withTime(13, 0, 0, 0);
        if (requestedTime.toLocalDateTime().isAfter(twelvePm.toLocalDateTime()) &&
                requestedTime.toLocalDateTime().isBefore(onePm.toLocalDateTime())) {
            throw new InvalidRequestedBookingTimeException("Between 12pm and 1pm");
        }

        DateTime fourPm = new DateTime().withDate(year, month, dayOfMonth).withTime(16, 0, 0, 0);
        DateTime sevenAmNextDay = new DateTime().withDate(year, month, dayOfMonth + 1).withTime(7, 0, 0, 0);
        if (requestedTime.toLocalDateTime().isAfter(fourPm.toLocalDateTime()) &&
                requestedTime.toLocalDateTime().isBefore(sevenAmNextDay.toLocalDateTime())) {
            throw new InvalidRequestedBookingTimeException("Outside business hours");
        }
    }

}
