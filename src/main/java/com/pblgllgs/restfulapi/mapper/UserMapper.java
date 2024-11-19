package com.pblgllgs.restfulapi.mapper;
/*
 *
 * @author pblgl
 * Created on 19-11-2024
 *
 */

import com.pblgllgs.restfulapi.dto.UserDTO;
import com.pblgllgs.restfulapi.entity.User;

public class UserMapper {

    public static User mapUserDTOToUser(UserDTO userDTO){
        User user = new User();
        user.setId(userDTO.getId());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        return user;
    }

    public static UserDTO mapUserToUserDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }
}
