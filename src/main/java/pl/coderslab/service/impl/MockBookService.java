package pl.coderslab.service.impl;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;
import pl.coderslab.model.Book;
import pl.coderslab.service.BookService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MockBookService implements BookService {

    private List<Book> books;

    public MockBookService() {
        this.books = new ArrayList<>();
        this.books.addAll(createFakeBooks());
    }

    private List<Book> createFakeBooks() {
        List<Book> list  = new ArrayList<>();
        Faker faker = new Faker();
        for(int i=0;i<10;i++){
          Book book = new Book(i+1L,  faker.number().digit(), faker.book().title(),faker.book().author(), faker.book().publisher(), faker.book().genre());
          list.add(book);
        }
        return list;
    }

    @Override
    public List<Book> findAll() {
        return this.books;
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.books.stream().filter(it->it.getId().equals(id)).findFirst();
    }

    @Override
    public Book create(Book book) {
        book.setId(this.books.size()+1L);
        this.books.add(book);
        return book;
    }

    @Override
    public Book update(Long id, Book book) {
        Book updatedBook = this.books.stream().filter(it->it.getId().equals(id)).peek(it->{
            it.setIsbn(book.getIsbn());
            it.setTitle(book.getTitle());
            it.setPublisher(book.getPublisher());
            it.setType(book.getType());
            it.setAuthor(book.getAuthor());
        }).findFirst().orElse(null);
        return updatedBook;
    }

    @Override
    public boolean delete(Long id) {
        return this.books.removeIf(it->it.getId().equals(id));
    }
}
