package com.endava.tmd.bookclubproject.service;

import com.endava.tmd.bookclubproject.entity.Borrow;
import com.endava.tmd.bookclubproject.repository.BookRepository;
import com.endava.tmd.bookclubproject.repository.BorrowRepository;
import com.endava.tmd.bookclubproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BorrowService {
    @Autowired
    private final BorrowRepository borrowRepository;
    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final BookRepository bookRepository;

    public BorrowService(BorrowRepository borrowRepository, UserRepository userRepository, BookRepository bookRepository) {
        this.borrowRepository = borrowRepository;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    public List<Borrow> getAll() {
        return borrowRepository.findAll();
    }

    public Optional<Borrow> getbyid(Long id) {
        return borrowRepository.findById(id);
    }


    public void deleteById(Long id) {
        borrowRepository.deleteById(id);
    }

    public void update(Borrow borrow) {
        if (borrowRepository.findById(borrow.getId_borrow()).isPresent())
            borrowRepository.save(borrow);
    }

    public void add(Long idUser, Long idBook, int borrowDays) {
        Borrow borrow=new Borrow();
        borrow.setUser_who_borrowed(userRepository.findById(idUser).get());
        borrow.setBorrowed_book(bookRepository.findById(idBook).get());
        borrow.setDate_when_borrowed(LocalDate.now());
        borrow.setDate_when_borrowed(LocalDate.now().plusDays(borrowDays));
        borrowRepository.save(borrow);
    }


}
