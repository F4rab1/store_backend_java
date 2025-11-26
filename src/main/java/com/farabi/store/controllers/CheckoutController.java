package com.farabi.store.controllers;

import com.farabi.store.dtos.CheckoutRequest;
import com.farabi.store.dtos.CheckoutResponse;
import com.farabi.store.dtos.ErrorDto;
import com.farabi.store.exceptions.CartEmptyException;
import com.farabi.store.exceptions.CartNotFoundException;
import com.farabi.store.services.CheckoutService;
import com.stripe.exception.StripeException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@AllArgsConstructor
@RestController
@RequestMapping("/checkout")
public class CheckoutController {
    private final CheckoutService chechoutService;

    @PostMapping
    public CheckoutResponse checkout(@Valid @RequestBody CheckoutRequest request) throws StripeException {
        return chechoutService.checkout(request);
    }

    @ExceptionHandler({CartNotFoundException.class, CartEmptyException.class})
    public ResponseEntity<ErrorDto> handleException(Exception exception) {
        return ResponseEntity.badRequest().body(new ErrorDto(exception.getMessage()));
    }
}
