package com.queue.your.patient.cart.payment;

import com.queue.your.patient.IntegrationTest;
import com.queue.your.patient.infrastructure.MailSender;
import com.queue.your.patient.order.Order;
import com.queue.your.patient.order.OrderRepository;
import com.queue.your.patient.payment.InvoiceGeneratorListener;
import com.queue.your.patient.payment.PaymentRegisteredEvent;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class InvoiceGenerationListenerTest extends IntegrationTest {
    @MockBean
    private MailSender mailSender;
    @MockBean
    private OrderRepository orderRepository;
    //only to check registration

    @Autowired
    private InvoiceGeneratorListener listener;

    @Autowired
    private ApplicationEventPublisher publisher;

    @Test
    public void shouldHandlePaymentEvent() throws Exception {
        Order order = mock(Order.class);
        given(orderRepository.findByCartId(anyString())).willReturn(order);

        publisher.publishEvent(new PaymentRegisteredEvent("id"));

        verify(mailSender).send(anyString(), anyString());
    }
}
