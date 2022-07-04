package com.endava.tmd.bookclubproject.service;

import com.endava.tmd.bookclubproject.entity.User;
import org.springframework.stereotype.Service;
import com.endava.tmd.bookclubproject.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getAll() {
        return repository.findAll();
    }
}
