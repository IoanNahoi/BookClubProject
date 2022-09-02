package com.endava.tmd.bookclubproject.controller;

import com.endava.tmd.bookclubproject.entity.User;
import com.endava.tmd.bookclubproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.endava.tmd.bookclubproject.service.UserService;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("users")
@CrossOrigin
public class UserController {
    private final UserService userService;
    @Autowired
    private final UserRepository userRepository;

    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok().body(userService.getAll());
    }

    @GetMapping(value = "getById")
    public Object getbyid(@RequestParam("idUser") Long id) {
        return userService.getbyid(id).isPresent() ? userService.getbyid(id).get() :
                new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "login")
    public Object login(@RequestParam("username") String username, @RequestParam("password") String password) {
        return userService.login(username, password);
    }

    @PostMapping(value = "register")
    public ResponseEntity<User> addUser(@RequestBody final User user) {
//        userService.addUser(user);
        User user1 = userRepository.save(user);
        URI userURI = URI.create("/register" + user1.getId());
        return ResponseEntity.created(userURI).body(user1);
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

//    @PostMapping(value = "/waiting")
//    public void addWaiting(@RequestParam(value = "idUserWhoBorrow") long idUser, @RequestParam(value = "title") String title) {
//        userService.addWaitingList(idUser, title);
//    }

}
