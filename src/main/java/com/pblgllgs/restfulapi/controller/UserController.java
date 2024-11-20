package com.pblgllgs.restfulapi.controller;
/*
 *
 * @author pblgl
 * Created on 18-11-2024
 *
 */

import com.pblgllgs.restfulapi.dto.UserDTO;
import com.pblgllgs.restfulapi.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Tag(
        name = "CRUD REST API for User Resource",
        description = "CREATE, UPDATE, GET, DELETE USERS"
)
public class UserController {
    private final UserService userService;

    @Operation(
            summary = "Create user REST API",
            description = "Create user rest api used to save a user into a database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Http Status 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDTO) {
        UserDTO createdUser = userService.createUser(userDTO);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @Operation(
            summary = "GET BY ID user REST API",
            description = "GET BY ID user rest api used to get a user"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 OK"
    )
    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> findUserById(@PathVariable("userId") Long userId) {
        return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
    }

    @Operation(
            summary = "GET ALL users REST API",
            description = "GET ALL users rest api used to get all users"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 OK"
    )
    @GetMapping
    public ResponseEntity<List<UserDTO>> findAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @Operation(
            summary = "UPDATE USER BY ID REST API",
            description = "UPDATE USER BY ID rest api used to update a user"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 OK"
    )
    @PutMapping("/{userId}")
    public ResponseEntity<UserDTO> updateUserById(
            @PathVariable("userId") Long userId,
            @Valid @RequestBody UserDTO userDTO
    ) {
        return new ResponseEntity<>(userService.updateUser(userId, userDTO), HttpStatus.OK);
    }

    @Operation(
            summary = "DELETE BY ID user REST API",
            description = "DELETE BY ID user rest api used to delete a user"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 OK"
    )
    @DeleteMapping("/{userId}")
    public ResponseEntity<String> delete(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok().build();
    }
}
