package com.softexpansion.searchlibrary.service;

import com.softexpansion.searchlibrary.entity.Category;
import com.softexpansion.searchlibrary.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    @Override
    public Category findByName(String name) {
        Category category = categoryRepository.findByName(name)
                .orElse(categoryRepository.save(new Category(name)));
        return category;

    }
}
