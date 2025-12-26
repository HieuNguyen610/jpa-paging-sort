package com.example.demo.service.impl;

import com.example.demo.dto.UserDto;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.request.CreateUserRequest;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final com.example.demo.mybatis.UserMapper mybatisUserMapper;

    @Override
    public List<UserDto> getAllUser() {
        List<User> users = mybatisUserMapper.findAll();
        return users.stream().map(userMapper::toDto).toList();
    }

    @Override
    public List<UserDto> getAllUser(String keyword) {
        List<User> users = userRepository.findByKeyword(keyword);
        return users.stream().map(userMapper::toDto).toList();
    }

    @Override
    public UserDto createUser(CreateUserRequest userRequest) {
        log.info("Creating user with username: {}", userRequest);
        User newUser = userMapper.toEntity(userRequest);
        log.info("Mapped User entity: {}", newUser);
        User savedUser = userRepository.save(newUser);
        log.info("Saved User entity: {}", savedUser);
        return userMapper.toDto(savedUser);
    }
}
