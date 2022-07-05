package com.endava.tmd.bookclubproject.controller;

import com.endava.tmd.bookclubproject.service.BookOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class BookOwnerController {
    @Autowired
    private final BookOwnerService bookOwnerService;

    public BookOwnerController(BookOwnerService bookOwnerService) {
        this.bookOwnerService = bookOwnerService;
    }

}
