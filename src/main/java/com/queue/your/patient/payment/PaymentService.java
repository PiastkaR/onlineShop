package com.queue.your.patient.payment;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;

import java.time.LocalDateTime;

@RequiredArgsConstructor
public class PaymentService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentService.class);
    private final PaymentRepository paymentRepository;
    private final ApplicationEventPublisher eventPublisher;

    public void paymentRegistered(String cartId) {
//        LOGGER.info("Payment Registered for cart [{}]", paymentRegisteredEvent);
        final Payment payment = paymentRepository.save(new Payment(cartId, LocalDateTime.now()));
        eventPublisher.publishEvent(new PaymentRegisteredEvent(payment.getId()));

    }
}
