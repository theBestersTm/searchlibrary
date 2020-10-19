package com.softexpansion.searchlibrary.service;

import com.softexpansion.searchlibrary.entity.User;


import java.util.List;

public interface UserService {
    User saveUser(User users);

    void deleteUser(Integer userId);

    User findByLogin(String login);
    User findById(Integer id);
    List<User> findAll();
}
