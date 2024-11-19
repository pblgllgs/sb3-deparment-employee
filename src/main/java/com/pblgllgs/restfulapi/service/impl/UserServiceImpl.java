package com.pblgllgs.restfulapi.service.impl;
/*
 *
 * @author pblgl
 * Created on 18-11-2024
 *
 */

import com.pblgllgs.restfulapi.dto.UserDTO;
import com.pblgllgs.restfulapi.entity.User;
import com.pblgllgs.restfulapi.exception.EmailAlreadyExistsException;
import com.pblgllgs.restfulapi.exception.ResourceNotFoundException;
import com.pblgllgs.restfulapi.repository.UserRepository;
import com.pblgllgs.restfulapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        Optional<User> userOptional = userRepository.findByEmail(userDTO.getEmail());
        if (userOptional.isPresent()) {
            throw new EmailAlreadyExistsException(String.format("Email %s already exists", userDTO.getEmail()));
        }
        User user = modelMapper.map(userDTO, User.class);
        User userSaved = userRepository.save(user);
        return modelMapper.map(userSaved, UserDTO.class);
    }

    @Override
    public UserDTO getUserById(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()) {
            throw new ResourceNotFoundException("User", "id", userId);
        }
        return modelMapper.map(userOptional.get(), UserDTO.class);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .toList();
    }

    @Override
    public UserDTO updateUser(Long userId, UserDTO user) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            throw new ResourceNotFoundException("User", "id", userId);
        }
        User updatedUser = optionalUser.get();
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setEmail(user.getEmail());
        User userUpdated = userRepository.save(updatedUser);
        return modelMapper.map(userUpdated, UserDTO.class);
    }

    @Override
    public void deleteUser(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            throw new ResourceNotFoundException("User", "id", userId);
        }
        userRepository.deleteById(userId);
    }
}
