package com.queue.your.patient.offer;

import lombok.*;

import static lombok.AccessLevel.PRIVATE;

@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor(access = PRIVATE)
@AllArgsConstructor
public class Offer {

    private long id;
    private int caloriesNeed;
    private String variant;
}
