package pl.coderslab.service;

import pl.coderslab.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();
    Optional<Book> findById(Long id);
    Book create(Book book);
    Book update(Long id, Book book);
    boolean delete(Long id);
}
