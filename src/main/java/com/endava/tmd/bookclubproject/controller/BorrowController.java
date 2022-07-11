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
    public StringBuilder getUserWhoBorrowed(@RequestParam("id") Long id) {
        List<Borrow> borrow = borrowService.borrowDetails(id);
        StringBuilder builder = new StringBuilder();
        for (Borrow borrow1 : borrow) {
            builder.append("Utilizatorul " + borrow1.getUser_who_borrowed().getFirstName() + " " + borrow1.getUser_who_borrowed().getLastName() + " a imprumutat cartea si o va returna in data de: " + borrow1.getDate_when_return() + '\n');
        }
        return builder;
    }

    @GetMapping(value = "whatIBorrowed")
    public StringBuilder getWhatIBorrowed(@RequestParam("idUser") Long id) {
        List<Borrow> borrow = borrowService.borrowDetails(id);
        StringBuilder builder = new StringBuilder();

        for (Borrow borrow1 : borrow) {
            builder.append("Ai imprumutat cartea: " + borrow1.getBorrowed_book().getTitle() + " scrisa de " + borrow1.getBorrowed_book().getAuthor() + " si trebuie returnata pana in data de: " + borrow1.getDate_when_return() + '\n');
        }
        return builder;
    }

    @PutMapping(value = "/extendPeriod")
    public void extendPeriod(@RequestParam("days") int days, @RequestParam("idUser") Long id, @RequestParam("bookName") String bookName) {
        borrowService.updatePeriod(days, id, bookName);
    }
}
