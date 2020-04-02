package com.queue.your.patient.offer;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
public class OfferService {

    private final OfferRepository offerRepository;

    @Transactional(readOnly = true)
    public Page<Offer> offersFor(Pageable pageable) {
        return (Page<Offer>) offerRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public Offer getById(long id) {
        return offerRepository.findById(id).orElseThrow(IllegalAccessError::new);
    }

    @Transactional(readOnly = true)
    public Long add(Offer offer) {
        return offerRepository.save(offer).getId();
    }
}
