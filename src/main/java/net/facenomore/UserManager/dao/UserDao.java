package net.facenomore.UserManager.dao;


import net.facenomore.UserManager.model.Page;
import net.facenomore.UserManager.model.User;

import java.util.List;

public interface UserDao {
    List<User> listUsers();

    User getUserById(int id);

    void addOrUpdateUser(User user);

    void removeUser(int id);

    Page getPage(int pageNumber, int pageSize, String sortType, String sortField, String nameFilter, Integer ageMoreFilter,
                 Integer ageLessFilter, Boolean isAdminFilter);

}
