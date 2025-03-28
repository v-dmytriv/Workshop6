package pl.coderslab.workshop6.service;

import pl.coderslab.workshop6.book.Book;

import java.util.List;
import java.util.Optional;

public interface ServiceInterface {
    List<Book> findAll();

    Optional<Book> findById(Long id);

    void add(Book book);

    void delete(Long id);

    void update(Book book);
}
