package com.softexpansion.searchlibrary.service;

import com.softexpansion.searchlibrary.entity.Book;
import com.softexpansion.searchlibrary.entity.dto.BookDto;

import java.util.List;
import java.util.Optional;

public interface BookService {

    Book saveBook(BookDto books);
    Book updateBook(BookDto books) throws Exception;
    Book findByName(String name);
    Book findById(Integer id) throws Exception;
    List<Book> findAll();
    void deleteBook(Integer userId);
}
