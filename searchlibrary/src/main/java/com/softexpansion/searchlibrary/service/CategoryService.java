package com.softexpansion.searchlibrary.service;


import com.softexpansion.searchlibrary.entity.Category;

public interface CategoryService {
    Category findByName(String name);
}
