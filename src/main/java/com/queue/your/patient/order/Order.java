package com.queue.your.patient.order;

import com.queue.your.patient.order.discount.DiscountPolicy;
import lombok.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.expression.spel.ast.OpOr;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Getter
@ToString
@NoArgsConstructor(access = PRIVATE)
@AllArgsConstructor
@EqualsAndHashCode
public class Order {
    private static final Logger LOGGER = LoggerFactory.getLogger(Order.class);

    private String id;
    private LocalDateTime orderedOn;
    private boolean accepted;
    private boolean paid;

    private List<OrderItem> items = new ArrayList<>();

    public Order(String clientId, LocalDateTime orderedOn) {
        this.id = clientId;
        this.orderedOn = orderedOn;
    }

    public void paid() {
        paid = true;
    }

    public void add(BigDecimal price) {
        items.add(new OrderItem(price));
    }

    public Order discount(DiscountPolicy discounts) {
        final BigDecimal price = discounts.calculate(this);
        LOGGER.info("Price after discount: [{}]", price);
        return this;
    }
}
