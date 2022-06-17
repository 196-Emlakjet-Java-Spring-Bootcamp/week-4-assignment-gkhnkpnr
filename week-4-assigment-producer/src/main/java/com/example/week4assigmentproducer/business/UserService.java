package com.example.week4assigmentproducer.business;

import com.example.week4assigmentproducer.dto.UserDTO;
import com.example.week4assigmentproducer.entity.User;

public interface UserService {
    void createUser(UserDTO userDTO);
}
