package com.pblgllgs.restfulapi.controller;
/*
 *
 * @author pblgl
 * Created on 18-11-2024
 *
 */

import com.pblgllgs.restfulapi.entity.User;
import com.pblgllgs.restfulapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> findUserById(@PathVariable("userId") Long userId){
        return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<User>> findAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUserById(
            @PathVariable("userId") Long userId,
            @RequestBody User user
    ){
        return new ResponseEntity<>(userService.updateUser(userId,user),HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> delete(@PathVariable("userId") Long userId){
        userService.deleteUser(userId);
        return ResponseEntity.ok().build();
    }
}
