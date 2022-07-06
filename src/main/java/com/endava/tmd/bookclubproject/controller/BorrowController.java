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

//    @PostMapping
//    public void addUser(@RequestBody final Borrow borrow) {
//        borrowService.addBook(borrow);
//    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        borrowService.deleteById(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void update(@RequestParam Borrow borrow) {
        borrowService.update(borrow);
    }
}
