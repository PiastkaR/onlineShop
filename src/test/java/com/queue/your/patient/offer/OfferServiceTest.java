//package com.queue.your.patient.offer;
//
//import com.queue.your.patient.IntegrationTest;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
////import org.springframework.data.domain.Sort;
//
//import java.util.Set;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static java.lang.Integer.MAX_VALUE;
//import static org.springframework.data.domain.Sort.sort;
//
//public class OfferServiceTest extends IntegrationTest {
//
//    @Autowired
//    private OfferService offerService;
//
//    @Autowired
//    private OfferRepository offerRepository;
//
//    @Test
//    public void shouldFindAllWebOffers() {
//        //given
//        final Offer offer = new Offer(1, 2500, "M");
//        offerRepository.save(offer);
//        //when
////        final Set<Offer> offers = offerService.offersFor(Channel.WEB);
//
//        //TODO poprawic PageRequest
//        final Page<Offer> offers = offerService.offersFor(new PageRequest(0, MAX_VALUE, Offer.class));
//        //then
//        assertThat(offers).contains(offer);
//    }
//}
