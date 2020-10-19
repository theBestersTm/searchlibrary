package com.softexpansion.searchlibrary.controller;

import com.softexpansion.searchlibrary.entity.Book;
import com.softexpansion.searchlibrary.entity.dto.BookDto;
import com.softexpansion.searchlibrary.service.BookServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/books")
@Log
@AllArgsConstructor
public class BookController {
    public static final String LIBRARIAN_PASSWORD = "12345";

    private final BookServiceImpl bookService;


    @GetMapping("/{id}")
    public Book findUserById(@PathVariable Integer id) {
        return bookService.findById(id);
    }

    @GetMapping
    public ResponseEntity<List<Book>> findAll() {
        List<Book> books = bookService.findAll();
        books.sort(Comparator.comparing(o -> o.getCategory().getName()));
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(books);
    }

    @GetMapping("/findByName")
    public Book findByName(@RequestParam String name) {
        return bookService.findByName(name);
    }



}
