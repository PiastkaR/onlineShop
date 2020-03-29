package com.queue.your.patient.cart;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

@RequiredArgsConstructor
@Scope(value = WebApplicationContext.SCOPE_SESSION)
public class CartService {
    private final CustomerCart customerCart;
    private final CartRepository cartRepository;
    private final ApplicationEventPublisher eventPublisher;

    Cart create() {
        final Cart cart = customerCart.finish();
        eventPublisher.publishEvent(new OrderStoredEvent(cart.getId()));
        return cartRepository.save(cart);
    }

    void add(long item) {
        customerCart.add(item);
    }

    public Cart getById(String id) {
        return cartRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

}
