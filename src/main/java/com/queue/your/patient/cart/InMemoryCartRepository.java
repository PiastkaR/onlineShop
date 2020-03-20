package com.queue.your.patient.cart;

import java.util.*;

public class InMemoryCartRepository implements CartRepository{
    private final Map<String, Cart> cartDb = new HashMap<>();

    @Override
    public Cart save(Cart cart) {
        cartDb.put(cart.getId(), cart);
        return cart;
    }

    @Override
    public List<Cart> findAll() {return new ArrayList<>(cartDb.values());}

    @Override
    public Optional<Cart> findById(String id) {
        return Optional.ofNullable(cartDb.get(id));
    }
}
