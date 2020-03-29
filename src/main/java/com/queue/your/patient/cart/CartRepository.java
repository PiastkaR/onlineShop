package com.queue.your.patient.cart;

import java.util.List;
import java.util.Optional;

//@Scope("singleton")
public interface CartRepository {

    Cart save(Cart offer);
    List<Cart> findAll();
    Optional<Cart> findById(String id);
}
