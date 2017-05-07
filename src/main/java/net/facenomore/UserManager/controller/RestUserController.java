package net.facenomore.UserManager.controller;

import net.facenomore.UserManager.dao.UserDao;
import net.facenomore.UserManager.model.Page;
import net.facenomore.UserManager.model.PageRestParameters;
import net.facenomore.UserManager.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/crud")
public class RestUserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/getPage/{pageSize}/{pageNumber}", method = RequestMethod.GET)
    public
    @ResponseBody
    Page getPage(@PathVariable("pageNumber") Integer pageNumber, @PathVariable("pageSize") Integer pageSize, @Valid @ModelAttribute PageRestParameters pageRestParameters) {
        return userDao.getPage(pageNumber, pageSize, pageRestParameters.getSortType(), pageRestParameters.getSortField(), pageRestParameters.getNameFilter(),
                pageRestParameters.getAgeMoreFilter(), pageRestParameters.getAgeMoreFilter(), pageRestParameters.getAdminFilter());
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("id") Integer id) {
        userDao.removeUser(id);
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public void updateItem(@RequestBody @Valid User updateUser) {
        userDao.addOrUpdateUser(updateUser);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public
    @ResponseBody
    List<User> getAllUsers() {
        return userDao.listUsers();
    }

    @RequestMapping(value = "/getById{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    User getUserById(@PathVariable("id") Integer id) {
        return userDao.getUserById(id);
    }
}