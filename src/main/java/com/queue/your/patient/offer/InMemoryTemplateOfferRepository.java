//package com.queue.your.patient.offer;
//
//import java.util.*;
//
//class InMemoryTemplateOfferRepository implements OfferRepository {
//
//    private final Map<Long, Offer> offerDb = new HashMap<>();
//
//    @Override
//    public Offer save(Offer offer) {
//        offerDb.put(offer.getId(), offer);
//        return offer;
//    }
//
//    @Override
//    public List<Offer> findAll() {
//        return new ArrayList<>(offerDb.values());
//    }
//
//    @Override
//    public Optional<Offer> findById(long id) {
//        return Optional.ofNullable(offerDb.get(id));
//    }
//
//}
