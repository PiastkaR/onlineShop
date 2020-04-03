package com.queue.your.patient.offer;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface OfferRepository extends PagingAndSortingRepository<Offer, Long> {

//    Offer save(Offer offer);
//
//    List<Offer> findAll(Pageable pageable);
//
//    Optional<Offer> findById(long id);
}
