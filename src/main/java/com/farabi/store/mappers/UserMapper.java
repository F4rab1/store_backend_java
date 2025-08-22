package com.farabi.store.mappers;

import com.farabi.store.dtos.UserDto;
import com.farabi.store.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
}
