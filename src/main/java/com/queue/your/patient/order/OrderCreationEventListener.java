package com.queue.your.patient.order;

import com.queue.your.patient.cart.Cart;
import com.queue.your.patient.cart.CartService;
import com.queue.your.patient.cart.OrderStoredEvent;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;

@RequiredArgsConstructor
public class OrderCreationEventListener {
    public static final Logger LOGGER = LoggerFactory.getLogger(OrderCreationEventListener.class);
    private final OrderService orderService;
    private final CartService cartService;

    @EventListener
    public void onOrderStoredEvent(OrderStoredEvent orderStoredEvent) {
        LOGGER.info("Order creation for cart [{}]", orderStoredEvent);
        final Cart cart = cartService.getById(orderStoredEvent.getCartId());
        orderService.create(cart);
    }
}
