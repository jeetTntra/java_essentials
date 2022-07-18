package ConcurrencyExample;

import ConcurrencyExample.Exception.SeatNotAvailableException;

public class Main {

  public static void main(String[] args) {
    Flight airbusFlight = new AirbusFlight("AA123", 10);

    Thread thread1 = new Thread(() -> {
      try {
        airbusFlight.bookFlight(airbusFlight, 6);
      } catch (SeatNotAvailableException e) {
        System.out.println(e.getMessage());
      }
    });

    Thread thread2 = new Thread(() -> {
      try {
        airbusFlight.bookFlight(airbusFlight, 6);
      } catch (SeatNotAvailableException e) {
        System.out.println(e.getMessage());
      }
    });

    Thread thread3 = new Thread(() -> {
      try {
        airbusFlight.bookFlight(airbusFlight, 6);
      } catch (SeatNotAvailableException e) {
        System.out.println(e.getMessage());
      }
    });

    thread2.setName("C2");
    thread1.setName("C1");
    thread3.setName("C3");

    thread1.start();
    thread2.start();
    thread3.start();
  }
}
