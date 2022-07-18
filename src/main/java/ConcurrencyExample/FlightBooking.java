package ConcurrencyExample;

import ConcurrencyExample.Exception.SeatNotAvailableException;

public interface FlightBooking {

    public void bookFlight(Flight flight, int seatNumber) throws SeatNotAvailableException;

}
