package com.queue.your.patient.order.discount;

import com.queue.your.patient.order.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;

import java.math.BigDecimal;
import java.util.List;

@Primary
@RequiredArgsConstructor
public class Discounts implements DiscountPolicy{

    private final List<DiscountPolicy> discountPolicies;

    @Override
    public BigDecimal calculate(Order order) {
        return discountPolicies.stream().map(discountPolicy -> discountPolicy.calculate(order)).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
