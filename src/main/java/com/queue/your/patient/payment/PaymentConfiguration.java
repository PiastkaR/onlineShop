package com.queue.your.patient.payment;

import com.queue.your.patient.infrastructure.MailSender;
import com.queue.your.patient.order.OrderRepository;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentConfiguration {

    @Bean
    public PaymentRepository paymentRepository() {
        return new InMemoryPaymentRepository();
    }

    @Bean
    public PaymentService paymentService(ApplicationEventPublisher eventPublisher) {
        return new PaymentService(paymentRepository(), eventPublisher);
    }

    @Bean
    InvoiceGeneratorListener invoiceGeneratorListener(MailSender mailSender){
        return new InvoiceGeneratorListener(mailSender);
    }

    @Bean
    PaymentNotificatior paymentNotificatior(OrderRepository orderRepository, MailSender mailSender){
        return new PaymentNotificatior(orderRepository, mailSender);
    }

    @Bean
    JobDetail paymentNotificationJobDetail() {
        return JobBuilder.newJob()
                .ofType(PaymentNotificationJob.class)
                .storeDurably()
                .withIdentity("Payment_Notification_Job_detail")
                .withDescription("Invoke payment notifiction servce...")
                .build();
    }

    @Bean
    Trigger paymentNotificationTrigger(@Value("${onlineShop.payment.notification.not-paid.crone:0/1 * * * * ?}") String cronePattern) {
        return TriggerBuilder.newTrigger()
                .forJob(paymentNotificationJobDetail())
                .withIdentity("Payment_Notification_Trigger")
               /* .withSchedule(cronSchedule(cronePattern))*/
                .build();
    }
}
