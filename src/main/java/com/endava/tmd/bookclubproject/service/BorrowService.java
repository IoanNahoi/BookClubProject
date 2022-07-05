package com.endava.tmd.bookclubproject.service;

import com.endava.tmd.bookclubproject.entity.Book;
import com.endava.tmd.bookclubproject.entity.Borrow;
import com.endava.tmd.bookclubproject.repository.BorrowRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BorrowService {
    private final BorrowRepository borrowRepository;

    public BorrowService(BorrowRepository borrowRepository) {
        this.borrowRepository = borrowRepository;
    }
    public List<Borrow> getAll() {
        return borrowRepository.findAll();
    }

    public Optional<Borrow> getbyid(Long id) {
        return borrowRepository.findById(id);
    }

    public void addBook(Borrow borrow) {
        borrowRepository.save(borrow);
    }

    public void deleteById(Long id) {
        borrowRepository.deleteById(id);
    }

    public void update(Borrow borrow) {
        if (borrowRepository.findById(borrow.getId_borrow()).isPresent())
            borrowRepository.save(borrow);
    }

}
