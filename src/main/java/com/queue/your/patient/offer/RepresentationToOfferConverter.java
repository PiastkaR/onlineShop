package com.queue.your.patient.offer;

import org.springframework.core.convert.converter.Converter;

public class RepresentationToOfferConverter implements Converter<OfferRepresentation, Offer> {

    @Override
    public Offer convert(OfferRepresentation offerRepresentation) {
        return new Offer(offerRepresentation.getId(), offerRepresentation.getCaloriesNeeded(), offerRepresentation.getVariant());
    }
}
