package com.softexpansion.searchlibrary.service;

import com.softexpansion.searchlibrary.entity.Book;
import com.softexpansion.searchlibrary.entity.Category;
import com.softexpansion.searchlibrary.entity.dto.BookDto;
import com.softexpansion.searchlibrary.exception.BookNotFoundException;
import com.softexpansion.searchlibrary.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository booksRepository;
    private final CategoryServiceImpl categoryService;

    @Override
    public Book saveBook(BookDto book) {

        Category category = categoryService.findByName(book.getCategoryName());
        return booksRepository.save(new Book(null,
                book.getName(),
                book.getAuthor(),
                book.getDescription(),
                category
        ));
    }

    @Override
    public Book updateBook(BookDto bookDto) throws Exception {

        Category category = categoryService.findByName(bookDto.getCategoryName());
        Book book = booksRepository.findById(bookDto.getBookId()).orElseThrow(() -> new BookNotFoundException("Book doesnt exist"));

        book.setAuthor(bookDto.getAuthor());
        book.setName(bookDto.getName());
        book.setDescription(bookDto.getDescription());
        book.setCategory(category);
        return booksRepository.save(book);

    }

    @Override
    public void deleteBook(Integer bookId) {
        booksRepository.deleteById(bookId);
    }

    @Override
    public Book findByName(String name) {
        return booksRepository.findByNameIsLike(name);
    }

    @Override
    public Book findById(Integer id) throws BookNotFoundException {
        return booksRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Book doesnt exist"));
    }

    @Override
    public List<Book> findAll() {
        return booksRepository.findAll();
    }

}
