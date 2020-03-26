package com.queue.your.patient.infrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InfrastructureConfiguration {

    @Bean
    MailSender mailSender() {
        return new MailSender();
    }
}
