package com.queue.your.patient.cart.payment;

import com.queue.your.patient.payment.Payment;
import com.queue.your.patient.payment.PaymentRegisteredEvent;
import com.queue.your.patient.payment.PaymentRepository;
import com.queue.your.patient.payment.PaymentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.context.ApplicationEventPublisher;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class PaymentServiceTest {
    @Mock
    private PaymentRepository paymentRepository;
    @Mock
    private ApplicationEventPublisher eventPublisher;

    @InjectMocks
    private PaymentService paymentService;

    @Test
    public void shouldPublishEvent() throws Exception {
        Payment payment = mock(Payment.class);
        given(paymentRepository.save(any(Payment.class))).willReturn(payment);

        paymentService.paymentRegistered("cart-id");
        eventPublisher.publishEvent(new PaymentRegisteredEvent(payment.getId()));
    }
}
