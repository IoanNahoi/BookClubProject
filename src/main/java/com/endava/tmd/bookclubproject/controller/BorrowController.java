package com.endava.tmd.bookclubproject.controller;

import com.endava.tmd.bookclubproject.entity.Borrow;
import com.endava.tmd.bookclubproject.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("borrow")
public class BorrowController {
    @Autowired
    private final BorrowService borrowService;

    public BorrowController(BorrowService borrowService) {
        this.borrowService = borrowService;
    }

    @GetMapping
    public List<Borrow> getAll() {
        return borrowService.getAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Object getbyid(@RequestParam Long id) {
        return borrowService.getbyid(id).isPresent() ? borrowService.getbyid(id).get() : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
//    @RequestMapping({"idUser","idBook","period"})
    public void addBorrow(@RequestParam("idUser") Long idUser, @RequestParam("idBook") Long idBook, @RequestParam("period") int days) {
        borrowService.add(idUser, idBook, days);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        borrowService.deleteById(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void update(@RequestParam Borrow borrow) {
        borrowService.update(borrow);
    }

    @GetMapping(value = "/seeWhoBorrowed")
    public String getUserWhoBorrowed(@RequestParam("id") Long id) {
        /// TODO: 7/10/2022 make borrow list
        Borrow borrow = borrowService.seeWhoBorrowed(id);
        return ("Username:" + borrow.getUser_who_borrowed().getFirstName() + " " + borrow.getUser_who_borrowed().getLastName() + " a imprumutat cartea si o va returna in data de: " + borrowService.seeWhoBorrowed(id).getDate_when_return());
    }

    @PutMapping(value = "/extendPeriod")
    public void extendPeriod(@RequestParam("days") int days, @RequestParam("idUser") Long id, @RequestParam("bookName") String bookName) {
        borrowService.updatePeriod(days, id, bookName);
    }
}
