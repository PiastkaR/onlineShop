package com.queue.your.patient.offer;

import com.queue.your.patient.IntegrationTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import static org.assertj.core.api.Assertions.assertThat;

public class OfferRepositoryTest extends IntegrationTest {

    @Autowired
    OfferRepository offerRepository;

    @Test
    public void shouldFIndAllOffers() {
        final Offer offer = new Offer(1, 1500, "S");
        offerRepository.save(offer);
        Pageable pageable = new Pageable() {
            @Override
            public int getPageNumber() {
                return 0;
            }

            @Override
            public int getPageSize() {
                return 0;
            }

            @Override
            public long getOffset() {
                return 0;
            }

            @Override
            public Sort getSort() {
                return null;
            }

            @Override
            public Pageable next() {
                return null;
            }

            @Override
            public Pageable previousOrFirst() {
                return null;
            }

            @Override
            public Pageable first() {
                return null;
            }

            @Override
            public boolean hasPrevious() {
                return false;
            }
        };
        assertThat(offerRepository.findAll(pageable))
                .contains(offer);
    }
}
