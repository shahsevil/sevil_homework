package GroupBooking.service;

import GroupBooking.dao.DAOBooking;
import GroupBooking.dao.DAOFlight;

import java.util.List;
import java.util.stream.Collectors;

public class Service {
  DAOBooking daoBooking;
  DAOFlight daoFlight;
  public Service(DAOBooking daoBooking, DAOFlight daoFlight ) {
    this.daoFlight = daoFlight;
    this.daoBooking = daoBooking;
  }

  public List<String> getAllFlights() {
    return daoFlight.getAllBy().stream().map(f -> f.represent()).collect(Collectors.toList());

  }
}
