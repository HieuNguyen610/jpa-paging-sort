package com.example.demo.service.impl;

import com.example.demo.dto.UserDto;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.request.CreateUserRequest;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserDto> getAllUser() {
        List<User> users = userRepository.findAll();
        return users.stream().map(userMapper::toDto).toList();
    }

    @Override
    public List<UserDto> getAllUser(String keyword) {
        List<User> users = userRepository.findByKeyword(keyword);
        return users.stream().map(userMapper::toDto).toList();
    }

    @Override
    public UserDto createUser(CreateUserRequest userRequest) {
        User newUser = userMapper.toEntity(userRequest);
        User savedUser = userRepository.save(newUser);
        return userMapper.toDto(savedUser);
    }
}
