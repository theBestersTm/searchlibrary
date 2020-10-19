package com.softexpansion.searchlibrary.service;

import com.softexpansion.searchlibrary.entity.User;
import com.softexpansion.searchlibrary.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService{
    private final UserRepository usersRepository;

    @Override
    public User saveUser(User users) {

        return usersRepository.save(users);

    }

    public User updateUser(User users) {

        Optional<User> userFromDb = usersRepository.findById(users.getUserid());
        User user =  userFromDb.orElseThrow(() -> new IllegalArgumentException("USER WITH ID : " + users.getUserid() + " not found"));

        User savedUser = usersRepository.save(users);

        return usersRepository.save(savedUser);
    }


    @Override
    public void deleteUser(Integer userId) {
        usersRepository.deleteById(userId);
    }

    @Override
    public User findByLogin(String name) {
        User users = usersRepository.findByName(name);
        if (users != null) {
            return users;
        }
        return null;
    }

    @Override
    public User findById(Integer id) {
        return usersRepository.getOne(id);
    }

    @Override
    public List<User> findAll() {
        return usersRepository.findAll();
    }
}
