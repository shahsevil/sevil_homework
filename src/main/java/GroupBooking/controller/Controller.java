package GroupBooking.controller;


import GroupBooking.io.Console;
import GroupBooking.io.ConsoleMain;
import GroupBooking.service.Service;

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

  public void search() {
    console.readLn();
  }

  public void book() {
    console.printLn("");
  }
}
