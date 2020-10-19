package com.softexpansion.searchlibrary.service;

import com.softexpansion.searchlibrary.entity.Category;
import com.softexpansion.searchlibrary.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Category saveCategory(Category categories) {

        return categoryRepository.save(categories);

    }


    @Override
    public Category findByName(String name) {
        Category categories = categoryRepository.findByName(name);
        if (categories != null) {
            return categories;
        }
        return null;
    }
}
