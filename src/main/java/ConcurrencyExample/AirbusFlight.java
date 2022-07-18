package ConcurrencyExample;

import ConcurrencyExample.Exception.SeatNotAvailableException;

public class AirbusFlight extends Flight {

  public AirbusFlight(String flightNumber, int totalSeats) {
    super(flightNumber, totalSeats);
  }

  @Override
  public void bookFlight(Flight flight, int seatNumber) {
    try {
      super.bookFlight(flight, seatNumber);
    } catch (SeatNotAvailableException e) {
      System.out.println(e.getMessage());
    }
  }
}