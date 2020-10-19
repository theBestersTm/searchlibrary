package com.softexpansion.searchlibrary.controller;

import com.softexpansion.searchlibrary.entity.User;
import com.softexpansion.searchlibrary.service.UserServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Log
@AllArgsConstructor
public class UserController {
    private final UserServiceImpl userService;

    @GetMapping
    public String GetUser() {
        return "index";
    }

    @PostMapping
    public User createUser(@RequestBody User users) {
        return userService.saveUser(users);
    }

    @PostMapping("/update/{id}")
    public User updateUser(@RequestBody User users) {
        return userService.updateUser(users);
    }

    @GetMapping("/{id}")
    public User findUserById(@PathVariable Integer id) {
        return userService.findById(id);
    }

    @GetMapping("/findByLogin")
    public User findByLogin(@RequestParam String login) {
        return userService.findByLogin(login);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUsers(@PathVariable Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }


}

