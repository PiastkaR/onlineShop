package com.queue.your.patient.cart;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = PRIVATE)
public class Cart {

    String id;
    List<DieteticSet> dieteticSets = new ArrayList<>();

    public void add(int caloriesNeed, String variant) { dieteticSets.add(new DieteticSet(caloriesNeed, variant)); }
}
