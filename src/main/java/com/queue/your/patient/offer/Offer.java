package com.queue.your.patient.offer;

import lombok.*;

@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class Offer {

    private long id;
    private int caloriesNeed;
    private String variant;
}
