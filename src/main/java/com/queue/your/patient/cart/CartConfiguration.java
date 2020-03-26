package com.queue.your.patient.cart;

import com.queue.your.patient.offer.OfferService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CartConfiguration {

    @Bean
    public CartRepository cartRepository(){
        return new InMemoryCartRepository();
    }

    @Bean
    public CustomerCartComponent customerCart(OfferService offerService) {
        return new CustomerCartComponent(offerService);
    }

    @Bean
    public CartService cartService(CustomerCart customerCart) {
        return new CartService(customerCart, cartRepository());
    }
}
