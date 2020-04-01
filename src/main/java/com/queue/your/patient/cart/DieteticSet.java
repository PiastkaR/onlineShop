package com.queue.your.patient.cart;

import lombok.*;

import javax.persistence.Embeddable;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor(access = PACKAGE)
@NoArgsConstructor(access = PRIVATE)
@Embeddable
public class DieteticSet {

    private int caloriesNeed;
    private String variant;
}
