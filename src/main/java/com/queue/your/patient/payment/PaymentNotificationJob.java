package com.queue.your.patient.payment;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class PaymentNotificationJob extends QuartzJobBean {

    @Autowired
    private PaymentNotificatior paymentNotificatior;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        paymentNotificatior.notifyCustomerAboutUnpaidEvent();
    }
}
