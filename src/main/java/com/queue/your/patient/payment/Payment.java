package com.queue.your.patient.payment;

import lombok.*;

import java.time.LocalDateTime;

import static lombok.AccessLevel.PRIVATE;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = PRIVATE)
public class Payment {
    private String id;
    private LocalDateTime when;
}
