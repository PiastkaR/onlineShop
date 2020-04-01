package com.queue.your.patient.cart;

import com.queue.your.patient.aop.Timed;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

import javax.transaction.Transactional;

@RequiredArgsConstructor
//@Scope(value = WebApplicationContext.SCOPE_SESSION)
@Transactional
public class CartService {
    private final CustomerCart customerCart;
    private final CartRepository cartRepository;
    private final ApplicationEventPublisher eventPublisher;

    @Timed
    Cart create() {
        final Cart cart = customerCart.finish();
        eventPublisher.publishEvent(new OrderStoredEvent(cart.getId()));
        return cartRepository.save(cart);
    }

    @Timed
    void add(long item) {
        customerCart.add(item);
    }

    @Timed
    public Cart getById(String id) {
        return cartRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

}
