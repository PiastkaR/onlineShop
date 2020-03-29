package com.queue.your.patient.payment;

import java.util.HashMap;

public class InMemoryPaymentRepository implements PaymentRepository {
    private final HashMap<String, Payment> paymentDb = new HashMap<>();

    @Override
    public Payment save(Payment payment) {
        paymentDb.put(payment.getId(), payment);
        return payment;
    }
}
