package com.queue.your.patient.order;

import com.queue.your.patient.cart.Cart;
import com.queue.your.patient.order.discount.DiscountPolicy;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final DiscountPolicy discountPolicy;

    public void create(Cart cart) {
        orderRepository.save(new Order(cart.getId(), LocalDateTime.now()));
    }

    public void calculateDiscount(Order order) {
        order.discount(discountPolicy);
    }
}
