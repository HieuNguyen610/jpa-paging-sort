package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.request.CreateUserRequest;

import java.util.List;

public interface UserService {

    List<UserDto> getAllUser();

    List<UserDto> getAllUser(String keyword);

    UserDto createUser(CreateUserRequest user);
}
