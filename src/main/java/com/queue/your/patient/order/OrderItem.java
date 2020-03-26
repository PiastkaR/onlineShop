package com.queue.your.patient.order;

import lombok.*;

import java.math.BigDecimal;

import static lombok.AccessLevel.PRIVATE;

@Getter
@NoArgsConstructor(access = PRIVATE)
@AllArgsConstructor
@ToString
public class OrderItem {

    private BigDecimal price;
}
