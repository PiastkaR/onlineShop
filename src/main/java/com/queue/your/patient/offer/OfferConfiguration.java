package com.queue.your.patient.offer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Configuration
public class OfferConfiguration {

    @Bean
    public OfferRepository offerRepository() {
        return new InMemoryTemplateOfferRepository();
    }

    @Bean
    public AvailabilityOffersFilter webOffersFilter(@Value("5000") int maxCaloriesNeed) {
        return new WebOffersFilter(maxCaloriesNeed);
    }

    @Bean
    public OfferService offerService(AvailabilityOffersFilterFactory filterFactory) {
        return new OfferService(filterFactory, offerRepository());
    }

    @Bean
    public AvailabilityOffersFilterFactory availabilityOffersFilterFactory(Optional<List<AvailabilityOffersFilter>> availabilityOffersFilters) {
        return new AvailabilityOffersFilterFactory(availabilityOffersFilters.orElseGet(Collections::emptyList));

    }

}
