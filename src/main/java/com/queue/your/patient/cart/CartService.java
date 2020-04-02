package com.queue.your.patient.cart;

import com.queue.your.patient.aop.LoggingAspect;
import com.queue.your.patient.aop.Timed;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Scope;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.web.context.WebApplicationContext;

import javax.transaction.Transactional;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
//@Scope(value = WebApplicationContext.SCOPE_SESSION)
@Transactional
public class CartService {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    private final CustomerCart customerCart;
    private final CartRepository cartRepository;
    private final ApplicationEventPublisher eventPublisher;

    @Timed
    @SneakyThrows
    public Cart create() {
        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
            @Override
            public void afterCommit() {
                LOGGER.info("Cart is commited");
            }
        });
        final Cart cart = customerCart.finish();
        eventPublisher.publishEvent(new OrderStoredEvent(cart.getId()));
        TimeUnit.SECONDS.sleep(3);
        return cartRepository.save(cart);
    }

    @Timed
    void add(long item) {
        customerCart.add(item);
    }

    @Timed
    public Cart getById(String id) {
        return cartRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

}
