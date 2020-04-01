package com.queue.your.patient.offer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import javax.validation.constraints.NotEmpty;


@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class OfferRepresentation {
    @JsonProperty("id")
    private long id;
    @JsonProperty("calories_needed")
    private int caloriesNeeded;
    @JsonProperty("variant")
    @NotEmpty
    private String variant;
}
