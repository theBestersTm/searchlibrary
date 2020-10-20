package com.softexpansion.searchlibrary.repository;

import com.softexpansion.searchlibrary.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    Book findByNameIsLike(String name);
    List<Book> findAllByOrderByCategoryAsc();

}
