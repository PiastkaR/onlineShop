package com.queue.your.patient.cart;

import java.util.List;

public interface CartRepository {

    Cart save(Cart offer);
    List<Cart> findAll();
}
