package com.farabi.store.mappers;

import com.farabi.store.dtos.OrderDto;
import com.farabi.store.entities.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderDto todto(Order order);
}
