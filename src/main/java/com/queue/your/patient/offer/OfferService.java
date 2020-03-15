package com.queue.your.patient.offer;

import lombok.RequiredArgsConstructor;

import java.util.Set;

import static java.util.stream.Collectors.toSet;

@RequiredArgsConstructor
public class OfferService {

    private final AvailabilityOffersFilterFactory availabilityOffersFilterFactory;
    private final OfferRepository offerRepository;

    public Set<Offer> offerrsFor(Channel channel) {
        AvailabilityOffersFilter filter = availabilityOffersFilterFactory.getFor(channel);
        return offerRepository.findAll()
                .stream()
                .filter(filter::accept)
                .collect(toSet());
    }
}
