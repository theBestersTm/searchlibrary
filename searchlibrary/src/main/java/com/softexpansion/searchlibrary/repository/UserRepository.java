package com.softexpansion.searchlibrary.repository;

import com.softexpansion.searchlibrary.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByName(String name);
}