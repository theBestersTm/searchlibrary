package com.softexpansion.searchlibrary.service;

import com.softexpansion.searchlibrary.entity.Book;
import com.softexpansion.searchlibrary.entity.dto.BookDto;

import java.util.List;

public interface BookService {

    Book saveBook(BookDto books);
    Book updateBook(BookDto books);
    Book findByName(String name);
    Book findById(Integer id);
    List<Book> findAll();

    void deleteBook(Integer userId);


}
