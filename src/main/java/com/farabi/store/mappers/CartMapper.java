package com.farabi.store.mappers;

import com.farabi.store.dtos.CartDto;
import com.farabi.store.dtos.CartItemDto;
import com.farabi.store.entities.Cart;
import com.farabi.store.entities.CartItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CartMapper {
    @Mapping(target = "totalPrice", expression = "java(cart.getTotalPrice())")
    CartDto toDto(Cart cart);

    @Mapping(target = "totalPrice", expression = "java(cartItem.getTotalPrice())")
    CartItemDto toDto(CartItem cartItem);
}
