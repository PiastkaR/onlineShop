package com.queue.your.patient.order;

import com.queue.your.patient.cart.Cart;
import com.queue.your.patient.order.discount.DiscountPolicy;
import lombok.RequiredArgsConstructor;
import org.mockito.internal.matchers.Or;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Transactional
public class OrderService {
    private static final Logger LOGGER = LoggerFactory.getLogger(Order.class);

    private final OrderRepository orderRepository;
    private final DiscountPolicy discountPolicy;

    public void create(Cart cart) {
        final Order order = new Order(cart.getId(), LocalDateTime.now());
        orderRepository.save(order.discount(discountPolicy));
    }

    public void accept(String id) {
        orderRepository.findById(id).orElseThrow(EntityNotFoundException::new).accept();
        LOGGER.info("Order accepted");
    }
}
