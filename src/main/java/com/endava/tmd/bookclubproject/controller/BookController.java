package com.endava.tmd.bookclubproject.controller;

import com.endava.tmd.bookclubproject.entity.Book;
import com.endava.tmd.bookclubproject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book")
public class BookController {
    @Autowired
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAll() {
        return bookService.getAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Object getbyid(@PathVariable Long id) {

        return bookService.getbyid(id).isPresent() ? bookService.getbyid(id).get() : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public void addBook(@RequestBody final Book book) {
        bookService.addBook(book);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        bookService.deleteById(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void update(@RequestParam Book book) {
        bookService.update(book);
    }
}
