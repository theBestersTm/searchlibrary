package com.softexpansion.searchlibrary.service;

import com.softexpansion.searchlibrary.entity.Book;
import com.softexpansion.searchlibrary.entity.User;

import java.util.List;

public interface BookService {

    Book saveBook(Book books);
    Book findByName(String name);
    Book findById(Integer id);
    List<Book> findAll();

    void deleteBook(Integer userId);


}
