package com.queue.your.patient.offer;

import com.queue.your.patient.IntegrationTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class OfferRepositoryTest extends IntegrationTest {

    @Autowired
    OfferRepository offerRepository;

    @Test
    public void shouldFIndAllOffers() {
        final Offer offer = new Offer(1, 1500, "S");
        offerRepository.save(offer);
        assertThat(offerRepository.findAll())
                .contains(offer);
    }
}
