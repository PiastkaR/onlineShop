package com.queue.your.patient.infrastructure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MailSender {

    public static final Logger LOGGER = LoggerFactory.getLogger(MailSender.class);

    public void send(String address, String content) {
        LOGGER.info("Sending Email to: [{}]: [{}]", address, content);
    }
}
