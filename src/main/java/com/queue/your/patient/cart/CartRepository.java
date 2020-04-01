package com.queue.your.patient.cart;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//@Scope("singleton")
public interface CartRepository extends CrudRepository<Cart, String> {
/*    Cart save(Cart offer);
    List<Cart> findAll();
    Optional<Cart> findById(String id);
*/
}
