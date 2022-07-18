package ConcurrencyExample;

import ConcurrencyExample.Exception.SeatNotAvailableException;
import java.util.Arrays;

public abstract class Flight implements FlightBooking{

  private final String flightNumber;
  private int totalSeats;
  private int[] bookedSeats;
  private final int[] availableSeats;

  public Flight(String flightNumber, int totalSeats) {
    this.flightNumber = flightNumber;
    this.totalSeats = totalSeats;
    this.bookedSeats = new int[totalSeats];
    this.availableSeats = new int[totalSeats];
    for (int i = 0; i < totalSeats; i++) {
      this.availableSeats[i] = i + 1;
    }
  }

  /**
   * @param flight
   * @param seatNumber
   * @throws SeatNotAvailableException
   */
  public synchronized void bookFlight(Flight flight, int seatNumber)
      throws SeatNotAvailableException {

    System.out.println(
        "Thread " + Thread.currentThread().getName() + " is booking seat " + seatNumber
            + " for flight " + flight.getFlightNumber());

    try {
      Thread.sleep((long) (Math.random() * 5000));
    } catch (Exception e) {
      System.out.println(e);
    }

    if (seatNumber > totalSeats || seatNumber < 1) {
      throw new SeatNotAvailableException("Seat number is not available");
    }

    if (!isSeatAvailable(seatNumber)) {
      this.availableSeats[seatNumber - 1] = 0;
      this.bookedSeats[seatNumber - 1] = seatNumber;
      System.out.println(
          "Seat " + seatNumber + " is booked by thread " + Thread.currentThread().getName()
              + " for flight " + flight.getFlightNumber());
    } else {
      throw new SeatNotAvailableException(
          "Seat " + seatNumber + " is not available for thread " + Thread.currentThread()
              .getName());
    }
  }

  private boolean isSeatAvailable(int seatNumber) {
    return this.availableSeats[seatNumber - 1] == 0;
  }

  public String getFlightNumber() {
    return flightNumber;
  }

  public void setTotalSeats(int totalSeats) {
    this.totalSeats = totalSeats;
  }

  public int[] getBookedSeats() {
    return bookedSeats;
  }

  public void setBookedSeats(int[] bookedSeats) {
    this.bookedSeats = bookedSeats;
  }

  public int[] getAvailableSeats() {
    return availableSeats;
  }

  public int getTotalSeats() {
    return totalSeats;
  }
}