package com.queue.your.patient.offer;

import com.queue.your.patient.IntegrationTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class OfferServiceTest extends IntegrationTest {

    @Autowired
    private OfferService offerService;

    @Autowired
    private OfferRepository offerRepository;

    @Test
    public void shouldFindAllWebOffers() {
        //given
        final Offer offer = new Offer(1, 2500, "M");
        offerRepository.save(offer);
        //when
        final Set<Offer> offers = offerService.offerrsFor(Channel.WEB);
        //then
        assertThat(offers).contains(offer);
    }
}
