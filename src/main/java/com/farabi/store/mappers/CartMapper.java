package com.farabi.store.mappers;

import com.farabi.store.dtos.CartDto;
import com.farabi.store.entities.Cart;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartMapper {
    CartDto toDto(Cart cart);
}
