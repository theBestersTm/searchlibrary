package com.softexpansion.searchlibrary.controller;

import com.softexpansion.searchlibrary.entity.Book;
import com.softexpansion.searchlibrary.entity.dto.BookDto;
import com.softexpansion.searchlibrary.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/admin")
@RestController
@AllArgsConstructor
public class LibrarianBookController {

    private final BookService bookService;

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUsers(@PathVariable Integer id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/books")
    public Book createBook(@RequestBody BookDto books)  {
        return bookService.saveBook(books);
    }

    @PutMapping("/books/{id}")
    public Book updateBook(@RequestBody BookDto books) throws Exception {
        return bookService.updateBook(books);
    }

}
