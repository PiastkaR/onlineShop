package com.queue.your.patient.order;

import com.queue.your.patient.cart.Cart;
import com.queue.your.patient.order.discount.DiscountPolicy;
import lombok.RequiredArgsConstructor;
import org.mockito.internal.matchers.Or;

import java.time.LocalDateTime;

@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final DiscountPolicy discountPolicy;

    public void create(Cart cart) {
        final Order order = new Order(cart.getId(), LocalDateTime.now());
        orderRepository.save(order.discount(discountPolicy));
    }
}
