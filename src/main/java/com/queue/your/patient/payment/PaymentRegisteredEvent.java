package com.queue.your.patient.payment;

import lombok.Value;

@Value
public class PaymentRegisteredEvent {
    private final String id;
}
