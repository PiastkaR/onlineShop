package com.queue.your.patient.cart;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = PRIVATE)
@Entity
@Table(name = "carts")
public class Cart {

    @Id
    String id;

    @ElementCollection
    @CollectionTable(name = "dieteticset", joinColumns = @JoinColumn(name = "cart_id"))
    List<DieteticSet> dieteticSets = new ArrayList<>();

    public void add(int caloriesNeed, String variant) {
        dieteticSets.add(new DieteticSet(caloriesNeed, variant));
    }
}
