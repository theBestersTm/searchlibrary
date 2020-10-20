package com.softexpansion.searchlibrary.service;

import com.softexpansion.searchlibrary.entity.Book;
import com.softexpansion.searchlibrary.entity.Category;
import com.softexpansion.searchlibrary.entity.dto.BookDto;
import com.softexpansion.searchlibrary.repository.BookRepository;
import com.softexpansion.searchlibrary.repository.CategoryRepository;
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

        Book book = booksRepository.findById(bookDto.getBookId()).orElseThrow(() -> new Exception());
        book.setAuthor(bookDto.getAuthor());
        book.setName(bookDto.getAuthor());
        //  book.setAuthor(bookDto.getAuthor());
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
    public Book findById(Integer id) throws Exception {
        return booksRepository.findById(id).orElseThrow(() -> new Exception());
    }

    @Override
    public List<Book> findAll() {
        return booksRepository.findAll();
    }
    //catergory серви окремий, експешн, постмент тест, секрьюріті
}
