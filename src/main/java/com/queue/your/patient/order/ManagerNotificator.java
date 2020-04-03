package com.queue.your.patient.order;

import com.queue.your.patient.cart.OrderStoredEvent;
import com.queue.your.patient.infrastructure.MailSender;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.TimeUnit;

import static java.lang.String.format;

@RequiredArgsConstructor
public class ManagerNotificator {
    private final MailSender mailSender;

    @Async
    @SneakyThrows
    @EventListener
    void onOrderStoredEvent(OrderStoredEvent event) {
        TimeUnit.SECONDS.sleep(3);
        mailSender.send("mailFromDb@sth.com", format("Please approve order #%s", event.getCartId()));
    }

}
