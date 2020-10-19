package com.softexpansion.searchlibrary.service;


import com.softexpansion.searchlibrary.entity.Category;

public interface CategoryService {

    Category saveCategory(Category category);
    Category findByName(String name);

}
