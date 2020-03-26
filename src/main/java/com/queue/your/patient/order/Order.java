package com.queue.your.patient.order;

import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor(access = PRIVATE)
@AllArgsConstructor
public class Order {

    private String id;

    private boolean accepted;

    private List<OrderItem> items = new ArrayList<>();

    public Order(String clientId) {
        this.id = clientId;
    }

    public void add(BigDecimal price) {
        items.add(new OrderItem(price));
    }
}
