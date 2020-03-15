package com.queue.your.patient.cart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryCartRepository {
    private final Map<String, Cart> cartDb = new HashMap<>();

    @Override
    public Cart save(Cart cart) {
        cartDb.put(cart.getId(), cart);
        return cart;
    }

    @Override
    public List<Cart> findAll() {return new ArrayList<>(cartDb.values());}
}
