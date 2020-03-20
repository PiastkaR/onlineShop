package com.queue.your.patient.cart;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
public class CartResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(CartResource.class);

    private final CartService cartService;

    @ResponseStatus(OK)
    @PostMapping("/cart/{item}")
    public void add
}
