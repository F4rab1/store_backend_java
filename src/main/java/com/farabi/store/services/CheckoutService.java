package com.farabi.store.services;

import com.farabi.store.dtos.CheckoutRequest;
import com.farabi.store.dtos.CheckoutResponse;
import com.farabi.store.entities.Order;
import com.farabi.store.exceptions.CartEmptyException;
import com.farabi.store.exceptions.CartNotFoundException;
import com.farabi.store.repositories.CartRepository;
import com.farabi.store.repositories.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CheckoutService {
    private final CartRepository cartRepository;
    private final OrderRepository orderRepository;
    private final AuthService authService;
    private final CartService cartService;

    public CheckoutResponse checkout(CheckoutRequest request) {
        var cart = cartRepository.getCartWithItems(request.getCartId()).orElse(null);
        if (cart == null) {
            throw new CartNotFoundException();
        }

        if (cart.isEmpty()) {
            throw new CartEmptyException();
        }

        var order = Order.fromCart(cart, authService.getCurrentUser());

        orderRepository.save(order);

        cartService.clearCart(cart.getId());

        return new CheckoutResponse(order.getId());
    }
}
