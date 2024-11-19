package com.pblgllgs.restfulapi.service;

import com.pblgllgs.restfulapi.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO createUser(UserDTO userDTO);

    UserDTO getUserById(Long userId);

    List<UserDTO> getAllUsers();

    UserDTO updateUser(Long userId, UserDTO user);

    void deleteUser(Long userId);
}
