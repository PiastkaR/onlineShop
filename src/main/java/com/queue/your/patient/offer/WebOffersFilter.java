package com.queue.your.patient.offer;

import static com.queue.your.patient.offer.Channel.WEB;
import static lombok.AccessLevel.PRIVATE;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor(access = PRIVATE)
public class WebOffersFilter implements AvailabilityOffersFilter{
    private int maxCaloriesNeed;
    
    @Override
    public boolean accept(Offer offer) {return offer.getCaloriesNeed() <= maxCaloriesNeed;}

    @Override
    public boolean applicableFor(Channel channel) {return WEB == channel; }
}
