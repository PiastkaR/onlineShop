package com.queue.your.patient.offer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OfferConfiguration {

    @Bean
    public AvailabilityOffersFilter webOfferFilter (@Value("${onlineShop.offer.filter.web.max-calorie-needed:3000}") int maxCaloriesNeed) {
        return new WebOffersFilter(maxCaloriesNeed);
    }
}
