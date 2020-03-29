package com.queue.your.patient.cart;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.context.ApplicationEventPublisher;

import java.util.Collections;

import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CartServiceTest {
    @Mock
    private CustomerCart customerCart;
    @Mock
    private CartRepository cartRepository;
    @Mock
    private ApplicationEventPublisher eventPublisher;

    @InjectMocks
    private CartService cartService;

    @Test
    public void shouldPublishEvent() {
        final Cart givenCart = new Cart("1", emptyList());
        given(customerCart.finish()).willReturn(givenCart);
        given(cartRepository.save(any())).willReturn(givenCart);

        final Cart cart = cartService.create();
        assertThat(cart)
                .isNotNull()
                .isEqualTo(givenCart);
                verify(cartRepository).save(givenCart);
        verify(eventPublisher).publishEvent(any(OrderStoredEvent.class));
    }
}
