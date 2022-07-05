package com.endava.tmd.bookclubproject.service;

import com.endava.tmd.bookclubproject.entity.User;
import org.springframework.stereotype.Service;
import com.endava.tmd.bookclubproject.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getAll() {
        return repository.findAll();
    }

    public Optional<User> getbyid(long id){
        return repository.findById(id);
    }

    public void addUser(User user) {
        repository.save(user);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
    public void update(User user){
        if(repository.findById(user.getId()).isPresent()){
            repository.save(user);
        }
    }
    public User getUserByNameOrEmail(Optional<String>name,Optional<String> email){
        return repository.getUserByNameOrEmail(name,email);
    }
}
