package HW_11.notebook.controller;

import HW_11.notebook.model.User;
import HW_11.notebook.model.repository.GBRepository;

import java.util.List;
import java.util.Objects;

public class UserController {
    private final GBRepository repository;

    public UserController(GBRepository repository) {
        this.repository = repository;
    }

    public void createUser(String firstName, String lastName, String phone) {
        repository.create(firstName, lastName, phone);
    }

    public User readUser(Long userId) throws Exception {
        List<User> users = repository.findAll();
        for (User user : users) {
            if (Objects.equals(user.getId(), userId)) {
                return user;
            }
        }

        throw new RuntimeException("User not found");
    }

    public void updateUser(String userId, String firstName, String lastName, String phone) {
        repository.update(Long.parseLong(userId), firstName, lastName, phone);
    }

    public List<User> readAll() {
        return repository.findAll();
    }

    public boolean deleteUser(String userId) {
        return repository.delete(Long.parseLong(userId));
    }
}
