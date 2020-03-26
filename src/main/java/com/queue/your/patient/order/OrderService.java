package com.queue.your.patient.order;

import com.queue.your.patient.cart.Cart;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public void create(Cart cart) {
        orderRepository.save(new Order(cart.getId()));
    }
}
