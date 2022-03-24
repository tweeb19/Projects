package com.revature.project2.service;


import com.revature.project2.Entity.User;
import com.revature.project2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
public class UserServiceImpl  implements UserService{

    @Autowired
    private UserRepository repository;

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public User getUserById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public User addUser(User user) {
        return repository.save(user);
    }

    @Override
    public void updateUser(int id, User user) {
        User userDb = repository.findById(id).get();
        userDb.setFirstName(user.getFirstName());
        userDb.setLastName(user.getLastName());
        userDb.setEmail(user.getEmail());
        userDb.setUsername(user.getUsername());
        userDb.setPassword(user.getPassword());
        repository.save(userDb);

    }

    @Override
    public void deleteUser(int id) {
        repository.deleteById(id);

    }
}
