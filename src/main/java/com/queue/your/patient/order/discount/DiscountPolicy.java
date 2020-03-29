package com.queue.your.patient.order.discount;

import com.queue.your.patient.order.Order;

import java.math.BigDecimal;

public interface DiscountPolicy {
    BigDecimal calculate(Order order);
}
