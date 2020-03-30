package com.queue.your.patient.order;

import com.queue.your.patient.IntegrationTest;
import com.queue.your.patient.cart.CartService;
import com.queue.your.patient.cart.OrderStoredEvent;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

public class OrderCreationEventListenerTest extends IntegrationTest {
    @MockBean
    private CartService cartService;
    @MockBean
    private OrderService orderService;
    //only to check if registered
    @Autowired
    private OrderCreationEventListener listener;
    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Test
    public void shouldHandleEventCreation() {
        eventPublisher.publishEvent(new OrderStoredEvent("cart-id"));
        verify(orderService).create(any());
    }
}
