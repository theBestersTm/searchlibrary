package com.softexpansion.searchlibrary.repository;

import com.softexpansion.searchlibrary.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Category findByName(String name);

}
