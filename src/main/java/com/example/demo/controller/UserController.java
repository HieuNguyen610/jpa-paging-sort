package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.request.CreateUserRequest;
import com.example.demo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@Validated
public class UserController {

    private final UserService userService;

    @GetMapping("/api/v1/users")
    @Operation(summary = "Get all users", description = "Retrieve a list of all users")
    public Map<String, Object> getAll() {
        Map<String, Object> response = Map.of(
                "status", "success",
                "data", userService.getAllUser(),
                "message", "Users retrieved successfully"
        );
        return response;
    }

    @GetMapping("/users/list")
    public Map<String, Object> list(@RequestParam(required = false) String keyword) {
        Map<String, Object> response = Map.of(
                "status", "success",
                "data", userService.getAllUser(keyword),
                "message", "Users retrieved successfully"
        );
        return response;
    }

    @PostMapping("/users/create")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody CreateUserRequest user) {
        UserDto userDto = userService.createUser(user);
        return ResponseEntity.ok(userDto);
    }
}
