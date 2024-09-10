package com.example.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    //create or save user
    public User saveUser(User user){
        return userRepo.save(user);
    }
    //find all users
    public List<User>findAllUsers(){
        return userRepo.findAll();
    }
    //find user By Id
    public Optional<User>findById(Long id){
        return userRepo.findById(id);
    }
    //update user
    public User updateUser(Long id, User userDetails) {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("USER NOT FOUND: " + id));

        user.setUsername(userDetails.getUsername());
        user.setPassword(userDetails.getPassword());

        return userRepo.save(user);
    }
    //delete user
    public void  deleteUserById(Long id){
        userRepo.deleteById(id);
    }
}
