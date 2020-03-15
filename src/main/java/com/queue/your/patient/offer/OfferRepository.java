package com.queue.your.patient.offer;

import java.util.List;
import java.util.Optional;

public interface OfferRepository {

    Offer save(Offer offer);

    List<Offer> findAll();

    Optional<Offer> findById(long id);
}
