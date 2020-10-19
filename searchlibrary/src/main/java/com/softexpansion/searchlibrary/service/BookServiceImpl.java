package com.softexpansion.searchlibrary.service;

import com.softexpansion.searchlibrary.entity.Book;
import com.softexpansion.searchlibrary.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class BookServiceImpl implements BookService{
    private final BookRepository booksRepository;

    @Override
    public Book saveBook(Book books) {

        return booksRepository.save(books);

    }

    public Book updateBook(Book books) {

        Optional<Book> bookFromDb = booksRepository.findById(books.getBookid());
        Book user =  bookFromDb.orElseThrow(() -> new IllegalArgumentException("USER WITH ID : " + books.getBookid() + " not found"));
        Book savedBook = booksRepository.save(books);

        return booksRepository.save(savedBook);
    }


    @Override
    public void deleteBook(Integer bookId) {
        booksRepository.deleteById(bookId);
    }

    @Override
    public Book findByName(String name) {
        Book books = booksRepository.findByName(name);
        if (books != null) {
            return books;
        }
        return null;
    }

    @Override
    public Book findById(Integer id) {
        return booksRepository.getOne(id);
    }

    @Override
    public List<Book> findAll() {
        return booksRepository.findAll();
    }
}
