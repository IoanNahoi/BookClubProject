package com.endava.tmd.bookclubproject.service;

import com.endava.tmd.bookclubproject.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.endava.tmd.bookclubproject.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository repository) {
        this.userRepository = repository;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public Optional<User> getbyid(Long id) {
        return userRepository.findById(id);
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public void update(User user) {
        if (userRepository.findById(user.getId()).isPresent()) {
            userRepository.save(user);
        }
    }

    public User getUserByNameOrEmail(Optional<String> name, Optional<String> email) {
        return userRepository.getUserByNameOrEmail(name, email);
    }

    public Object login(String username, String password) {
        return userRepository.login(username, password).isPresent() ? (User) userRepository.login(username, password).get() : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
