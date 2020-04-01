package com.queue.your.patient.offer;

import org.springframework.core.convert.converter.Converter;

public class OfferToRepresentationConverter implements Converter<Offer, OfferRepresentation> {

    @Override
    public OfferRepresentation convert(Offer offer) {
        return new OfferRepresentation(offer.getId(), offer.getCaloriesNeed(), offer.getVariant());
    }
}
