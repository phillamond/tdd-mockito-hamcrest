package uk.co.pat.postman.model;

/**
 * Created by plamond on 10/04/2014.
 */
public class BookingResult {
    private final String name;
    private final String address;

    public BookingResult(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public boolean isSuccessful() {
        return false;
    }
}
