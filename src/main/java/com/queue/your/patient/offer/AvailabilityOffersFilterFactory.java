package com.queue.your.patient.offer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.queue.your.patient.offer.AvailabilityOffersFilter.ACCEPT_ALL;

@RequiredArgsConstructor
@Component
public class AvailabilityOffersFilterFactory {
    private final List<AvailabilityOffersFilter> filters;

    public AvailabilityOffersFilter getFor(Channel channel) {
        return filters
                .stream()
                .filter(f -> f.applicableFor(channel))
                .findFirst()
                .orElse(ACCEPT_ALL);
    }
}
