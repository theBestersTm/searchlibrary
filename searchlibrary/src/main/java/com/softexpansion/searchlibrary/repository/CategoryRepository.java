package com.softexpansion.searchlibrary.repository;

import com.softexpansion.searchlibrary.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

   Optional<Category> findByName(String name);

}
