package com.endava.tmd.bookclubproject.controller;

import com.endava.tmd.bookclubproject.service.BookOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("owner")
public class BookOwnerController {
    @Autowired
    private final BookOwnerService bookOwnerService;

    public BookOwnerController(BookOwnerService bookOwnerService) {
        this.bookOwnerService = bookOwnerService;
    }

    @PostMapping
    public void addBookAndOwner(@RequestParam("idUser") long idUser, @RequestParam("idBook") long idBook) {
        bookOwnerService.addBookAndOwner(idUser, idBook);
    }

    @GetMapping(value = "/bookByUserId")
    public void getBookByUserId(@RequestParam("idUser") long idUser){
        bookOwnerService.getBookByUserId(idUser);
    }
}