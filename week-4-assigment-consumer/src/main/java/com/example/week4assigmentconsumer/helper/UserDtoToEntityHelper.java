package com.example.week4assigmentconsumer.helper;

import com.example.week4assigmentconsumer.dto.UserDTO;
import com.example.week4assigmentconsumer.entity.User;

public class UserDtoToEntityHelper {
    public static User transform(UserDTO userDTO){
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        return user;
    }
}
