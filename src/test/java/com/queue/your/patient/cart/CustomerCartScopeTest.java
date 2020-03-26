package com.queue.your.patient.cart;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.queue.your.patient.IntegrationTest;
import com.queue.your.patient.offer.Offer;
import com.queue.your.patient.offer.OfferRepository;
import lombok.SneakyThrows;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CustomerCartScopeTest extends IntegrationTest {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private OfferRepository offerRepository;
    @Autowired
    private ObjectMapper objectMapper;

    @Before
    public void setUp() throws Exception {
        offerRepository.save(new Offer(1, 2000, "S"));
        offerRepository.save(new Offer(2, 2500, "M"));
    }

    @Test
    public void shouldProperlyHandleSessionCart() throws Exception {
        //given
        MockHttpSession session = new MockHttpSession();
        //when
        mockMvc.perform(
                post("/cart/1")
                        .session(session))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldProperlyHandleTwoSessionCart() throws Exception {
        //given
        MockHttpSession session = new MockHttpSession();
        //when
        mockMvc.perform(
                post("/cart/1")
                        .session(session))
                .andExpect(status().isOk());
        mockMvc.perform(
                post("/cart/2")
                        .session(session))
                .andExpect(status().isOk());

        final MvcResult result = mockMvc.perform(
                post("/cart/order")
                .session(session))
                .andExpect(status().isOk())
                .andReturn();

        final CartResource.IdReference id = referenceOf(result);

        final Optional<Cart> cart = cartRepository.findById(id.getId());

        assertThat(cart)
                .isPresent()
                .isNotNull()
                .map(Cart::getDieteticSets)
                .map(List::size)
                .get()
                .isEqualTo(1);
    }

    @SneakyThrows
    private CartResource.IdReference referenceOf(MvcResult result) {
        //TODO deserialize response and convert toString...
       // String JsonDeserialized = JsonConvert.DeserializeObject<?>(result) to be filled in getResponse
        return  objectMapper.readValue(result.getResponse().getContentAsString(), CartResource.IdReference.class);
    }
}
