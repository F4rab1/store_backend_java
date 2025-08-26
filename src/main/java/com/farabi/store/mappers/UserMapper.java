package com.farabi.store.mappers;

import com.farabi.store.dtos.RegisterUserRequest;
import com.farabi.store.dtos.UpdateUserRequest;
import com.farabi.store.dtos.UserDto;
import com.farabi.store.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
//    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    UserDto toDto(User user);
    User toEntity(RegisterUserRequest registerUserRequest);
    void update(UpdateUserRequest updateUserRequest, @MappingTarget User user);
}
