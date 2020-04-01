package com.queue.your.patient.offer;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

@RequiredArgsConstructor
public class OfferService {

    private final AvailabilityOffersFilterFactory availabilityOffersFilterFactory;
    private final OfferRepository offerRepository;

    @Transactional(readOnly = true)
    public Set<Offer> offersFor(Channel channel) {
        AvailabilityOffersFilter filter = availabilityOffersFilterFactory.getFor(channel);
        return offerRepository.findAll()
                .stream()
                .filter(filter::accept)
                .collect(toSet());
    }

    @Transactional(readOnly = true)
    public Offer getById(long id) {
        return offerRepository.findById(id).orElseThrow(IllegalAccessError::new);
    }

    @Transactional(readOnly = true)
    public Long add(Offer offer) {return  offerRepository.save(offer).getId();}
}
