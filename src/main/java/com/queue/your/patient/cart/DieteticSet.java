package com.queue.your.patient.cart;

import lombok.*;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor(access = PACKAGE)
@NoArgsConstructor(access = PRIVATE)
public class DieteticSet {

    private int caloriesNeed;
    private String variant;
}
