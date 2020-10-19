package com.softexpansion.searchlibrary.controller;

import com.softexpansion.searchlibrary.entity.Book;
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

    private final BookServiceImpl bookService;


    @PostMapping
    public Book createBook(@RequestBody Book books)  {
        return bookService.saveBook(books);
    }

    @PostMapping("/update/{id}")
    public Book updateUser(@RequestBody Book books)  {
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

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUsers(@PathVariable Integer id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok().build();
    }

}
