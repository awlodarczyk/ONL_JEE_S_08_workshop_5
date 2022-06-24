package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Book;
import pl.coderslab.service.BookService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookService service;


    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public List<Book> findAll(){ return service.findAll(); }


    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    public Book findById(@PathVariable Long id){ return service.findById(id).orElse(null); }


    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public Book create(@RequestBody Book book){ return service.create(book); }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.PUT)
    public Book update(@PathVariable Long id,@RequestBody Book book){ return service.update(id, book); }


    @RequestMapping(value = "/book/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable Long id){ return service.delete(id); }
}
