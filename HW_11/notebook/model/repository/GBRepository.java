package HW_11.notebook.model.repository;

import HW_11.notebook.model.User;

import java.util.List;
import java.util.Optional;

public interface GBRepository {
    List<User> findAll();
    User create(String firstName, String lastName, String phone);
    Optional<User> findById(Long id);
    Optional<User> update(Long userId, String firstName, String lastName, String phone);
    boolean delete(Long id);
    List<String> readAll();
    void saveAll(List<String> data);
}
