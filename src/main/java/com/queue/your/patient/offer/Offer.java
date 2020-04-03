package com.queue.your.patient.offer;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import static lombok.AccessLevel.PRIVATE;

@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor(access = PRIVATE)
@AllArgsConstructor
@Entity
@Table(name = "offers")
public class Offer {
    @Id
    private long id;
    @Column(name = "calories_needed")
    private int caloriesNeed;
    private String variant;
}
