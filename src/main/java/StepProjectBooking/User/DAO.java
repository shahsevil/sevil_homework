package StepProjectBooking.User;

import java.util.List;


public interface DAO<T> {

    void SaveData(String fileName);

    void ReadData(String fileName);

    void LoadData(List<T> users);

    List<T> getAll();

    void save(T user);

    boolean delete(String name);

    T get(int id);

}
