package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
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
        List<UserDto> users = userService.getAllUser(keyword);
        Map<String, Object> response = Map.of(
                "status", "success",
                "data", users,
                "message", "Users retrieved successfully"
        );
        return response;
    }
}
