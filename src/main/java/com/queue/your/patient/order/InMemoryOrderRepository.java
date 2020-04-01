//package com.queue.your.patient.order;
//
//import java.time.LocalDateTime;
//import java.util.*;
//import java.util.stream.Collectors;
//
//import static java.lang.String.format;
//
//public class InMemoryOrderRepository implements OrderRepository {
//    private final Map<String, Order> orderDb = new HashMap<>();
//
//    @Override
//    public Order save(Order order) {
//        orderDb.put(order.getId(), order);
//        return order;
//    }
//
//    @Override
//    public List<Order> findAll() {
//        return new ArrayList<>(orderDb.values());
//    }
//
//    @Override
//    public Optional<Order> findById(String id) {
//        return Optional.ofNullable(orderDb.get(id));
//    }
//
//    @Override
//    public List<Order> findOlderThan(LocalDateTime border) {return orderDb.values()
//            .stream()
//            .filter(order -> !border.isBefore(order.getOrderedOn()))
//            .collect(Collectors.toList());
//    }
//
//    @Override
//    public Order findByCartId(String id) {
//        return orderDb.values()
//                .stream()
//                .filter(order -> Objects.equals(order.getId(), id))
//                .findFirst()
//                .orElseThrow(() -> new IllegalArgumentException(format("Order not found by cart id [%s] ", id)));
//    }
//}
