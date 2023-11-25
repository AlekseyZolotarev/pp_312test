package com.example.pp_312testboot.dao;

import com.example.pp_312testboot.models.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers(String sql);

    User getUser(int id);

    void saveUser(User user);

    void editUser(int id, User user);

    void deleteUser(int id);
}

