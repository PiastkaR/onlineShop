package com.queue.your.patient.offer;

import com.queue.your.patient.IntegrationTest;
import org.junit.Test;

public class OfferResourceTest extends IntegrationTest {

    @Test
    public void shouldAddOffer() throws Exception {}

    private String givenOffer(int id) {
        return "{\"id\": " + id + ", \"calories_needed\": 2000, \"variant\": \"E\"}";
    }
}
