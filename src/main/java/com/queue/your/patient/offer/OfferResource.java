package com.queue.your.patient.offer;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import net.minidev.asm.ex.ConvertException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.ConverterNotFoundException;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import static com.queue.your.patient.infrastructure.PagedResource.toPageResource;
import static org.springframework.core.convert.TypeDescriptor.collection;
import static org.springframework.core.convert.TypeDescriptor.valueOf;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.ResponseEntity.status;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "onlineShop/offer")
public class OfferResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(OfferResource.class);
    private final OfferService offerService;
    private final ConversionService conversionService;

    @GetMapping(path = "/find")
    public ResponseEntity<List<OfferRepresentation>> findOffers(Pageable pageable) {
        final Page<Offer> offers = offerService.offersFor(pageable);
        return status(OK)
                .headers(toPageResource(offers, "/offers"))
                .body(converter(offers.getContent()));
    }

    @ResponseStatus(OK)
    @PostMapping(path = "/add", consumes = APPLICATION_JSON_VALUE)
    public IdReference addOffer(@Validated @RequestBody OfferRepresentation offer) {
        final Long id = offerService.add(conversionService.convert(offer, Offer.class));
        return new IdReference(id);
    }

    @SuppressWarnings("unchecked")
    private List<OfferRepresentation> converter(Collection<Offer> offers) {
        final TypeDescriptor from = collection(Set.class, valueOf(Offer.class));
        final TypeDescriptor to = collection(List.class, valueOf(Offer.class));
        return (List<OfferRepresentation>) conversionService.convert(offers, from, to);
    }

    @Value
    static class IdReference {
        private final Long id;
    }

    @ExceptionHandler
    public ResponseEntity<String> handleConverterNotFoundException(final ConverterNotFoundException e) {
        LOGGER.error("Unexpected ConverterNotFoundException exception! ", e);
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler
    public ResponseEntity<String> handleConvertException(final ConvertException e) {
        LOGGER.error("Unexpected ConvertException exception! ", e);
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }
}
