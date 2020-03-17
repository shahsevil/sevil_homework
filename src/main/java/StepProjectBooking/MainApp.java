package StepProjectBooking;

import StepProjectBooking.Exceptions.FlightNotCancelledException;
import StepProjectBooking.Exceptions.FlightNotFoundException;
import StepProjectBooking.Exceptions.UserFlightsNotFound;
import StepProjectBooking.User.User;
import StepProjectBooking.User.UserController;
import StepProjectBooking.controller.Controller;
import StepProjectBooking.dao.DAOBookingFileText;
import StepProjectBooking.dao.DAOFlightFileText;
import StepProjectBooking.io.ConsoleMain;
import StepProjectBooking.service.Service;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class MainApp {
    public static void main(String[] args) throws IOException {

        ConsoleMain console = new ConsoleMain();
        DAOBookingFileText daoBooking = new DAOBookingFileText("booking.txt");
        DAOFlightFileText daoFlight = new DAOFlightFileText("flight.txt");
        Service service = new Service(daoBooking, daoFlight);
        Controller controller = new Controller(console, service);

        if (controller.getAll()) {
            int i = 0;
            while (i++ < 50) {
                controller.addFlight();
            }
        }

        login();

        boolean cont = true;
        while (cont) {
            console.printLn(controller.showMenu());
            console.print("Enter menu num: \n");
            String input = console.readLn();
            switch (input) {
                case "1":
                    console.printLn(controller.show());
                    break;
                case "2":
                    try {
                        console.printLn(controller.search());
                    } catch (FlightNotFoundException ex) {
                        console.printLn("No flight found...");
                    }
                    break;
                case "3":
                    console.printLn("Enter destination: ");
                    String dest = console.readLn();
                    LocalDate date = null;
                    try {
                        console.printLn("Enter date (YYYY-MM-DD): ");
                        date = LocalDate.parse(console.readLn());
                    } catch (DateTimeParseException ex) {
                        console.printLn("Be sure you entering valid date...");
                        console.printLn(controller.showMenu());
                    }
                    console.printLn("Enter number of people: ");
                    int numOfPeople = Integer.parseInt(console.readLn());
                    console.print("\n");
                    if (controller.searchForBook(dest, date, numOfPeople).length() == 0) {
                        console.printLn("There is no flight with given conditions");
                        break;
                    } else {
                        console.printLn(controller.searchForBook(dest, date, numOfPeople));
                        console.printLn("Enter flightId to book or 0 to exit: ");
                        String flightIdOrExit = console.readLn();
                        if (flightIdOrExit.equals("0")) break;
                        else {
                            controller.book(flightIdOrExit, numOfPeople);
                            break;
                        }
                    }
                case "4":
                    try {
                        console.printLn(controller.cancelBooking());
                    } catch (FlightNotCancelledException ex) {
                        console.printLn("Something went wrong when cancelling flight...");
                    }
                    break;
                case "5":
                    try {
                        console.printLn(controller.getMyFlights());
                    } catch (UserFlightsNotFound ex) {
                        console.printLn("You have no flight...");
                    }
                    break;
                case "6":
                    cont = false;
                    console.printLn("Bye...");
                    break;
                case "7":
                    logout();
                    break;
                default:
                    console.printLn("Please enter menu num again");
            }
        }
    }

    private static void logout() throws IOException {
        ConsoleMain consoleMain = new ConsoleMain();
        consoleMain.printLn("You logged out...");
        login();
    }

    private static void forRegistering() throws IOException {
        UserController userController = new UserController();
        ConsoleMain consoleMain = new ConsoleMain();
        BufferedReader read = new BufferedReader(new FileReader("users.txt"));
        consoleMain.print("Enter following information about you: your username and your password");
        String userName = consoleMain.readLn();
        String password = consoleMain.readLn();
        try {
            while (read.readLine() != null) {
            }
            userController.userByReg(userName, password);
        } catch (Exception ex) {
            consoleMain.printLn("Wrong name or password");
            forRegistering();
        }
        read.close();
    }

    private static void newUserRegistrator() throws IOException {
        UserController userController = new UserController();
        ConsoleMain consoleMain = new ConsoleMain();
        FileWriter fileWriter = new FileWriter("users.txt", true);
        consoleMain.printLn("Please, enter your information.\nEnter your name:");
        String name1 = consoleMain.readLn();
        consoleMain.printLn("Enter your password:");
        String password1 = consoleMain.readLn();
        try {
            fileWriter.write(System.lineSeparator());
            fileWriter.write(name1);
            fileWriter.write(System.lineSeparator());
            fileWriter.write(password1);
            consoleMain.printLn("New user saved...");
            fileWriter.close();
        } catch (IOException ex) {
            throw new RuntimeException("Something went wrong/..", ex);
        }
        userController.save(new User(name1, password1));
    }

    public static void login() throws IOException {
        ConsoleMain consoleMain = new ConsoleMain();
        consoleMain.print("Do you have an account?Yes or No(The first letter must be uppercase)?");
        switch (consoleMain.readLn()) {
            case "Yes":
                forRegistering();
                break;
            case "No":
                newUserRegistrator();
                break;
            default:
                throw new IllegalArgumentException("----Yes---No----");
        }
    }
}
