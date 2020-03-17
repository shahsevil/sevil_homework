package StepProjectBooking.controller;

import StepProjectBooking.entity.Passenger;
import StepProjectBooking.io.Console;
import StepProjectBooking.io.ConsoleMain;
import StepProjectBooking.service.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    Service service;
    Console console;

    public Controller(ConsoleMain console, Service service) {
        this.service = service;
        this.console = console;
    }

    public String show() {
        return String.join("\n", service.getAllFlights());
    }

    public String search() {
            console.print("Enter flight id: ");
            return service.getFlightById(Integer.parseInt(console.readLn()));

    }

    public String searchForBook(String dest, LocalDate date, int numOfPeople) {
            return String.join("\n", service.searchForBook(dest.toLowerCase(), date, numOfPeople));
    }

    public void book(String flightId, int numOfPeople) {
        List<Passenger> passengers = new ArrayList<>();
        while (numOfPeople-- > 0) {
            console.print("Enter name: ");
            String name = console.readLn();
            console.print("Enter surname: ");
            String surname = console.readLn();
            passengers.add(new Passenger(name, surname));
        }
        service.book(Integer.parseInt(flightId), passengers);
    }

    public String cancelBooking() {
           console.print("Enter booking id: ");
        return service.cancelBooking(Integer.parseInt(console.readLn()));
    }

    public String getMyFlights() {
        console.print("Enter name: ");
        String name = console.readLn();
        console.print("Enter surname: ");
        String surname = console.readLn();
        return String.join("\n", service.getMyFlights(name.toLowerCase().trim(), surname.toLowerCase().trim()));
    }

    public void addFlight() {
        service.addFlight();
    }

    public boolean getAll() {
        return service.getAll();
    }

    public String showMenu() {
        return service.showMenu();
    }
}
