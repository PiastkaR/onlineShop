package com.queue.your.patient.offer;

public interface AvailabilityOffersFilter {

    AvailabilityOffersFilter ACCEPT_ALL = new AcceptAllOffersFilter();
    boolean accept(Offer offer);
    boolean applicableFor(Channel channel);

    class AcceptAllOffersFilter implements  AvailabilityOffersFilter {

        @Override
        public boolean accept(Offer offer) {return true;}

        @Override
        public boolean applicableFor(Channel channel) {return true;}
    }
}
