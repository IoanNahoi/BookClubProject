package com.endava.tmd.bookclubproject.service;

import com.endava.tmd.bookclubproject.entity.Book;
import com.endava.tmd.bookclubproject.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    public Optional<Book> getbyid(Long id) {
        return bookRepository.findById(id);
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    public void update(Book book) {
        if (bookRepository.findById(book.getId()).isPresent())
            bookRepository.save(book);
    }
    public Book getBookByTitle(String bookTitle){
        return bookRepository.getBookByTitle(bookTitle);
    }
    public List<Book> getAvailableBooks(long id){
        return bookRepository.getAvailableBooks(id);
    }




}
