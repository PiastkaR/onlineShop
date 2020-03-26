package com.queue.your.patient.order;

import java.util.*;

public class InMemoryOrderRepository implements OrderRepository {
    private final Map<String, Order> offerDb = new HashMap<>();

    @Override
    public Order save(Order order) {
        offerDb.put(order.getId(), order);
        return order;
    }

    @Override
    public List<Order> findAll() {
        return new ArrayList<>(offerDb.values());
    }

    @Override
    public Optional<Order> findById(String id) {
        return Optional.ofNullable(offerDb.get(id));
    }
}
