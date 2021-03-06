package com.queue.your.patient.order;

import com.queue.your.patient.payment.PaymentRegisteredEvent;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Transactional
public class  OrderPaidListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderPaidListener.class);
    private final OrderRepository orderRepository;

    @EventListener
    public void onPaymentRegisteredEvent(PaymentRegisteredEvent event){
        LOGGER.info("Registered payment based on event [{}]", event);
        orderRepository.findByCartId(event.getId()).paid();
    }
}
