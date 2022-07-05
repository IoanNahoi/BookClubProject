package com.endava.tmd.bookclubproject.controller;

import com.endava.tmd.bookclubproject.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.endava.tmd.bookclubproject.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Object getbyid(@PathVariable Long id) {
        return userService.getbyid(id).isPresent() ? userService.getbyid(id).get() :
                new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public void addUser(@RequestBody final User user) {
        userService.addUser(user);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        userService.deleteById(id);
    }

    @PutMapping
    public void update(@RequestParam User user) {
        userService.update(user);
    }

    @RequestMapping(value = "/NameOrEmail", method = RequestMethod.GET)
    public User getUserByNameOrEmail(@RequestParam(value = "name") Optional<String> name, @RequestParam(value = "email") Optional<String> email) {
        return userService.getUserByNameOrEmail(name, email);
    }

}
