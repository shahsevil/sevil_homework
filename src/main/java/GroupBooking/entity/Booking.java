package GroupBooking.entity;

import java.util.List;

public class Booking {
  private int bookingId;
  private int flightId;
  List<Passenger> passengerList;

  public static int counter=0;

  public Booking(int flightId, List<Passenger> passengerList) {
    this.bookingId=++counter;
    this.flightId = flightId;
    this.passengerList = passengerList;
  }

  public int getBookingId() {
    return bookingId;
  }

  public void setBookingId(int bookingId) {
    this.bookingId = bookingId;
  }

  public int getFlightId() {
    return flightId;
  }

  public void setFlightId(int flightId) {
    this.flightId = flightId;
  }

  public List<Passenger> getPassengerList() {
    return passengerList;
  }

  public void setPassengerList(List<Passenger> passengerList) {
    this.passengerList = passengerList;
  }

  public static int getCounter() {
    return counter;
  }

  public static void setCounter(int counter) {
    Booking.counter = counter;
  }

  @Override
  public String toString() {
    return String.format("Booking{bookingId=%d, flightId=%d, passengerList=%s}",
            bookingId, flightId, passengerList);
  }
}
