package com.queue.your.patient.cart;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CartConfiguration {

    @Bean
    public CartRepository cartRepository(){
        return new InMemoryCartRepository();
    }

    @Bean
    public CustomerCart customerCartcomponent() {
        return new CustomerCartcomponent();
    }
}
