package com.revature.project2.controller;


import com.revature.project2.Entity.User;
import com.revature.project2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public List<User>getAllUsers(){
        return  userService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id")int id){
        return userService.getUserById(id);
    }

    @PostMapping("/user")
    public  User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @PutMapping("/user/{id}")
    public String updateUser(@PathVariable("id")int id, @RequestBody User user){
        userService.updateUser(id, user);
        return "record updated successfully";
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable("id")int id){
        userService.deleteUser(id);
        return "record deleted successfully";
    }
}
