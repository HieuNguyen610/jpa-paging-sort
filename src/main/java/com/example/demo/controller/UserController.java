package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/api/v1/users")
    @Operation(summary = "Get all users", description = "Retrieve a list of all users")
    public ResponseEntity<?> getAll() {
        List<UserDto> users = userService.getAllUser();
        return ResponseEntity.of(Optional.ofNullable(users));
    }

    @GetMapping("/users/list")
    public ResponseEntity<?> list(@RequestParam(required = false) String keyword) {
        List<UserDto> users = userService.getAllUser(keyword);
        return ResponseEntity.of(Optional.ofNullable(users));
    }
}
