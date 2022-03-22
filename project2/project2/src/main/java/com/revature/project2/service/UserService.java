package com.revature.project2.service;


import com.revature.project2.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public List<User> getAllUsers();
    public User getUserById(int id);
    public User addUser(User user);
    public void updateUser(int id, User user);
    public  void deleteUser(int id);
}
