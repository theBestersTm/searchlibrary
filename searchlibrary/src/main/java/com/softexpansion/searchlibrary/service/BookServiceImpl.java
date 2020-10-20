package com.softexpansion.searchlibrary.service;

import com.softexpansion.searchlibrary.entity.Book;
import com.softexpansion.searchlibrary.entity.Category;
import com.softexpansion.searchlibrary.entity.dto.BookDto;
import com.softexpansion.searchlibrary.repository.BookRepository;
import com.softexpansion.searchlibrary.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class BookServiceImpl implements BookService {
    private final BookRepository booksRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public Book saveBook(BookDto books) {

        Category category = categoryRepository.findByName(books.getCategoryName());
        category = category != null ? category : categoryRepository.save(new Category(books.getCategoryName()));

        return booksRepository.save(new Book(null,
                books.getName(),
                books.getAuthor(),
                books.getDescription(),
                category
        ));
    }

    @Override
    public Book updateBook(BookDto books) {
        return saveBook(books);
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
    public Optional<Book> findById(Integer id) {
        return booksRepository.findById(id);
    }

    @Override
    public List<Book> findAll() {
        return booksRepository.findAll();
    }
}
