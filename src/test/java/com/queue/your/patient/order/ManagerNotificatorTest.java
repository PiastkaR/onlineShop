package com.queue.your.patient.order;

import com.queue.your.patient.IntegrationTest;
import com.queue.your.patient.cart.CartService;
import com.queue.your.patient.cart.OrderStoredEvent;
import com.queue.your.patient.infrastructure.MailSender;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

public class ManagerNotificatorTest extends IntegrationTest {
    @MockBean
    private MailSender mailSender;
    @MockBean
    private CartService cartService;
    @MockBean
    private OrderService orderService;

    //only to check if registered

    @Autowired
    private ManagerNotificatior managerNotificatior;
    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Test
    public void shouldHandleStoreEvent() throws Exception {
        eventPublisher.publishEvent(new OrderStoredEvent("cart-id"));

        verify(mailSender).send(any(),any());
    }
}
