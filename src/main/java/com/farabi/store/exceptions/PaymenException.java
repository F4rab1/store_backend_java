package com.farabi.store.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PaymenException extends RuntimeException {
    public PaymenException(String message) {
        super(message);
    }
}
