package com.queue.your.patient.payment;

import com.queue.your.patient.infrastructure.MailSender;
import com.queue.your.patient.order.Order;
import com.queue.your.patient.order.OrderRepository;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Transactional
public class PaymentNotificatior {
    private final OrderRepository orderRepository;
    private final MailSender mailSender;

    public void notifyCustomerAboutUnpaidEvent() {
        final LocalDateTime remindingBoarder = LocalDateTime.now().minusDays(3);
        final List<Order> orders = orderRepository.findPaidFalseAndOrdered(remindingBoarder);
        orders.forEach(order -> mailSender.send("customer.name@sth.com", "Your Order is not paid."));
    }
}
