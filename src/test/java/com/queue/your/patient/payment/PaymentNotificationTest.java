//package com.queue.your.patient.payment;
//
//import com.queue.your.patient.IntegrationTest;
//import com.queue.your.patient.order.OrderRepository;
//import org.awaitility.Duration;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.SpyBean;
//
//import static org.awaitility.Awaitility.await;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//
//public class PaymentNotificationTest extends IntegrationTest {
//    @Autowired
//    private PaymentNotificatior paymentNotificatior;
//    @SpyBean
//    private OrderRepository orderRepository;
//
//    @Test
//    public void shouldSendNotification() throws Exception {
//        //TODO test not working properly
//        await().atMost(Duration.TWO_SECONDS)
//                .untilAsserted(() -> verify(orderRepository, times(2)).findPaidFalseAndOrdered(any()));
//    }
//}
