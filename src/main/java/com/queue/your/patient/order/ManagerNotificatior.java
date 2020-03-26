package com.queue.your.patient.order;

import com.queue.your.patient.cart.OrderStoredEvent;
import com.queue.your.patient.infrastructure.MailSender;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;

import static java.lang.String.format;

@RequiredArgsConstructor
public class ManagerNotificatior {
    private MailSender mailSender;

    @EventListener
    public void onOrderStoredEvent(OrderStoredEvent event) {
        mailSender.send("mailFromDb@", format("Please approve order #%s", event.getCartId()));
    }

}
