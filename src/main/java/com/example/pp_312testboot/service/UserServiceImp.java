package com.example.pp_312testboot.service;

import com.example.pp_312testboot.dao.UserDao;
import com.example.pp_312testboot.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    private final UserDao userDao;

    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userDao.getAllUsers("select u from User u");
    }

    @Override
    @Transactional(readOnly = true)
    public User getUser(int id) {
        return userDao.getUser(id);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    @Transactional
    public void editUser(int id, User user) {
        userDao.editUser(id, user);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }
}
