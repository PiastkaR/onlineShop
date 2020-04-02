package com.queue.your.patient.order;

import com.queue.your.patient.cart.Cart;
import com.queue.your.patient.cart.CartService;
import com.queue.your.patient.cart.OrderStoredEvent;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.event.TransactionalEventListener;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Transactional
@Async
public class OrderCreationEventListener {
    public static final Logger LOGGER = LoggerFactory.getLogger(OrderCreationEventListener.class);
    private final OrderService orderService;
    private final CartService cartService;

    @TransactionalEventListener
    public void onOrderStoredEvent(OrderStoredEvent orderStoredEvent) {
        LOGGER.info("Order creation for cart [{}]", orderStoredEvent);
        final Cart cart = cartService.getById(orderStoredEvent.getCartId());
        orderService.create(cart);
    }
}
