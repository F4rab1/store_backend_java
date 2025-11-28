package com.farabi.store.payments;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PaymenException extends RuntimeException {
    public PaymenException(String message) {
        super(message);
    }
}
