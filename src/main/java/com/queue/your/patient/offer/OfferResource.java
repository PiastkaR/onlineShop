package com.queue.your.patient.offer;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.http.ResponseEntity;

import java.util.Collection;
import java.util.List;
import java.util.Set;


import static java.util.Collections.emptyList;
import static org.springframework.core.convert.TypeDescriptor.collection;
import static org.springframework.core.convert.TypeDescriptor.valueOf;

@RequiredArgsConstructor
public class OfferResource {
    private final OfferService offerService;
    private final ConversionService conversionService;
    
    public ResponseEntity<List<OfferRepresentation>> findOffers() {
        return ResponseEntity.ok(emptyList());
    }

//    /unchecked/
    private List<OfferRepresentation> converter(Collection<Offer> offers) {
        final TypeDescriptor from = collection(Set.class, valueOf(Offer.class));
        final TypeDescriptor to = collection(List.class, valueOf(Offer.class));
        return (List<OfferRepresentation>) conversionService.convert(offers, from, to);
    }

    @Value
    static class IdReference {
        private final Long id;
    }
}
