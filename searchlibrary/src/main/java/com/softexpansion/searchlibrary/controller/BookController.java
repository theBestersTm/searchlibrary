package com.softexpansion.searchlibrary.controller;

import com.softexpansion.searchlibrary.entity.Book;
import com.softexpansion.searchlibrary.entity.dto.BookDto;
import com.softexpansion.searchlibrary.service.BookServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
@Log
@AllArgsConstructor
public class BookController {
    public static final String LIBRARIAN_PASSWORD = "12345";

    private final BookServiceImpl bookService;

    @PostMapping
    public Book createBook(@RequestBody BookDto books)  {
        return bookService.saveBook(books);
    }

    @PostMapping("/update/{id}")
    public Book updateUser(@RequestBody BookDto books)  {
        return bookService.updateBook(books);
    }

    @GetMapping("/{id}")
    public Book findUserById(@PathVariable Integer id) {
        return bookService.findById(id);
    }

    @GetMapping("/findByLogin")
    public Book findByLogin(@RequestParam String name) {
        return bookService.findByName(name);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsers(@PathVariable Integer id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok().build();
    }

}
