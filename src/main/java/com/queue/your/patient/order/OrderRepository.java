package com.queue.your.patient.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {
/*
    Order save(Order order);

    List<Order> findAll();

    Optional<Order> findById(String id);

    List<Order> findOlderThan(LocalDateTime boarder);

    Order findByCartId(String id);

 */

    List<Order> findPaidFalseAndOrdered(LocalDateTime boarder);

    default Order findByCartId(String id) {
        return findById(id).orElse(null);
    }
}
