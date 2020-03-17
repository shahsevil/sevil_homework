package StepProjectBooking.entity;

import java.time.LocalDate;
import java.time.LocalTime;

public class Flight {
  private int id;
  private String dest;
  private LocalDate date;
  private LocalTime time;
  private int freeSpaces;

  public static int counter = 0;

  public Flight(String dest, LocalDate date, LocalTime time, int freeSpaces) {
    this.id = ++counter;
    this.dest = dest;
    this.date = date;
    this.time = time;
    this.freeSpaces = freeSpaces;
  }

  public Flight(int flightId, String dest, LocalDate date, LocalTime time, int freeSpaces) {
    this.id = flightId;
    this.dest = dest;
    this.date = date;
    this.time = time;
    this.freeSpaces = freeSpaces;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getDest() {
    return dest;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public LocalTime getTime() {
    return time;
  }

  public void setTime(LocalTime time) {
    this.time = time;
  }

  public int getFreeSpaces() {
    return freeSpaces;
  }

  public void setDest(String dest) {
    this.dest = dest;
  }

  public void setFreeSpaces(int freeSpaces) {
    this.freeSpaces = freeSpaces;
  }

  public String represent() {
    return String.format("%10d|%10s|%10s|%10s|%10d", id, dest, date, time, freeSpaces);
  }

  @Override
  public String toString() {
    return String.format("Flight{id=%d, dest='%s', date=%s, time=%s, freeSpaces=%d}", id, dest, date, time, freeSpaces);
  }

  public static Flight parse(String line) {
    String[] chunks = line.split("\\|");
    return new Flight(Integer.parseInt(chunks[0]), chunks[1], LocalDate.parse(chunks[2]),
            LocalTime.parse(chunks[3]), Integer.parseInt(chunks[4]));
  }
}
