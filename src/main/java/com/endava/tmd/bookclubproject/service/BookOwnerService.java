package com.endava.tmd.bookclubproject.service;

import com.endava.tmd.bookclubproject.entity.BookOwner;
import com.endava.tmd.bookclubproject.entity.Borrow;
import com.endava.tmd.bookclubproject.repository.BookOwnerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BookOwnerService {
    private final BookOwnerRepository bookOwnerRepository;

    public BookOwnerService(BookOwnerRepository bookOwnerRepository) {
        this.bookOwnerRepository = bookOwnerRepository;
    }
    public List<BookOwner> getAll() {
        return bookOwnerRepository.findAll();
    }

    public Optional<BookOwner> getbyid(Long id) {
        return bookOwnerRepository.findById(id);
    }

    public void addBook(BookOwner bookOwner) {
        bookOwnerRepository.save(bookOwner);
    }

    public void deleteById(Long id) {
        bookOwnerRepository.deleteById(id);
    }

    public void update(BookOwner bookOwner) {
        if (bookOwnerRepository.findById(bookOwner.getId()).isPresent())
            bookOwnerRepository.save(bookOwner);
    }
}
