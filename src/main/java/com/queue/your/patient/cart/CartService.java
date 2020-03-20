package com.queue.your.patient.cart;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

@RequiredArgsConstructor
@Scope(value= WebApplicationContext.SCOPE_SESSION)
class CartService {
    private final CustomerCart customerCart;
    private final CartRepository cartRepository;

    Cart create() {
        final Cart cart = customerCart.finish();
        return cartRepository.save(cart);
    }

    void add(long item ) {customerCart.add(item);}
}
