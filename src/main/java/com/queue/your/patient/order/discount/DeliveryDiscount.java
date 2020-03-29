package com.queue.your.patient.order.discount;

import com.queue.your.patient.order.Order;

import java.math.BigDecimal;

public class DeliveryDiscount implements DiscountPolicy {
    @Override
    public BigDecimal calculate(Order order) {return BigDecimal.ZERO;}
}
