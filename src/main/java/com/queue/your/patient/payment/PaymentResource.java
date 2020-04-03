package com.queue.your.patient.payment;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequiredArgsConstructor
public class PaymentResource {

    private final PaymentService paymentService;

    @ResponseStatus(OK)
    @RequestMapping(method = POST, path = "/payment/{orderId}")
    public void register(@PathVariable @NotEmpty String orderId) {
        paymentService.paymentRegistered(orderId);
    }
}
