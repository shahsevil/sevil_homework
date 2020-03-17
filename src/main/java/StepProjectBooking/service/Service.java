package StepProjectBooking.service;

import StepProjectBooking.Helpers.FlightGenerator;
import StepProjectBooking.Helpers.Predicates;
import StepProjectBooking.dao.DAOBookingFileText;
import StepProjectBooking.dao.DAOFlightFileText;
import StepProjectBooking.entity.Booking;
import StepProjectBooking.entity.Flight;
import StepProjectBooking.entity.Passenger;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Service {
  DAOBookingFileText daoBooking;
  DAOFlightFileText daoFlight;

  public Service(DAOBookingFileText daoBooking, DAOFlightFileText daoFlight) {
    this.daoBooking = daoBooking;
    this.daoFlight = daoFlight;
  }

  public List<String> getAllFlights() {
    return daoFlight.getAllBy(Predicates.isSomeHoursBefore(24))
            .stream().map(Flight::represent).collect(Collectors.toList());
  }

  public String getFlightById(int flightId) {
    return daoFlight.get(flightId).map(Flight::represent)
            .orElse("No flight found");
  }

  public List<String> searchForBook(String dest, LocalDate date, int numOfPeople) {
    return daoFlight.getAllBy(Predicates.isBookable(dest, date, numOfPeople))
            .stream().map(Flight::represent).collect(Collectors.toList());
  }

  public void book(int flightId, List<Passenger> passengers) {
    daoBooking.create(new Booking(flightId, passengers));
    Optional<Flight> flightExtra = daoFlight.get(flightId);
    daoFlight.delete(flightId);
    flightExtra.ifPresent(f -> f.setFreeSpaces(f.getFreeSpaces() - passengers.size()));
    daoFlight.create(flightExtra.orElseThrow(RuntimeException::new));
  }

  public String cancelBooking(int bookingId) {
    return daoBooking.get(bookingId).map(b -> {
      Flight newFlight = daoFlight.get(b.getFlight_id()).orElseThrow(RuntimeException::new);
      newFlight.setFreeSpaces(newFlight.getFreeSpaces() + b.getPassengers().size());
      daoBooking.delete(bookingId);
      daoFlight.delete(b.getFlight_id());
      daoFlight.create(newFlight);
      return "Booking deleted.";
    }).orElse("There is no any booking.");
  }

  public List<String> getMyFlights(String name, String surname) {
    return daoBooking.getAllBy(Predicates.isMyFlight(name, surname))
            .stream().map(Booking::represent).collect(Collectors.toList());
  }

  public boolean getAll() {
    return daoFlight.getAll().size() == 0;
  }

  public void addFlight() {
    daoFlight.create(FlightGenerator.genFlight());
  }

  public String showMenu() {
    StringBuilder sb = new StringBuilder();
    return sb.append("1. Online - board\n")
            .append("2. Show the flight info\n")
            .append("3. Search and book a flight\n")
            .append("4. Cancel the booking\n")
            .append("5. My flights\n")
            .append("6. Exit\n")
            .append("7. End session")
            .toString();
  }
}
