package ru.testdb.spring.services;

import ru.testdb.spring.models.User;

import java.util.List;

public interface UserService {
    List<User> index();

    User show(int id);

    void save(User user);

    void update(int id, User updatedUser);

    void delete(int id);
}
