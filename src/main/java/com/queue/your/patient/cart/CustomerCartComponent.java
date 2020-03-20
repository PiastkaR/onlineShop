package com.queue.your.patient.cart;

import com.queue.your.patient.offer.Offer;
import com.queue.your.patient.offer.OfferService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

@Scope(value = WebApplicationContext.SCOPE_SESSION)
@AllArgsConstructor
public class CustomerCartComponent implements CustomerCart {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerCartComponent.class);

    private final OfferService offerService;
    private final String uuid = UUID.randomUUID().toString();
    private final List<Long> items = new ArrayList<>();

    @Override
    public void add(long item) {
        LOGGER.info("Add {} to cart {}", item, uuid);
        items.add(item);
    }

    @Override
    public Cart finish() {
        final List<DieteticSet> dieteticSets = items.stream().map(this::offerOf).map(this::dieteticSetOf).collect(toList());
        return new Cart (uuid, dieteticSets);
    }

    private Offer offerOf(long id) {return offerService.getById(id);}

    private DieteticSet dieteticSetOf(Offer offer) {
        return new DieteticSet(offer.getCaloriesNeed(), offer.getVariant());
    }
}
