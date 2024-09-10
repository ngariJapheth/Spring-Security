package com.example.Login;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
@NoArgsConstructor
@AllArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/new")
    public User createUser(@RequestBody User user){
        return userService.saveUser(user);

    }
    @GetMapping
    public List<User>getAllUsers(){
        return userService.findAllUsers();
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        Optional<User> user=userService.findById(id);
        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());    }
    }

//    @PutMapping("/users/{id}")
//    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
//        try {
//            User updatedUser = UserService.updateUser(id, userDetails);
//            return ResponseEntity.ok(updatedUser);
//        } catch (RuntimeException e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void>deleteUser(@PathVariable long id){
//
//    }
//
//
//
