package me.dio.service;

import me.dio.domain.model.User;

public interface UserService {

    User findById(Long id);
    void createUser(User user);
    Iterable<User> getAll();
    void updateUser(Long id, User user);
    void deleteUser(Long id);

}
