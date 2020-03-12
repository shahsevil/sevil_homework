package GroupBooking.entity;

import java.time.LocalDate;
import java.time.LocalTime;

public class Flight {
  private int id;
  private String destination;
  private LocalDate localDate;
  private LocalTime localTime;
  private int freespaces;
  public static int counter=0;

  public Flight(String destination, LocalDate localDate, LocalTime localTime, int freespaces) {
    this.id = ++counter;
    this.destination = destination;
    this.localDate = localDate;
    this.localTime = localTime;
    this.freespaces = freespaces;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getDestination() {
    return destination;
  }

  public void setDestination(String destination) {
    this.destination = destination;
  }

  public LocalDate getLocalDate() {
    return localDate;
  }

  public void setLocalDate(LocalDate localDate) {
    this.localDate = localDate;
  }

  public LocalTime getLocalTime() {
    return localTime;
  }

  public void setLocalTime(LocalTime localTime) {
    this.localTime = localTime;
  }

  public int getFreespaces() {
    return freespaces;
  }

  public void setFreespaces(int freespaces) {
    this.freespaces = freespaces;
  }

  public static int getCounter() {
    return counter;
  }

  public static void setCounter(int counter) {
    Flight.counter = counter;
  }

  public String represent() {
    return String.format("%d %s %s %s %d",id,destination,localDate,localTime,freespaces);
  }

}
