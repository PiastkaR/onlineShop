package com.queue.your.patient.order;

import org.mockito.internal.matchers.Or;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface OrderRepository {

    Order save(Order order);

    List<Order> findAll();

    Optional<Order> findById(String id);

    List<Order> findOlderThan(LocalDateTime boarder);

    Order findByCartId(String id);
}
