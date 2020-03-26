package com.queue.your.patient.cart;

import lombok.Value;

@Value
public class OrderStoredEvent {

    private final String cartId;
}
