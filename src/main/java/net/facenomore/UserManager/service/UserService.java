package net.facenomore.UserManager.service;


import net.facenomore.UserManager.model.User;

import java.util.List;

public interface UserService {
    void addOrUpdateUser(User user);

    void removeUser(int id);

    User getUserById(int id);

    List<User> listUsers();
}
