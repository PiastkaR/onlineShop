package com.queue.your.patient.order;

import com.queue.your.patient.cart.OrderStoredEvent;
import com.queue.your.patient.infrastructure.MailSender;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;

import static java.lang.String.format;

@RequiredArgsConstructor
public class ManagerNotificator {
    private final MailSender mailSender;

    @EventListener
    void onOrderStoredEvent(OrderStoredEvent event) {
        mailSender.send("mailFromDb@sth.com", format("Please approve order #%s", event.getCartId()));
    }

}
