package com.example.demo.mapper;

import com.example.demo.dto.UserDto;
import com.example.demo.model.User;
import com.example.demo.request.CreateUserRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    User toEntity(UserDto userDto);

    @Mapping(target = "id", ignore = true)
    User toEntity(CreateUserRequest request);

    UserDto toDto(User user);
}
