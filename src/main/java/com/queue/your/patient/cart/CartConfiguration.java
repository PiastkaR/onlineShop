package com.queue.your.patient.cart;

import com.queue.your.patient.offer.OfferService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

@Configuration
public class CartConfiguration {
/*
    @Bean
    public CartRepository cartRepository(){
        return new InMemoryCartRepository();
    }*/
    @Bean
    @SessionScope
    CustomerCart customerCart(OfferService offerService) {
        return new CustomerCartComponent(offerService);
    }

    @Bean
    public CartService cartService(CustomerCart customerCart, CartRepository cartRepository, ApplicationEventPublisher eventPublisher) {
        return new CartService(customerCart, cartRepository, eventPublisher);
    }
}
