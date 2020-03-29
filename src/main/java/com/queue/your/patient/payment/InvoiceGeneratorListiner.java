package com.queue.your.patient.payment;

import com.queue.your.patient.infrastructure.MailSender;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;

import static java.lang.String.format;

@RequiredArgsConstructor
public class InvoiceGeneratorListiner {
    private final MailSender mailSender;
    private static final Logger LOGGER = LoggerFactory.getLogger(InvoiceGeneratorListiner.class);

    @EventListener
    public void onPaymentRegisteredEvent(PaymentRegisteredEvent event){
        LOGGER.info("Generate an invoice for payment [{}] ", event.getId());
        mailSender.send("exampleMail@mail.com", format(event.getId()) + "Your Invoice, Regards");
    }
}
