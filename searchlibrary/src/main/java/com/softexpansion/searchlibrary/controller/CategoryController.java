package com.softexpansion.searchlibrary.controller;

import com.softexpansion.searchlibrary.entity.Book;
import com.softexpansion.searchlibrary.entity.Category;
import com.softexpansion.searchlibrary.service.CategoryServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
@Log
@AllArgsConstructor
public class CategoryController {
    private final CategoryServiceImpl categoryService;

    @PostMapping
    public Category createController(@RequestBody Category categories)  {
        return categoryService.saveCategory(categories);
    }


    @GetMapping("/findByLogin")
    public Category findByLogin(@RequestParam String name) {
        return categoryService.findByName(name);
    }

}
