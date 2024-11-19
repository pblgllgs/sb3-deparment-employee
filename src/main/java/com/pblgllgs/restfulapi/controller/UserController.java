package com.pblgllgs.restfulapi.controller;
/*
 *
 * @author pblgl
 * Created on 18-11-2024
 *
 */

import com.pblgllgs.restfulapi.dto.UserDTO;
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
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        UserDTO createdUser = userService.createUser(userDTO);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> findUserById(@PathVariable("userId") Long userId){
        return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDTO> updateUserById(
            @PathVariable("userId") Long userId,
            @RequestBody UserDTO userDTO
    ){
        return new ResponseEntity<>(userService.updateUser(userId,userDTO),HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> delete(@PathVariable("userId") Long userId){
        userService.deleteUser(userId);
        return ResponseEntity.ok().build();
    }
}
