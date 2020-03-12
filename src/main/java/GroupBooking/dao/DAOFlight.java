package GroupBooking.dao;

import GroupBooking.entity.Flight;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

public class DAOFlight implements DAO<Flight> {
  @Override
  public Optional<Flight> get(int id) {
    return Optional.empty();
  }

  @Override
  public Collection<Flight> getAll() {
    return null;
  }

  @Override
  public Collection<Flight> getAllBy(Predicate<Flight> p) {
    return null;
  }

  @Override
  public void create(Flight flight) {

  }

  @Override
  public void delete(int id) {

  }
}
