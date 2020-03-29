package com.queue.your.patient.order.discount;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(includeFilters = @ComponentScan.Filter(
        type = FilterType.ASSIGNABLE_TYPE, classes = DiscountPolicy.class
))
public class DiscountConfiguration {
}
