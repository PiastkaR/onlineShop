package com.queue.your.patient.order.discount;

import com.queue.your.patient.IntegrationTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class DiscountTest extends IntegrationTest {

    @Autowired
    ApplicationContext context;

    @Test
    public void shouldContainDiscountBean() throws Exception {
        final DiscountPolicy bean = context.getBean(Discounts.class);

        assertThat(bean).isNotNull();
    }

    @Test
    public void shouldContainDeliveryDiscountBean() throws Exception {
        final DiscountPolicy bean = context.getBean(DeliveryDiscount.class);

        assertThat(bean).isNotNull();
    }

    @Test
    public void shouldContainLoyaltyDiscountBean() throws Exception {
        final DiscountPolicy bean = context.getBean(LoyaltyDiscounts.class);

        assertThat(bean).isNotNull();
    }
}
