package com.queue.your.patient.cart;

import com.queue.your.patient.IntegrationTest;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class CartRepositoryTest extends IntegrationTest {

    private @Mock List<DieteticSet> mockedDieteticSet = new ArrayList<>();

    @Autowired
    private CartRepository cartRepository;

    @Test
    public void shouldFindCartWithGivenId() {
        final Cart cart = new Cart("1", Collections.emptyList());
        cartRepository.save(cart);
        assertThat(cartRepository.findById("1").equals(Optional.of(cart)));
    }

    @Test
    public void shouldFindAllCarts() {
        final Cart cart1 = new Cart("1",  mockedDieteticSet);
        final Cart cart2 = new Cart("2",  mockedDieteticSet);
        cartRepository.save(cart1);
        cartRepository.save(cart2);
        assertThat(cartRepository.findAll().containsAll(Arrays.asList(cart1, cart2)));
    }
}
