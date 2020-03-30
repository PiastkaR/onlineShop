package com.queue.your.patient.order;

import com.queue.your.patient.cart.CartService;
import com.queue.your.patient.infrastructure.MailSender;
import com.queue.your.patient.order.discount.DiscountPolicy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderConfiguration {

    @Bean
    OrderRepository orderRepository() {
        return new InMemoryOrderRepository();
    }

    @Bean
    OrderService orderService(DiscountPolicy discountPolicy) {
        return new OrderService(orderRepository(), discountPolicy);
    }

    @Bean
    OrderCreationEventListener orderCreationEventListener(OrderService orderService, CartService cartService) {
        return new OrderCreationEventListener(orderService, cartService);
    }

    @Bean
    ManagerNotificator managerNotificator(MailSender mailSender) {
        return new ManagerNotificator(mailSender);
    }

    @Bean
    OrderPaidListener orderPaidListener() {
        return new OrderPaidListener(orderRepository());
    }
}
