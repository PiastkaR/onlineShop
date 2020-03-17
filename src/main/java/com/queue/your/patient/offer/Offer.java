package com.queue.your.patient.offer;

import lombok.*;
import org.springframework.stereotype.Component;

import static lombok.AccessLevel.PRIVATE;

@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor(access = PRIVATE)
@AllArgsConstructor
@Component
public class Offer {

    private long id;
    private int caloriesNeed;
    private String variant;
}
