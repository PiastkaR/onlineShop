package com.queue.your.patient.order;

import com.queue.your.patient.cart.CartService;
import com.queue.your.patient.infrastructure.MailSender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderConfiguration {

    @Bean
    OrderRepository orderRepository() {
        return new InMemoryOrderRepository();
    }

    @Bean
    OrderService orderService() {
        return new OrderService(orderRepository());
    }

    @Bean
    OrderCreationEventListener orderConfigurationEventListener(CartService cartService) {
        return new OrderCreationEventListener(orderService(), cartService);
    }

    @Bean
    ManagerNotificatior managerNotificatior(MailSender mailSender) {
        return new ManagerNotificatior(mailSender);
    }

    @Bean
    OrderPaidListener orderPaidListiner() {
        return new OrderPaidListener(orderRepository());
    }
}
