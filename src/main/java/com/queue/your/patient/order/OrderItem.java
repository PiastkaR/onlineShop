package com.queue.your.patient.order;

import lombok.*;

import javax.persistence.Embeddable;
import java.math.BigDecimal;

import static lombok.AccessLevel.PRIVATE;

@Getter
@NoArgsConstructor(access = PRIVATE)
@AllArgsConstructor
@ToString
@Embeddable
public class OrderItem {

    private BigDecimal price;
}
